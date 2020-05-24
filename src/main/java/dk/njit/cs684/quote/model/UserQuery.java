package dk.njit.cs684.quote.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.mongojack.Id;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserQuery {
    @Id
    private ObjectId id;
    private String username, message;
    private boolean complete, success;
    private Date timestamp;

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public boolean isComplete() { return complete; }
    public void setComplete(boolean complete) { this.complete = complete; }
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}
