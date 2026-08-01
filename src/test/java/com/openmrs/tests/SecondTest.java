package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondTest extends BaseTest {
     private static final Logger logger = LoggerFactory.getLogger(SecondTest.class);

    @Test
    public void verifySecondThreadExecution() throws InterruptedException {

        logger.info("Second test running");

        Thread.sleep(5000);
    }
}