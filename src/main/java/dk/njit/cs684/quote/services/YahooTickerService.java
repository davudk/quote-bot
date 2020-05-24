package dk.njit.cs684.quote.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.njit.cs684.quote.model.YahooSearchResult;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class YahooTickerService {
    private static final Logger logger = LoggerFactory.getLogger(YahooTickerService.class);
    private static final ObjectMapper om = new ObjectMapper();

    public List<YahooSearchResult> search(String text) throws IOException {
        final URI uri = new DefaultUriBuilderFactory()
                .builder()
                .scheme("https")
                .host("query1.finance.yahoo.com")
                .path("v1/finance/search")
                .queryParam("q", text)
                .queryParam("lang", "en-US")
                .queryParam("region", "US")
                .queryParam("quotesCount", "5")
                .queryParam("newsCount", "0")
                .build();

        final Connection.Response res = HttpConnection.connect(uri.toString()).timeout(5000)
                .ignoreContentType(true)
                .timeout(5000).execute();
        final JsonNode root = om.readTree(res.bodyStream());

        final List<YahooSearchResult> searchResults = new ArrayList<>();
        for (JsonNode item : root.get("quotes")) {
            final YahooSearchResult r = om.convertValue(item, YahooSearchResult.class);
            searchResults.add(r);
        }

        return searchResults;
    }
}
