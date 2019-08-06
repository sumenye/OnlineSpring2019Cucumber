package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EbaySearchTest {
    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) {
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        test1();
        driver.close();
    }


    public static void test1(){
        WebElement searchItem = driver.findElement(By.id("gh-ac"));
        searchItem.sendKeys("wooden spoon");
        driver.findElement(By.id("gh-btn")).click();
        WebElement results = driver.findElement(By.className("srp-controls__count-heading"));
        String str1= results.getText();
        String justNumbers= str1.replaceAll("[^0-9]", "");
        int x1 = Integer.parseInt(justNumbers);
        driver.findElement(By.xpath("//*[@id=\"w3\"]/li[1]/ul/li[1]/ul/li/a/span")).click();
        WebElement allResults = driver.findElement(By.className("srp-controls__count-heading"));
        String str2 =allResults.getText();
        String justNumbers2= str2.replaceAll("[^0-9]", "");
        int x2 = Integer.parseInt(justNumbers2);
        if(x2>x1) {
            System.out.println("Passed! " + x2+" is greater than "+x1);
        }else {
            System.out.println("Failed! ");
        }
        driver.navigate().back();
        driver.navigate().back();
        if(driver.findElement(By.id("gh-ac")).getAttribute("placeholder").equals("Search for anything")) {
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!"+driver.findElement(By.id("gh-ac")).getAttribute("value"));
        }
    }


}