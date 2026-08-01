package com.openmrs.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger = LoggerFactory.getLogger(RetryAnalyzer.class);

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            logger.info("Retrying test '{}' (Attempt {}/{})",
                    result.getName(),
                    retryCount,
                    MAX_RETRY_COUNT);

            return true;
        }

        logger.error("Test '{}' failed after {} retries.",
                result.getName(),
                MAX_RETRY_COUNT);

        return false;
    }
}
