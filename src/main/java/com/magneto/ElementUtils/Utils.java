package com.magneto.ElementUtils;

import com.magneto.constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Utils {

   private WebDriver driver;


    public Utils(WebDriver driver) {
        this.driver = driver;
    }




    public void click(By locator){
        waitElementVisible(locator, AppConstants.DEFAULT_LONG_TIME_OUT);
        driver.findElement(locator).click();
    }

    public WebElement waitElementVisible(By locator , int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitElementsVisible(By locator , int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void sendKeys(By locator, String text){
        waitElementVisible(locator,AppConstants.DEFAULT_LONG_TIME_OUT);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementDisplayed(By locator , int timeOut){
        boolean flag  = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
           WebElement element =wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
              if(element.isDisplayed()){
                  flag=true;
                  System.out.println("element is displayed" + locator);
              }
        }catch (Exception e){
            flag=false;
            System.out.println("element is Not displayed" + locator);
        }
        return flag;
    }

    public  WebElement getElement(By locator) {
        return waitElementVisible(locator,AppConstants.DEFAULT_LONG_TIME_OUT).findElement(locator);

    }

    public void mouseHover(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(locator)).perform();
    }


    public List<String> getListWebElements(By locator){
        List<WebElement> eleList = waitElementsVisible(locator, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        List<String> eleText = new ArrayList<>();
        for(WebElement e : eleList){
            String text = e.getText();
            eleText.add(text);
        }
       return eleText;
    }

    public void clickElementByName(By locator, String name){
        List<WebElement> eleList = waitElementsVisible(locator, AppConstants.DEFAULT_LONG_TIME_OUT);
        for(WebElement e : eleList){
            String text = e.getText();
          if(text.equalsIgnoreCase(name)){
              e.click();
              break;
          }
        }
        System.out.println("Element was not found");

    }

}
