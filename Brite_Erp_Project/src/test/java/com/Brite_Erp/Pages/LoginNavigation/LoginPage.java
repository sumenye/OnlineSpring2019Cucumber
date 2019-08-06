package com.Brite_Erp.Pages.LoginNavigation;

import com.Brite_Erp.Utilities.ConfigurationReader;
import com.Brite_Erp.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
     private WebDriver driver = Driver.getDriver();
    private  WebDriverWait wait = new WebDriverWait(driver,5);

    public LoginPage(WebDriver driver){
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath="//*[@id='login']")
    public WebElement userInput;

    @FindBy(xpath="//*[@id='password']")
    public WebElement passwordInput;

    @FindBy(css=".btn.btn-primary")
    public WebElement loginButton;



}
