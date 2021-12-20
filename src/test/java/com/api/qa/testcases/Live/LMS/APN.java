package com.api.qa.testcases.Live.LMS;

import com.api.qa.APIs.APIResponse;
import com.api.qa.base.TestBase_Deletion;
import com.api.qa.util.DataUtil;
import com.api.qa.util.Live.LMS.TestData_APN;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APN extends TestBase_Deletion {

    APIResponse apiResponse = new APIResponse();
    TestData_APN testData_apn = new TestData_APN();


    @BeforeClass
    @Parameters("Role")
    public void setUID(String Role) {
        if (Role.equals("super_admin")) {
            apiResponse.uid = DataUtil.SuperAdminUID;
        } else if (Role.equals("admin")) {
            apiResponse.uid = DataUtil.AdminUID;
        } else if (Role.equals("marketing")) {
            apiResponse.uid = DataUtil.MarketingUID;
        }
    }

    @Test(priority = 1, description = "Get APN Config")
    public void getAPNConfig() {
        Response response = apiResponse.getAPNConfig();
        Assert.assertEquals(response.statusCode(), DataUtil.STATUSCODE_200);
    }

    @Test(priority = 2, description = "Update APN Config")
    public void updateAPNConfig() {
        Response response = apiResponse.updateAPNConfig(testData_apn.updateAPNConfigPayload());
        Assert.assertEquals(response.jsonPath().getString("result.enabled_free_class_notification"), Boolean.toString(DataUtil.enabled_free_class_notification));
        Assert.assertEquals(response.jsonPath().getString("result.enabled_paid_class_notification"), Boolean.toString(DataUtil.enabled_paid_class_notification));
        Assert.assertEquals(response.jsonPath().getString("result.notificationsTimeBeforeClass"), Integer.toString(DataUtil.notificationsTimeBeforeClass));
    }

    @Test(priority = 3, description = "Update APN Config without free flag")
    public void updateAPNConfigWithOutFreeFlag() {
        Response response = apiResponse.updateAPNConfig(testData_apn.updateAPNConfigWithoutFreePayload());
        Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_400);
    }

    @Test(priority = 4, description = "Update APN Config without paid flag")
    public void updateAPNConfigWithOutPaidFlag() {
        Response response = apiResponse.updateAPNConfig(testData_apn.updateAPNConfigWithoutPaidPayload());
        Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_400);
    }

    @Test(priority = 5, description = "Update APN Config without Notification flag")
    public void updateAPNConfigWithOutNotificationFlag() {
        Response response = apiResponse.updateAPNConfig(testData_apn.updateAPNConfigWithoutNotiPayload());
        Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_400);
    }

    @Test(priority = 6, description = "Update APN Config without Type flag")
    public void updateAPNConfigWithOutTypeFlag() {
        Response response = apiResponse.updateAPNConfig(testData_apn.updateAPNConfigWithoutTypePayload());
        Assert.assertEquals(response.statusCode(),DataUtil.STATUSCODE_400);
    }


}
