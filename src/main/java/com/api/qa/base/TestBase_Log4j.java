package com.api.qa.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestBase_Log4j {

    public static final Logger log = Logger.getLogger(TestBase_Deletion.class);

    public void TestBase_Log4j() {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/java/com/api/qa/config/log4j.properties");
    }

}