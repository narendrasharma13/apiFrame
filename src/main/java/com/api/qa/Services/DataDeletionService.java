package com.api.qa.Services;

import com.api.qa.Databases.ESOperations;
import com.api.qa.Databases.MongoOperations;
import com.api.qa.base.TestBase_Log4j;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataDeletionService extends TestBase_Log4j {

    BufferedReader reader;

    MongoOperations mongoOperations = new MongoOperations();
    ESOperations esOperations = new ESOperations();

    public Properties prop;

    public DataDeletionService(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/api"
                    + "/qa/config/mongo.properties");
            prop.load(ip);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String collectionName) {
        try {
            reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + collectionName));
            String id = reader.readLine();
            while (id != null) {

                //Delete from Mongo
                log.info("Deleting the Data from Mongo");
                mongoOperations.deleteMongoData(collectionName, prop.getProperty("URI"), prop.getProperty("neoURL"), id);

                log.info("Waiting for 10 sec to run monstache service");
                Thread.sleep(10000);

                //Check data in ES
                log.info("Checking the Data from ES");
                esOperations.verifyDataPresenceInES(collectionName, id);

                id = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String collectionName,String ESHost) {
        try {
            reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + collectionName));
            String id = reader.readLine();
            while (id != null) {

                //Delete from Mongo
                log.info("Deleting the Data from Mongo");
                mongoOperations.deleteMongoData(collectionName, prop.getProperty("URI"), prop.getProperty("neoURL"), id);

                log.info("Waiting for 10 sec to run monstache service");
                Thread.sleep(10000);

                //Check data in ES
                log.info("Checking the Data from ES");
                esOperations.verifyDataPresenceInES(collectionName, id, ESHost);

                id = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
