package com.magneto.test;

import com.magneto.ElementUtils.initData;
import com.magneto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @BeforeClass
    public void accPageSetup() {
        homePage =   loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));;
    }



    @Test(priority = 1)
    public void verifyAccountDetailsTest(){
        homePage.HomePageVerification();
        String actualOrganization = homePage.verifyAccountDetails();
        Assert.assertEquals(actualOrganization, initData.initDataProp().getProperty("organizationName"));
    }


    @Test(priority = 2)
    public void verifyAccountTest(){
        homePage.HomePageVerification();
        String actualOrganization = homePage.verifyAccountDetails();
        Assert.assertEquals(actualOrganization, initData.initDataProp().getProperty("organizationName"));
    }

}
