package com.api.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestData_LearningPlan {

    public String createLearningPlanPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id","");
        requestVariable.put("title",DataUtil.createLearningPlan_Title);
        requestVariable.put("name",DataUtil.createLearningPlan_Name);
        requestVariable.put("description","<p>testing automation</p>");
        requestVariable.put("type","sub-chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        subjects.put("matematikaa");
        metaInfo.put("subjects",subjects);
        classIDs.put("d66da317-2739-429c-b106-b91a2146a216");
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail","https://zs-inline.s3.ap-southeast-1.amazonaws.com/staging/b/51/cfa7/b51cfa793c564e4bbacc1cca8b7f3886.jpg?efs=https%3A%2F%2Fwww.zeniusnet.com%2Fassets%2Fv-img%2Fb%2F51%2Fcfa7%2Fb51cfa793c564e4bbacc1cca8b7f3886.jpg");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningPlanPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("id",DataUtil.updateLearningPlan_ID);
        requestVariable.put("title",DataUtil.createLearningPlan_Title);
        requestVariable.put("name",DataUtil.createLearningPlan_Name);
        requestVariable.put("description","<p>testing automation123</p>");
        requestVariable.put("type","sub-chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId","lp20615");
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        subjects.put("matematikaa");
        metaInfo.put("subjects",subjects);
        classIDs.put("d66da317-2739-429c-b106-b91a2146a216");
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail","https://zs-inline.s3.ap-southeast-1.amazonaws.com/staging/b/51/cfa7/b51cfa793c564e4bbacc1cca8b7f3886.jpg?efs=https%3A%2F%2Fwww.zeniusnet.com%2Fassets%2Fv-img%2Fb%2F51%2Fcfa7%2Fb51cfa793c564e4bbacc1cca8b7f3886.jpg");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningPlanContentPayLoad() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id",DataUtil.subjectID);
        requestVariable.put("checksum",DataUtil.updateLearningPlan_Checksum);
        addLearningPlanID.put("learningPlanId",DataUtil.updateLearningPlan_ID);
        addLearningPlanID.put("order",DataUtil.learningPlanContentOrder);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningPlanState() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","updateLearningPlanState");
        requesrVariable.put("id",DataUtil.updateLearningPlan_ID);
        requesrVariable.put("visibility",DataUtil.visibility_Suppressed);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningPlanState($id: String!, $visibility: String!) {\n updateLearningPlanState(id: $id, visibility: $visibility)\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningPlanStateBulk() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject planID = new JSONObject();
        JSONArray data = new JSONArray();
        requestParam.put("operationName","updateLearningPlanStateBulk");
        planID.put("id",DataUtil.updateLearningPlan_ID);
        planID.put("visibility","published");
        data.put(planID);
        requestVariable.put("data",data);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanStateBulk($data: [UpdateLPBulkInput!]!) {\n updateLearningPlanStateBulk(data: $data) {\n success\n failed {\n reason\n data {\n id\n visibility\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningPlanBulk() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject planID = new JSONObject();
        JSONObject planID1 = new JSONObject();
        JSONArray data = new JSONArray();
        JSONArray tags = new JSONArray();
        JSONArray tags1 = new JSONArray();
        requestParam.put("operationName","updateLearningPlanBulk");

        planID.put("id",DataUtil.updateLearningPlan_ID);
        planID.put("title",DataUtil.createLearningPlan_Title);
        planID.put("description","");
        tags.put("penjumlahan");
        tags.put("pengurangan");
        tags.put("matematika");
        tags.put("bilangan");
        tags.put("pelajaran");
        tags.put("sampai");
        planID.put("tags",tags);
        data.put(planID);

        /*planID1.put("id","0fac711d-2ae4-45e6-a84d-a357ab14b4c2");
        planID1.put("title","BAB 1 - Bilangan Cacah 0 Sampai 20");
        planID1.put("description","");
        tags1.put("bilangan");
        tags1.put("matematika");
        tags1.put("pelajaran");
        tags1.put("cacah");
        tags1.put("sampai");
        planID1.put("tags",tags1);
        data.put(planID1);*/

        requestVariable.put("data",data);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanBulk($data: [UpdateLearningPlanInput!]!) {\n updateLearningPlanBulk(data: $data) {\n success {\n id\n url\n type\n title\n description\n content {\n learningPlanId\n __typename\n }\n __typename\n }\n failed {\n reason\n data {\n id\n url\n type\n title\n description\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }


    public String learningPlanPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","learningPlan");
        requesrVariable.put("id",DataUtil.updateLearningPlan_ID);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query learningPlan($id: String!) {\n  learningPlan(id: $id) {\n    id\n    checksum\n    title\n    name\n    url\n    type\n    description\n    visibility\n    privilege\n    privileges\n    shortId\n    tags\n    score\n    thumbnail\n    createdBy\n    createdAt\n    updatedBy\n    updatedAt\n    deletedBy\n    deletedAt\n    metaInfo\n    content {\n      order\n      learningPlanId\n      learningPlan {\n        id\n        type\n        title\n        visibility\n        privilege\n        privileges\n        description\n        tags\n        shortId\n        thumbnail\n        metaInfo\n        content {\n          order\n          learningUnitId\n          assessmentPlanId\n          learningPlanId\n          learningUnit {\n            id\n            title\n            visibility\n            duration\n            type\n            shortId\n            __typename\n          }\n          __typename\n        }\n        __typename\n      }\n      assessmentPlanId\n      assessmentPlan {\n        id\n        type\n        title\n        name\n        title\n        shortId\n        description\n        url\n        difficultyLevel\n        type\n        tags\n        score\n        duration\n        checksum\n        visibility\n        privilege\n        privileges\n        createdAt\n        updatedAt\n        createdBy\n        updatedBy\n        deletedAt\n        deletedBy\n        metaInfo\n        content {\n          order\n          __typename\n        }\n        __typename\n      }\n      learningUnitId\n      learningUnit {\n        id\n        type\n        title\n        tags\n        shortId\n        metaInfo\n        visibility\n        description\n        privileges\n        content {\n          order\n          id\n          type\n          title\n          videoUrl\n          metaInfo\n          content\n          thumbnail\n          __typename\n        }\n        __typename\n      }\n      __typename\n    }\n    __typename\n  }\n}\n");
        return requesrParam.toString();
    }

    public String learningPlanByShortIDPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","learningPlanByShortId");
        requesrVariable.put("shortId",DataUtil.learningPlan_shortID);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query learningPlanByShortId($shortId: String!) {\n learningPlanByShortId(shortId: $shortId) {\n id\n title\n name\n url\n type\n description\n visibility\n privilege\n shortId\n tags\n thumbnail\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n metaInfo\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n description\n tags\n shortId\n metaInfo\n content {\n order\n learningPlan {\n id\n type\n title\n visibility\n privilege\n description\n tags\n shortId\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n assessmentPlan {\n id\n type\n name\n title\n shortId\n description\n url\n type\n duration\n visibility\n privilege\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n duration\n thumbnail\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

    public String createLPPayloadFlashcardGroup() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.flashcardGroup_Title);
        requestVariable.put("name",DataUtil.flashcardGroup_Title);
        requestVariable.put("description","");
        requestVariable.put("type","flashcard_group");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        metaInfo.put("majors",new JSONArray());
        subjects.put("ips");
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",subjects);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentPayLoadFlashcardGroup() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id",DataUtil.flashcardGroup_SubChapterID);
        requestVariable.put("checksum",DataUtil.flashcardGroup_Checksum);
        addLearningPlanID.put("learningPlanId",DataUtil.flashcardGroup_ID);
        addLearningPlanID.put("order",1);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPPayloadFlashCardGroup() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("id",DataUtil.flashcardGroup_ID);
        requestVariable.put("title",DataUtil.flashcardGroupUpdated_Title);
        requestVariable.put("name",DataUtil.flashcardGroupUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","flashcard_group");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId",DataUtil.flashcardGroup_ShortID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        metaInfo.put("majors",new JSONArray());
        subjects.put("ips");
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",subjects);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPStateFlashcardGroup() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","updateLearningPlanState");
        requesrVariable.put("id",DataUtil.flashcardGroup_ID);
        requesrVariable.put("visibility",DataUtil.visibility_Suppressed);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningPlanState($id: String!, $visibility: String!) {\n updateLearningPlanState(id: $id, visibility: $visibility)\n}\n");
        return requesrParam.toString();
    }

    public String learningPlanPayloadFlashcardGroup() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","learningPlan");
        requestVariable.put("id",DataUtil.flashcardGroup_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query learningPlan($id: String!) {\n learningPlan(id: $id) {\n id\n checksum\n title\n name\n url\n type\n description\n visibility\n privilege\n privileges\n shortId\n tags\n score\n thumbnail\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n metaInfo\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n learningUnitId\n assessmentPlanId\n learningPlanId\n learningUnit {\n id\n title\n visibility\n duration\n type\n shortId\n __typename\n }\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n checksum\n visibility\n privilege\n privileges\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    //------------------------------------Node Payload--------------------------------

    public String createLPPayloadNode() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.node_Title);
        requestVariable.put("name",DataUtil.node_Title);
        requestVariable.put("description","");
        requestVariable.put("type","node");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        metaInfo.put("majors",new JSONArray());
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",JSONObject.NULL);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentPayLoadNode() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id",DataUtil.flashcardGroup_SubChapterID);
        requestVariable.put("checksum",DataUtil.node_Checksum);
        addLearningPlanID.put("learningPlanId",DataUtil.node_ID);
        addLearningPlanID.put("order",1);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPPayloadNode() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("id",DataUtil.node_ID);
        requestVariable.put("title",DataUtil.nodeUpdated_Title);
        requestVariable.put("name",DataUtil.nodeUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","node");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId",DataUtil.node_ShortID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        metaInfo.put("majors",new JSONArray());
        subjects.put("ips");
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",subjects);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPStateNode() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","updateLearningPlanState");
        requesrVariable.put("id",DataUtil.node_ID);
        requesrVariable.put("visibility",DataUtil.visibility_Suppressed);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningPlanState($id: String!, $visibility: String!) {\n updateLearningPlanState(id: $id, visibility: $visibility)\n}\n");
        return requesrParam.toString();
    }

    public String learningPlanPayloadNode() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","learningPlan");
        requestVariable.put("id",DataUtil.node_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query learningPlan($id: String!) {\n learningPlan(id: $id) {\n id\n checksum\n title\n name\n url\n type\n description\n visibility\n privilege\n privileges\n shortId\n tags\n score\n thumbnail\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n metaInfo\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n learningUnitId\n assessmentPlanId\n learningPlanId\n learningUnit {\n id\n title\n visibility\n duration\n type\n shortId\n __typename\n }\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n checksum\n visibility\n privilege\n privileges\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    //-------------------------------------Topic Payload------------------------------------------
    public String createLPPayloadTopic() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.topic_Title);
        requestVariable.put("name",DataUtil.topic_Title);
        requestVariable.put("description","");
        requestVariable.put("type","topic");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects","bahasa_indonesia");
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentPayLoadTopic() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id","df1d6f18-efd0-4bc4-85d1-ebab9e193d0e");
        requestVariable.put("checksum",DataUtil.topic_Checksum);
        addLearningPlanID.put("learningPlanId",DataUtil.topic_ID);
        addLearningPlanID.put("order",5);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPPayloadTopic() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("id",DataUtil.topic_ID);
        requestVariable.put("title",DataUtil.topicUpdated_Title);
        requestVariable.put("name",DataUtil.topicUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","topic");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId",DataUtil.topic_ShortID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        subjects.put("bahasa_indonesia");
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",subjects);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPStateTopic() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateLearningPlanState");
        requestVariable.put("id",DataUtil.topic_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanState($id: String!, $visibility: String!) {\n updateLearningPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String learningPlanPayloadTopic() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","learningPlan");
        requestVariable.put("id",DataUtil.topic_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query learningPlan($id: String!) {\n learningPlan(id: $id) {\n id\n checksum\n title\n name\n url\n type\n description\n visibility\n privilege\n privileges\n shortId\n tags\n score\n thumbnail\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n metaInfo\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n learningUnitId\n assessmentPlanId\n learningPlanId\n learningUnit {\n id\n title\n visibility\n duration\n type\n shortId\n __typename\n }\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n checksum\n visibility\n privilege\n privileges\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    //-------------------------------------Sub Chapter Payload------------------------------------------
    public String createLPPayloadSubChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.subChapter_Title);
        requestVariable.put("name",DataUtil.subChapter_Title);
        requestVariable.put("description","");
        requestVariable.put("type","sub-chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",JSONObject.NULL);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentPayLoadSubChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id",DataUtil.subjectID);
        requestVariable.put("checksum",DataUtil.subChapter_Checksum);
        addLearningPlanID.put("learningPlanId",DataUtil.subChapter_ID);
        addLearningPlanID.put("order",2);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPPayloadSubChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("id",DataUtil.subChapter_ID);
        requestVariable.put("title",DataUtil.subChapterUpdated_Title);
        requestVariable.put("name",DataUtil.subChapterUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","sub-chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId",DataUtil.subChapter_ShortID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",JSONObject.NULL);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPStateSubChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateLearningPlanState");
        requestVariable.put("id",DataUtil.subChapter_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanState($id: String!, $visibility: String!) {\n updateLearningPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String learningPlanPayloadSubChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","learningPlan");
        requestVariable.put("id",DataUtil.subChapter_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query learningPlan($id: String!) {\n learningPlan(id: $id) {\n id\n checksum\n title\n name\n url\n type\n description\n visibility\n privilege\n privileges\n shortId\n tags\n score\n thumbnail\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n metaInfo\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n learningUnitId\n assessmentPlanId\n learningPlanId\n learningUnit {\n id\n title\n visibility\n duration\n type\n shortId\n __typename\n }\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n checksum\n visibility\n privilege\n privileges\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    //-------------------------------------Chapter Payload------------------------------------------
    public String createLPPayloadChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();
        JSONArray subjectsID = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.chapter_Title);
        requestVariable.put("name",DataUtil.chapter_Title);
        requestVariable.put("description","");
        requestVariable.put("type","chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        subjectsID.put("bahasa_inggris");
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",subjectsID);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentPayLoadChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("id",DataUtil.subjectID);
        requestVariable.put("checksum",DataUtil.chapter_Checksum);
        addLearningPlanID.put("learningPlanId",DataUtil.chapter_ID);
        addLearningPlanID.put("order",2);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPPayloadChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("id",DataUtil.chapter_ID);
        requestVariable.put("title",DataUtil.chapterUpdated_Title);
        requestVariable.put("name",DataUtil.chapterUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId",DataUtil.chapter_ShortID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",JSONObject.NULL);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPStatechapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateLearningPlanState");
        requestVariable.put("id",DataUtil.chapter_ID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanState($id: String!, $visibility: String!) {\n updateLearningPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String learningPlanPayloadChapter() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","learningPlan");
        requestVariable.put("id",DataUtil.chapter_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query learningPlan($id: String!) {\n learningPlan(id: $id) {\n id\n checksum\n title\n name\n url\n type\n description\n visibility\n privilege\n privileges\n shortId\n tags\n score\n thumbnail\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n metaInfo\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n learningUnitId\n assessmentPlanId\n learningPlanId\n learningUnit {\n id\n title\n visibility\n duration\n type\n shortId\n __typename\n }\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n checksum\n visibility\n privilege\n privileges\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }


    //-------------------------------------Negative Test cases Payload------------------------------------------
    public String createLPPayloadChapterWithoutTitle() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();
        JSONArray subjectsID = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("name",DataUtil.chapter_Title);
        requestVariable.put("description","");
        requestVariable.put("type","chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        subjectsID.put("bahasa_inggris");
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",subjectsID);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String createLPPayloadWithoutDesc() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();
        JSONArray subjectsID = new JSONArray();

        requestParam.put("operationName","createLearningPlan");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.chapter_Title);
        requestVariable.put("name",DataUtil.chapter_Title);
        requestVariable.put("type","chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        subjectsID.put("bahasa_inggris");
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",subjectsID);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createLearningPlan($name: String!, $title: String!, $type: String!, $privilege: String, $privileges: [String], $description: String, $url: String, $tags: [String], $metaInfo: JSONObject, $thumbnail: String, $content: [LearningPlanContentInput]) {\n createLearningPlan(name: $name, title: $title, type: $type, description: $description, privilege: $privilege, privileges: $privileges, url: $url, tags: $tags, metaInfo: $metaInfo, thumbnail: $thumbnail, content: $content) {\n id\n checksum\n name\n title\n type\n tags\n description\n privilege\n shortId\n url\n metaInfo\n thumbnail\n privileges\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPContentPayLoadWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject addLearningPlanID = new JSONObject();
        JSONArray content = new JSONArray();
        requestParam.put("operationName","updateLearningPlanContent");
        requestVariable.put("checksum",DataUtil.chapter_Checksum);
        addLearningPlanID.put("learningPlanId",DataUtil.chapter_ID);
        addLearningPlanID.put("order",2);
        content.put(addLearningPlanID);
        requestVariable.put("content",content);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanContent($id: String!, $content: [LearningPlanContentInput]!, $checksum: String!) {\n updateLearningPlanContent(id: $id, checksum: $checksum, content: $content) {\n id\n checksum\n url\n type\n title\n description\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n visibility\n privilege\n privileges\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPStateWithoutVisiability() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","updateLearningPlanState");
        requestVariable.put("id",DataUtil.chapter_ID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlanState($id: String!, $visibility: String!) {\n updateLearningPlanState(id: $id, visibility: $visibility)\n}\n");
        return requestParam.toString();
    }

    public String updateLPPayloadWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("title",DataUtil.chapterUpdated_Title);
        requestVariable.put("name",DataUtil.chapterUpdated_Title);
        requestVariable.put("description","");
        requestVariable.put("type","chapter");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId",DataUtil.chapter_ShortID);
        requestVariable.put("visibility",DataUtil.visibility_Suppressed);
        requestVariable.put("tags",new JSONArray());
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",JSONObject.NULL);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLPPayloadWithoutPrivilege() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray classIDs = new JSONArray();

        requestParam.put("operationName","updateLearningPlan");
        requestVariable.put("id","78061ad2-b0b0-475e-aa9c-7871a1da13a4");
        requestVariable.put("title","QOTD-Geografy");
        requestVariable.put("name","QOTD-Geografy");
        requestVariable.put("description","");
        requestVariable.put("type","chapter");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("shortId","cg3172");
        requestVariable.put("visibility","published");
        requestVariable.put("tags",new JSONArray());
        classIDs.put(DataUtil.learningUnit_ClassID);
        requestVariable.put("subjects",JSONObject.NULL);
        requestVariable.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("thumbnail",JSONObject.NULL);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningPlan($id: String!, $name: String, $type: String, $title: String, $url: String, $description: String, $privilege: String, $privileges: [String], $thumbnail: String, $tags: [String], $metaInfo: JSONObject) {\n updateLearningPlan(id: $id, name: $name, type: $type, title: $title, url: $url, description: $description, privilege: $privilege, privileges: $privileges, thumbnail: $thumbnail, tags: $tags, metaInfo: $metaInfo) {\n id\n type\n title\n name\n url\n description\n thumbnail\n privilege\n privileges\n visibility\n shortId\n tags\n metaInfo\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n privilege\n visibility\n description\n shortId\n tags\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n tags\n shortId\n description\n url\n difficultyLevel\n score\n duration\n privilege\n visibility\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n metaInfo\n shortId\n visibility\n description\n content {\n order\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String learningPlanPayloadWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","learningPlan");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query learningPlan($id: String!) {\n learningPlan(id: $id) {\n id\n checksum\n title\n name\n url\n type\n description\n visibility\n privilege\n privileges\n shortId\n tags\n score\n thumbnail\n createdBy\n createdAt\n updatedBy\n updatedAt\n deletedBy\n deletedAt\n metaInfo\n content {\n order\n learningPlanId\n learningPlan {\n id\n type\n title\n visibility\n privilege\n privileges\n description\n tags\n shortId\n thumbnail\n metaInfo\n content {\n order\n learningUnitId\n assessmentPlanId\n learningPlanId\n learningUnit {\n id\n title\n visibility\n duration\n type\n shortId\n __typename\n }\n __typename\n }\n __typename\n }\n assessmentPlanId\n assessmentPlan {\n id\n type\n title\n name\n title\n shortId\n description\n url\n difficultyLevel\n type\n tags\n score\n duration\n checksum\n visibility\n privilege\n privileges\n createdAt\n updatedAt\n createdBy\n updatedBy\n deletedAt\n deletedBy\n metaInfo\n content {\n order\n __typename\n }\n __typename\n }\n learningUnitId\n learningUnit {\n id\n type\n title\n tags\n shortId\n metaInfo\n visibility\n description\n privileges\n content {\n order\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n __typename\n }\n __typename\n }\n questionId\n question {\n id\n title\n thumbnail\n score\n subject\n shortId\n image\n answers\n tags\n metaInfo\n options {\n label\n value\n __typename\n }\n type\n description\n difficultyLevel\n visibility\n multipleResponses\n answers\n learningUnitId\n updatedAt\n learningUnit {\n id\n type\n title\n description\n thumbnail\n metaInfo\n visibility\n shortId\n content {\n type\n title\n videoUrl\n thumbnail\n content\n tutorId\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

}
