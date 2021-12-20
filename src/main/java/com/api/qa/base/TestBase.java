package com.api.qa.base;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class TestBase {
	
	public static Properties prop;

	public void TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/api"
					+ "/qa/config/path.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}













}
