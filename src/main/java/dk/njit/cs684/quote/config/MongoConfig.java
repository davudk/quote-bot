package dk.njit.cs684.quote.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dk.njit.cs684.quote.model.Quote;
import dk.njit.cs684.quote.model.UsageLog;
import dk.njit.cs684.quote.model.UserQuery;
import org.mongojack.JacksonMongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class MongoConfig {

    @Value("${datasource.mongo.url:}")
    private String connectionString;

    @Bean
    public MongoClient mongoClient() {
        if (StringUtils.hasText(connectionString)) {
            final MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .retryWrites(true)
                    .build();
            return MongoClients.create(settings);
        } else return null;
    }

    @Bean
    public JacksonMongoCollection<Quote> stockQuoteCollection(@Autowired(required = false) MongoClient client) {
        if (client == null) return null;
        return JacksonMongoCollection.builder()
                .build(client, "CS684", "StockQuotes", Quote.class);
    }

    @Bean
    public JacksonMongoCollection<UserQuery> requestLogCollection(@Autowired(required = false) MongoClient client) {
        if (client == null) return null;
        return JacksonMongoCollection.builder()
                .build(client, "CS684", "RequestLog", UserQuery.class);
    }

    @Bean
    public JacksonMongoCollection<UsageLog> usageLogCollection(@Autowired(required = false) MongoClient client) {
        if (client == null) return null;
        return JacksonMongoCollection.builder()
                .build(client, "CS684", "UsageLog", UsageLog.class);
    }
}
