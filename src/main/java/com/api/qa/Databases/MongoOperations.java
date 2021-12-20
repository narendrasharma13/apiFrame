package com.api.qa.Databases;

import com.api.qa.base.TestBase_Log4j;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;
import java.util.HashMap;
import java.util.Map;

public class MongoOperations extends TestBase_Log4j {

    Mongo_Quries mongo_quries = new Mongo_Quries();
    Neo4jOperations neo4jOperations = new Neo4jOperations();
    MongoCollection<Document> collection;
    private Map<String, String> dataMap = new HashMap<>();

    private void mongoConnection(String db, String collectionName, String URI) {
        MongoClientURI uri = new MongoClientURI(URI);
        MongoClient mongo = new MongoClient(uri);
        //Connecting to the database
        MongoDatabase database = mongo.getDatabase(db);
        //Creating a collection object
        collection = database.getCollection(collectionName);
    }

    public void deleteMongoData(String collectionName, String URI, String neoURL, String id) {

        String type = "";
        String shortId = "";

        mongoConnection("zs_content", collectionName, URI);

        //fetch relavent data for ID
        FindIterable<Document> iterableDoc = mongo_quries.getDataBasedOnID(collection, id);
        for (Document doc : iterableDoc) {
            type = String.valueOf(doc.get("type"));
            shortId = String.valueOf(doc.get("shortId"));
            log.info("Short Id is " + shortId + " Type is " + type);
            dataMap.put(shortId, type);
        }

        //Delete data from mongo
        log.info("Deleting data from Mongo");
        long deletedCount = mongo_quries.deleteLearningPlanBasedOnIDs(collection, id);

        //Check if data is deleted or not from mongo
        log.info("Checking if data is deleted or not from mongo");
        if (deletedCount > 0) {
            //Delete the data from Neo4j
            log.info("Deleting the data from Neo4j");
            neo4jOperations.deleteNeo4jData(shortId, type, neoURL);
        }
    }

}
