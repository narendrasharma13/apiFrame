package com.api.qa.testcases;

import com.api.qa.APIs.APIResponse;
import com.api.qa.Services.DataDeletionService;
import com.api.qa.base.TestBase_Deletion;
import com.api.qa.util.DataUtil;
import com.api.qa.util.TestData_Questions;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Questions_Graph extends TestBase_Deletion {

    APIResponse apiResponse = new APIResponse();
    DataDeletionService dataDeletionService = new DataDeletionService();
    TestData_Questions testData = new TestData_Questions();

    private String role;
    @BeforeClass
    @Parameters("Role")
    public void setUID(String Role) {
        TestBase_Deletion_FileCreation(DataUtil.QuestionsCollectionName);
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

    /*@Test(priority = 1,description = "Verify Create Questions")
    public void verifyCreateQuestions() throws IOException {
        Response response = apiResponse.postRequest(testData.createQuestionPayload());
        System.out.println(response.asString());
        DataUtil.question_ID = response.jsonPath().getString("data.createQuestion.id");
        DataUtil.question_ShortID = response.jsonPath().getString("data.createQuestion.shortId");
        if (DataUtil.createQuestion(role)) { Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);
            out.write(response.jsonPath().getString("data.createQuestion.id"));
            out.newLine(); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 2,description = "Verify Update Learning Plan Content API for Question")
    public void verifyUpdateQuestionContent() {
        Response response = apiResponse.postRequest(testData.updateAPContentQuestionPayLoad());
        DataUtil.question_Checksum = response.jsonPath().getString("data.updateAssessmentPlanContent.checksum");
        if (DataUtil.updateQuestionContent(role)) { Assert.assertTrue(response.jsonPath().getString("data.updateAssessmentPlanContent.id").contains(DataUtil.questionQuiz_ID)); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 3,description = "Verify Update Question title")
    public void verifyUpdateQuestion() {
        Response response = apiResponse.postRequest(testData.updateQuestionPayload());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateQuestion.title"),DataUtil.questionUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);}
    }

    @Test(priority = 4,description = "Verify Update Question State")
    public void verifyUpdateQuestionState() {
        Response response = apiResponse.postRequest(testData.updateQuestionStatePayload());
        if (DataUtil.updateQuestion(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateQuestionState"),"true"); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 5,description = "Verify Get Question API")
    public void verifyGetQuestion() {
        Response response = apiResponse.postRequest(testData.getQuestionPayload());
        if (DataUtil.getQuestion(role)) { Assert.assertEquals(response.jsonPath().getString("data.question.title"),DataUtil.questionUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }*/

    //-------------------------------------Negative Cases----------------------------------------------
    @Test(priority = 6,description = "Verify Create Questions Without Title")
    public void verifyCreateQuestionsWithoutTitle() {
        Response response = apiResponse.postRequest(testData.createQuestionPayloadWithoutTitle());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 7,description = "Verify Update Learning Plan Content API for Question Without ID")
    public void verifyUpdateContentQuestionWithoutId() {
        Response response = apiResponse.postRequest(testData.updateContentQuestionPayLoadWithoutID());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 8,description = "Verify Update Question title Without ID")
    public void verifyUpdateQuestionWithoutId() {
        Response response = apiResponse.postRequest(testData.updateQuestionPayloadWithoutId());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 9,description = "Verify Update Question State Without Id")
    public void verifyUpdateQuestionStateWithoutId() {
        Response response = apiResponse.postRequest(testData.updateQuestionStatePayloadWithoutId());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 10,description = "Verify Get Question API Without Id")
    public void verifyGetQuestionWithoutId() {
        Response response = apiResponse.postRequest(testData.getQuestionPayloadWithoutId());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 11,description = "Verify Create Questions Without Subject")
    public void verifyCreateQuestionsWithoutSubject() throws IOException {
        Response response = apiResponse.postRequest(testData.createQuestionPayloadWithoutSub());
        DataUtil.question_ID = response.jsonPath().getString("data.createQuestion.id");
        if (DataUtil.createQuestion(role)) { Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);
            out.write(response.jsonPath().getString("data.createQuestion.id"));
            out.newLine(); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 12,description = "Verify Update Learning Plan Content API for Question Without Order")
    public void updateQuestionContentWithoutOrder() {
        Response response = apiResponse.postRequest(testData.contentQuestionPayLoadWithoutOrder());
        if (DataUtil.updateQuestionContent(role)) { Assert.assertTrue(response.jsonPath().getString("data.updateAssessmentPlanContent.id").contains(DataUtil.questionQuiz_ID)); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }


    @AfterClass
    public void deleteTestData() throws IOException {
        out.close();
        dataDeletionService.deleteData(DataUtil.QuestionsCollectionName,"18.140.231.103");
    }


}
