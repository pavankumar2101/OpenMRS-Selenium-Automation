


package com.openmrs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getExtentReports() {

        if(extentReports == null){

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "test-output/ExtentReport.html"
                    );

            extentReports = new ExtentReports();

            extentReports.attachReporter(spark);

            extentReports.setSystemInfo(
                    "Project",
                    "OpenMRS Automation Framework"
            );

            extentReports.setSystemInfo(
                    "Tester",
                    "Automation Team"
            );

            extentReports.setSystemInfo(
                    "Environment",
                    ConfigReader.getProperty("environment")
            );

            extentReports.setSystemInfo(
                    "Browser",
                    ConfigReader.getProperty("browser")
            );

            extentReports.setSystemInfo(
                    "URL",
                    ConfigReader.getProperty("url")
            );
        }

        return extentReports;
    }
}