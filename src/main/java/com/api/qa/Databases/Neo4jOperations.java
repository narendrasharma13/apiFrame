package com.api.qa.Databases;

import com.api.qa.base.TestBase_Log4j;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Neo4jOperations extends TestBase_Log4j {

    public void deleteNeo4jData(String shortId, String type, String neoURL){
        RestAssured.baseURI = neoURL;

        Response res =  given()
                .contentType(ContentType.JSON)
                .body("{\"shortId\":\""+shortId+"\",\n" +
                        " \"type\":\""+type+"\"\n" +
                        "}")
                .post("/api/v1/removeNode")
                .then()
                .extract()
                .response();
        log.info("Data Deleted from neo4j "+res.asString());
    }

}
