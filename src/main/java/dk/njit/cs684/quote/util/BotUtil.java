package dk.njit.cs684.quote.util;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;

public class BotUtil {

    public static String getUserMention(MessageAuthor author) {
        try {
            return author.asUser().map(User::getMentionTag)
                    .map(m -> m + " ")
                    .orElse("");
        } catch (Exception e) {
            return "";
        }
    }
}
