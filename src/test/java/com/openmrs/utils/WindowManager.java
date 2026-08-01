package com.openmrs.utils;

import org.openqa.selenium.WebDriver;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowManager {
    private WebDriver driver;
    private String parentWindow;

    private static  final Logger logger = LoggerFactory.getLogger(WindowManager.class);

    public WindowManager(WebDriver driver) {
        this.driver=driver;
    }

    public void saveParentWindow() {

        parentWindow = driver.getWindowHandle();
        logger.info("Parent window saved");
    }

    public void switchToChildWindow() {


        logger.info("Switching to child window");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windows = driver.getWindowHandles();
        for( String window : windows  ) {
            if(!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToParentWindow(){
        logger.info("Switching back to parent window");
        driver.switchTo().window(parentWindow);
    }

}

