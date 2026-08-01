
package com.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HomePage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    private By productMenu = By.cssSelector("a[href='https://openmrs.org/product/']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        logger.info("Opening OpenMRS home page");
        driver.get("https://openmrs.org");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickProductMenu(){
        logger.info("Clicking Product menu");
        wait.until(ExpectedConditions.elementToBeClickable(productMenu)).click();
    }

    public void clickDownload() {

        // TODO:
        // We will implement this method in the next lesson
        // after identifying the correct navigation path
        // to the Download page.

    }
}