package com.Brite_Erp.Tests.components.LoginNavigation;

import com.Brite_Erp.Pages.LoginNavigation.LoginPage;
import com.Brite_Erp.Utilities.ConfigurationReader;
import com.Brite_Erp.Utilities.Driver;
import com.Brite_Erp.Utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTest1() {

        LoginPage loginPage = new LoginPage(Driver.getDriver());
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.userInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        String loginExpectedMessage = "Congratulations, your inbox is empty";
        String successfulLoginLocator = "o_thread_title";   //classname
        Assert.assertEquals(loginExpectedMessage,Driver.getDriver().findElement(By.className(successfulLoginLocator)));
    }

}
