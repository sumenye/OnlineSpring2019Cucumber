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

public class CRMFisrtHomeWork {
    //crmuser=eventscrmmanager50@info.com
    //crmpassword=eventscrmmanager
    //crmurl=http://34.220.250.213/web/login
    /*User Story :
    As a user, when I already created an opportunity in CRM module of Bribe ERP application,
    I want to be able to delete it.Acceptance Criteria :
    1.Verify that user should be able to see the list view.
    2.Verify that user should be able to delete the opportunity from action drop down list .* */

    WebDriver driver;

    String crmModuleLocator = "//span[contains(text(),'CRM')][@class='oe_menu_text']";
    String listLocator ="//button[@aria-label='list']";
    String tableVerufyingLocator="//table//thead/tr/th";
    String newElementLocator="//span[contains(text(),'New')]";
    //String checkboxLocator=" (//td[@class='o_data_cell o_readonly_modifier'])[1]";
    String checkBoxReal="//tbody/tr[1]/td/div/input";
    String actionLocator = " //button[contains(text(),'Action')]";
    String deleteLocator = " //a[@href='#'][contains(text(),'Delete')]";
    String okButtonLocator="//span[contains(text(),'Ok')]";
    String numberLocator="//span[@class='o_pager_limit']";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/web/login");
    }
    @Test
    public void verifyToSeeView(){
        BriteUtils.login(driver,"eventscrmmanager50@info.com","eventscrmmanager");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(crmModuleLocator)).click();
        SeleniumUtils.waitPlease(3);
        //will verify if the new element is visible
        Assert.assertTrue(driver.findElement(By.xpath(newElementLocator)).isDisplayed());
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(listLocator)).click();
        SeleniumUtils.waitPlease(5);
        Assert.assertTrue(driver.findElement(By.xpath(tableVerufyingLocator)).isDisplayed());
    }

    @Test
    public void verifyToDeleteOppotunity(){
        BriteUtils.login(driver,"eventscrmmanager50@info.com","eventscrmmanager");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(crmModuleLocator)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(listLocator)).click();
        SeleniumUtils.waitPlease(5);
        int countFirst= Integer.parseInt(driver.findElement(By.xpath(numberLocator)).getText());
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(checkBoxReal)).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(actionLocator)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(deleteLocator)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(okButtonLocator)).click();
        SeleniumUtils.waitPlease(3);
        int countLast= Integer.parseInt(driver.findElement(By.xpath(numberLocator)).getText());
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(countFirst>countLast);

    }


    @AfterMethod
    public void close(){
        driver.quit();

    }

}
