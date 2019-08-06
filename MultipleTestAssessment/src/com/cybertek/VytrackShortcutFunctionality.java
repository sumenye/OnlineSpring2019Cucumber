package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
public class VytrackShortcutFunctionality {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/");
        test();
        driver.close();
    }
    public static void test() {
        WebElement userName = driver.findElement(By.name("_username"));
        WebElement password = driver.findElement(By.name("_password"));
        WebElement loginButton = driver.findElement(By.name("_submit"));
        userName.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        loginButton.click();
        SeleniumUtils.waitPlease(2);
        String title1 = driver.getTitle();
        if (title1.equals("Dashboard")) {
            System.out.println("Passed! Dashboard page is open!");
        } else {
            System.out.println("Failed!");
        }
        WebElement shortCutIcon = driver.findElement(By.xpath(".//a/i[@class='fa-share-square']"));
        SeleniumUtils.waitPlease(2);
        shortCutIcon.click();
        driver.findElement(By.linkText("See full list")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.linkText("Opportunities")).click();
        SeleniumUtils.waitPlease(3);
        if(driver.getTitle().contains("Open Opportunities")){
            System.out.println("Passed! Open opportunities is open!");
        }else{
            System.out.println("Failed!");
        }
        SeleniumUtils.waitPlease(2);
        shortCutIcon.click();
        SeleniumUtils.waitPlease(2);
        WebElement shortCutAction = driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/input"));
        SeleniumUtils.waitPlease(2);
        shortCutAction.sendKeys("V");
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/ul/li[6]")).click();
        SeleniumUtils.waitPlease(2);
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div"));
        if(errorMsg.getText().equals("You do not have permission to perform this action.")){
            System.out.println("Passed the Error Message!");
        }else{
            System.out.println("Failed!");
        }
        if(driver.getTitle().contains("Open Opportunities")){
            System.out.println("Passed! Open opportunities is still open!");
        }else{
            System.out.println("Failed!");
        }
    }
}