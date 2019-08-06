package com.Brite_Erp.Tests;

import com.Brite_Erp.Utilities.BriteUtils;
import com.Brite_Erp.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase18 {
    //User should be able to add attendee to an event.

    WebDriver driver;
    String eventsModuleXPath="//*[@id='oe_main_menu_navbar']/div[2]/ul[1]/li[6]/a/span";
    String firstEventXPath="/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]";
    String attendeeXpath = "//button[@class='btn btn-sm oe_stat_button']";
    String createButtonLocator = "//button[contains(text(),'Create')]";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/web/login");
    }

    @Test
    public void test17(){
        BriteUtils.login(driver,"expensesmanager74@info.com","expensesmanager");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(eventsModuleXPath)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(firstEventXPath)).click();
        String attendeeCount = driver.findElement(By.xpath("//span[@class='o_stat_value']")).getText();
        SeleniumUtils.waitPlease(3);
        if(attendeeCount.equals("0")){
            driver.findElement(By.xpath(attendeeXpath)).click();
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.xpath(createButtonLocator)).click();
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.xpath("//input[@class='o_field_char o_field_widget o_input' and @name='name']")).sendKeys("Sumeyye");
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.xpath("//button[contains(text(),'Save') and @accesskey='s']")).click();
            SeleniumUtils.waitPlease(3);

        }else{
            driver.findElement(By.xpath(attendeeXpath)).click();
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.xpath("//input[@class='o_field_char o_field_widget o_input' and @name='name']")).sendKeys("Okan");
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.xpath("//button[contains(text(),'Save') and @accesskey='s']")).click();
            SeleniumUtils.waitPlease(3);
        }



    }

    @AfterMethod
    public void close(){
        driver.quit();

    }
}
