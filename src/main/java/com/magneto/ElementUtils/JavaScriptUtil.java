package com.magneto.ElementUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtil {

    public WebDriver driver;

    public JavaScriptUtil(WebDriver driver) {

        this.driver = driver;
    }

    public void scrollPageDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollTo(0,document.body.scrollHeight");
    }

    /**
     *
     */
    public void scrollPageUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }

    /**
     *
     * @param locator
     */
    public void scrollIntoView(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(locator));
    }

    /**
     *
     * @param locator
     */
    public void clickElementJs(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",driver.findElement(locator));
    }
}
