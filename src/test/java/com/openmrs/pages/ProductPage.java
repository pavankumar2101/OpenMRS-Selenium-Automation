package com.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{
    private By downloadLink = By.partialLinkText("Download");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickDownload() {
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());


        wait.until(ExpectedConditions.elementToBeClickable(downloadLink))
                .click();
    }
}
