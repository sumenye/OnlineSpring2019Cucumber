package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class GoogleResults {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        driver.manage().window().fullscreen();
        driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
        for(String each: searchStrs) {
            test1(each);
        }
        driver.close();
        }


        public static void test1(String str){
        WebElement searchbox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchbox.sendKeys(str, Keys.ENTER);
       // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement searchresult = driver.findElement(By.className("iUh30"));
        String  expectedUrl = searchresult.getText();
        searchresult.click();
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl)){
            System.out.println("PASSED");
            System.out.println("Actual url: "+actualUrl);
            System.out.println("Expected url: "+expectedUrl);}
            else{
            System.out.println("FAILED");
            System.out.println("Actual url: "+actualUrl);
            System.out.println("Expected url: "+expectedUrl);}
            driver.navigate().back();
            driver.navigate().back();


        }}




