package com.api.qa.APIs;

import com.api.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class APIResponse extends TestBase {
    public APIResponse() {
        TestBase();
    }
    public String uid;

    public Response postRequest(String payload) {
    	
        RestAssured.baseURI = prop.getProperty("zenius_Dev");
        return
                given()
                        .contentType(ContentType.JSON)
                        .header("x-token", "Bearer " + getToken())
                        .body(payload)
                        .post("/graphql")
                        .then()
                        .extract()
                        .response();
    }

    //To get APN Config
    public Response getAPNConfig() {
        RestAssured.baseURI = prop.getProperty("APNConfig_URL");
        return
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + getToken())
                        .get("/config/detail/apn_config")
                        .then()
                        .extract()
                        .response();
    }

    //To Post/Update APN Config
    public Response updateAPNConfig(String payload) {
        RestAssured.baseURI = prop.getProperty("APNConfig_URL");
        return
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + getToken())
                        .body(payload)
                        .post("/config/upsert")
                        .then()
                        .extract()
                        .response();
    }

    public String getToken() {
        RestAssured.baseURI=prop.getProperty("getToken_URL");
        return  given().
                contentType(ContentType.JSON).
                param("uid", uid).
                param("adminToken", "vfYUE56456AK^UtouJ").
                when().
                get("/token").
                then().
                extract().
                jsonPath().get("idToken");
    }

    public String getToken_APP() {
        RestAssured.baseURI=prop.getProperty("getToken_URL");
        return  given().
                contentType(ContentType.JSON).
                param("uid", uid).
                param("adminToken", "vfYUE56456AK^UtouJ").
                when().
                get("/token").
                then().
                extract().
                jsonPath().get("idToken");
    }
    
    public Response postRequestMathpix(String payload) {
        RestAssured.baseURI = prop.getProperty("Mathpix_URL");
        return
                given()
                        .contentType(ContentType.JSON)
                        .header("app_id","kartik_zeniuseducation_com_91b78c")
                        .header("app_key","37da8ffaa2067ec7adc9")
                        .header("Content-Type","application/json;charset=UTF-8")
                        .body(payload)
                        .post("/v3/text")
                        .then()
                        .extract()
                        .response();
    }
    
    public Response postRequestVectorSearch(String payload) {
        RestAssured.baseURI = prop.getProperty("VectorSearch");
        Response res=
                given()
                        .contentType(ContentType.JSON)
                        .header("authorization", "Bearer " + getToken())
                        .header("Content-Type","application/json;charset=UTF-8")
                        .body(payload)
                        .post()
                        .then()
                        .extract()
                        .response();
        return res;
    }


    public Response putUnlikeRequest(String payload) {
    	
        RestAssured.baseURI = prop.getProperty("unlikeUrl");
        return
                given()
                        .contentType(ContentType.JSON)
                        .header("x-token", "Bearer " + getToken())
                        .body(payload)
                        .put()
                        .then()
                        .extract()
                        .response();
    }

}