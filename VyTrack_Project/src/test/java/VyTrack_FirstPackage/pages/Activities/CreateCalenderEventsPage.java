package VyTrack_FirstPackage.pages.Activities;

import VyTrack_FirstPackage.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalenderEventsPage {

    private WebDriver driver = Driver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver,5);

    public CreateCalenderEventsPage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1' and contains(text(),'Activities')]")
    public WebElement activitiesElmnt;


    @FindBy(xpath = "//span[@class='title title-level-2' and contains(text(),'Calendar Events')]")
    public WebElement calenderEventsElmnt;

    @FindBy(xpath= "//div/a[@href='/calendar/event/create' and contains(text(),'Create Calendar event')] ")
    public WebElement createCalenderEventBtn;



    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDateInput;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDateInput;

    @FindBy(xpath = "//button[contains(text(),'Today')]")
    public WebElement todayButton;


    @FindBy(css = "#tinymce>p")
    public WebElement descriptionInput;

    @FindBy(xpath = "//input[@type='text' and @data-name='field__title']")
    public WebElement titleInput;

    @FindBy(css = ".oro-dropdown-mask")
    public WebElement startTimeElement;


    @FindBy(xpath = "//input[@id='time_selector_oro_calendar_event_form_end-uid-5d3e73f21fb50']")
    public WebElement endTimeElement;

}
