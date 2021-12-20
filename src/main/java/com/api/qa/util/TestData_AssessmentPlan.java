package com.api.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestData_AssessmentPlan {

    public String createAPQuizPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createAssessmentPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.quiz_Title);
        requestVariable.put("description","Created Quiz through Automation");
        requestVariable.put("type","quiz");
        requestVariable.put("name",DataUtil.quiz_Title);
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        metaInfo.put("subjects",JSONObject.NULL);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createAssessmentPlan($name: String!, $title: String!, $difficultyLevel: Int, $privilege: String, $type: String!, $tags: [String], $description: String, $duration: Int, $metaInfo: JSONObject) {\n createAssessmentPlan(name: $name, title: $title, difficultyLevel: $difficultyLevel, privilege: $privilege, type: $type, tags: $tags, description: $description, duration: $duration, metaInfo: $metaInfo) {\n id\n name\n checksum\n title\n difficultyLevel\n privilege\n shortId\n type\n tags\n description\n duration\n metaInfo\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentQuizPayLoad() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id",DataUtil.quizChapter_ID);
        requestVariable.put("checksum",DataUtil.quiz_Checksum);
        addLearningPlanID.put("assessmentPlanId",DataUtil.quiz_ID);
        addLearningPlanID.put("order",2);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateQuizLPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateAssessmentPlan");
        requestVariable.put("id",DataUtil.quiz_ID);
        requestVariable.put("title",DataUtil.quizUpdated_Title);
        requestVariable.put("name",DataUtil.quizUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","quiz");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        metaInfo.put("subjects",JSONObject.NULL);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlan($id: String!, $name: String, $title: String, $url: String, $type: String, $description: String, $tags: [String], $metaInfo: JSONObject, $duration: Int, $difficultyLevel: Int) {\n updateAssessmentPlan(id: $id, name: $name, title: $title, url: $url, type: $type, description: $description, tags: $tags, metaInfo: $metaInfo, duration: $duration, difficultyLevel: $difficultyLevel) {\n id\n checksum\n name\n title\n url\n type\n tags\n metaInfo\n description\n content {\n learningUnitId\n questionId\n order\n question {\n id\n type\n thumbnail\n title\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n multipleResponses\n difficultyLevel\n score\n scoreType\n duration\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPStateQuiz() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateAssessmentPlanState");
        requestVariable.put("id",DataUtil.quiz_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanState($id: String!, $visibility: String!) {\n updateAssessmentPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String assessmentPlanPayloadQuiz() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","assessmentPlan");
        requestVariable.put("id",DataUtil.quiz_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query assessmentPlan($id: String!) {\n assessmentPlan(id: $id) {\n id\n checksum\n status\n name\n title\n description\n status\n url\n difficultyLevel\n type\n shortId\n tags\n privilege\n privileges\n download_privileges\n metaInfo\n moduleFileUrl\n content {\n order\n assessmentPlanId\n assessmentPlan {\n id\n title\n description\n duration\n type\n visibility\n privilege\n shortId\n content {\n assessmentPlanId\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n type\n thumbnail\n title\n privilege\n shortId\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n subject\n isMath\n multipleResponses\n difficultyLevel\n visibility\n score\n avgCorrect\n scoreType\n duration\n metaInfo\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n image\n thumbnail\n visibility\n description\n shortId\n tags\n difficultyLevel\n privilege\n metaInfo\n content {\n type\n title\n videoUrl\n __typename\n }\n __typename\n }\n __typename\n }\n score\n duration\n startTime\n endTime\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n avgScore\n noOfUsers\n stats {\n bucketArray\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }


    //--------------------------------Practice Payload---------------------------------------
    public String createPracticeAPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createAssessmentPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.practice_Title);
        requestVariable.put("description","Created Practice through Automation");
        requestVariable.put("type","practice");
        requestVariable.put("name",DataUtil.practice_Title);
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        metaInfo.put("subjects",JSONObject.NULL);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createAssessmentPlan($name: String!, $title: String!, $difficultyLevel: Int, $privilege: String, $type: String!, $tags: [String], $description: String, $duration: Int, $metaInfo: JSONObject) {\n createAssessmentPlan(name: $name, title: $title, difficultyLevel: $difficultyLevel, privilege: $privilege, type: $type, tags: $tags, description: $description, duration: $duration, metaInfo: $metaInfo) {\n id\n name\n checksum\n title\n difficultyLevel\n privilege\n shortId\n type\n tags\n description\n duration\n metaInfo\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentPracticePayLoad() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id",DataUtil.practiceNode_ID);
        requestVariable.put("checksum",DataUtil.practice_Checksum);
        addLearningPlanID.put("assessmentPlanId",DataUtil.practice_ID);
        addLearningPlanID.put("order",2);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updatePracticeLPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateAssessmentPlan");
        requestVariable.put("id",DataUtil.practice_ID);
        requestVariable.put("title",DataUtil.practiceUpdated_Title);
        requestVariable.put("name",DataUtil.practiceUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","practice");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        metaInfo.put("subjects",JSONObject.NULL);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlan($id: String!, $name: String, $title: String, $url: String, $type: String, $description: String, $tags: [String], $metaInfo: JSONObject, $duration: Int, $difficultyLevel: Int) {\n updateAssessmentPlan(id: $id, name: $name, title: $title, url: $url, type: $type, description: $description, tags: $tags, metaInfo: $metaInfo, duration: $duration, difficultyLevel: $difficultyLevel) {\n id\n checksum\n name\n title\n url\n type\n tags\n metaInfo\n description\n content {\n learningUnitId\n questionId\n order\n question {\n id\n type\n thumbnail\n title\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n multipleResponses\n difficultyLevel\n score\n scoreType\n duration\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPStatePractice() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateAssessmentPlanState");
        requestVariable.put("id",DataUtil.practice_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanState($id: String!, $visibility: String!) {\n updateAssessmentPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String assessmentPlanPayloadPractice() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","assessmentPlan");
        requestVariable.put("id",DataUtil.practice_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query assessmentPlan($id: String!) {\n assessmentPlan(id: $id) {\n id\n checksum\n status\n name\n title\n description\n status\n url\n difficultyLevel\n type\n shortId\n tags\n privilege\n privileges\n download_privileges\n metaInfo\n moduleFileUrl\n content {\n order\n assessmentPlanId\n assessmentPlan {\n id\n title\n description\n duration\n type\n visibility\n privilege\n shortId\n content {\n assessmentPlanId\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n type\n thumbnail\n title\n privilege\n shortId\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n subject\n isMath\n multipleResponses\n difficultyLevel\n visibility\n score\n avgCorrect\n scoreType\n duration\n metaInfo\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n image\n thumbnail\n visibility\n description\n shortId\n tags\n difficultyLevel\n privilege\n metaInfo\n content {\n type\n title\n videoUrl\n __typename\n }\n __typename\n }\n __typename\n }\n score\n duration\n startTime\n endTime\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n avgScore\n noOfUsers\n stats {\n bucketArray\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }


    //--------------------------------TryOuts Payload---------------------------------------
    public String createTryoutAPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray examIDs = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createAssessmentPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.tryout_Title);
        requestVariable.put("description","Created Tryout through Automation");
        requestVariable.put("type","tryout");
        requestVariable.put("name",DataUtil.tryout_Title);
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",3600);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        subjects.put("fisika");
        metaInfo.put("subjects",subjects);
        examIDs.put(DataUtil.tryout_examId);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createAssessmentPlan($name: String!, $title: String!, $difficultyLevel: Int, $privilege: String, $privileges: [String], $metaInfo: JSONObject, $type: String!, $tags: [String], $startTime: Date, $endTime: Date, $duration: Int, $description: String) {\n createAssessmentPlan(name: $name, title: $title, difficultyLevel: $difficultyLevel, privilege: $privilege, privileges: $privileges, metaInfo: $metaInfo, type: $type, tags: $tags, startTime: $startTime, endTime: $endTime, duration: $duration, description: $description) {\n id\n name\n title\n difficultyLevel\n privilege\n metaInfo\n type\n shortId\n tags\n startTime\n endTime\n duration\n description\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateTryoutLPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray examIDs = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateAssessmentPlan");
        requestVariable.put("id",DataUtil.tryout_ID);
        requestVariable.put("title",DataUtil.tryoutUpdated_Title);
        requestVariable.put("name",DataUtil.tryoutUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","tryout");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",3600);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        subjects.put("fisika");
        metaInfo.put("subjects",subjects);
        examIDs.put(DataUtil.tryout_examId);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlan($id: String!, $name: String, $title: String, $url: String, $type: String, $description: String, $difficultyLevel: Int, $tags: [String], $startTime: Date, $endTime: Date, $metaInfo: JSONObject, $duration: Int, $privileges: [String]) {\n updateAssessmentPlan(id: $id, name: $name, title: $title, url: $url, type: $type, difficultyLevel: $difficultyLevel, duration: $duration, description: $description, tags: $tags, startTime: $startTime, endTime: $endTime, metaInfo: $metaInfo, privileges: $privileges) {\n id\n name\n title\n url\n type\n tags\n description\n difficultyLevel\n duration\n startTime\n endTime\n content {\n learningUnitId\n questionId\n order\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPStateTryout() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateAssessmentPlanState");
        requestVariable.put("id",DataUtil.tryout_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanState($id: String!, $visibility: String!) {\n updateAssessmentPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String assessmentPlanPayloadTryout() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","assessmentPlan");
        requestVariable.put("id",DataUtil.tryout_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query assessmentPlan($id: String!) {\n assessmentPlan(id: $id) {\n id\n checksum\n status\n name\n title\n description\n status\n url\n difficultyLevel\n type\n shortId\n tags\n privilege\n privileges\n download_privileges\n metaInfo\n moduleFileUrl\n content {\n order\n assessmentPlanId\n assessmentPlan {\n id\n title\n description\n duration\n type\n visibility\n privilege\n shortId\n content {\n assessmentPlanId\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n type\n thumbnail\n title\n privilege\n shortId\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n subject\n isMath\n multipleResponses\n difficultyLevel\n visibility\n score\n avgCorrect\n scoreType\n duration\n metaInfo\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n image\n thumbnail\n visibility\n description\n shortId\n tags\n difficultyLevel\n privilege\n metaInfo\n content {\n type\n title\n videoUrl\n __typename\n }\n __typename\n }\n __typename\n }\n score\n duration\n startTime\n endTime\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n avgScore\n noOfUsers\n stats {\n bucketArray\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    //--------------------------------Premium TryOuts Payload---------------------------------------
    public String createPremiumTryoutAPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray privileges = new JSONArray();
        JSONArray subjects = new JSONArray();
        JSONArray examIDs = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createAssessmentPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.premiumTryout_Title);
        requestVariable.put("description","Created Premium Tryout through Automation");
        requestVariable.put("type","premium-tryout");
        requestVariable.put("name",DataUtil.premiumTryout_Title);
        requestVariable.put("privilege","member");
        privileges.put("premium");
        privileges.put("ULTIM9");
        requestVariable.put("privileges",privileges);
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",3600);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        subjects.put("ekonomi");
        metaInfo.put("subjects",subjects);
        examIDs.put(DataUtil.premiumTryout_examId);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createAssessmentPlan($name: String!, $title: String!, $difficultyLevel: Int, $privilege: String, $privileges: [String], $metaInfo: JSONObject, $type: String!, $tags: [String], $startTime: Date, $endTime: Date, $duration: Int, $description: String) {\n createAssessmentPlan(name: $name, title: $title, difficultyLevel: $difficultyLevel, privilege: $privilege, privileges: $privileges, metaInfo: $metaInfo, type: $type, tags: $tags, startTime: $startTime, endTime: $endTime, duration: $duration, description: $description) {\n id\n name\n title\n difficultyLevel\n privilege\n metaInfo\n type\n shortId\n tags\n startTime\n endTime\n duration\n description\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updatePremiumTryoutAPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray privileges = new JSONArray();
        JSONArray subjects = new JSONArray();
        JSONArray examIDs = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateAssessmentPlan");
        requestVariable.put("id",DataUtil.premiumTryout_ID);
        requestVariable.put("title",DataUtil.premiumTryoutUpdated_Title);
        requestVariable.put("name",DataUtil.premiumTryoutUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","premium-tryout");
        requestVariable.put("privilege","member");
        privileges.put("premium");
        privileges.put("ULTIM9");
        requestVariable.put("privileges",privileges);
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",3600);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        subjects.put("ekonomi");
        metaInfo.put("subjects",subjects);
        examIDs.put(DataUtil.premiumTryout_examId);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlan($id: String!, $name: String, $title: String, $url: String, $type: String, $description: String, $difficultyLevel: Int, $tags: [String], $startTime: Date, $endTime: Date, $metaInfo: JSONObject, $duration: Int, $privileges: [String]) {\n updateAssessmentPlan(id: $id, name: $name, title: $title, url: $url, type: $type, difficultyLevel: $difficultyLevel, duration: $duration, description: $description, tags: $tags, startTime: $startTime, endTime: $endTime, metaInfo: $metaInfo, privileges: $privileges) {\n id\n name\n title\n url\n type\n tags\n description\n difficultyLevel\n duration\n startTime\n endTime\n content {\n learningUnitId\n questionId\n order\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPStatePremiumTryout() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateAssessmentPlanState");
        requestVariable.put("id",DataUtil.premiumTryout_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanState($id: String!, $visibility: String!) {\n updateAssessmentPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String assessmentPlanPayloadPremiumTryout() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","assessmentPlan");
        requestVariable.put("id",DataUtil.premiumTryout_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query assessmentPlan($id: String!) {\n assessmentPlan(id: $id) {\n id\n checksum\n status\n name\n title\n description\n status\n url\n difficultyLevel\n type\n shortId\n tags\n privilege\n privileges\n download_privileges\n metaInfo\n moduleFileUrl\n content {\n order\n assessmentPlanId\n assessmentPlan {\n id\n title\n description\n duration\n type\n visibility\n privilege\n shortId\n content {\n assessmentPlanId\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n type\n thumbnail\n title\n privilege\n shortId\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n subject\n isMath\n multipleResponses\n difficultyLevel\n visibility\n score\n avgCorrect\n scoreType\n duration\n metaInfo\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n image\n thumbnail\n visibility\n description\n shortId\n tags\n difficultyLevel\n privilege\n metaInfo\n content {\n type\n title\n videoUrl\n __typename\n }\n __typename\n }\n __typename\n }\n score\n duration\n startTime\n endTime\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n avgScore\n noOfUsers\n stats {\n bucketArray\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }


    //--------------------------------Daily Quiz Payload---------------------------------------
    public String createDailyQuizAPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createAssessmentPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.dailyQuiz_Title);
        requestVariable.put("description","Created Daily Quiz through Automation");
        requestVariable.put("type","daily-quiz");
        requestVariable.put("name",DataUtil.dailyQuiz_Title);
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",JSONObject.NULL);
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createAssessmentPlan($name: String!, $title: String!, $difficultyLevel: Int, $privilege: String, $privileges: [String], $metaInfo: JSONObject, $type: String!, $tags: [String], $startTime: Date, $endTime: Date, $duration: Int, $description: String) {\n createAssessmentPlan(name: $name, title: $title, difficultyLevel: $difficultyLevel, privilege: $privilege, privileges: $privileges, metaInfo: $metaInfo, type: $type, tags: $tags, startTime: $startTime, endTime: $endTime, duration: $duration, description: $description) {\n id\n name\n title\n difficultyLevel\n privilege\n metaInfo\n type\n shortId\n tags\n startTime\n endTime\n duration\n description\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateDailyQuizAPPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateAssessmentPlan");
        requestVariable.put("id",DataUtil.dailyQuiz_ID);
        requestVariable.put("title",DataUtil.dailyQuizUpdated_Title);
        requestVariable.put("name",DataUtil.dailyQuizUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","daily-quiz");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",JSONObject.NULL);
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlan($id: String!, $name: String, $title: String, $url: String, $type: String, $description: String, $difficultyLevel: Int, $tags: [String], $startTime: Date, $endTime: Date, $metaInfo: JSONObject, $duration: Int, $privileges: [String]) {\n updateAssessmentPlan(id: $id, name: $name, title: $title, url: $url, type: $type, difficultyLevel: $difficultyLevel, duration: $duration, description: $description, tags: $tags, startTime: $startTime, endTime: $endTime, metaInfo: $metaInfo, privileges: $privileges) {\n id\n name\n title\n url\n type\n tags\n description\n difficultyLevel\n duration\n startTime\n endTime\n content {\n learningUnitId\n questionId\n order\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPStateDailyQuiz() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateAssessmentPlanState");
        requestVariable.put("id",DataUtil.dailyQuiz_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanState($id: String!, $visibility: String!) {\n updateAssessmentPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String assessmentPlanPayloadDailyQuiz() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","assessmentPlan");
        requestVariable.put("id",DataUtil.dailyQuiz_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query assessmentPlan($id: String!) {\n assessmentPlan(id: $id) {\n id\n checksum\n status\n name\n title\n description\n status\n url\n difficultyLevel\n type\n shortId\n tags\n privilege\n privileges\n download_privileges\n metaInfo\n moduleFileUrl\n content {\n order\n assessmentPlanId\n assessmentPlan {\n id\n title\n description\n duration\n type\n visibility\n privilege\n shortId\n content {\n assessmentPlanId\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n type\n thumbnail\n title\n privilege\n shortId\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n subject\n isMath\n multipleResponses\n difficultyLevel\n visibility\n score\n avgCorrect\n scoreType\n duration\n metaInfo\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n image\n thumbnail\n visibility\n description\n shortId\n tags\n difficultyLevel\n privilege\n metaInfo\n content {\n type\n title\n videoUrl\n __typename\n }\n __typename\n }\n __typename\n }\n score\n duration\n startTime\n endTime\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n avgScore\n noOfUsers\n stats {\n bucketArray\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    //--------------------------------Negative test cases Payload---------------------------------------
    public String createAPPayloadWithoutTitle() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createAssessmentPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("description","Created Daily Quiz through Automation");
        requestVariable.put("type","daily-quiz");
        requestVariable.put("name",DataUtil.dailyQuiz_Title);
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",JSONObject.NULL);
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createAssessmentPlan($name: String!, $title: String!, $difficultyLevel: Int, $privilege: String, $privileges: [String], $metaInfo: JSONObject, $type: String!, $tags: [String], $startTime: Date, $endTime: Date, $duration: Int, $description: String) {\n createAssessmentPlan(name: $name, title: $title, difficultyLevel: $difficultyLevel, privilege: $privilege, privileges: $privileges, metaInfo: $metaInfo, type: $type, tags: $tags, startTime: $startTime, endTime: $endTime, duration: $duration, description: $description) {\n id\n name\n title\n difficultyLevel\n privilege\n metaInfo\n type\n shortId\n tags\n startTime\n endTime\n duration\n description\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPPayloadWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateAssessmentPlan");
        requestVariable.put("title",DataUtil.dailyQuizUpdated_Title);
        requestVariable.put("name",DataUtil.dailyQuizUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","daily-quiz");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",JSONObject.NULL);
        requestVariable.put("startTime",DataUtil.tryout_StartDate);
        requestVariable.put("endTime",DataUtil.tryout_EndDate);
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("duration",0);
        classIDs.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlan($id: String!, $name: String, $title: String, $url: String, $type: String, $description: String, $difficultyLevel: Int, $tags: [String], $startTime: Date, $endTime: Date, $metaInfo: JSONObject, $duration: Int, $privileges: [String]) {\n updateAssessmentPlan(id: $id, name: $name, title: $title, url: $url, type: $type, difficultyLevel: $difficultyLevel, duration: $duration, description: $description, tags: $tags, startTime: $startTime, endTime: $endTime, metaInfo: $metaInfo, privileges: $privileges) {\n id\n name\n title\n url\n type\n tags\n description\n difficultyLevel\n duration\n startTime\n endTime\n content {\n learningUnitId\n questionId\n order\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPStateWithoutVisiability() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateAssessmentPlanState");
        requestVariable.put("id",DataUtil.dailyQuiz_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanState($id: String!, $visibility: String!) {\n updateAssessmentPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String assessmentPlanPayloadWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","assessmentPlan");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query assessmentPlan($id: String!) {\n assessmentPlan(id: $id) {\n id\n checksum\n status\n name\n title\n description\n status\n url\n difficultyLevel\n type\n shortId\n tags\n privilege\n privileges\n download_privileges\n metaInfo\n moduleFileUrl\n content {\n order\n assessmentPlanId\n assessmentPlan {\n id\n title\n description\n duration\n type\n visibility\n privilege\n shortId\n content {\n assessmentPlanId\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n type\n thumbnail\n title\n privilege\n shortId\n description\n options {\n label\n value\n __typename\n }\n answers\n hint\n subject\n isMath\n multipleResponses\n difficultyLevel\n visibility\n score\n avgCorrect\n scoreType\n duration\n metaInfo\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n image\n thumbnail\n visibility\n description\n shortId\n tags\n difficultyLevel\n privilege\n metaInfo\n content {\n type\n title\n videoUrl\n __typename\n }\n __typename\n }\n __typename\n }\n score\n duration\n startTime\n endTime\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n avgScore\n noOfUsers\n stats {\n bucketArray\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }


}
