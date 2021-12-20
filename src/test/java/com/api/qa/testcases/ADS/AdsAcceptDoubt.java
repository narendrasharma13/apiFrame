package com.api.qa.testcases.ADS;

import com.api.qa.APIs.APIResponse;
import com.api.qa.Services.DataDeletionService;
import com.api.qa.base.TestBase_Deletion;
import com.api.qa.util.DataUtil;
import com.api.qa.util.TestData_ADS;
import com.api.qa.util.TestData_AssessmentPlan;
import io.restassured.response.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class AdsAcceptDoubt extends TestBase_Deletion {

	DataDeletionService dataDeletionService = new DataDeletionService();
	TestData_ADS testData = new TestData_ADS();
	APIResponse apiResponse = new APIResponse();
	Response response;
	String imgLink;
	JSONObject vectorJson;
	String questionId;
	String learningUnitId;
	JSONArray data;
	String doubtTxt;
	String doubtDesc;
	String resourceId;

	private String role;

	@BeforeClass
	@Parameters("Role")
	public void setUID(@Optional("super_admin")String Role) {
		this.role = Role;
		if (Role.equals("super_admin")) { apiResponse.uid = DataUtil.SuperAdminUID; }
		else if (Role.equals("admin")) { apiResponse.uid = DataUtil.AdminUID; }
		else if (Role.equals("marketing")) { apiResponse.uid = DataUtil.MarketingUID; }
	}

	@Test(enabled=false,priority = 1,description = "Verify image upload")
	public void verifyImageUpload() throws IOException {
		response = apiResponse.postRequest(testData.uploadImagePayload());
		Assert.assertEquals(response.getStatusCode(),DataUtil.STATUSCODE_200); 
		imgLink=response.jsonPath().getString("data.getDoubtsPreSignedUrl.signedUrl");
	}

	@Test(priority = 2,description = "verify mathpix")
	public void verifyMathpix() throws IOException {
		testData.mathpixSrc="https://zs-user.s3.ap-southeast-1.amazonaws.com/development/doubts/ads/mcOlLb49hlT1OCPXLeEQB8mX3kV2/035aca53-d73f-437e-a0be-ff100ddb9b01.png";
		response = apiResponse.postRequestMathpix(testData.mathpixPayload());
		Assert.assertEquals(response.getStatusCode(),DataUtil.STATUSCODE_200); 
		String respBody=response.getBody().asString();
		vectorJson=new JSONObject(respBody);
		data=vectorJson.getJSONArray("data");
		doubtDesc=vectorJson.getString("html");
		doubtTxt=vectorJson.getString("text");
		
		vectorJson.remove("request_id");
		vectorJson.remove("is_printed");
		vectorJson.remove("is_handwritten");
		vectorJson.remove("auto_rotate_confidence");
		vectorJson.remove("auto_rotate_degrees");
		vectorJson.remove("latex_styled");
		Number conR=vectorJson.getNumber("confidence_rate");
		vectorJson.remove("confidence_rate");
		vectorJson.put("confidenceRate", conR);
	}    

	@Test(enabled=true,priority = 3,description = "createAdsResource")
	public void createADSResource() throws IOException {
		//testData.mathpixSrc="https://zs-user.s3.ap-southeast-1.amazonaws.com/development/doubts/ads/c69e0fda-729c-4d22-bd0d-fbf9f3ac268f/1626381654685%2B2021-7-15%2Bat%2B08.40.54%2BPM.png";
		response = apiResponse.postRequest(testData.createADSResourcePayload(testData.mathpixSrc, doubtTxt, data, doubtDesc));
		response.prettyPrint();
		resourceId=response.jsonPath().getString("data.createAdsResource._id");
		Assert.assertEquals(response.getStatusCode(),DataUtil.STATUSCODE_200); 
		System.out.println("#################################################");
	}   
	
	@Test(priority = 4,description = "verify Vector search")
	public void verifyVectorSearch() throws IOException {
		//testData.mathpixSrc="https://zs-user.s3.ap-southeast-1.amazonaws.com/development/doubts/ads/c69e0fda-729c-4d22-bd0d-fbf9f3ac268f/1626381654685%2B2021-7-15%2Bat%2B08.40.54%2BPM.png";
		System.out.println("#################################  VECTOR SEARCH ################");
		response = apiResponse.postRequestVectorSearch(testData.vectorSearchPayload(vectorJson));
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(),DataUtil.STATUSCODE_200); 
		setVideoQuestionId(response);
		System.out.println("#################################################");
	}   

	@Test(priority = 5,description = "verify Doubt detail")
	public void verifyDoubtDetails() throws IOException {
		//testData.mathpixSrc="https://zs-user.s3.ap-southeast-1.amazonaws.com/development/doubts/ads/c69e0fda-729c-4d22-bd0d-fbf9f3ac268f/1626381654685%2B2021-7-15%2Bat%2B08.40.54%2BPM.png";
		response = apiResponse.postRequest(testData.doubtDetailPayload(questionId));
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(),DataUtil.STATUSCODE_200); 
		verifyJsonResponse("data.question.learningUnitId", learningUnitId);
		verifyJsonResponse("data.question.learningUnitAds.type", "video");
		String videoUrl=response.jsonPath().getString("data.question.learningUnitAds.content[0].videoUrl");
		System.out.println(videoUrl);

	}   

	@Test(priority = 6,description = "verify feedback")
	public void verifyfeedback() throws IOException {
		//testData.mathpixSrc="https://zs-user.s3.ap-southeast-1.amazonaws.com/development/doubts/ads/c69e0fda-729c-4d22-bd0d-fbf9f3ac268f/1626381654685%2B2021-7-15%2Bat%2B08.40.54%2BPM.png";
		response = apiResponse.putUnlikeRequest(testData.doubtUnlikePayload(questionId, -1));
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(),DataUtil.STATUSCODE_200); 
	}  
	
	@Test(priority = 7,description = "verify submit doubt")
	public void verifySubmitDoubt() throws IOException {
		//testData.mathpixSrc="https://zs-user.s3.ap-southeast-1.amazonaws.com/development/doubts/ads/c69e0fda-729c-4d22-bd0d-fbf9f3ac268f/1626381654685%2B2021-7-15%2Bat%2B08.40.54%2BPM.png";
		response = apiResponse.postRequest(testData.submitDoubtPayload(resourceId));
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(),DataUtil.STATUSCODE_200); 
	}   
	
	
	///////////////
	public void setVideoQuestionId(Response response)
	{
		try{
			for(int i=0;i<20;i++)
			{
				String items=response.jsonPath().getString("data.items["+i+"].learningUnitType");
				if(items!=null&&items.contains("video"))
				{
					questionId=response.jsonPath().getString("data.items["+i+"].id");
					learningUnitId=response.jsonPath().getString("data.items["+i+"].learningUnitId");
					break;
				}
			}
			if(questionId==null)
				questionId=response.jsonPath().getString("data.items[0].id");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyJsonResponse(String jsonPath,String value)
	{
		try{
			String jsonValue=response.jsonPath().getString(jsonPath);
			if(!jsonValue.equalsIgnoreCase(value))
				Assert.assertEquals(jsonValue, value);
			System.out.println("actual:"+jsonValue+" expected: "+value+"(verified)");
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
