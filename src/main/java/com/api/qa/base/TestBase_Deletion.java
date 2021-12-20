package com.api.qa.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestBase_Deletion extends TestBase_Log4j {
    public static BufferedWriter out;
    public void TestBase_Deletion_FileCreation (String filename) {

        TestBase_Log4j();
        log.info("Creating a file " + filename + " to delete data based on Id's");
        String filePath = System.getProperty("user.dir");
        try {
            File file = new File(filePath + "/" + filename);
            out = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
