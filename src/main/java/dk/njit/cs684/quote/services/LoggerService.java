package dk.njit.cs684.quote.services;

import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import dk.njit.cs684.quote.model.UsageLog;
import org.mongojack.JacksonMongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

@Service
public class LoggerService {
    private ThreadLocal<String> defaultContext = new InheritableThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return UUID.randomUUID().toString();
        }
    };

    @Autowired(required = false)
    private JacksonMongoCollection<UsageLog> usageLogCollection;

    public String getThreadLocalContext() {
        return defaultContext.get();
    }

    public void setThreadLocalContext(String context) {
        this.defaultContext.set(context);
    }

    public void info(Throwable t) {
        log("INFO", getThreadLocalContext(), t);
    }
    public void info(String context, Throwable t) {
        log("INFO", context, t);
    }
    public void info(String text) {
        log("INFO", getThreadLocalContext(), text);
    }
    public void info(String context, String text) {
        log("INFO", context, text);
    }

    public void warn(Throwable t) {
        log("WARN", getThreadLocalContext(), t);
    }
    public void warn(String context, Throwable t) {
        log("WARN", context, t);
    }
    public void warn(String text) {
        log("WARN", getThreadLocalContext(), text);
    }
    public void warn(String context, String text) {
        log("WARN", context, text);
    }

    public void error(Throwable t) {
        log("ERROR", getThreadLocalContext(), t);
    }
    public void error(String context, Throwable t) {
        log("ERROR", context, t);
    }
    public void error(String text) {
        log("ERROR", getThreadLocalContext(), text);
    }
    public void error(String context, String text) {
        log("ERROR", context, text);
    }

    private void log(String level, String context, Throwable t) {
        try (final StringWriter sw = new StringWriter()) {
            try (final PrintWriter pw = new PrintWriter(sw)) {
                t.printStackTrace(pw);
            }
            log(level, context, sw.toString());
        } catch (Exception e) {
            log(level, context, t.getMessage());
            e.printStackTrace();
        }
    }

    private void log(String level, String context, String text) {
        if (usageLogCollection != null) {
            final UsageLog log = new UsageLog();
            log.setLevel(level);
            log.setContext(context);
            log.setText(text);
            log.setTimestamp(new Date());

            try {
                usageLogCollection.insertOne(log);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<UsageLog> getContexts() {
        if (usageLogCollection == null) return Collections.emptyList();
        return usageLogCollection.aggregate(Collections.singletonList(
                Aggregates.group("$context", Accumulators.max("timestamp", "$timestamp"))
        )).into(new ArrayList<>());
    }

    public List<UsageLog> getLogs(String context) {
        if (usageLogCollection == null) return Collections.emptyList();
        return usageLogCollection.find(Filters.eq("context", context))
                .sort(Sorts.ascending("timestamp"))
                .into(new ArrayList<>());
    }
}
