package com.openmrs.reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;

public class ExtentTestManager {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void createTest(String testName,ExtentReports extentReports){
     ExtentTest test= extentReports.createTest(testName);
     extentTest.set(test);
    }

    public static ExtentTest getTest(){
        return extentTest.get();
    }

    public static void unloadTest(){
        extentTest.remove();
    }

}
