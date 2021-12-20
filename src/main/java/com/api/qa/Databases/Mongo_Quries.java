package com.api.qa.Databases;

import com.api.qa.base.TestBase_Log4j;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.eq;

public class Mongo_Quries extends TestBase_Log4j {

    public long deleteLearningPlanBasedOnIDs(MongoCollection<Document> collection, String id) {
        Bson filter = eq("_id", id);
        DeleteResult result = collection.deleteOne(filter);
        log.info("Number of Data Deleted: " + result.getDeletedCount() + "\nIds are: " +id);
        return result.getDeletedCount();
    }

    public FindIterable<Document> getDataBasedOnID(MongoCollection<Document> collection, String id) {

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("_id", id);
        return collection.find(whereQuery);

    }


}
