package com.cybertek;
import org.openqa.selenium.WebDriver;


public class TestingBrowserFactory {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("firefox");

        driver.get("http://practice.cybertekschool.com");
    }
}

