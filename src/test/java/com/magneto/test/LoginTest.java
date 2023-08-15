package com.magneto.test;

import com.magneto.base.BaseTest;
import com.magneto.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void loginTest(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(homePage.HomePageVerification(),AppConstants.HOME_PAGE_TEXT);
    }


}
