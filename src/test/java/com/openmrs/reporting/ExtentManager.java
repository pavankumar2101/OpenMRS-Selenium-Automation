

package com.openmrs.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.openmrs.utils.ConfigReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extentReports;
    private static final Logger logger =
            LoggerFactory.getLogger(ExtentManager.class);



    public static ExtentReports createReport()
    {
//        DateTimeFormatter formatter =
//                DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
//        String timeStamp = LocalDateTime.now().format(formatter);

        logger.info("Creating Extent Report");
        String reportPath=   "test-output/ExtentReport.html";

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(reportPath);

        sparkReporter.config().setDocumentTitle(
                "OpenMRS Automation Execution Report"
        );

        sparkReporter.config().setReportName(
                "OpenMRS Selenium Test Results"
        );

        sparkReporter.config().setTheme(
                Theme.STANDARD
        );

        sparkReporter.config().setTimeStampFormat(
                "dd-MM-yyyy HH:mm:ss"
        );

        logger.info("Report Path: {}", reportPath);

        extentReports = new ExtentReports();

        extentReports.attachReporter(sparkReporter);

        logger.info("Environment: {}", ConfigReader.getProperty("environment"));

        logger.info("Browser: {}",
                ConfigReader.getProperty("browser"));

        logger.info("URL: {}",
                 ConfigReader.getProperty("url"));


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

        extentReports.setSystemInfo(
                "Execution Time",
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                )
        );

        extentReports.setSystemInfo(
                "Java Version",
                System.getProperty("java.version")
        );

        extentReports.setSystemInfo(
                "Java Vendor",
                System.getProperty("java.vendor")
        );

        extentReports.setSystemInfo(
                "Operating System",
                System.getProperty("os.name")
        );

        extentReports.setSystemInfo(
                "OS Architecture",
                System.getProperty("os.arch")
        );

        extentReports.setSystemInfo(
                "Maven Profile",
                System.getProperty("env")
        );


        return extentReports;
    }


    public static synchronized ExtentReports getReport(){

        if(extentReports==null){
            createReport();
        }

        return extentReports;
    }

}
