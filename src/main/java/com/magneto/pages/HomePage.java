package com.magneto.pages;

import com.magneto.DriverFactory.initDriver;
import com.magneto.ElementUtils.JavaScriptUtil;
import com.magneto.ElementUtils.Utils;
import com.magneto.constants.AppConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private static Logger logger = LogManager.getLogger(HomePage.class);
   private  WebDriver driver;
   public Utils utils;

   public JavaScriptUtil js;


    public HomePage(WebDriver driver) {
        this.driver=driver;
        this.utils = new Utils(driver);
        this.js = new JavaScriptUtil(driver);

    }

    By homePageText = By.xpath("//div[text()='Get Started Guide']");

    By accountLabel = By.xpath("//button[@aria-label='Account']//*[name()='svg']");

    By teamManagementText = By.xpath("//span[text() ='Team Management']");

    By name = By.xpath("//*[@id=\"name\"]");


    /**
     *
     * @return
     */
    public String HomePageVerification(){
    return utils.waitElementVisible(homePageText,AppConstants.DEFAULT_LONG_TIME_OUT).getText();
    }

    /**
     *
     * @return
     */
    public String verifyAccountDetails(){
        utils.click(accountLabel);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(teamManagementText)).click().perform();
        logger.info("fetching account name in accounts page");
        return utils.getElement(name).getAttribute("value");

    }


}
