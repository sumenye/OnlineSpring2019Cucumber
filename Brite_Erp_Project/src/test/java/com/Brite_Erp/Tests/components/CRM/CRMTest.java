package com.Brite_Erp.Tests.components.CRM;

import com.Brite_Erp.Pages.CRM.CRMPage;
import com.Brite_Erp.Pages.LoginNavigation.LoginPage;
import com.Brite_Erp.Utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CRMTest extends TestBase {
    //The system should display the correct information for each opportunity on the view list page and the pivot table.



@Test
public void verifyOpportunityValue(){
    LoginPage loginPage = new LoginPage(Driver.getDriver());
    String username = ConfigurationReader.getProperty("username");
    String password = ConfigurationReader.getProperty("password");
    loginPage.userInput.sendKeys(username);
    loginPage.passwordInput.sendKeys(password);
    loginPage.loginButton.click();

    BriteUtils.navigateToModule(Driver.getDriver(),"CRM");
    CRMPage crmPage = new CRMPage();
  //  crmPage.createOptionPreCondition();
    SeleniumUtils.waitPlease(3);
    crmPage.listIconLocator.click();
    SeleniumUtils.waitPlease(3);
    String secondValueInList=crmPage.secondRawLocatorInList.getText();
    SeleniumUtils.waitPlease(3);
    crmPage.pivotButtonLocator.click();
    SeleniumUtils.waitPlease(3);
    crmPage.totalButtonLocator1.click();
    SeleniumUtils.waitPlease(3);
    crmPage.totalButtonLocator2.click();
    SeleniumUtils.waitPlease(3);
    crmPage.opportunityLocator.click();
    SeleniumUtils.waitPlease(3);
    String secondRowValue=crmPage.secondRawLocator.getText();
    SeleniumUtils.waitPlease(3);

    Assert.assertEquals(secondRowValue,secondValueInList);
}

    @Test
    public void verifyTotalValue() {
        LoginPage loginPage = new LoginPage(Driver.getDriver());
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.userInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
//navigating to module CRM
        BriteUtils.navigateToModule(Driver.getDriver(), "CRM");
        CRMPage crmPage = new CRMPage();
//preconditions
        crmPage.createOptionPreCondition();
        SeleniumUtils.waitPlease(3);
        crmPage.pivotButtonLocator.click();
        SeleniumUtils.waitPlease(3);
        crmPage.totalButtonLocator1.click();
        SeleniumUtils.waitPlease(3);
        crmPage.totalButtonLocator2.click();
        SeleniumUtils.waitPlease(3);
        crmPage.opportunityLocator.click();
        SeleniumUtils.waitPlease(3);
//store the value from total box
        double sumInPivotBoard=Double.parseDouble(driver.findElement(By.cssSelector("tbody>tr:nth-of-type(1)>td:nth-of-type(2)")).getText().replaceAll("\\D+",""));
        System.out.println(sumInPivotBoard);
        SeleniumUtils.waitPlease(3);
//store all values from the table and find the sum
        List<String> list = BriteUtils.getElementsText(crmPage.expectedValueLocatorFromTable);
        SeleniumUtils.waitPlease(3);
       double calculated= crmPage.sumOfElements(list);
        System.out.println(calculated);
        SeleniumUtils.waitPlease(5);

       Assert.assertEquals(sumInPivotBoard,calculated);
    }
}
