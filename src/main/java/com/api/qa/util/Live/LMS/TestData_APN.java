package com.api.qa.util.Live.LMS;

import com.api.qa.util.DataUtil;
import org.json.JSONObject;

public class TestData_APN {

    public String updateAPNConfigPayload() {
        JSONObject requestParam = new JSONObject();
        requestParam.put("enabled_free_class_notification", DataUtil.enabled_free_class_notification);
        requestParam.put("enabled_paid_class_notification", DataUtil.enabled_paid_class_notification);
        requestParam.put("notificationsTimeBeforeClass", DataUtil.notificationsTimeBeforeClass);
        requestParam.put("type", "apn_config");
        return requestParam.toString();
    }

    public String updateAPNConfigWithoutFreePayload() {
        JSONObject requestParam = new JSONObject();
        requestParam.put("enabled_paid_class_notification", DataUtil.enabled_paid_class_notification);
        requestParam.put("notificationsTimeBeforeClass", DataUtil.notificationsTimeBeforeClass);
        requestParam.put("type", "apn_config");
        return requestParam.toString();
    }

    public String updateAPNConfigWithoutPaidPayload() {
        JSONObject requestParam = new JSONObject();
        requestParam.put("enabled_free_class_notification", DataUtil.enabled_free_class_notification);
        requestParam.put("notificationsTimeBeforeClass", DataUtil.notificationsTimeBeforeClass);
        requestParam.put("type", "apn_config");
        return requestParam.toString();
    }

    public String updateAPNConfigWithoutNotiPayload() {
        JSONObject requestParam = new JSONObject();
        requestParam.put("enabled_free_class_notification", DataUtil.enabled_free_class_notification);
        requestParam.put("enabled_paid_class_notification", DataUtil.enabled_paid_class_notification);
        requestParam.put("type", "apn_config");
        return requestParam.toString();
    }

    public String updateAPNConfigWithoutTypePayload() {
        JSONObject requestParam = new JSONObject();
        requestParam.put("enabled_free_class_notification", DataUtil.enabled_free_class_notification);
        requestParam.put("enabled_paid_class_notification", DataUtil.enabled_paid_class_notification);
        requestParam.put("notificationsTimeBeforeClass", DataUtil.notificationsTimeBeforeClass);
        return requestParam.toString();
    }


}
