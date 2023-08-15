package com.magneto.base;

import com.magneto.DriverFactory.initDriver;
import com.magneto.pages.HomePage;
import com.magneto.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {


    WebDriver driver;
    initDriver initDriver;
    protected Properties prop;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Parameters({ "browser", "browserversion", "testcasename" })
    @BeforeTest
    public void setUp(@Optional("chrome") String browserName,@Optional("111") String browserVersion, @Optional("test")String testCaseName){
        initDriver = new initDriver();
        prop =initDriver.initializeProperties();
        if(browserName!=null){
            prop.setProperty("browser", browserName);
            //prop.setProperty("browserversion", browserVersion);
           // prop.setProperty("testcasename", testCaseName);
        }
        driver = initDriver.initializeDriver(prop);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
