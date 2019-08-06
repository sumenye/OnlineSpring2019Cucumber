package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class VytrackTitleTest {

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

        userName.sendKeys("user10");
        password.sendKeys("UserUser123");
        loginButton.click();
        WebElement nameOnTopRight = driver.findElement(By.className("dropdown-toggle"));
        String str = nameOnTopRight.getText();
        driver.findElement(By.className("fa-caret-down")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.linkText("My Configuration")).click();
        SeleniumUtils.waitPlease(2);
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(str);
        if (title.startsWith(str)) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }

}