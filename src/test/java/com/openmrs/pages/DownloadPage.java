package com.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DownloadPage extends BasePage{

    private By standaloneDownloadButton = By.cssSelector("a[href*='openmrs-standalone']");


    public DownloadPage(WebDriver driver){
        super(driver);
    }

    public void clickStandaloneDownload(){
        wait.until(ExpectedConditions.elementToBeClickable(standaloneDownloadButton)).click();
    }

    public boolean isDownloadPage(){
        wait.until(ExpectedConditions.urlContains("download"));
        return driver.getCurrentUrl().contains("download");
    }
}
