package com.api.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Listeners;

public class TestData_ADS {

	public String mathpixSrc;
	
    public String uploadImagePayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","getDoubtsPreSignedUrl");
        requestVariable.put("classId","ads");
        requestVariable.put("filename","6b698254-8417-49d4-9db7-15c5484f3c95.png");
        requestVariable.put("contentType","image/jpeg");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query getDoubtsPreSignedUrl($classId: String!, $filename: String!, $contentType: String!) { getDoubtsPreSignedUrl(classId: $classId, filename: $filename, contentType: $contentType) { __typename url signedUrl } }");
        return requestParam.toString();
    }
    
    public String mathpixPayload() {
        JSONObject requestParam = new JSONObject();
        JSONObject dataOptions = new JSONObject();
        JSONArray formats=new JSONArray();
        formats.put("text");
        formats.put("html");
        formats.put("data");
        formats.put("latex_styled");
        dataOptions.put("include_asciimath", true);
        dataOptions.put("include_latex", true);
        requestParam.put("src",mathpixSrc);
        requestParam.put("formats",formats);
        requestParam.put("data_options",dataOptions);
        return requestParam.toString();
    }

    public String vectorSearchPayload(JSONObject requestParam)
    {	
    	requestParam.put("imageUrl", mathpixSrc);
    	requestParam.put("page", "0");
    	requestParam.put("requestId", "123");
    	requestParam.put("doubtId", "345");
    	requestParam.put("route", "bert");
    	requestParam.put("size", "20");
    	requestParam.put("subject", "matematika");
    	requestParam.put("type", "BM25");
    	return requestParam.toString();
    }

    public String doubtDetailPayload(String questionID)
    {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","question");
        requestVariable.put("id",questionID);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","query question($id:String!) { question(id:$id) { __typename id type description isMath subject learningUnitId image answers metaInfo options { __typename label value } shortId learningUnitAds { __typename id type title duration description thumbnail shortId privileges content { __typename type title videoUrl htmlContent thumbnail } } } }");
        return requestParam.toString();
    }

    public String doubtUnlikePayload(String questionID,int feedback)
    {
        JSONObject requestParam = new JSONObject();
        requestParam.put("questionId",questionID);
        requestParam.put("relevancyFeedback",feedback);
        requestParam.put("resourceId","60f5c470fe515e00134d5632");
        return requestParam.toString();
    }

    
    public String submitDoubtPayload(String resourceId)
    {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","markAnswerForAds");
        requestVariable.put("doubtStatus","POOL");
        requestVariable.put("resourceId",resourceId);
        requestVariable.put("automatedAnsBestFitQuestionId","");
        requestVariable.put("wasAnswerHelpful","");
        requestVariable.put("doubtSource","RD Sharma");
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation markAnswerForAds($doubtStatus: String!, $classId: String, $resourceId: String!, $automatedAnsBestFitQuestionId: String, $manualReport: String, $wasAnswerHelpful: String, $feedback: String, $reportQuestion: [String], $doubtSource: String) { markAnswerForAds(doubtStatus:$doubtStatus, classId:$classId, resourceId:$resourceId, automatedAnsBestFitQuestionId: $automatedAnsBestFitQuestionId, manualReport: $manualReport, wasAnswerHelpful: $wasAnswerHelpful, feedback: $feedback, reportQuestion: $reportQuestion, doubtSource : $doubtSource) { __typename _id resource user_id isSolved meta_info createdAt } }");
        return requestParam.toString();
    }

    
    public String createADSResourcePayload(String imgUrl,String doubtTxt,JSONArray mathpix,String desc)
    {
        JSONObject requestParam = new JSONObject();
        JSONObject requestVariable = new JSONObject();
        requestParam.put("operationName","createAdsResource");
        requestVariable.put("subject","matematika");
        requestVariable.put("doubtImage",imgUrl);
        requestVariable.put("doubtText",doubtTxt);
        requestVariable.put("doubtStatus","NEW");
        requestVariable.put("classId","95e92c8c-538e-4497-9687-d30549566bd5");
        requestVariable.put("learningPlanId","7f3358412a58db5a2432d9ece9f5ef9e");
        requestVariable.put("mathpix_data_ios",mathpix);
        requestParam.put("variables",requestVariable);
        requestParam.put("query","mutation createAdsResource($subject: String!, $doubtImage:String!, $doubtText:String!, $doubtStatus: String!, $classId: String!, $learningPlanId: String, $mathpix_data: [Object], $mathpix_data_ios: [MATHPIX_DATA]) { createAdsResource(subject: $subject, doubtImage:$doubtImage, doubtText:$doubtText, doubtStatus:$doubtStatus, classId:$classId, learningPlanId:$learningPlanId, mathpix_data:$mathpix_data, mathpix_data_ios: $mathpix_data_ios) { __typename _id resource user_id isSolved meta_info createdAt } }");
        return requestParam.toString();
    }

    
}
