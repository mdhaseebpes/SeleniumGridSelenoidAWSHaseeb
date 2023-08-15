package com.magneto.pages;

import com.magneto.ElementUtils.Utils;
import com.magneto.constants.AppConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static Logger logger = LogManager.getLogger(LoginPage.class);
    private WebDriver driver;
    Utils utils;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    private By signInLink = By.xpath("(//a[contains(text(),'Sign In')])[1]");
    private By userName  = By.id("idToken1");
    private By pwd = By.id("idToken2");

    private By signInBtn = By.id("loginButton_0");


    /**
     *
     * @return
     */
    public String getTitle(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        logger.info(e.getMessage());
        }
        String title =driver.getTitle();
        logger.info("Login page title : " + title);
        return title;
    }

    /**
     *
     */
    public void clickSignIn(){
        utils.waitElementVisible(signInLink, AppConstants.DEFAULT_LONG_TIME_OUT);
        utils.click(signInLink);
    }

    /**
     *
     * @author
     */
    public HomePage doLogin(String user, String password){
        utils.sendKeys(userName,user);
        utils.sendKeys(pwd,password);
        utils.click(signInBtn);
        return new HomePage(driver);
    }

}
