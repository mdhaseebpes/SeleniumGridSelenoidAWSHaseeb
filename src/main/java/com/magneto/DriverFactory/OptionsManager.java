package com.magneto.DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

    private static Logger logger = LogManager.getLogger(OptionsManager.class);
    private Properties prop;
    private ChromeOptions co;
    private FirefoxOptions fo;


    public OptionsManager(Properties prop){
        this.prop=prop;
    }

    public ChromeOptions ChromeOptions(){
        co= new ChromeOptions();
        //co.addArguments("--remote-allow-origins=*");
        if(Boolean.parseBoolean(prop.getProperty("remote"))){
            co.setBrowserVersion(prop.getProperty("browserversion"));
            co.setCapability("browsername", "chrome");
            co.setCapability("enableVNC", true);
            co.setCapability("name", prop.getProperty("testcasename"));

        }
        if(Boolean.parseBoolean(prop.getProperty("headless").trim())){
            logger.info("running in headless");
            co.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim())){
            logger.info("running in incognito");
            co.addArguments("--incognito");
        }
        return co;
    }


    public FirefoxOptions FirefoxOptions(){
        fo= new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless").trim())){
            logger.info("running in headless");
            fo.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim())){
            logger.info("running in incognito");
            fo.addArguments("--incognito");
        }
        return fo;
    }


}
