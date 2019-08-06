package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class BrowserFactory {

    public	static WebDriver getDriver(String str) {
        if (str.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/sumeyyecetintas/Documents/selenium dependencies/drivers/chromedriver");
            return new ChromeDriver();
        }
        else if (str.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/sumeyyecetintas/Documents/selenium dependencies/drivers/geckodriver");
            return new FirefoxDriver();
        }
        else  if (str.equals("safari")) {

            return new SafariDriver();
        }

        else if (str.equals("edge")) {
            return null;
        }
        else
            return null;
    }

}