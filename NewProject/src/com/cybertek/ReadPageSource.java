package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPageSource {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyyecetintas/Documents/selenium dependencies/drivers/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().fullscreen();
    driver.get("http://practice.cybertekschool.com");
    String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.close();

    }
}
