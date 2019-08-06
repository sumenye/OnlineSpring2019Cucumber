package VyTrack_FirstPackage.tests.components.login_navigation;

import VyTrack_FirstPackage.pages.Login_Navigation.LoginPage;
import VyTrack_FirstPackage.utilities.ConfigurationReader;
import VyTrack_FirstPackage.utilities.SeleniumUtils;
import VyTrack_FirstPackage.utilities.TestBase;
import VyTrack_FirstPackage.utilities.VYTrackUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginTest1(){
        //this is required , otherwise you will get null pointer exception
        extentLogger = report.createTest("Login as a store manager");
        //we are instantiating page class inside the tests'
        //because for second test, if we run all tests in a row, driver will have null session
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        extentLogger.info("Clickking remember me button");
        loginPage.clickRememberMe();
        loginPage.login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(VYTrackUtils.getPageSubTitle(), "Dash");
        extentLogger.pass("verified that page name is Dashboard");
    }
    @Test
    public void negativeLoginTest1(){
        extentLogger = report.createTest("Login with invalid credentials");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Logging with wrong username: wrongusername, wrongpassword");
        loginPage.login("wrongusername", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid user name or password.");
        SeleniumUtils.waitPlease(3);
        extentLogger.pass("verified that warning message displayed");
    }

}
