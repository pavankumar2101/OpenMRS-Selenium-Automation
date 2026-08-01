

package com.openmrs.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.openmrs.pages.HomePage;
import com.openmrs.pages.ProductPage;
import com.openmrs.pages.DownloadPage;
import com.openmrs.utils.WindowManager;
import com.openmrs.utils.ConfigReader;
import com.openmrs.utils.BrowserFactory;
import com.openmrs.utils.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected DownloadPage downloadPage;
    protected WindowManager windowManager;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);


    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

//        System.out.println("Selected Browser is:" + browser);
        logger.info("Selected browser: {}", browser);

        driver = BrowserFactory.getBrowser(browser);
        logger.info("Browser launched successfully");

        DriverManager.setDriver(driver);

        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        downloadPage = new DownloadPage(driver);
        windowManager = new WindowManager(driver);

    }

     @AfterMethod
    public void tearDown() {
        if(DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();

        }
     }

}
