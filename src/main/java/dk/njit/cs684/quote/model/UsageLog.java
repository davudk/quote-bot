package dk.njit.cs684.quote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsageLog {
    private String level, context, text;
    private Date timestamp;

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public String getContext() { return context; }
    public void setContext(String context) { this.context = context; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}
