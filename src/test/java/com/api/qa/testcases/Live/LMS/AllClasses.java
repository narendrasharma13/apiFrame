package com.api.qa.testcases.Live.LMS;

import com.api.qa.APIs.APIResponse;
import com.api.qa.Services.DataDeletionService;
import com.api.qa.base.TestBase_Deletion;
import com.api.qa.util.DataUtil;
import com.api.qa.util.Live.LMS.TestData_AllClassess;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class AllClasses extends TestBase_Deletion {

    APIResponse apiResponse = new APIResponse();
    DataDeletionService dataDeletionService = new DataDeletionService();
    TestData_AllClassess testData = new TestData_AllClassess();

    private String role;

    @BeforeClass
    @Parameters("Role")
    public void setUID(String Role) {
        TestBase_Deletion_FileCreation(DataUtil.AllClassesCollectionName);
        role = Role;
        if (Role.equals("super_admin")) {
            apiResponse.uid = DataUtil.SuperAdminUID;
        } else if (Role.equals("admin")) {
            apiResponse.uid = DataUtil.AdminUID;
        } else if (Role.equals("marketing")) {
            apiResponse.uid = DataUtil.MarketingUID;
        }
    }

    @Test(priority = 1, description = "Create new class from LMS")
    public void createNewClassRoom() throws IOException {
        Response response = apiResponse.postRequest(testData.createNewClassRoomPayload());
        System.out.println("11 - " + response.asString());
        DataUtil.classRoomID = response.jsonPath().getString("data.createClassRoom.id");
        out.write(response.jsonPath().getString("data.createClassRoom.id"));
        out.newLine();
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.statusCode(), DataUtil.STATUSCODE_200);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }
    }

    @Test(priority = 2, dependsOnMethods = "createNewClassRoom", description = "Published class")
    public void publishLiveClass()  {
        Response response = apiResponse.postRequest(testData.publishLiveClass());
        System.out.println("22 - " + response.asString());
        if (DataUtil.crateLearningPlan(role)) {
            Assert.assertEquals(response.statusCode(), DataUtil.STATUSCODE_200);
        } else {
            Assert.assertEquals(response.jsonPath().getString("errors.statusCode"), DataUtil.STATUSCODE_500);
        }

    }


    @AfterClass
    public void deleteTestData() throws IOException {
        out.close();
        // dataDeletionService.deleteData(DataUtil.AllClassesCollectionName);
    }


}
