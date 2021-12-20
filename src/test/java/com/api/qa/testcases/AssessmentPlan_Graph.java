package com.api.qa.testcases;

import com.api.qa.APIs.APIResponse;
import com.api.qa.Services.DataDeletionService;
import com.api.qa.base.TestBase_Deletion;
import com.api.qa.util.DataUtil;
import com.api.qa.util.TestData_AssessmentPlan;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;

public class AssessmentPlan_Graph extends TestBase_Deletion {

    APIResponse apiResponse = new APIResponse();
    DataDeletionService dataDeletionService = new DataDeletionService();
    TestData_AssessmentPlan testData = new TestData_AssessmentPlan();

    private String role;

    @BeforeClass
    @Parameters("Role")
    public void setUID(String Role) {
        TestBase_Deletion_FileCreation(DataUtil.AssessmentPlanCollectionName);
        role = Role;
        if (Role.equals("super_admin")) { apiResponse.uid = DataUtil.SuperAdminUID; }
        else if (Role.equals("admin")) { apiResponse.uid = DataUtil.AdminUID; }
        else if (Role.equals("marketing")) { apiResponse.uid = DataUtil.MarketingUID; }
    }

    @Test(priority = 1,description = "Verify Create Assessment Plan for Quiz")
    public void verifyCreateAPQuiz() throws IOException {
        Response response = apiResponse.postRequest(testData.createAPQuizPayload());
        DataUtil.quiz_ID = response.jsonPath().getString("data.createAssessmentPlan.id");
        DataUtil.quiz_ShortID = response.jsonPath().getString("data.createAssessmentPlan.shortId");
        if (DataUtil.crateAssessmentPlan(role)) { Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_200);
            out.write(response.jsonPath().getString("data.createAssessmentPlan.id"));
            out.newLine(); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 2,description = "Verify Update Learning Plan Content API for Quiz")
    public void verifyUpdateAPContentQuiz() {
        Response response = apiResponse.postRequest(testData.updateLPContentQuizPayLoad());
        DataUtil.quiz_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        if (DataUtil.updateAssessmentlanContent(role)) { Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanContent.content.assessmentPlanId").contains(DataUtil.quiz_ID)); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 3,description = "Verify Update Assessment Plan for Quiz")
    public void verifyUpdateAPQuiz() {
        Response response = apiResponse.postRequest(testData.updateQuizLPPayload());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlan.title"),DataUtil.quizUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);}
    }

    @Test(priority = 4,description = "Verify Update Assessment Plan State Quiz")
    public void verifyUpdateAPStateQuiz() {
        Response response = apiResponse.postRequest(testData.updateAPStateQuiz());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlanState"),"true"); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 5,description = "Verify Assessment Plan for Quiz")
    public void verifyAPQuiz() {
        Response response = apiResponse.postRequest(testData.assessmentPlanPayloadQuiz());
        if (DataUtil.getAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.assessmentPlan.title"),DataUtil.quizUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }


    //----------------------------------Practice Test cases----------------------------------------
    @Test(priority = 6,description = "Verify Create Assessment Plan for Practice")
    public void verifyCrateAPPractice() throws IOException {
        Response response = apiResponse.postRequest(testData.createPracticeAPPayload());
        DataUtil.practice_ID = response.jsonPath().getString("data.createAssessmentPlan.id");
        DataUtil.practice_ShortID = response.jsonPath().getString("data.createAssessmentPlan.shortId");
        if (DataUtil.crateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.createAssessmentPlan.name"),DataUtil.practice_Title);
            out.write(response.jsonPath().getString("data.createAssessmentPlan.id"));
            out.newLine(); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 7,description = "Verify Update Learning Plan Content API for Practice")
    public void verifyUpdateAPContentPractice() {
        Response response = apiResponse.postRequest(testData.updateLPContentPracticePayLoad());
        DataUtil.practice_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        if (DataUtil.updateAssessmentlanContent(role)) { Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanContent.content.assessmentPlanId").contains(DataUtil.practice_ID)); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 8,description = "Verify Update Assessment Plan for Practice")
    public void verifyUpdateAPPractice() {
        Response response = apiResponse.postRequest(testData.updatePracticeLPPayload());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlan.title"),DataUtil.practiceUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);}
    }

    @Test(priority = 9,description = "Verify Update Assessment Plan State Practice")
    public void verifyUpdateAPStatePractice() {
        Response response = apiResponse.postRequest(testData.updateAPStatePractice());
        System.out.println(response.asString());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlanState"),"true"); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 10,description = "Verify Assessment Plan for Practice")
    public void verifyAPPractice() {
        Response response = apiResponse.postRequest(testData.assessmentPlanPayloadPractice());
        System.out.println(response.asString());
        if (DataUtil.getAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.assessmentPlan.title"),DataUtil.practiceUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    //----------------------------------TryOut Test cases----------------------------------------
    @Test(priority = 11,description = "Verify Create Assessment Plan for Tryout")
    public void verifyCrateAPTryout() throws IOException {
        Response response = apiResponse.postRequest(testData.createTryoutAPPayload());
        DataUtil.tryout_ID = response.jsonPath().getString("data.createAssessmentPlan.id");
        DataUtil.tryout_ShortID = response.jsonPath().getString("data.createAssessmentPlan.shortId");
        if (DataUtil.crateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.createAssessmentPlan.name"),DataUtil.tryout_Title);
            out.write(response.jsonPath().getString("data.createAssessmentPlan.id"));
            out.newLine(); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 12,description = "Verify Update Assessment Plan for Tryout")
    public void verifyUpdateAPTryout() {
        Response response = apiResponse.postRequest(testData.updateTryoutLPPayload());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlan.title"),DataUtil.tryoutUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);}
    }

    @Test(priority = 13,description = "Verify Update Assessment Plan State Tryout")
    public void verifyUpdateAPStateTryout() {
        Response response = apiResponse.postRequest(testData.updateAPStateTryout());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlanState"),"true"); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 14,description = "Verify Assessment Plan for Tryout")
    public void verifyAPTryout() {
        Response response = apiResponse.postRequest(testData.assessmentPlanPayloadTryout());
        if (DataUtil.getAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.assessmentPlan.title"),DataUtil.tryoutUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    //----------------------------------Premium TryOut Test cases----------------------------------------
    @Test(priority = 15,description = "Verify Create Assessment Plan for Premium Tryout")
    public void verifyCrateAPPremiumTryout() throws IOException {
        Response response = apiResponse.postRequest(testData.createPremiumTryoutAPPayload());
        DataUtil.premiumTryout_ID = response.jsonPath().getString("data.createAssessmentPlan.id");
        DataUtil.premiumTryout_ShortID = response.jsonPath().getString("data.createAssessmentPlan.shortId");
        if (DataUtil.crateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.createAssessmentPlan.name"),DataUtil.premiumTryout_Title);
            out.write(response.jsonPath().getString("data.createAssessmentPlan.id"));
            out.newLine(); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 16,description = "Verify Update Assessment Plan for Premium Tryout")
    public void verifyUpdateAPPremiumTryout() {
        Response response = apiResponse.postRequest(testData.updatePremiumTryoutAPPayload());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlan.title"),DataUtil.premiumTryoutUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);}
    }

    @Test(priority = 17,description = "Verify Update Assessment Plan State Premium Tryout")
    public void verifyUpdateAPStatePremiumTryout() {
        Response response = apiResponse.postRequest(testData.updateAPStatePremiumTryout());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlanState"),"true"); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 18,description = "Verify Assessment Plan for Premium Tryout")
    public void verifyAPPremiumTryout() {
        Response response = apiResponse.postRequest(testData.assessmentPlanPayloadPremiumTryout());
        if (DataUtil.getAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.assessmentPlan.title"),DataUtil.premiumTryoutUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    //----------------------------------Daily Quiz Test cases----------------------------------------
    @Test(priority = 19,description = "Verify Create Assessment Plan for Daily Quiz")
    public void verifyCrateAPDailyQuiz() throws IOException {
        Response response = apiResponse.postRequest(testData.createDailyQuizAPPayload());
        DataUtil.dailyQuiz_ID = response.jsonPath().getString("data.createAssessmentPlan.id");
        DataUtil.dailyQuiz_ShortID = response.jsonPath().getString("data.createAssessmentPlan.shortId");
        if (DataUtil.crateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.createAssessmentPlan.name"),DataUtil.dailyQuiz_Title);
            out.write(response.jsonPath().getString("data.createAssessmentPlan.id"));
            out.newLine(); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 20,description = "Verify Update Assessment Plan for DailyQuiz")
    public void verifyUpdateAPDailyQuiz() {
        Response response = apiResponse.postRequest(testData.updateDailyQuizAPPayload());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlan.title"),DataUtil.dailyQuizUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);}
    }

    @Test(priority = 21,description = "Verify Update Assessment Plan State DailyQuiz")
    public void verifyUpdateAPStateDailyQuiz() {
        Response response = apiResponse.postRequest(testData.updateAPStateDailyQuiz());
        if (DataUtil.updateAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.updateAssessmentPlanState"),"true"); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    @Test(priority = 22,description = "Verify Assessment Plan for DailyQuiz")
    public void verifyAPDailyQuiz() {
        Response response = apiResponse.postRequest(testData.assessmentPlanPayloadDailyQuiz());
        if (DataUtil.getAssessmentPlan(role)) { Assert.assertEquals(response.jsonPath().getString("data.assessmentPlan.title"),DataUtil.dailyQuizUpdated_Title); }
        else { Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500); }
    }

    //----------------------------------Negative Test cases----------------------------------------
    @Test(priority = 23,description = "Verify Create Assessment Plan Without Title")
    public void verifyCrateAPWithoutTitle() {
        Response response = apiResponse.postRequest(testData.createAPPayloadWithoutTitle());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 24,description = "Verify Update Assessment Plan Without ID")
    public void verifyUpdateAPDailyQuizWithoutID() {
        Response response = apiResponse.postRequest(testData.updateAPPayloadWithoutID());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 25,description = "Verify Update Assessment Plan State Without Visiability")
    public void verifyUpdateAPStateWithoutVisiability() {
        Response response = apiResponse.postRequest(testData.updateAPStateWithoutVisiability());
        System.out.println(response.asString());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"),DataUtil.STATUSCODE_500);
    }

    @Test(priority = 26,description = "Verify Assessment Plan Without ID")
    public void verifyAPWithoutID() {
        Response response = apiResponse.postRequest(testData.assessmentPlanPayloadWithoutID());
        System.out.println(response.asString());
        Assert.assertNull(response.jsonPath().getString("data.assessmentPlan"));
    }


    @AfterClass
    public void deleteTestData() throws IOException {
        out.close();
        dataDeletionService.deleteData(DataUtil.AssessmentPlanCollectionName);
    }


}
