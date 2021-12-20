package com.api.qa.testcases;

import com.api.qa.APIs.APIResponse;
import com.api.qa.Services.DataDeletionService;
import com.api.qa.base.TestBase_Deletion;
import com.api.qa.util.DataUtil;
import com.api.qa.util.TestData_LearningPlan;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class LearningPlan_Graph extends TestBase_Deletion {

    APIResponse apiResponse = new APIResponse();
    DataDeletionService dataDeletionService = new DataDeletionService();
    TestData_LearningPlan testData = new TestData_LearningPlan();

    private String role;

    @BeforeClass
    @Parameters("Role")
    public void setUID(String Role) {
        TestBase_Deletion_FileCreation(DataUtil.LearningPlanCollectionName);
        role = Role;
        if (Role.equals("super_admin")) {
            apiResponse.uid = DataUtil.SuperAdminUID;
        } else if (Role.equals("admin")) {
            apiResponse.uid = DataUtil.AdminUID;
        } else if (Role.equals("marketing")) {
            apiResponse.uid = DataUtil.MarketingUID;
        }
    }

    @Test(priority = 1, description = "Verify Create Learning Plan API")
    public void verifyCrateLearningPlanAPI() throws IOException {
        Response response = apiResponse.postRequest(testData.createLearningPlanPayload());
        DataUtil.updateLearningPlan_ID = response.jsonPath().getString("data.createLearningPlan.id");
        DataUtil.learningPlan_shortID = response.jsonPath().getString("data.createLearningPlan.shortId");
        out.write(response.jsonPath().getString("data.createLearningPlan.id"));
        out.newLine();
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.statusCode(), DataUtil.STATUSCODE_200);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }

    }

    @Test(priority = 2, description = "Verify Update Learning Plan Content API")
    public void verifyUpdateLearningPlanContentAPI() {
        Response response = apiResponse.postRequest(testData.updateLearningPlanContentPayLoad());
        DataUtil.updateLearningPlan_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        Assert.assertEquals(response.statusCode(), DataUtil.STATUSCODE_200);
    }

    @Test(priority = 3, description = "Verify Update Learning Plan API")
    public void verifyUpdateLearningPlanAPI() {
        Response response = apiResponse.postRequest(testData.updateLearningPlanPayload());
        Assert.assertEquals(response.statusCode(), DataUtil.STATUSCODE_200);
    }

    @Test(priority = 4, description = "Verify Update Learning Plan State API")
    public void verifyUpdateLearningPlanStateAPI() {
        Response response = apiResponse.postRequest(testData.updateLearningPlanState());
        Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlanState"), "true");
    }

    @Test(priority = 5, description = "Verify Learning Plan API")
    public void verifyLearningPlanAPI() {
        Response response = apiResponse.postRequest(testData.learningPlanPayload());
        Assert.assertEquals(response.jsonPath().getString("data.learningPlan.name"), DataUtil.createLearningPlan_Title);
    }

    @Test(priority = 6, description = "Verify Update Learning Plan State Bulk API")
    public void verifyUpdateLearningPlanStateBulkAPI() {
        Response response = apiResponse.postRequest(testData.updateLearningPlanStateBulk());
        Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanStateBulk.success").contains(DataUtil.updateLearningPlan_ID));
    }

    @Test(priority = 7, description = "Verify Update Learning Plan Bulk API")
    public void verifyUpdateLearningPlanBulkAPI() {
        Response response = apiResponse.postRequest(testData.updateLearningPlanBulk());
        Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanBulk.success").contains(DataUtil.updateLearningPlan_ID));
    }

    @Test(priority = 8, description = "Verify Learning Plan By Short ID API")
    public void verifyLearningPlanByShortIDAPI() {
        Response response = apiResponse.postRequest(testData.learningPlanByShortIDPayload());
        Assert.assertEquals(response.jsonPath().getString("data.learningPlanByShortId.name"), DataUtil.createLearningPlan_Name);
    }

    //----------------------------------Flash card Group Operations--------------------------------------
    @Test(priority = 9, description = "Verify Create Learning Plan API for Flashcard group")
    public void verifyCreateLPapiFlashcardGroup() throws IOException {
        Response response = apiResponse.postRequest(testData.createLPPayloadFlashcardGroup());
        DataUtil.flashcardGroup_ID = response.jsonPath().getString("data.createLearningPlan.id");
        DataUtil.flashcardGroup_ShortID = response.jsonPath().getString("data.createLearningPlan.shortId");
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.createLearningPlan.title"), DataUtil.flashcardGroup_Title);
            out.write(response.jsonPath().getString("data.createLearningPlan.id"));
            out.newLine();
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 10, description = "Verify Update Learning Plan Content API for Flashcard Group")
    public void verifyUpdateLPContentAPIFlashcardGroup() {
        Response response = apiResponse.postRequest(testData.updateLPContentPayLoadFlashcardGroup());
        DataUtil.flashcardGroup_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        if (DataUtil.updateLearningPlanContent(role)) {
            Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanContent.content.learningPlan.id").contains(DataUtil.flashcardGroup_ID));
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 11, description = "Verify Update Learning Plan API for flashcard group")
    public void verifyUpdateLPAPIFlashcardGroup() {
        Response response = apiResponse.postRequest(testData.updateLPPayloadFlashCardGroup());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlan.title"), DataUtil.flashcardGroupUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 12, description = "Verify Update Learning Plan State API")
    public void verifyUpdateLPStateAPIFlashcardGroup() {
        Response response = apiResponse.postRequest(testData.updateLPStateFlashcardGroup());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlanState"), "true");
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 13, description = "Verify Learning Plan API for Flashcard Group")
    public void verifyLearningPlanAPIFlashcardGroup() {
        Response response = apiResponse.postRequest(testData.learningPlanPayloadFlashcardGroup());
        System.out.println(response.asString());
        DataUtil.flashcardGroup_Checksum = response.jsonPath().getString("data.learningPlan.checksum");
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.learningPlan.title"), DataUtil.flashcardGroupUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    //-------------------------------------Node Operations-----------------------------------------
    @Test(priority = 14, description = "Verify Create Learning Plan API for Node")
    public void verifyCreateLPapiNode() throws IOException {
        Response response = apiResponse.postRequest(testData.createLPPayloadNode());
        DataUtil.node_ID = response.jsonPath().getString("data.createLearningPlan.id");
        DataUtil.node_ShortID = response.jsonPath().getString("data.createLearningPlan.shortId");
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.createLearningPlan.title"), DataUtil.node_Title);
            out.write(response.jsonPath().getString("data.createLearningPlan.id"));
            out.newLine();
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 15, description = "Verify Update Learning Plan Content API for Node")
    public void verifyUpdateLPContentAPINode() {
        Response response = apiResponse.postRequest(testData.updateLPContentPayLoadNode());
        System.out.println(response.asString());
        DataUtil.node_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        if (DataUtil.updateLearningPlanContent(role)) {
            Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanContent.content.learningPlan.id").contains(DataUtil.node_ID));
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 16, description = "Verify Update Learning Plan API for Node")
    public void verifyUpdateLPapiNode() {
        Response response = apiResponse.postRequest(testData.updateLPPayloadNode());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlan.title"), DataUtil.nodeUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 17, description = "Verify Update Learning Plan State API for Node")
    public void verifyUpdateLPStateAPINode() {
        Response response = apiResponse.postRequest(testData.updateLPStateNode());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlanState"), "true");
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 18, description = "Verify Learning Plan API for Flashcard Group")
    public void verifyLearningPlanAPINode() {
        Response response = apiResponse.postRequest(testData.learningPlanPayloadNode());
        System.out.println(response.asString());
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.learningPlan.title"), DataUtil.nodeUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    //-------------------------------------Topic Operations-----------------------------------------
    @Test(priority = 19, description = "Verify Create Learning Plan API for Topic")
    public void verifyCreateLPapiTopic() throws IOException {
        Response response = apiResponse.postRequest(testData.createLPPayloadTopic());
        DataUtil.topic_ID = response.jsonPath().getString("data.createLearningPlan.id");
        DataUtil.topic_ShortID = response.jsonPath().getString("data.createLearningPlan.shortId");
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.createLearningPlan.title"), DataUtil.topic_Title);
            out.write(response.jsonPath().getString("data.createLearningPlan.id"));
            out.newLine();
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 20, description = "Verify Update Learning Plan Content API for Topic")
    public void verifyUpdateLPContentAPITopic() {
        Response response = apiResponse.postRequest(testData.updateLPContentPayLoadTopic());
        DataUtil.topic_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        if (DataUtil.updateLearningPlanContent(role)) {
            Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanContent.content.learningPlan.id").contains(DataUtil.topic_ID));
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 21, description = "Verify Update Learning Plan API for Topic")
    public void verifyUpdateLPapiTopic() {
        Response response = apiResponse.postRequest(testData.updateLPPayloadTopic());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlan.title"), DataUtil.topicUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 22, description = "Verify Update Learning Plan State API for Topic")
    public void verifyUpdateLPStateAPITopic() {
        Response response = apiResponse.postRequest(testData.updateLPStateTopic());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlanState"), "true");
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 23, description = "Verify Learning Plan API for Flashcard Topic")
    public void verifyLearningPlanAPITopic() {
        Response response = apiResponse.postRequest(testData.learningPlanPayloadTopic());
        System.out.println(response.asString());
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.learningPlan.title"), DataUtil.topicUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    //-------------------------------------Sub Chapter Operations-----------------------------------------
    @Test(priority = 24, description = "Verify Create Learning Plan API for SubChapter")
    public void verifyCreateLPapiSubChapter() throws IOException {
        Response response = apiResponse.postRequest(testData.createLPPayloadSubChapter());
        DataUtil.subChapter_ID = response.jsonPath().getString("data.createLearningPlan.id");
        DataUtil.subChapter_ShortID = response.jsonPath().getString("data.createLearningPlan.shortId");
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.createLearningPlan.title"), DataUtil.subChapter_Title);
            out.write(response.jsonPath().getString("data.createLearningPlan.id"));
            out.newLine();
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 25, description = "Verify Update Learning Plan Content API for SubChapter")
    public void verifyUpdateLPContentAPISubChapter() {
        Response response = apiResponse.postRequest(testData.updateLPContentPayLoadSubChapter());
        DataUtil.subChapter_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        if (DataUtil.updateLearningPlanContent(role)) {
            Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanContent.content.learningPlan.id").contains(DataUtil.subChapter_ID));
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 26, description = "Verify Update Learning Plan API for SubChapter")
    public void verifyUpdateLPapiSubChapter() {
        Response response = apiResponse.postRequest(testData.updateLPPayloadSubChapter());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlan.title"), DataUtil.subChapterUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 27, description = "Verify Update Learning Plan State API for SubChapter")
    public void verifyUpdateLPStateAPISubChapter() {
        Response response = apiResponse.postRequest(testData.updateLPStateSubChapter());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlanState"), "true");
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 28, description = "Verify Learning Plan API for Flashcard SubChapter")
    public void verifyLearningPlanAPISubChapter() {
        Response response = apiResponse.postRequest(testData.learningPlanPayloadSubChapter());
        System.out.println(response.asString());
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.learningPlan.title"), DataUtil.subChapterUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    //-------------------------------------Chapter Operations-----------------------------------------
    @Test(priority = 29, description = "Verify Create Learning Plan API for Chapter")
    public void verifyCreateLPapiChapter() throws IOException {
        Response response = apiResponse.postRequest(testData.createLPPayloadChapter());
        DataUtil.chapter_ID = response.jsonPath().getString("data.createLearningPlan.id");
        DataUtil.chapter_ShortID = response.jsonPath().getString("data.createLearningPlan.shortId");
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.createLearningPlan.title"), DataUtil.chapter_Title);
            out.write(response.jsonPath().getString("data.createLearningPlan.id"));
            out.newLine();
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 30, description = "Verify Update Learning Plan Content API for Chapter")
    public void verifyUpdateLPContentAPIChapter() {
        Response response = apiResponse.postRequest(testData.updateLPContentPayLoadChapter());
        DataUtil.chapter_Checksum = response.jsonPath().getString("data.updateLearningPlanContent.checksum");
        if (DataUtil.updateLearningPlanContent(role)) {
            Assert.assertTrue(response.jsonPath().getString("data.updateLearningPlanContent.content.learningPlan.id").contains(DataUtil.chapter_ID));
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 31, description = "Verify Update Learning Plan API for Chapter")
    public void verifyUpdateLPapiChapter() {
        Response response = apiResponse.postRequest(testData.updateLPPayloadChapter());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlan.title"), DataUtil.chapterUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 32, description = "Verify Update Learning Plan State API for Chapter")
    public void verifyUpdateLPStateAPIChapter() {
        Response response = apiResponse.postRequest(testData.updateLPStatechapter());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlanState"), "true");
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 33, description = "Verify Learning Plan API for Flashcard Chapter")
    public void verifyLearningPlanAPIChapter() {
        Response response = apiResponse.postRequest(testData.learningPlanPayloadChapter());
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.learningPlan.title"), DataUtil.chapterUpdated_Title);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }


    //-------------------------------------Negative Test Cases------------------------------------
    @Test(priority = 34, description = "Verify Create Learning Plan API for Chapter without Title")
    public void verifyCreateLPWithoutTitle() {
        Response response = apiResponse.postRequest(testData.createLPPayloadChapterWithoutTitle());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
    }

    @Test(priority = 35, description = "Verify Create Learning Plan API for Chapter without Descriptiom")
    public void verifyCreateLPWithoutDescriprion() throws IOException {
        Response response = apiResponse.postRequest(testData.createLPPayloadWithoutDesc());
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.createLearningPlan.title"), DataUtil.chapter_Title);
            out.write(response.jsonPath().getString("data.createLearningPlan.id"));
            out.newLine();
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 36, description = "Verify Update Learning Plan Content API Without ID")
    public void verifyUpdateLPContentWithoutID() {
        Response response = apiResponse.postRequest(testData.updateLPContentPayLoadWithoutID());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
    }

    @Test(priority = 37, description = "Verify Update Learning Plan State API for Chapter")
    public void verifyUpdateLPStateWithoutVisiability() {
        Response response = apiResponse.postRequest(testData.updateLPStateWithoutVisiability());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
    }

    @Test(priority = 38, description = "Verify Update Learning Plan API without ID")
    public void verifyUpdateLPWithoutID() {
        Response response = apiResponse.postRequest(testData.updateLPPayloadWithoutID());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
    }

    @Test(priority = 39, description = "Verify Update Learning Plan API without privilege")
    public void verifyUpdateLPWithoutPrivilege() {
        Response response = apiResponse.postRequest(testData.updateLPPayloadWithoutPrivilege());
        System.out.println(response.asString());
        if (DataUtil.updateLearningPlan(role)) {
            Assert.assertEquals(response.jsonPath().getString("data.updateLearningPlan.title"), "QOTD-Geografy");
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 40, description = "Verify Learning Plan API Without ID")
    public void verifyLearningPlanWithoutID() {
        Response response = apiResponse.postRequest(testData.learningPlanPayloadWithoutID());
        Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
    }


    @AfterClass
    public void deleteTestData() throws IOException {
        out.close();
        dataDeletionService.deleteData(DataUtil.LearningPlanCollectionName);
    }


}
