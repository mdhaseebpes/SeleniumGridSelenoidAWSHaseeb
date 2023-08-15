package com.magneto.DriverFactory;

import com.magneto.constants.FileLocations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class initDriver {

    private static Logger logger = LogManager.getLogger(initDriver.class);
    public WebDriver driver;
    public Properties prop;

    OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> tlDriver =  new ThreadLocal<>();

    /**
     * this method is initializing the driver on the basis of given browser name
     * @return this returns the driver
     * @author : Mohammed Haseeb
     */
    public WebDriver initializeDriver(Properties prop){
        optionsManager = new OptionsManager(prop);
        String browserName = prop.getProperty("browser").toLowerCase().trim();

        if(browserName.equalsIgnoreCase("chrome")){
            if(Boolean.parseBoolean(prop.getProperty("remote"))){
                //run on remote/grid:
                initRemoteDriver("chrome");
            }else{
                //driver = new ChromeDriver(optionsManager.ChromeOptions());
                tlDriver.set(new ChromeDriver(optionsManager.ChromeOptions()));
            }

        } else if (browserName.trim().equalsIgnoreCase("firefox")) {
            if(Boolean.parseBoolean(prop.getProperty("remote"))){
                initRemoteDriver("firefox");
            }else {
                //driver = new FirefoxDriver(optionsManager.FirefoxOptions());
                tlDriver.set(new FirefoxDriver(optionsManager.FirefoxOptions()));
            }
        }else if (browserName.equalsIgnoreCase("safari")) {
            //  driver = new SafariDriver();
            tlDriver.set(new SafariDriver());
        }else {
            System.out.println("please pass the right browser ..." + browserName);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().fullscreen();
        getDriver().get(prop.getProperty("url"));
        return getDriver();
    }


    /**
     * this method is called internally to initialize the driver with
     * RemoteWebDriver
     * @param browser
     *  @author : Mohammed Haseeb
     */
    private void initRemoteDriver(String browser){
        logger.info("Running in remote grid ....." + browser);
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.ChromeOptions()));
                    break;
                case "firefox":
                        tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.FirefoxOptions()));
                    break;
                default:
                    throw new IllegalArgumentException("Please pass the correct browser for remote execution..." + browser);
            }
        }   catch (MalformedURLException e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * this method is reading the properties from the .properties file
     * @return : Properties
     * @author : Mohammed Haseeb
     */
    public Properties initializeProperties() {
        prop = new Properties();
        FileInputStream fileInputStream = null;
        String envName = System.getProperty("env");

        try {
            if (envName == null) {
                logger.info("Running in qa environment as no environment is passed...... ");
                fileInputStream = new FileInputStream(FileLocations.QA_CONFIG_PATH);
            }
            switch (Objects.requireNonNull(envName).toLowerCase().trim()) {
                case "qa":
                    logger.info("Running in "+envName+" environment...... ");
                    fileInputStream = new FileInputStream(FileLocations.QA_CONFIG_PATH);
                    break;
                case "dev":
                    logger.info("Running in "+envName+" environment...... ");
                    fileInputStream = new FileInputStream(FileLocations.DEV_CONFIG_PATH);
                    break;
                case "stage":
                    logger.info("Running in "+envName+" environment...... ");
                    fileInputStream = new FileInputStream(FileLocations.STAGE_CONFIG_PATH);
                    break;
                case "prod":
                    logger.info("Running in "+envName+" environment...... ");
                    fileInputStream = new FileInputStream(FileLocations.CONFIG_PATH);
                    break;
                default:
                    logger.info("Pass correct environment ");

            }
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    /*
     * get the local thread copy of the driver
     */
    public  static WebDriver getDriver() {

        return tlDriver.get();
    }



    /**
     *
     */
    public static String getScreenShot(){
        File fileSrc = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "build" + File.separator + "screenshot"+ File.separator + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtil.copyFile(fileSrc,destination);
        } catch (IOException e) {
          e.printStackTrace();
        }
        return path;
    }
}
