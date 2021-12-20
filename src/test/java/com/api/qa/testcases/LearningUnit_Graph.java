package com.api.qa.testcases;

import com.api.qa.APIs.APIResponse;
import com.api.qa.Services.DataDeletionService;
import com.api.qa.base.TestBase_Deletion;
import com.api.qa.util.DataUtil;
import com.api.qa.util.TestData_LearningUnit;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LearningUnit_Graph extends TestBase_Deletion {

    APIResponse apiResponse = new APIResponse();
    DataDeletionService dataDeletionService = new DataDeletionService();
    TestData_LearningUnit testDataLearningUnit = new TestData_LearningUnit();

    private String role;
    public static final String learningUnit_Title = "Berhitung (Part 3)";
    public static final String learningUnitByShortID_Score = "1";

    @BeforeClass
    @Parameters("Role")
    public void setUID(String Role) {

        TestBase_Deletion_FileCreation(DataUtil.LearningUnitCollectionName);

        role = Role;
        switch (Role) {
            case "super_admin":
                apiResponse.uid = DataUtil.SuperAdminUID;
                break;
            case "admin":
                apiResponse.uid = DataUtil.AdminUID;
                break;
            case "marketing":
                apiResponse.uid = DataUtil.MarketingUID;
                break;
        }
    }

    @Test(priority = 1,description = "Verify Create Learning Unit API")
    public void verifyCreateLearningUnit () throws IOException {
        Response response = apiResponse.postRequest(testDataLearningUnit.createLearningUnitPayload());
        DataUtil.learningUnit_ID = response.jsonPath().getString("data.createLearningUnit.id");
        DataUtil.learningUnit_shortID = response.jsonPath().getString("data.createLearningUnit.shortId");
        if (DataUtil.crateLearningUnit(role)) {Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);
            out.write(response.jsonPath().getString("data.createLearningUnit.id"));
            out.newLine();}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 2,description = "Verify Update Learning Unit Content")
    public void verifyUpdateLearningUnitContent () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitContent());
        if (DataUtil.updateLearningUnitContent(role)) {Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 3,description = "Verify Update Learning Unit")
    public void verifyUpdateLearningUnit () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnit());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 4,description = "Verify Update Learning Unit state")
    public void verifyUpdateLearningUnitState () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitState());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("data.updateLearningUnitState"), "true");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 5,description = "Verify Learning Unit By Short ID")
    public void verifyLearningUnitByShortID () {
        Response response = apiResponse.postRequest(testDataLearningUnit.learningUnitByShortIDPayload());
        System.out.println(response.asString());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("data.learningUnitByShortId.score"),learningUnitByShortID_Score);}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 6,description = "Verify Update Learning Unit bulk operation")
    public void verifyUpdateLearningUnitStateBulk () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitStateBulk());
        System.out.println(response.asString());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertTrue(response.jsonPath().getString("data.updateLearningUnitStateBulk.success").contains(DataUtil.learningUnit_ID));}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }

    }

    @Test(priority = 7,description = "Verify Get Parents By child ID API")
    public void verifyGetParentsByChildId () {
        Response response = apiResponse.postRequest(testDataLearningUnit.getParentsByChildId());
        System.out.println(response.asString());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.statusCode(), DataUtil.STATUSCODE_200);}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 8,description = "Verify Learning Unit API")
    public void verifyLearningUnitAPI () {
        Response response = apiResponse.postRequest(testDataLearningUnit.learningUnitPayload());
        System.out.println(response.asString());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertTrue(response.jsonPath().getString("data.learningUnit.visibility").equals(DataUtil.visibility_Published) &&
                response.jsonPath().getString("data.learningUnit.title").equals(learningUnit_Title));}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 9,description = "Verify Create Learning Unit API without Title")
    public void verifyCreateLearningUnitWithoutTitle () {
        Response response = apiResponse.postRequest(testDataLearningUnit.createLearningUnitWithoutTitlePayload());
        if (DataUtil.crateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$title\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 10,description = "Verify Create Learning Unit API without Description")
    public void verifyCreateLearningUnitWithoutDescription () throws IOException {
        Response response = apiResponse.postRequest(testDataLearningUnit.createLearningUnitWithoutDescriptionPayload());
        if (DataUtil.crateLearningUnit(role)) {Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);
            out.write(response.jsonPath().getString("data.createLearningUnit.id"));
            out.newLine();}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 11,description = "Verify Update Learning Unit Content without ID")
    public void verifyUpdateLearningUnitContentWithoutID () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitContentWithoutID());
        if (DataUtil.updateLearningUnitContent(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$id\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 12,description = "Verify Update Learning Unit Content without privilege")
    public void verifyUpdateLearningUnitContentWithoutPrivilege () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitContentWithoutPrivilege());
        System.out.println(response.asString());
        if (DataUtil.updateLearningUnitContent(role)) {Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 13,description = "Verify Update Learning Unit without ID")
    public void verifyUpdateLearningUnitWithoutID () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitWithoutID());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$id\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 14,description = "Verify Update Learning Unit without Legacy")
    public void verifyUpdateLearningUnitWithoutLegacy () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitWithoutLegacy());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 15,description = "Verify Update Learning Unit state without ID")
    public void verifyUpdateLearningUnitStateWithoutID () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitStateWithoutID());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$id\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 16,description = "Verify Update Learning Unit state without Visiability")
    public void verifyUpdateLearningUnitStateWithoutVisiability () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitStateWithoutVisiaility());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$visibility\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 17,description = "Verify Learning Unit without Short ID")
    public void verifyLearningUnitWithoutShortID () {
        Response response = apiResponse.postRequest(testDataLearningUnit.learningUnitWithoutShortIDPayload());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$shortId\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 18,description = "Verify Update Learning Unit bulk operation without ID")
    public void verifyUpdateLearningUnitStateBulkWithoutID () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitStateBulkWithoutID());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 19,description = "Verify Get Parents without child ID API")
    public void verifyGetParentsWithoutChildId () {
        Response response = apiResponse.postRequest(testDataLearningUnit.getParentsWithoutChildId());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$childId\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 20,description = "Verify Learning Unit API without ID")
    public void verifyLearningUnitAPIWithoutID () {
        Response response = apiResponse.postRequest(testDataLearningUnit.learningUnitPayloadWithoutID());
        System.out.println(response.asString());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("errors.message"),"[Variable \"$id\" of required type \"String!\" was not provided.]");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 21,description = "Verify Create Learning Unit API to create flashcard")
    public void verifyCreateCreateFlashCard () throws IOException {
        Response response = apiResponse.postRequest(testDataLearningUnit.createFlashcardPayload());
        DataUtil.flashcard_ID = response.jsonPath().getString("data.createLearningUnit.id");
        DataUtil.flashcard_Checksum = response.jsonPath().getString("data.createLearningUnit.checksum");
        if (DataUtil.crateLearningUnit(role)) {Assert.assertNotNull(response.jsonPath().getString("data.createLearningUnit.id"));
            out.write(response.jsonPath().getString("data.createLearningUnit.id"));
            out.newLine();}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 22,description = "Verify Update Learning Unit Content for flash card")
    public void verifyUpdateLUcontentFlashcard () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateFlashcardLUcontent());
        if (DataUtil.updateLearningUnitContent(role)) {Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 23,description = "Verify Update Learning Unit state for flashcard")
    public void verifyUpdateLearningUnitStateFlashcard () {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLearningUnitStateFlashcard());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertEquals(response.jsonPath().getString("data.updateLearningUnitState"), "true");}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 24,description = "Verify Update Learning Unit bulk operation for flashcard")
    public void verifyUpdateLearningUnitStateBulkFlashcard() {
        Response response = apiResponse.postRequest(testDataLearningUnit.updateLUStateBulkFlashcard());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertTrue(response.jsonPath().getString("data.updateLearningUnitStateBulk.success").contains(DataUtil.flashcard_ID));}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 25,description = "Verify Learning Unit API for Flash card")
    public void verifyLUAPIFlashcard () {
        Response response = apiResponse.postRequest(testDataLearningUnit.learningUnitFlashcardPayload());
        System.out.println(response.asString());
        if (DataUtil.updateLearningUnit(role)) {Assert.assertTrue(response.jsonPath().getString("data.learningUnit.visibility").equals(DataUtil.visibility_Published) &&
                response.jsonPath().getString("data.learningUnit.title").equals(DataUtil.flashcard_Title));}
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @AfterClass
    public void deleteTestData() throws IOException {
        out.close();
        dataDeletionService.deleteData(DataUtil.LearningUnitCollectionName);
    }

}
