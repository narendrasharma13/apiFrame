package com.api.qa.util.Live.LMS;

import com.api.qa.util.DataUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestData_AllClassess {

    public String createNewClassRoomPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();

        JSONArray kind = new JSONArray();
        JSONArray description = new JSONArray();
        JSONArray selectedTargets = new JSONArray();
        JSONArray majors = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createClassRoom");
        requestVariable.put("id","");
        requestVariable.put("name",DataUtil.classRoomName);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("classPlanId","a86bc858-8576-4064-a4d8-67830ce2afcf");
        requestVariable.put("subjectTag","matematika");
        requestVariable.put("xCode",RandomStringUtils.random(4,true,false) + RandomStringUtils.random(1,false,true) +"q");
        requestVariable.put("privileges",new JSONArray());
        kind.put("student");
        metaInfo.put("kinds",kind);
        metaInfo.put("image",JSONObject.NULL);
        metaInfo.put("teacherPic","https://zs-inline.s3.ap-southeast-1.amazonaws.com/production/a/82/8d71/a828d719ad2d43d5a806d567556a4231.jpg?efs=https%3A%2F%2Fwww.zenius.net%2Fassets%2Fv-img%2Fa%2F82%2F8d71%2Fa828d719ad2d43d5a806d567556a4231.jpg");
        metaInfo.put("teacherDesc","Lulusan ilmu ekonomi FEB UI angkatan 2014. Medalis perak Olimpiade Sains Nasional (OSN) bidang ekonomi tahun 2012 dan 2013. Pengajar ekonomi berpengalaman sejak 2015.");
        description.put("Automation testing");
        metaInfo.put("description",description);
        metaInfo.put("startTime",java.time.Clock.systemUTC().instant());
        metaInfo.put("endTime",java.time.Clock.systemUTC().instant().plusSeconds(3600));
        metaInfo.put("classType","master_class");
        metaInfo.put("platform","zenius");
        metaInfo.put("isDoubtEnabled",false);
        metaInfo.put("upselling",false);
        selectedTargets.put("a86bc858-8576-4064-a4d8-67830ce2afcf");
        metaInfo.put("selectedTargets",selectedTargets);
        majors.put("natural-sciences");
        metaInfo.put("majors",majors);
        classIDs.put("3e38e30b-84c6-464c-be0d-105fcf71e115");
        classIDs.put("b4e7e453-2ad6-4724-afa6-b5e240323a1c");
        classIDs.put("7d2fd98b-41d2-4c4a-b040-63706cc5eeec");
        classIDs.put("a86bc858-8576-4064-a4d8-67830ce2afcf");
        metaInfo.put("classIds",classIDs);
        metaInfo.put("targetDisplayText","Kelas 12");
        metaInfo.put("originalEndTime",java.time.Clock.systemUTC().instant().plusSeconds(3600));
        metaInfo.put("isRecordable",true);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("title",DataUtil.classRoomName);
        requestVariable.put("teacherName","Agung");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createClassRoom($name: String!, $title: String!, $description: String, $xCode: String!, $classPlanId: String!, $subjectTag: String!, $visibility: String, $url: String, $shareUrl: String, $metaInfo: Object, $teacherName: String, $privileges: [String]) {\n createClassRoom(name: $name, title: $title, description: $description, xCode: $xCode, classPlanId: $classPlanId, subjectTag: $subjectTag, visibility: $visibility, url: $url, shareUrl: $shareUrl, metaInfo: $metaInfo, teacherName: $teacherName, privileges: $privileges) {\n id\n rootPlanId\n name\n title\n description\n teacherName\n xCode\n classPlanId\n subjectTag\n visibility\n url\n shareUrl\n metaInfo\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String publishLiveClass() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();

        requestParam.put("operationName","updateClassroomVisibility");
        requestVariable.put("classroomId",DataUtil.classRoomID);
        requestVariable.put("visibility",DataUtil.visibility_Published);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateClassroomVisibility($classroomId: String!, $visibility: String!) {\n updateClassroomVisibility(classroomId: $classroomId, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

}
