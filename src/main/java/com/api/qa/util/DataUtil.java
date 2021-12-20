package com.api.qa.util;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class DataUtil{

	public final static int STATUSCODE_200 = 200;
	public final static int STATUSCODE_400 = 400;
	public final static String STATUSCODE_500 = "[500]";

	public final static String visibility_Suppressed = "suppressed";
	public final static String visibility_Published = "published";


	public static String learningUnit_shortID = "";
	public static String learningUnit_ID = "";
	public static String learningUnit_ClassID = "aaf5f644-b4d5-4930-9b75-d5ebbd9b114f";
	public static String learningUnit_ContentID = "15327409-3c18-4072-98f6-5c1daf04c6fd";


	public final static String createLearningPlan_Title = "Automation86";
	public final static String createLearningPlan_Name = "Automation86";
	public final static int learningPlanContentOrder = 10;
	public static String learningPlan_shortID = "";
	public static String updateLearningPlan_ID = "";
	public static String updateLearningPlan_Checksum = "";

	//----------------------------------Chapter-------------------------------------------
	public final static String chapter_Title = "Automation Chapter";
	public final static String chapterUpdated_Title = "Automation Chapter Updated";
	public static String chapter_ID = "";
	public static String chapter_ShortID = "";
	public static String chapter_Checksum = "";
	public final static String subjectID = "2aa5347b-9b9a-4bb3-b797-994683874050";

	//----------------------------------Sub Chapter-------------------------------------------
	public final static String subChapter_Title = "Automation Sub Chapter";
	public final static String subChapterUpdated_Title = "Automation Sub Chapter Updated";
	public static String subChapter_ID = "";
	public static String subChapter_ShortID = "";
	public static String subChapter_Checksum = "";

	//----------------------------------Topic-------------------------------------------
	public final static String topic_Title = "Automation Topic";
	public final static String topicUpdated_Title = "Automation Topic Updated";
	public static String topic_ID = "";
	public static String topic_ShortID = "";
	public static String topic_Checksum = "";

	//----------------------------------Node--------------------------------------------
	public final static String node_Title = "Automation Node";
	public final static String nodeUpdated_Title = "Automation Node Updated";
	public static String node_ID = "";
	public static String node_ShortID = "";
	public static String node_Checksum = "";

	//----------------------------------Flashcard Group---------------------------------
	public final static String flashcardGroup_Title = "Automation Flashcard Group";
	public final static String flashcardGroupUpdated_Title = "Automation Flashcard Group Updated";
	public final static String flashcardGroup_SubChapterID = "7b99824d-893e-40af-9946-f0bb729af6a8";
	public static String flashcardGroup_ID = "";
	public static String flashcardGroup_ShortID = "";
	public static String flashcardGroup_Checksum = "";

	//------------------------------------------Flashcard--------------------------------------
	public static String flashcard_ID = "";
	public static String flashcard_Checksum = "";
	public final static String flashcard_Title = "Automation Flash Card";
	public static String flashcard_FrontID = "555fabdb-0acd-486b-9d9d-dc0193cb3bc1";
	public static String flashcard_BackID = "290e6d9a-7cf8-4fe1-8fe3-e5e25af0a635";


	//----------------------------------Data Deletion File Name---------------------------------
	public final static String LearningPlanCollectionName = "learning_plan";
	public final static String LearningUnitCollectionName = "learning_unit";
	public final static String AssessmentPlanCollectionName = "assessment_plan";
	public final static String QuestionsCollectionName = "question";
	public final static String AllClassesCollectionName = "LMS_AllClasses";

	//------------------------------------------Quiz--------------------------------------------
	public final static String quizChapter_ID = "5262cace-4451-4851-9dfd-b08e4253ba5f";
	public final static String quiz_Title = "Automation Quiz";
	public final static String quizUpdated_Title = "Automation Quiz Updated";
	public static String quiz_ID = "";
	public static String quiz_ShortID = "";
	public static String quiz_Checksum = "";

	//------------------------------------------Practice--------------------------------------------
	public final static String practiceNode_ID = "865b290a-681c-4910-8915-9c2ba284c40c";
	public final static String practice_Title = "Automation Practice";
	public final static String practiceUpdated_Title = "Automation Practice Updated";
	public static String practice_ID = "";
	public static String practice_ShortID = "";
	public static String practice_Checksum = "";

	//------------------------------------------Tryout--------------------------------------------
	public final static String tryout_Title = "Automation Tryout";
	public final static String tryoutUpdated_Title = "Automation Tryout Updated";
	public final static String tryout_examId = "e1a592ad-7d8b-4398-ab65-99c1572ecb23";
	public static String tryout_ID = "";
	public static String tryout_ShortID = "";
	public static String tryout_Checksum = "";
	public final static String tryout_StartDate = "2020-12-23T05:45:44.945Z";
	public final static String tryout_EndDate = "2020-12-24T05:45:00.000Z";

	//------------------------------------------Premium Tryout--------------------------------------------
	public final static String premiumTryout_Title = "Automation Premium Tryout";
	public final static String premiumTryoutUpdated_Title = "Automation Premium Tryout Updated";
	public final static String premiumTryout_examId = "e1a592ad-7d8b-4398-ab65-99c1572ecb23";
	public static String premiumTryout_ID = "";
	public static String premiumTryout_ShortID = "";
	public static String premiumTryout_Checksum = "";

	//------------------------------------------Daily Quiz--------------------------------------------
	public final static String dailyQuiz_Title = "Automation Daily Quiz";
	public final static String dailyQuizUpdated_Title = "Automation Daily Quiz Updated";
	public static String dailyQuiz_ID = "";
	public static String dailyQuiz_ShortID = "";
	public static String dailyQuiz_Checksum = "";

	//------------------------------------------Questions--------------------------------------------
	public final static String question_Title = "Automated Question";
	public final static String questionUpdated_Title = "Automated Question Updated";
	public final static String questionQuiz_ID = "0bb4a8ae-3bc9-49b2-8407-0b15b5d9e9b6";
	public static String question_ID = "";
	public static String question_ShortID = "";
	public static String question_Checksum = "";

	//------------------------------------------Live--------------------------------------------
	public final static String classRoomName = "Automated Class Final 11";
	public static String classRoomID = "";

	//------------------------------------------APN--------------------------------------------
	public final static boolean enabled_free_class_notification = false;
	public final static boolean enabled_paid_class_notification = true;
	public final static int notificationsTimeBeforeClass = 10;


	//----------------------------------Role Wise Access Map------------------------------------
	public final static String SuperAdminUID = "gI2XwK527dQa5waEUsSvxPuK82n1";
	public final static String AdminUID = "fhsjd43whjkb";
	public final static String TutorUID = "";
	public final static String MarketingUID = "";
	public final static String FinanceUID = "";


	public static Map<String, Boolean> roleAccess = new HashMap<>();

	public static boolean crateLearningPlan(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean updateLearningPlanContent(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean updateLearningPlan(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean crateLearningUnit(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}
	public static boolean updateLearningUnitContent(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}
	public static boolean updateLearningUnit(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	//-----------------------------------------Assessment Plan--------------------------------------
	public static boolean crateAssessmentPlan(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean updateAssessmentlanContent(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean updateAssessmentPlan(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean getAssessmentPlan(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	//-----------------------------------------Questions--------------------------------------
	public static boolean createQuestion(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean updateQuestionContent(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean updateQuestion(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	public static boolean getQuestion(String role) {
		roleAccess.put("super_admin",true);
		roleAccess.put("admin",false);
		roleAccess.put("tutor",true);
		roleAccess.put("marketing",false);
		roleAccess.put("finance",false);
		return roleAccess.get(role);
	}

	
	

}
