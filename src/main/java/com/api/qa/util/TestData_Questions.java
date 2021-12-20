package com.api.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestData_Questions {

    public String createQuestionPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject optObject1 = new JSONObject();
        JSONObject optObject2 = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray options = new JSONArray();
        JSONArray answer = new JSONArray();
        JSONArray subjects = new JSONArray();
        JSONArray classIds = new JSONArray();

        requestParam.put("operationName","createQuestion");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.question_Title);
        requestVariable.put("description","Created Question through Automation");
        requestVariable.put("type","mcq");
        requestVariable.put("isQuestionOnly",false);
        requestVariable.put("difficultyLevel",1);
        optObject1.put("label","Manual Test");
        optObject1.put("value","1");
        optObject2.put("label","Automated Test");
        optObject2.put("value","2");
        options.put(optObject1);
        options.put(optObject2);
        requestVariable.put("options",options);
        requestVariable.put("multipleResponses",false);
        answer.put("1");
        requestVariable.put("answers",answer);
        requestParam.put("tags",JSONObject.NULL);
        requestVariable.put("score",1);
        requestVariable.put("subject","");
        subjects.put("bahasa_indonesia");
        metaInfo.put("subjects",subjects);
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        metaInfo.put("conceptPlanId","");
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("learningUnitId",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createQuestion($type: String!, $difficultyLevel: Int!, $title: String!, $description: String!, $multipleResponses: Boolean, $answers: [String], $options: [OptionsInput], $learningUnitId: String, $score: Int, $subject: String!, $metaInfo: JSONObject) {\n createQuestion(type: $type, difficultyLevel: $difficultyLevel, title: $title, description: $description, multipleResponses: $multipleResponses, answers: $answers, options: $options, learningUnitId: $learningUnitId, score: $score, subject: $subject, metaInfo: $metaInfo) {\n id\n type\n difficultyLevel\n title\n description\n multipleResponses\n shortId\n answers\n learningUnitId\n subject\n visibility\n metaInfo\n options {\n label\n value\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateAPContentQuestionPayLoad() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addQuestionID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateAssessmentPlanContent");
        requestVariable.put("id",DataUtil.questionQuiz_ID);
        requestVariable.put("checksum",DataUtil.question_Checksum);

        addQuestionID.put("questionId",DataUtil.question_ID);
        addQuestionID.put("order",2);
        content.put(addQuestionID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanContent($id: String!, $content: [AssessmentPlanContentInput]!, $checksum: String!) {\n updateAssessmentPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n tags\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateQuestionPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject optObject1 = new JSONObject();
        JSONObject optObject2 = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray options = new JSONArray();
        JSONArray answer = new JSONArray();
        JSONArray subjects = new JSONArray();
        JSONArray classIds = new JSONArray();

        requestParam.put("operationName","updateQuestion");
        requestVariable.put("id",DataUtil.question_ID);
        requestVariable.put("title",DataUtil.questionUpdated_Title);
        requestVariable.put("type","mcq");
        requestVariable.put("description","Created Question through Automation");
        requestVariable.put("isQuestionOnly",false);
        requestVariable.put("difficultyLevel",1);
        optObject1.put("label","Manual Test");
        optObject1.put("value","1");
        optObject2.put("label","Automated Test");
        optObject2.put("value","2");
        options.put(optObject1);
        options.put(optObject2);
        requestVariable.put("options",options);
        requestVariable.put("multipleResponses",false);
        answer.put("1");
        requestVariable.put("answers",answer);
        requestParam.put("tags",JSONObject.NULL);
        requestVariable.put("score",1);
        requestVariable.put("subject","");
        subjects.put("bahasa_indonesia");
        metaInfo.put("subjects",subjects);
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        metaInfo.put("conceptPlanId","");
        metaInfo.put("isAdsSearch",false);
        metaInfo.put("is_mathpix_latex",false);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("learningUnitId",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateQuestion($id: String!, $title: String, $type: String, $description: String, $difficultyLevel: Int, $multipleResponses: Boolean, $answers: [String], $options: [OptionsInput], $tags: [String], $learningUnitId: String, $metaInfo: JSONObject, $score: Int, $subject: String!, $image: String) {\n updateQuestion(id: $id, title: $title, type: $type, description: $description, difficultyLevel: $difficultyLevel, multipleResponses: $multipleResponses, answers: $answers, options: $options, tags: $tags, learningUnitId: $learningUnitId, metaInfo: $metaInfo, score: $score, subject: $subject, image: $image) {\n id\n title\n type\n description\n difficultyLevel\n multipleResponses\n answers\n tags\n learningUnitId\n metaInfo\n subject\n image\n options {\n label\n value\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateQuestionStatePayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateQuestionState");
        requestVariable.put("id",DataUtil.question_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateQuestionState($id: String!, $visibility: String!) {\n updateQuestionState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String getQuestionPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","question");
        requestVariable.put("id",DataUtil.question_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query question($id: String!) {\n question(id: $id) {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n options {\n label\n value\n __typename\n }\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }


    //----------------------------------Negative Cases----------------------------------------
    public String createQuestionPayloadWithoutTitle() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject optObject1 = new JSONObject();
        JSONObject optObject2 = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray options = new JSONArray();
        JSONArray answer = new JSONArray();
        JSONArray subjects = new JSONArray();
        JSONArray classIds = new JSONArray();

        requestParam.put("operationName","createQuestion");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("description","Created Question through Automation");
        requestVariable.put("type","mcq");
        requestVariable.put("isQuestionOnly",false);
        requestVariable.put("difficultyLevel",1);
        optObject1.put("label","Manual Test");
        optObject1.put("value","1");
        optObject2.put("label","Automated Test");
        optObject2.put("value","2");
        options.put(optObject1);
        options.put(optObject2);
        requestVariable.put("options",options);
        requestVariable.put("multipleResponses",false);
        answer.put("1");
        requestVariable.put("answers",answer);
        requestParam.put("tags",JSONObject.NULL);
        requestVariable.put("score",1);
        requestVariable.put("subject","");
        subjects.put("bahasa_indonesia");
        metaInfo.put("subjects",subjects);
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        metaInfo.put("conceptPlanId","");
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("learningUnitId",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createQuestion($type: String!, $difficultyLevel: Int!, $title: String!, $description: String!, $multipleResponses: Boolean, $answers: [String], $options: [OptionsInput], $learningUnitId: String, $score: Int, $subject: String!, $metaInfo: JSONObject) {\n createQuestion(type: $type, difficultyLevel: $difficultyLevel, title: $title, description: $description, multipleResponses: $multipleResponses, answers: $answers, options: $options, learningUnitId: $learningUnitId, score: $score, subject: $subject, metaInfo: $metaInfo) {\n id\n type\n difficultyLevel\n title\n description\n multipleResponses\n shortId\n answers\n learningUnitId\n subject\n visibility\n metaInfo\n options {\n label\n value\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateContentQuestionPayLoadWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addQuestionID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateAssessmentPlanContent");
        requestVariable.put("checksum",DataUtil.question_Checksum);
        addQuestionID.put("questionId",DataUtil.question_ID);
        addQuestionID.put("order",2);
        content.put(addQuestionID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanContent($id: String!, $content: [AssessmentPlanContentInput]!, $checksum: String!) {\n updateAssessmentPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n tags\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateQuestionPayloadWithoutId() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject optObject1 = new JSONObject();
        JSONObject optObject2 = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray options = new JSONArray();
        JSONArray answer = new JSONArray();
        JSONArray subjects = new JSONArray();
        JSONArray classIds = new JSONArray();

        requestParam.put("operationName","updateQuestion");
        requestVariable.put("title",DataUtil.questionUpdated_Title);
        requestVariable.put("type","mcq");
        requestVariable.put("description","Created Question through Automation");
        requestVariable.put("isQuestionOnly",false);
        requestVariable.put("difficultyLevel",1);
        optObject1.put("label","Manual Test");
        optObject1.put("value","1");
        optObject2.put("label","Automated Test");
        optObject2.put("value","2");
        options.put(optObject1);
        options.put(optObject2);
        requestVariable.put("options",options);
        requestVariable.put("multipleResponses",false);
        answer.put("1");
        requestVariable.put("answers",answer);
        requestParam.put("tags",JSONObject.NULL);
        requestVariable.put("score",1);
        requestVariable.put("subject","");
        subjects.put("bahasa_indonesia");
        metaInfo.put("subjects",subjects);
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        metaInfo.put("conceptPlanId","");
        metaInfo.put("isAdsSearch",false);
        metaInfo.put("is_mathpix_latex",false);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("learningUnitId",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateQuestion($id: String!, $title: String, $type: String, $description: String, $difficultyLevel: Int, $multipleResponses: Boolean, $answers: [String], $options: [OptionsInput], $tags: [String], $learningUnitId: String, $metaInfo: JSONObject, $score: Int, $subject: String!, $image: String) {\n updateQuestion(id: $id, title: $title, type: $type, description: $description, difficultyLevel: $difficultyLevel, multipleResponses: $multipleResponses, answers: $answers, options: $options, tags: $tags, learningUnitId: $learningUnitId, metaInfo: $metaInfo, score: $score, subject: $subject, image: $image) {\n id\n title\n type\n description\n difficultyLevel\n multipleResponses\n answers\n tags\n learningUnitId\n metaInfo\n subject\n image\n options {\n label\n value\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateQuestionStatePayloadWithoutId() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateQuestionState");
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateQuestionState($id: String!, $visibility: String!) {\n updateQuestionState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String getQuestionPayloadWithoutId() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","question");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query question($id: String!) {\n question(id: $id) {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n options {\n label\n value\n __typename\n }\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String createQuestionPayloadWithoutSub() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject optObject1 = new JSONObject();
        JSONObject optObject2 = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray options = new JSONArray();
        JSONArray answer = new JSONArray();
        JSONArray classIds = new JSONArray();

        requestParam.put("operationName","createQuestion");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.question_Title);
        requestVariable.put("description","Created Question through Automation");
        requestVariable.put("type","mcq");
        requestVariable.put("isQuestionOnly",false);
        requestVariable.put("difficultyLevel",1);
        optObject1.put("label","Manual Test");
        optObject1.put("value","1");
        optObject2.put("label","Automated Test");
        optObject2.put("value","2");
        options.put(optObject1);
        options.put(optObject2);
        requestVariable.put("options",options);
        requestVariable.put("multipleResponses",false);
        answer.put("1");
        requestVariable.put("answers",answer);
        requestParam.put("tags",JSONObject.NULL);
        requestVariable.put("score",1);
        requestVariable.put("subject","");
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        metaInfo.put("conceptPlanId","");
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("learningUnitId",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createQuestion($type: String!, $difficultyLevel: Int!, $title: String!, $description: String!, $multipleResponses: Boolean, $answers: [String], $options: [OptionsInput], $learningUnitId: String, $score: Int, $subject: String!, $metaInfo: JSONObject) {\n createQuestion(type: $type, difficultyLevel: $difficultyLevel, title: $title, description: $description, multipleResponses: $multipleResponses, answers: $answers, options: $options, learningUnitId: $learningUnitId, score: $score, subject: $subject, metaInfo: $metaInfo) {\n id\n type\n difficultyLevel\n title\n description\n multipleResponses\n shortId\n answers\n learningUnitId\n subject\n visibility\n metaInfo\n options {\n label\n value\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String contentQuestionPayLoadWithoutOrder() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addQuestionID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateAssessmentPlanContent");
        requestVariable.put("id",DataUtil.questionQuiz_ID);
        requestVariable.put("checksum",DataUtil.question_Checksum);

        addQuestionID.put("questionId",DataUtil.question_ID);
        content.put(addQuestionID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateAssessmentPlanContent($id: String!, $content: [AssessmentPlanContentInput]!, $checksum: String!) {\n updateAssessmentPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n tags\n __typename\n }\n}\n");
        return requestParam.toString();
    }


}
