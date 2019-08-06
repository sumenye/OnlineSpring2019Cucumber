package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {


    //it's not main method
    //it's a method that returns object of webdriver
    //it can be firefox of chrome based on value of parameter
    //again, we create method to reuse a code
    //remember, if some code must be used at least twice
    //create method for this code
    //don't duplicate same code again and again
    public static WebDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            //we need to specify properties for chromedriver
            //otherwise, selenium will not know where to find chromedriver
            //1st param is webdriver type
            //2nd param is for path to the web driver
            //it's required by selenium web driver to interact with web browser
            //we need to specify properties for chromedriver
            //otherwise, selenium will not know where to find chromedriver
            System.setProperty("webdriver.chrome.driver", "/Users/sumeyyecetintas/Documents/selenium dependencies/drivers/chromedriver");

            return new ChromeDriver();
        }

        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/sumeyyecetintas/Documents/selenium dependencies/drivers/geckodriver");
            return new FirefoxDriver();
        }
        else
        return null;

    }
}

