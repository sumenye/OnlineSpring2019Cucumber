package VyTrack_FirstPackage.tests.components.activities;

import VyTrack_FirstPackage.pages.Activities.CreateCalenderEventsPage;
import VyTrack_FirstPackage.pages.Login_Navigation.LoginPage;
import VyTrack_FirstPackage.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Date;

public class CreateCalenderEventsTest extends TestBase {

    @Test
    public void dateTimeEndDateAutoAdjust1(){
        LoginPage loginPage = new LoginPage();
        CreateCalenderEventsPage createCalender = new CreateCalenderEventsPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);
        VYTrackUtils.waitUntilLoaderScreenDisappear();
        VYTrackUtils.navigateToModule("Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear();
        createCalender.createCalenderEventBtn.click();
        createCalender.startDateInput.clear();
//      LocalDate localDate = LocalDate.of(2017, 06, 22);
//      localDate.plusMonths(1);
        createCalender.startDateInput.sendKeys("Jul 29, 2020", Keys.ENTER);
        SeleniumUtils.waitPlease(5);
        createCalender.titleInput.sendKeys("hello");
        String actual = createCalender.endDateInput.getText();
        SeleniumUtils.waitPlease(5);
        Assert.assertEquals(actual,createCalender.startDateInput.getText());
        SeleniumUtils.waitPlease(2);
        createCalender.todayButton.click();
        Assert.assertEquals(actual,"Jul 29, 2020");
    }
    @Test
    public void dateTimeEndDateAutoAdjust2() {
        LoginPage loginPage = new LoginPage();
        CreateCalenderEventsPage createCalender = new CreateCalenderEventsPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);
        VYTrackUtils.waitUntilLoaderScreenDisappear();
        VYTrackUtils.navigateToModule("Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear();
        createCalender.createCalenderEventBtn.click();

    }

}
