package com.Brite_Erp.Tests;

import com.Brite_Erp.Utilities.BriteUtils;
import com.Brite_Erp.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase09 {
    //As an expense manager,I should not be able to send message to attendees.

    WebDriver driver;
    String eventsModuleXPath="//*[@id='oe_main_menu_navbar']/div[2]/ul[1]/li[6]/a/span";
    String firstEventXPath="/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]";
    String sendMessage = "//*[contains(text(),'Send message')]";
    String messageinput="//textarea[@placeholder='Write something...']";
    String input="Dear Attendees, Please be sure you saved the event to your calendar...";
    String sendButton="//button[@tabindex=\"3\" and contains(text(),'Send')]";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/web/login");
    }
    @Test
    public void test(){
        BriteUtils.login(driver,"expensesmanager74@info.com","expensesmanager");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(eventsModuleXPath)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(firstEventXPath)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(sendMessage)).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(messageinput)).sendKeys(input);
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(sendButton)).click();
        SeleniumUtils.waitPlease(5);
        String actualPopup=driver.findElement(By.xpath("//*[@class='o_dialog_warning modal-body']")).getText();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//button/span[contains(text(),'Ok')]")).click();
        String expectedPopupPartial="Sorry, you are not allowed to modify this document.";
        System.out.println(actualPopup);

        Assert.assertTrue(actualPopup.contains(expectedPopupPartial));
    }

    @AfterMethod
    public void close(){
        driver.quit();

    }
}
