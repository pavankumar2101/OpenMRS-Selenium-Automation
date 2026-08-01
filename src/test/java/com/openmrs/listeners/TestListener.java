package com.openmrs.listeners;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.openmrs.utils.DriverManager;
import com.openmrs.utils.ScreenshotUtil;
import com.openmrs.reporting.ExtentManager;
import com.openmrs.reporting.ExtentTestManager;
import org.testng.ISuite;

public class TestListener implements ITestListener, ISuiteListener {
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failure :" + result.getName());
       String screenshot = ScreenshotUtil.captureScreenshot(DriverManager.getDriver(),result.getName());

        ExtentTestManager.getTest()
                .fail(result.getThrowable());

        ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);

    }

    @Override
     public void onTestStart(ITestResult result) {
        ExtentTestManager.createTest(result.getName(), ExtentManager.getReport());
    }

    @Override
    public void onFinish(ISuite suite){

        ExtentManager.getReport().flush();

    }


}

