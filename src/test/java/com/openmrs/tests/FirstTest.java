

package com.openmrs.tests;

import com.openmrs.base.BaseTest;

import com.openmrs.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void verifyNavigationToDownloadPage() {

        homePage.open();

        homePage.clickProductMenu();


        productPage.clickDownload();


        windowManager.saveParentWindow();

        downloadPage.clickStandaloneDownload();

         windowManager.switchToChildWindow();

//         Assert.assertTrue(false);
        Assert.assertTrue(downloadPage.isDownloadPage(), "Download page URL validation failed");

        windowManager.switchToParentWindow();
        System.out.println("Switched back to parent window");
        System.out.println(ConfigReader.getProperty("url"));

    }
}