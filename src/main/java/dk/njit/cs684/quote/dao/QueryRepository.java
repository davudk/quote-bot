package dk.njit.cs684.quote.dao;

import com.mongodb.client.model.Sorts;
import dk.njit.cs684.quote.model.UserQuery;
import org.bson.types.ObjectId;
import org.mongojack.JacksonMongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class QueryRepository {
    @Autowired(required = false)
    private JacksonMongoCollection<UserQuery> requestLogCollection;

    public List<UserQuery> getRecent() {
        if (requestLogCollection == null) {
            return Collections.emptyList();
        }

        return requestLogCollection.find()
                .sort(Sorts.descending("timestamp"))
                .limit(25)
                .into(new ArrayList<>());
    }

    public void create(UserQuery query) {
        Objects.requireNonNull(query);
        if (requestLogCollection != null) {
            requestLogCollection.insertOne(query);
        } else {
            query.setId(ObjectId.get());
        }
    }

    public void replace(UserQuery query) {
        Objects.requireNonNull(query);
        if (requestLogCollection != null) {
            requestLogCollection.replaceOneById(query.getId(), query);
        }
    }
}
