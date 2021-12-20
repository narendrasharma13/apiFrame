package com.api.qa.util;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class TestData_LearningUnit {

    public String learningUnitPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","learningUnit");
        requesrVariable.put("id",DataUtil.learningUnit_ID);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query learningUnit($id: String!) {\n  learningUnit(id: $id) {\n    id\n    checksum\n    type\n    title\n    image\n    shortId\n    thumbnail\n    visibility\n    description\n    tags\n    score\n    difficultyLevel\n    privilege\n    privileges\n    metaInfo\n    content {\n      id\n      type\n      title\n      videoUrl\n      metaInfo\n      content\n      thumbnail\n      tutorId\n      duration\n      template\n      text\n      __typename\n    }\n    __typename\n  }\n}\n");
        return requesrParam.toString();
    }

    public String learningUnitByShortIDPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","learningUnitByShortId");
        requesrVariable.put("shortId",DataUtil.learningUnit_shortID);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query learningUnitByShortId($shortId: String!) {\n  learningUnitByShortId(shortId: $shortId) {\n    id\n    type\n    title\n    image\n    shortId\n    score\n    thumbnail\n    visibility\n    description\n    tags\n    difficultyLevel\n    privilege\n    metaInfo\n    content {\n      id\n      type\n      title\n      videoUrl\n      metaInfo\n      content\n      thumbnail\n      __typename\n    }\n    __typename\n  }\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnitState() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","updateLearningUnitState");
        requesrVariable.put("id",DataUtil.learningUnit_ID);
        requesrVariable.put("visibility",DataUtil.visibility_Suppressed);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningUnitState($id: String!, $visibility: String!) {\n  updateLearningUnitState(id: $id, visibility: $visibility)\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnit() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        JSONObject metainfo = new JSONObject();
        JSONObject tutors = new JSONObject();
        JSONObject content = new JSONObject();
        JSONArray tutor = new JSONArray();

        List<String> tags = new ArrayList();
        List<String> classIds = new ArrayList();

        tags.add("bilangan");
        tags.add("matematika");
        tags.add("sub");
        tags.add("pelajaran");
        tags.add("cacah");
        tags.add("berhitung");

        requesrParam.put("operationName","updateLearningUnit");
        requesrVariable.put("id",DataUtil.learningUnit_ID);
        requesrVariable.put("title","Berhitung (Part 3)");
        requesrVariable.put("description","<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\">tst001</span></span></p>");
        requesrVariable.put("type","video");
        requesrVariable.put("privilege","member");
        requesrVariable.put("privileges","");
        requesrVariable.put("difficultyLevel",1);
        requesrVariable.put("tags",tags);
        tutors.put("label","Wilona");
        tutors.put("value","290271141566501");
        requesrVariable.put("tutors",tutors);
        requesrVariable.put("thumbnail","https://www.zenius.net/assets/v-img/2/60/9dcd/2609dcdfa59d1b27667569e70b559a2db644166b1af9b6206c387c9166e9ab92.jpg");
        metainfo.put("playlistId","5e2a88d2-ebef-4a5d-a675-736a42fcfdf2");
        metainfo.put("embeddable",false);
        metainfo.put("videoLegacyId",123622);
        metainfo.put("name","03 No.3");
        metainfo.put("dbId","290271113856635");
        metainfo.put("unitDbId","290271165228499");
        metainfo.put("sub_tag","solution_video");
        metainfo.put("publicity","published");
        metainfo.put("last_publish_timestamp","2013-05-01T05:05:27.000Z");
        tutor.put("{dbId:290271141566501}");
        metainfo.put("tutors",tutor);
        metainfo.put("legacy_id",40537);
        metainfo.put("last_edit_timestamp","2019-12-06T10:34:32.249Z");
        metainfo.put("creation_timestamp","2019-12-06T10:34:32.249Z");
        metainfo.put("type","board");
        metainfo.put("upload_timestamp","2013-05-01T05:05:27.000Z");
        metainfo.put("play_icon_color","black");
        classIds.add("aaf5f644-b4d5-4930-9b75-d5ebbd9b114f");
        classIds.add("d66da317-2739-429c-b106-b91a2146a216");
        metainfo.put("classIds",classIds);
        requesrVariable.put("metaInfo",metainfo);
        content.put("id","a52e1f68-1b6b-4db6-a4c1-a4097d7ed3b3");
        content.put("type","animation");
        content.put("title","Berhitung (Part 3)");
        content.put("videoUrl","https://vs4zenius.akamaized.net/video-staging/a/52/e1f6/a52e1f681b6b4db6a4c1a4097d7ed3b3.m3u8?hdnts=st=1603095160~exp=1603096960~acl=/video-staging/*~hmac=bd1b6ba115fdc182bdf81e256b6d8208207bea4c3c78ad4418bcbb77ca6d3bdb");
        content.put("metaInfo","");
        content.put("content","staging-a52e1f681b6b4db6a4c1a4097d7ed3b3.mp4");
        content.put("thumbnail","https://www.zeniusnet.com/assets/v-img/5/c9/2f79/5c92f7951213409c839e7b5ba40980d7-00001.png");
        content.put("tutorId","300271141566005.0");
        content.put("duration",406);
        content.put("text","");
        content.put("__typename","LearningUnitContentType");
        requesrVariable.put("content",content);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningUnit($id: String!, $url: String, $type: String, $title: String, $description: String, $privilege: String, $duration: Int, $difficultyLevel: Int, $tags: [String], $metaInfo: JSONObject) {\n updateLearningUnit(id: $id, url: $url, type: $type, title: $title, description: $description, privilege: $privilege, difficultyLevel: $difficultyLevel, duration: $duration, tags: $tags, metaInfo: $metaInfo) {\n id\n checksum\n url\n type\n title\n tags\n metaInfo\n description\n difficultyLevel\n privilege\n content {\n id\n title\n order\n content\n type\n thumbnail\n tutorId\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnitContent() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray content = new JSONArray();
        JSONObject contentData = new JSONObject();
        JSONArray subject = new JSONArray();
        JSONArray classIds = new JSONArray();


        requestParam.put("operationName","updateLearningUnitContent");
        requestVariable.put("id",DataUtil.learningUnit_ID);
        requestVariable.put("title","Autotest");
        requestVariable.put("description","");
        requestVariable.put("type","video");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("tutors","");
        subject.put("bahasa_indonesia");
        metaInfo.put("subjects",subject);
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        requestVariable.put("metaInfo",metaInfo);
        contentData.put("id",DataUtil.learningUnit_ContentID);
        contentData.put("title","test");
        contentData.put("content","staging-8320b219a77c47e7bebd82ab2fad3439.mp4");
        contentData.put("tutorId","300271141566005.0");
        contentData.put("type","scribe");
        contentData.put("order",2);
        contentData.put("thumbnail","staging-6f2a4f5d6e9b46518f43273fd1c1929a-00001.png");
        content.put(contentData);
        requestVariable.put("content",content);
        requestVariable.put("checksum","");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningUnitContent($id: String!, $content: [LearningUnitContentInput]!, $checksum: String!) {\n updateLearningUnitContent(id: $id, content: $content, checksum: $checksum) {\n id\n checksum\n content {\n id\n title\n order\n content\n type\n thumbnail\n tutorId\n template\n text\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningUnitStateBulk() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONArray data = new JSONArray();
        JSONObject dataObj = new JSONObject();
        requestParam.put("operationName","updateLearningUnitStateBulk");
        dataObj.put("id",DataUtil.learningUnit_ID);
        dataObj.put("visibility",DataUtil.visibility_Published);
        data.put(dataObj);
        requestVariable.put("data",data);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningUnitStateBulk($data: [UpdateLUBulkInput!]!) {\n updateLearningUnitStateBulk(data: $data) {\n success\n failed {\n reason\n data {\n id\n visibility\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String getParentsByChildId() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","getParentsByChildId");
        requesrVariable.put("childId",DataUtil.learningUnit_ID);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query getParentsByChildId($childId: String!) {\n  getParentsByChildId(childId: $childId)\n}\n");
        return requesrParam.toString();
    }

    public String createLearningUnitPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONArray emptyArray = new JSONArray();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requesrParam.put("operationName","createLearningUnit");
        requestVariable.put("id","");
        requestVariable.put("title","testing186");
        requestVariable.put("description","");
        requestVariable.put("type","video");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",emptyArray);
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",emptyArray);
        requestVariable.put("tutors","");
        subjects.put("matematika");
        metaInfo.put("subjects",subjects);
        classIDs.put(DataUtil.learningUnit_ID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("content",emptyArray);
        requesrParam.put("variables",requestVariable);
        requesrParam.put("query","mutation createLearningUnit($type: String!, $difficultyLevel: Int!, $title: String!, $privilege: String!, $tags: [String], $image: String, $duration: Int, $metaInfo: JSONObject, $description: String, $content: [LearningUnitContentInput]) {\n createLearningUnit(type: $type, difficultyLevel: $difficultyLevel, title: $title, privilege: $privilege, tags: $tags, image: $image, metaInfo: $metaInfo, description: $description, content: $content, duration: $duration) {\n id\n checksum\n type\n description\n difficultyLevel\n shortId\n title\n privilege\n tags\n image\n metaInfo\n content {\n content\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

    public String createLearningUnitWithoutTitlePayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONArray emptyArray = new JSONArray();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requesrParam.put("operationName","createLearningUnit");
        requestVariable.put("id","");
        requestVariable.put("description","");
        requestVariable.put("type","video");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",emptyArray);
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",emptyArray);
        requestVariable.put("tutors","");
        subjects.put("matematika");
        metaInfo.put("subjects",subjects);
        classIDs.put(DataUtil.learningUnit_ID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("content",emptyArray);
        requesrParam.put("variables",requestVariable);
        requesrParam.put("query","mutation createLearningUnit($type: String!, $difficultyLevel: Int!, $title: String!, $privilege: String!, $tags: [String], $image: String, $duration: Int, $metaInfo: JSONObject, $description: String, $content: [LearningUnitContentInput]) {\n createLearningUnit(type: $type, difficultyLevel: $difficultyLevel, title: $title, privilege: $privilege, tags: $tags, image: $image, metaInfo: $metaInfo, description: $description, content: $content, duration: $duration) {\n id\n checksum\n type\n description\n difficultyLevel\n shortId\n title\n privilege\n tags\n image\n metaInfo\n content {\n content\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

    public String createLearningUnitWithoutDescriptionPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONArray emptyArray = new JSONArray();
        JSONObject metaInfo = new JSONObject();
        JSONArray subjects = new JSONArray();
        JSONArray classIDs = new JSONArray();

        requesrParam.put("operationName","createLearningUnit");
        requestVariable.put("id","");
        requestVariable.put("title","testing186");
        requestVariable.put("type","video");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",emptyArray);
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",emptyArray);
        requestVariable.put("tutors","");
        subjects.put("matematika");
        metaInfo.put("subjects",subjects);
        classIDs.put(DataUtil.learningUnit_ID);
        metaInfo.put("classIds",classIDs);
        requestVariable.put("metaInfo",metaInfo);
        requestVariable.put("content",emptyArray);
        requesrParam.put("variables",requestVariable);
        requesrParam.put("query","mutation createLearningUnit($type: String!, $difficultyLevel: Int!, $title: String!, $privilege: String!, $tags: [String], $image: String, $duration: Int, $metaInfo: JSONObject, $description: String, $content: [LearningUnitContentInput]) {\n createLearningUnit(type: $type, difficultyLevel: $difficultyLevel, title: $title, privilege: $privilege, tags: $tags, image: $image, metaInfo: $metaInfo, description: $description, content: $content, duration: $duration) {\n id\n checksum\n type\n description\n difficultyLevel\n shortId\n title\n privilege\n tags\n image\n metaInfo\n content {\n content\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnitContentWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray content = new JSONArray();
        JSONObject contentData = new JSONObject();
        JSONArray subject = new JSONArray();
        JSONArray classIds = new JSONArray();


        requestParam.put("operationName","updateLearningUnitContent");
        requestVariable.put("title","Autotest");
        requestVariable.put("description","");
        requestVariable.put("type","video");
        requestVariable.put("privilege","member");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("tutors","");
        subject.put("bahasa_indonesia");
        metaInfo.put("subjects",subject);
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        requestVariable.put("metaInfo",metaInfo);
        contentData.put("id",DataUtil.learningUnit_ContentID);
        contentData.put("title","test");
        contentData.put("content","staging-8320b219a77c47e7bebd82ab2fad3439.mp4");
        contentData.put("tutorId","300271141566005.0");
        contentData.put("type","scribe");
        contentData.put("order",2);
        contentData.put("thumbnail","staging-6f2a4f5d6e9b46518f43273fd1c1929a-00001.png");
        content.put(contentData);
        requestVariable.put("content",content);
        requestVariable.put("checksum","");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningUnitContent($id: String!, $content: [LearningUnitContentInput]!, $checksum: String!) {\n updateLearningUnitContent(id: $id, content: $content, checksum: $checksum) {\n id\n checksum\n content {\n id\n title\n order\n content\n type\n thumbnail\n tutorId\n template\n text\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningUnitContentWithoutPrivilege() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject metaInfo = new JSONObject();
        JSONArray content = new JSONArray();
        JSONObject contentData = new JSONObject();
        JSONArray subject = new JSONArray();
        JSONArray classIds = new JSONArray();

        requestParam.put("operationName","updateLearningUnitContent");
        requestVariable.put("id",DataUtil.learningUnit_ID);
        requestVariable.put("title","Autotest");
        requestVariable.put("description","");
        requestVariable.put("type","video");
        requestVariable.put("privileges",new JSONArray());
        requestVariable.put("difficultyLevel",1);
        requestVariable.put("tags",new JSONArray());
        requestVariable.put("tutors","");
        subject.put("bahasa_indonesia");
        metaInfo.put("subjects",subject);
        classIds.put(DataUtil.learningUnit_ClassID);
        metaInfo.put("classIds",classIds);
        requestVariable.put("metaInfo",metaInfo);
        contentData.put("id",DataUtil.learningUnit_ContentID);
        contentData.put("title","test");
        contentData.put("content","staging-8320b219a77c47e7bebd82ab2fad3439.mp4");
        contentData.put("tutorId","300271141566005.0");
        contentData.put("type","scribe");
        contentData.put("order",2);
        contentData.put("thumbnail","staging-6f2a4f5d6e9b46518f43273fd1c1929a-00001.png");
        content.put(contentData);
        requestVariable.put("content",content);
        requestVariable.put("checksum","");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningUnitContent($id: String!, $content: [LearningUnitContentInput]!, $checksum: String!) {\n updateLearningUnitContent(id: $id, content: $content, checksum: $checksum) {\n id\n checksum\n content {\n id\n title\n order\n content\n type\n thumbnail\n tutorId\n template\n text\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningUnitWithoutID() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        JSONObject metainfo = new JSONObject();
        JSONObject tutors = new JSONObject();
        JSONObject content = new JSONObject();
        JSONArray tutor = new JSONArray();

        List<String> tags = new ArrayList();
        List<String> classIds = new ArrayList();

        tags.add("bilangan");
        tags.add("matematika");
        tags.add("sub");
        tags.add("pelajaran");
        tags.add("cacah");
        tags.add("berhitung");

        requesrParam.put("operationName","updateLearningUnit");
        requesrVariable.put("title","Berhitung (Part 3)");
        requesrVariable.put("description","<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\">tst001</span></span></p>");
        requesrVariable.put("type","video");
        requesrVariable.put("privilege","member");
        requesrVariable.put("privileges","");
        requesrVariable.put("difficultyLevel",1);
        requesrVariable.put("tags",tags);
        tutors.put("label","Wilona");
        tutors.put("value","290271141566501");
        requesrVariable.put("tutors",tutors);
        requesrVariable.put("thumbnail","https://www.zenius.net/assets/v-img/2/60/9dcd/2609dcdfa59d1b27667569e70b559a2db644166b1af9b6206c387c9166e9ab92.jpg");
        metainfo.put("playlistId","5e2a88d2-ebef-4a5d-a675-736a42fcfdf2");
        metainfo.put("embeddable",false);
        metainfo.put("videoLegacyId",123622);
        metainfo.put("name","03 No.3");
        metainfo.put("dbId","290271113856635");
        metainfo.put("unitDbId","290271165228499");
        metainfo.put("sub_tag","solution_video");
        metainfo.put("publicity","published");
        metainfo.put("last_publish_timestamp","2013-05-01T05:05:27.000Z");
        tutor.put("{dbId:290271141566501}");
        metainfo.put("tutors",tutor);
        metainfo.put("legacy_id",40537);
        metainfo.put("last_edit_timestamp","2019-12-06T10:34:32.249Z");
        metainfo.put("creation_timestamp","2019-12-06T10:34:32.249Z");
        metainfo.put("type","board");
        metainfo.put("upload_timestamp","2013-05-01T05:05:27.000Z");
        metainfo.put("play_icon_color","black");
        classIds.add("aaf5f644-b4d5-4930-9b75-d5ebbd9b114f");
        classIds.add("d66da317-2739-429c-b106-b91a2146a216");
        metainfo.put("classIds",classIds);
        requesrVariable.put("metaInfo",metainfo);
        content.put("id","a52e1f68-1b6b-4db6-a4c1-a4097d7ed3b3");
        content.put("type","animation");
        content.put("title","Berhitung (Part 3)");
        content.put("videoUrl","https://vs4zenius.akamaized.net/video-staging/a/52/e1f6/a52e1f681b6b4db6a4c1a4097d7ed3b3.m3u8?hdnts=st=1603095160~exp=1603096960~acl=/video-staging/*~hmac=bd1b6ba115fdc182bdf81e256b6d8208207bea4c3c78ad4418bcbb77ca6d3bdb");
        content.put("metaInfo","");
        content.put("content","staging-a52e1f681b6b4db6a4c1a4097d7ed3b3.mp4");
        content.put("thumbnail","https://www.zeniusnet.com/assets/v-img/5/c9/2f79/5c92f7951213409c839e7b5ba40980d7-00001.png");
        content.put("tutorId","300271141566005.0");
        content.put("duration",406);
        content.put("text","");
        content.put("__typename","LearningUnitContentType");
        requesrVariable.put("content",content);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningUnit($id: String!, $url: String, $type: String, $title: String, $description: String, $privilege: String, $duration: Int, $difficultyLevel: Int, $tags: [String], $metaInfo: JSONObject) {\n updateLearningUnit(id: $id, url: $url, type: $type, title: $title, description: $description, privilege: $privilege, difficultyLevel: $difficultyLevel, duration: $duration, tags: $tags, metaInfo: $metaInfo) {\n id\n checksum\n url\n type\n title\n tags\n metaInfo\n description\n difficultyLevel\n privilege\n content {\n id\n title\n order\n content\n type\n thumbnail\n tutorId\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnitWithoutLegacy() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        JSONObject metainfo = new JSONObject();
        JSONObject tutors = new JSONObject();
        JSONObject content = new JSONObject();
        JSONArray tutor = new JSONArray();

        List<String> tags = new ArrayList();
        List<String> classIds = new ArrayList();

        tags.add("bilangan");
        tags.add("matematika");
        tags.add("sub");
        tags.add("pelajaran");
        tags.add("cacah");
        tags.add("berhitung");

        requesrParam.put("operationName","updateLearningUnit");
        requesrVariable.put("id",DataUtil.learningUnit_ID);
        requesrVariable.put("title","Berhitung (Part 3)");
        requesrVariable.put("description","<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\">tst001</span></span></p>");
        requesrVariable.put("type","video");
        requesrVariable.put("privilege","member");
        requesrVariable.put("privileges","");
        requesrVariable.put("difficultyLevel",1);
        requesrVariable.put("tags",tags);
        tutors.put("label","Wilona");
        tutors.put("value","290271141566501");
        requesrVariable.put("tutors",tutors);
        requesrVariable.put("thumbnail","https://www.zenius.net/assets/v-img/2/60/9dcd/2609dcdfa59d1b27667569e70b559a2db644166b1af9b6206c387c9166e9ab92.jpg");
        metainfo.put("playlistId","5e2a88d2-ebef-4a5d-a675-736a42fcfdf2");
        metainfo.put("embeddable",false);
        metainfo.put("videoLegacyId",123622);
        metainfo.put("name","03 No.3");
        metainfo.put("dbId","290271113856635");
        metainfo.put("unitDbId","290271165228499");
        metainfo.put("sub_tag","solution_video");
        metainfo.put("publicity","published");
        metainfo.put("last_publish_timestamp","2013-05-01T05:05:27.000Z");
        tutor.put("{dbId:290271141566501}");
        metainfo.put("tutors",tutor);
        metainfo.put("last_edit_timestamp","2019-12-06T10:34:32.249Z");
        metainfo.put("creation_timestamp","2019-12-06T10:34:32.249Z");
        metainfo.put("type","board");
        metainfo.put("upload_timestamp","2013-05-01T05:05:27.000Z");
        metainfo.put("play_icon_color","black");
        classIds.add("aaf5f644-b4d5-4930-9b75-d5ebbd9b114f");
        classIds.add("d66da317-2739-429c-b106-b91a2146a216");
        metainfo.put("classIds",classIds);
        requesrVariable.put("metaInfo",metainfo);
        content.put("id","a52e1f68-1b6b-4db6-a4c1-a4097d7ed3b3");
        content.put("type","animation");
        content.put("title","Berhitung (Part 3)");
        content.put("videoUrl","https://vs4zenius.akamaized.net/video-staging/a/52/e1f6/a52e1f681b6b4db6a4c1a4097d7ed3b3.m3u8?hdnts=st=1603095160~exp=1603096960~acl=/video-staging/*~hmac=bd1b6ba115fdc182bdf81e256b6d8208207bea4c3c78ad4418bcbb77ca6d3bdb");
        content.put("metaInfo","");
        content.put("content","staging-a52e1f681b6b4db6a4c1a4097d7ed3b3.mp4");
        content.put("thumbnail","https://www.zeniusnet.com/assets/v-img/5/c9/2f79/5c92f7951213409c839e7b5ba40980d7-00001.png");
        content.put("tutorId","300271141566005.0");
        content.put("duration",406);
        content.put("text","");
        content.put("__typename","LearningUnitContentType");
        requesrVariable.put("content",content);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningUnit($id: String!, $url: String, $type: String, $title: String, $description: String, $privilege: String, $duration: Int, $difficultyLevel: Int, $tags: [String], $metaInfo: JSONObject) {\n updateLearningUnit(id: $id, url: $url, type: $type, title: $title, description: $description, privilege: $privilege, difficultyLevel: $difficultyLevel, duration: $duration, tags: $tags, metaInfo: $metaInfo) {\n id\n checksum\n url\n type\n title\n tags\n metaInfo\n description\n difficultyLevel\n privilege\n content {\n id\n title\n order\n content\n type\n thumbnail\n tutorId\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnitStateWithoutID() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","updateLearningUnitState");
        requesrVariable.put("visibility",DataUtil.visibility_Suppressed);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningUnitState($id: String!, $visibility: String!) {\n  updateLearningUnitState(id: $id, visibility: $visibility)\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnitStateWithoutVisiaility() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","updateLearningUnitState");
        requesrVariable.put("id",DataUtil.learningUnit_ID);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningUnitState($id: String!, $visibility: String!) {\n  updateLearningUnitState(id: $id, visibility: $visibility)\n}\n");
        return requesrParam.toString();
    }

    public String learningUnitWithoutShortIDPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","learningUnitByShortId");
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query learningUnitByShortId($shortId: String!) {\n  learningUnitByShortId(shortId: $shortId) {\n    id\n    type\n    title\n    image\n    shortId\n    score\n    thumbnail\n    visibility\n    description\n    tags\n    difficultyLevel\n    privilege\n    metaInfo\n    content {\n      id\n      type\n      title\n      videoUrl\n      metaInfo\n      content\n      thumbnail\n      __typename\n    }\n    __typename\n  }\n}\n");
        return requesrParam.toString();
    }

    public String updateLearningUnitStateBulkWithoutID() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONArray data = new JSONArray();
        JSONObject dataObj = new JSONObject();
        requestParam.put("operationName","updateLearningUnitStateBulk");
        dataObj.put("visibility",DataUtil.visibility_Published);
        data.put(dataObj);
        requestVariable.put("data",data);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningUnitStateBulk($data: [UpdateLUBulkInput!]!) {\n updateLearningUnitStateBulk(data: $data) {\n success\n failed {\n reason\n data {\n id\n visibility\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String getParentsWithoutChildId() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","getParentsByChildId");
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query getParentsByChildId($childId: String!) {\n  getParentsByChildId(childId: $childId)\n}\n");
        return requesrParam.toString();
    }

    public String learningUnitPayloadWithoutID() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","learningUnit");
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query learningUnit($id: String!) {\n  learningUnit(id: $id) {\n    id\n    checksum\n    type\n    title\n    image\n    shortId\n    thumbnail\n    visibility\n    description\n    tags\n    score\n    difficultyLevel\n    privilege\n    privileges\n    metaInfo\n    content {\n      id\n      type\n      title\n      videoUrl\n      metaInfo\n      content\n      thumbnail\n      tutorId\n      duration\n      template\n      text\n      __typename\n    }\n    __typename\n  }\n}\n");
        return requesrParam.toString();
    }

    //-----------------------------------Flash Card-------------------------------
    public String createFlashcardPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONArray content = new JSONArray();
        JSONObject frontSide = new JSONObject();
        JSONObject backSide = new JSONObject();
        requesrParam.put("operationName","createLearningUnit");
        requestVariable.put("id",JSONObject.NULL);
        requestVariable.put("title",DataUtil.flashcard_Title);
        requestVariable.put("type","video");
        requestVariable.put("privilege","member");
        requestVariable.put("difficultyLevel",1);
        frontSide.put("id",DataUtil.flashcard_FrontID);
        frontSide.put("type","front");
        frontSide.put("title","frontTitle");
        frontSide.put("text","<p>front side test</p>");
        frontSide.put("content","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>front side test</p> </div></div><div class=\\\"watermark\\\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        frontSide.put("template","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>front side test</p> </div></div><div class=\"watermark\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        backSide.put("id",DataUtil.flashcard_BackID);
        backSide.put("type","back");
        backSide.put("title","backTitle");
        backSide.put("text","<p>back side test</p>");
        backSide.put("content","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>back side test</p> </div></div><div class=\"watermark\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        backSide.put("template","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>back side test</p> </div></div><div class=\"watermark\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        content.put(frontSide);
        content.put(backSide);
        requestVariable.put("content",content);
        requestVariable.put("type","flashcard");
        requesrParam.put("variables",requestVariable);
        requesrParam.put("query","mutation createLearningUnit($type: String!, $difficultyLevel: Int!, $title: String!, $privilege: String!, $tags: [String], $image: String, $duration: Int, $metaInfo: JSONObject, $description: String, $content: [LearningUnitContentInput]) { createLearningUnit(type: $type, difficultyLevel: $difficultyLevel, title: $title, privilege: $privilege, tags: $tags, image: $image, metaInfo: $metaInfo, description: $description, content: $content, duration: $duration) { id checksum type description difficultyLevel title privilege tags image metaInfo content { content __typename } __typename } } ");
        return requesrParam.toString();
    }

    public String updateFlashcardLUcontent() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONObject frontSide = new JSONObject();
        JSONObject backSide = new JSONObject();
        JSONArray content = new JSONArray();

        requestParam.put("operationName","updateLearningUnitContent");
        requestVariable.put("id",DataUtil.flashcard_ID);
        requestVariable.put("title",DataUtil.flashcard_Title);
        requestVariable.put("privilege","member");
        requestVariable.put("difficultyLevel",1);
        frontSide.put("id",DataUtil.flashcard_FrontID);
        frontSide.put("type","front");
        frontSide.put("title","frontTitle");
        frontSide.put("text","<p>front side test</p>");
        frontSide.put("content","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>front side test</p> </div></div><div class=\\\"watermark\\\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        frontSide.put("template","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>front side test</p> </div></div><div class=\"watermark\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        backSide.put("id",DataUtil.flashcard_BackID);
        backSide.put("type","back");
        backSide.put("title","backTitle");
        backSide.put("text","<p>back side test</p>");
        backSide.put("content","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>back side test</p> </div></div><div class=\"watermark\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        backSide.put("template","<div style='width: 100%; height: 100%;display: flex; align-items: center;'> <div style='height:100%; text-align: center; white-space: break-spaces; display: flex; justify-content: center; align-items: center; overflow: hidden;word-break: break-word;'><div style='width: 100%; padding: 10px'> <p>back side test</p> </div></div><div class=\"watermark\" style='position: absolute;right: 1.5rem;bottom: .3rem;color: #dcd9d9;font-size: 16px;font-weight: bold;'>Zenius</div></div>");
        content.put(frontSide);
        content.put(backSide);
        requestVariable.put("content",content);
        requestVariable.put("tutors","");
        requestVariable.put("type","flashcard");
        requestVariable.put("checksum",DataUtil.flashcard_Checksum);
        requestVariable.put("content",content);
        requestVariable.put("checksum","");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningUnitContent($id: String!, $content: [LearningUnitContentInput]!, $checksum: String!) {\n updateLearningUnitContent(id: $id, content: $content, checksum: $checksum) {\n id\n checksum\n content {\n id\n title\n order\n content\n type\n thumbnail\n tutorId\n template\n text\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String updateLearningUnitStateFlashcard() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","updateLearningUnitState");
        requesrVariable.put("id",DataUtil.flashcard_ID);
        requesrVariable.put("visibility",DataUtil.visibility_Suppressed);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","mutation updateLearningUnitState($id: String!, $visibility: String!) {\n updateLearningUnitState(id: $id, visibility: $visibility)\n}\n");
        return requesrParam.toString();
    }

    public String updateLUStateBulkFlashcard() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        JSONArray data = new JSONArray();
        JSONObject dataObj = new JSONObject();
        requestParam.put("operationName","updateLearningUnitStateBulk");
        dataObj.put("id",DataUtil.flashcard_ID);
        dataObj.put("visibility",DataUtil.visibility_Published);
        data.put(dataObj);
        requestVariable.put("data",data);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation updateLearningUnitStateBulk($data: [UpdateLUBulkInput!]!) {\n updateLearningUnitStateBulk(data: $data) {\n success\n failed {\n reason\n data {\n id\n visibility\n __typename\n }\n __typename\n }\n __typename\n }\n}\n");
        return requestParam.toString();
    }

    public String learningUnitFlashcardPayload() {
        JSONObject requesrParam = new JSONObject();
        JSONObject requesrVariable = new JSONObject();
        requesrParam.put("operationName","learningUnit");
        requesrVariable.put("id",DataUtil.flashcard_ID);
        requesrParam.put("variables",requesrVariable);
        requesrParam.put("query","query learningUnit($id: String!) {\n learningUnit(id: $id) {\n id\n checksum\n type\n title\n image\n shortId\n thumbnail\n visibility\n description\n tags\n score\n difficultyLevel\n privilege\n privileges\n metaInfo\n content {\n id\n type\n title\n videoUrl\n metaInfo\n content\n thumbnail\n tutorId\n duration\n template\n text\n __typename\n }\n __typename\n }\n}\n");
        return requesrParam.toString();
    }

}
