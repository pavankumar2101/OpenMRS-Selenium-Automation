package com.openmrs.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        File fileSource = ts.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("screenshots/"+ testName + ".png");
        File screenshots = new File("screenshots");
        if(!screenshots.exists()){
            screenshots.mkdirs();
        }
        try{
            Files.copy(
                    fileSource.toPath(),
                    destinationFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destinationFile.getPath();

    }
}
