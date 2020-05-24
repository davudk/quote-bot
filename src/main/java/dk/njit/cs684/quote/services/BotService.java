package dk.njit.cs684.quote.services;

import dk.njit.cs684.quote.dao.QueryRepository;
import dk.njit.cs684.quote.model.Quote;
import dk.njit.cs684.quote.model.UserQuery;
import dk.njit.cs684.quote.model.YahooSearchResult;
import dk.njit.cs684.quote.model.queries.*;
import dk.njit.cs684.quote.model.responses.StockSpreadsheetResponse;
import dk.njit.cs684.quote.model.responses.StockStatisticsResponse;
import dk.njit.cs684.quote.services.grammar.GrammarService;
import dk.njit.cs684.quote.util.BotUtil;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.jsoup.helper.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BotService {
    private static Pattern USER_ID_PATTERN = Pattern.compile("<@!?\\d+>");
    private static DateTimeFormatter AMERICAN_DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/YYYY");

    @Value("${discord.token}")
    private String discordBotToken;

    @Autowired
    private GrammarService grammarService;

    @Autowired
    private QueryHandlerService queryHandlerService;

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private LoggerService loggerService;

    private DiscordApi client;

    @Bean
    private DiscordApi discordClient() {
        final DiscordApi api;
        try {
             api = new DiscordApiBuilder().setToken(discordBotToken).login().join();
        } catch (Exception e) {
            throw new RuntimeException("Discord Bot login failed. Is the login token correct?", e);
        }

        api.addMessageCreateListener(event -> {
            if (event.getMessage().mentionsEveryone()) return;

//            final GenericWebApplicationContext ctx = new GenericWebApplicationContext();
//            ctx.getAutowireCapableBeanFactory().au

            final long clientId = event.getApi().getClientId();
            boolean mentioned = event.getMessage().getMentionedUsers().stream()
                    .anyMatch(u -> u.getId() == clientId);
            if (!mentioned) return;

            final UserQuery userQuery = new UserQuery();
            userQuery.setUsername(event.getMessageAuthor().getDisplayName());
            userQuery.setMessage("Input was not understood.");
            userQuery.setTimestamp(new Date());
            queryRepository.create(userQuery);

            loggerService.setThreadLocalContext(userQuery.getId().toString());

            loggerService.info(String.format("Received Discord message from %s: %s",
                    event.getMessageAuthor().getDisplayName(),
                    event.getMessage().getContent()));

            try {
                final String input;
                try {
                    input = USER_ID_PATTERN.matcher(event.getMessageContent())
                            .replaceAll("")
                            .replaceAll("\\s+", " ")
                            .toLowerCase()
                            .trim();
                    loggerService.info("Cleaned up input: " + input);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to clean up input.", e);
                }
                userQuery.setMessage(input);
                queryRepository.replace(userQuery);

                respond(event, input);

                userQuery.setComplete(true);
                userQuery.setSuccess(true);
                queryRepository.replace(userQuery);
            } catch (Exception e) {
                loggerService.warn("Failed to handle user query.");
                loggerService.error(e);

                userQuery.setComplete(true);
                userQuery.setSuccess(false);
                queryRepository.replace(userQuery);
            }
        });

        return api;
    }

    private void respond(MessageCreateEvent event, String input) {
        try {
            loggerService.info("Parsing input.");
            final QueryBase query;
            try {
                query = grammarService.parse(input);
                loggerService.info("Parsed query as: " + query.getClass().getName());
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse query.", e);
            }

            if (query instanceof StockQuoteQuery) {
                handleStockQuoteQuery(event, (StockQuoteQuery) query);
            } else if (query instanceof HistoricalStockQuoteQuery) {
                handleHistoricalStockQuoteQuery(event, (HistoricalStockQuoteQuery) query);
            } else if (query instanceof RangedStockQuoteQuery) {
                handleRangedStockQuoteQuery(event, (RangedStockQuoteQuery) query);
            } else if (query instanceof StockStatisticsQuery) {
                handleStockStatisticsQuery(event, (StockStatisticsQuery) query);
            } else if (query instanceof StockSearchQuery) {
                handleStockSearchQuery(event, (StockSearchQuery) query);
            } else if (query instanceof StockSpreadsheetQuery) {
                handleStockSpreadsheetQuery(event, (StockSpreadsheetQuery) query);
            } else {
                throw new RuntimeException("Unknown query grammar.");
            }

        } catch (Exception e) {
            final String mention = BotUtil.getUserMention(event.getMessageAuthor());
            event.getChannel().sendMessage(mention + " Sorry I couldn't understand that.");
            throw new RuntimeException("Failed to handle query.", e);
        }
    }

    private void handleStockQuoteQuery(MessageCreateEvent event,
                                       StockQuoteQuery query) {
        loggerService.info("Handling stock quote query.");
        loggerService.info("Identifier: " + query.getTicker());
        final Optional<Quote> quote = queryHandlerService.handle(query);

        if (quote.isPresent()) {
            loggerService.info("Responding: " + quote.get());
            final String ticker = quote.get().getTicker();
            final String price = quote.get().toShortString();
            event.getChannel().sendMessage(new EmbedBuilder()
                    .addField(ticker, price)
                    .setColor(new Color(0, 128, 0))
                    .setFooter("This is not financial advice.")
            );
            loggerService.info("Success.");
        } else {
            loggerService.error("Failed to load quote.");
            final String userMention = BotUtil.getUserMention(event.getMessageAuthor());
            event.getChannel().sendMessage(userMention +
                    "Sorry, couldn't find that.");
        }
    }

    private void handleHistoricalStockQuoteQuery(MessageCreateEvent event,
                                                 HistoricalStockQuoteQuery query) {
        loggerService.info("Handling historical stock quote query.");
        loggerService.info("Identifier: " + query.getTicker());
        loggerService.info("Date: " + query.getDate());
        final Optional<Quote> quote = queryHandlerService.handle(query);

        if (quote.isPresent()) {
            loggerService.info("Responding: " + quote.get());
            final String tickerAndDate = quote.get().getTicker() + " " +
                    quote.get().getDate().format(AMERICAN_DATE_FORMAT);
            final String price = quote.get().toShortString();
            event.getChannel().sendMessage(new EmbedBuilder()
                    .addField(tickerAndDate, price)
                    .setColor(new Color(0, 128, 0))
                    .setFooter("This is not financial advice.")
            );
            loggerService.info("Success.");
        } else {
            loggerService.error("Failed to load quote.");
            final String userMention = BotUtil.getUserMention(event.getMessageAuthor());
            event.getChannel().sendMessage(userMention +
                    "Sorry, couldn't find that.");
        }
    }

    private void handleRangedStockQuoteQuery(MessageCreateEvent event,
                                             RangedStockQuoteQuery query) {
        loggerService.info("Handling ranged stock quote query.");
        loggerService.info("Identifier: " + query.getTicker());
        loggerService.info("Start date: " + query.getStartDate());
        loggerService.info("End date: " + query.getEndDate());
        final Optional<List<Quote>> quotes = queryHandlerService.handle(query);

        if (quotes.isPresent()) {
            final String concat = quotes.get().stream()
                    .map(Quote::toShortDatedString)
                    .collect(Collectors.joining("; "));
            loggerService.info("Responding: " + concat);
            final EmbedBuilder builder = new EmbedBuilder()
                    .setAuthor(quotes.get().get(0).getTicker().toUpperCase())
                    .setColor(new Color(0, 128, 0))
                    .setFooter("This is not financial advice.");

            for (Quote q : quotes.get()) {
                builder.addInlineField(
                        q.getDate().format(AMERICAN_DATE_FORMAT),
                        q.toShortString());
            }

            event.getChannel().sendMessage(builder);
            loggerService.info("Success.");
        } else {
            loggerService.error("Failed to load quote.");
            final String userMention = BotUtil.getUserMention(event.getMessageAuthor());
            event.getChannel().sendMessage(userMention +
                    "Sorry, couldn't find that.");
        }
    }

    private void handleStockStatisticsQuery(MessageCreateEvent event,
                                            StockStatisticsQuery query) {
        loggerService.info("Handling stock statistics query.");
        loggerService.info("Identifier: " + query.getTicker());
        final Optional<StockStatisticsResponse> response = queryHandlerService.handle(query);

        if (response.isPresent()) {
            loggerService.info("Responding: " + response.get());
            final StockStatisticsResponse r = response.get();
            event.getChannel().sendMessage(new EmbedBuilder()
                    .setAuthor(r.getTicker())
                    .addField("Latest - " + r.getLatest().getDate().format(AMERICAN_DATE_FORMAT),
                            r.getLatest().toShortString())
                    .addField("Oldest - " + r.getOldest().getDate().format(AMERICAN_DATE_FORMAT),
                            r.getOldest().toShortString())
                    .addField("Max - " + r.getMax().getDate().format(AMERICAN_DATE_FORMAT),
                            r.getMax().toShortString())
                    .addField("Min - " + r.getMin().getDate().format(AMERICAN_DATE_FORMAT),
                            r.getMin().toShortString()));
            loggerService.info("Success.");
        } else {
            loggerService.error("Failed to load quote.");
            final String userMention = BotUtil.getUserMention(event.getMessageAuthor());
            event.getChannel().sendMessage(userMention +
                    "Sorry, couldn't find that.");
        }
    }

    private void handleStockSearchQuery(MessageCreateEvent event,
                                        StockSearchQuery query) {
        loggerService.info("Handling stock search query.");
        loggerService.info("Identifier: " + query.getTicker());
        final Optional<List<YahooSearchResult>> results = queryHandlerService.handle(query);

        if (results.isPresent()) {
            final List<YahooSearchResult> list = results.get();
            final int LIMIT = 5;

            final EmbedBuilder builder = new EmbedBuilder()
                    .setColor(new Color(0, 128, 128))
                    .setFooter("Search results for '" + query.getTicker().toUpperCase() + "'");

            for (int i = 0; i < list.size() && i < LIMIT; i++) {
                String name = list.get(i).getShortname();
                if (name == null) name = list.get(i).getLongname();
                if (name == null) name = list.get(i).getSymbol();
                builder.addField(list.get(i).getSymbol(), name);
            }

            final String concat = list.stream()
                    .map(YahooSearchResult::getSymbol)
                    .collect(Collectors.joining(", "));
            loggerService.info("Responding: " + concat);
            event.getChannel().sendMessage(builder);
            loggerService.info("Success.");
        } else {
            loggerService.error("Failed to load quote.");
            final String userMention = BotUtil.getUserMention(event.getMessageAuthor());
            event.getChannel().sendMessage(userMention +
                    "Sorry, couldn't search that.");
        }
    }

    private void handleStockSpreadsheetQuery(MessageCreateEvent event,
                                             StockSpreadsheetQuery query) throws IOException {
        loggerService.info("Handling stock spreadsheet query.");
        loggerService.info("Identifier: " + query.getTicker());
        final Optional<StockSpreadsheetResponse> response = queryHandlerService.handle(query);

        if (response.isPresent()) {
            loggerService.info("Responding: " + response.get().getDownloadLink());
            event.getChannel().sendMessage(
                    HttpConnection.connect(response.get().getDownloadLink()).execute().bodyStream(),
                    response.get().getTicker() + ".csv"
            );
            loggerService.info("Success.");
        } else {
            loggerService.error("Failed to load quote.");
            final String userMention = BotUtil.getUserMention(event.getMessageAuthor());
            event.getChannel().sendMessage(userMention +
                    "Sorry, couldn't find that.");
        }
    }
}
