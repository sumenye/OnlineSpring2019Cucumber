package VyTrack_FirstPackage.pages.Login_Navigation;

import VyTrack_FirstPackage.utilities.Driver;
import VyTrack_FirstPackage.utilities.VYTrackUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver = Driver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver,5);

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="prependedInput")
    public WebElement userNameElement;

    @FindBy(id="prependedInput2")
    public WebElement passwordElement;

    @FindBy(id="_submit")
    public WebElement loginButton;


    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;

    @FindBy(tagName = "h2")
    public WebElement titleElement;

    @FindBy(css = "[class='alert alert-error'] > div")
    public WebElement errorMessageElement;

    @FindBy(css = " span[class='custom-checkbox__icon']")
    public WebElement rememberMeElement;

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }

    public void clickRememberMe(){
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
        if(!rememberMeElement.isSelected()){
            rememberMeElement.click();
        }
    }

    public void login(String username,String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButton.click();

    }



}
