package com.Brite_Erp.Pages.CRM;

import com.Brite_Erp.Utilities.BriteUtils;
import com.Brite_Erp.Utilities.Driver;
import com.Brite_Erp.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CRMPage {
    private WebDriver driver = Driver.getDriver();

//    @FindBy(css = "table[class^='o_list_view table table-condensed']")
//    public WebElement listTable;
//    @FindBy(css = "table[class^='o_list_view table table-condensed']>tbody>tr")
//    public WebElement firstOptionOfTable;
//    @FindBy(xpath = "//button[contains(text(),'Action')]")
//    public WebElement actionButtonLOcator;
//    @FindBy(css = "div[class='modal-footer']>button>span")
//    public WebElement okButtonLocator;
//    @FindBy(xpath = "//ol[@class='breadcrumb']//a[contains(text(),'Pipeline')]")
//    public WebElement pageNameLocator;
//    @FindBy(xpath = "//li[@class='active']//span[@class='oe_menu_text'][contains(text(),'Pipeline')]")
//    public WebElement pipelinePage;

//    @FindBy(css = "button[accesskey='c']")
//    public WebElement createButtonLocator;
//    @FindBy(css = "input[name='name']")
//    public WebElement inputOpportunityTitleLocator;
//    @FindBy(xpath = "//div[@class='o_input_dropdown']//input")
//    public WebElement inputCustomerLocator;

  String createCusromerLocator="//footer/button[@class='btn btn-sm btn-primary']/span[text()='Create']";
String lastCreateButton="//footer//span[text()='Create']";



    @FindBy(css = "div[class='btn-group btn-group-sm o_cp_switch_buttons']>button[accesskey='l']")
    public WebElement listIconLocator;

    @FindBy(css = "[aria-label='pivot']")
    public WebElement pivotButtonLocator;

    //tbody>tr:nth-of-type(1)>td:nth-of-type(1)

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement totalButtonLocator1;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement totalButtonLocator2;



    @FindBy(css = "ul>li:nth-of-type(25)>a")
    public WebElement opportunityLocator;

    @FindBy(xpath = "//tr[3]/td[2]")
    public WebElement secondRawLocator;



    @FindBy(xpath = "//table//tr[2]/td[9]")
    public WebElement secondRawLocatorInList;

// @FindBy(css = "tbody>tr:nth-of-type(1)>td:nth-of-type(3)")
// public WebElement numberOfRowsElement;
@FindBy(css = "table>tbody>tr>td:nth-of-type(2)")
public List<WebElement> expectedValueLocatorFromTable;


    public CRMPage(){
    PageFactory.initElements(Driver.getDriver(), this);

}

    public void selectAction(String actionName) {
        String optionLocator = "//a[contains(@data-section,'other') and contains(text(),'" + actionName + "')]";
        BriteUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath(optionLocator)), 5);
        Driver.getDriver().findElement(By.xpath(optionLocator)).click();
    }

    public void verifyThatOpportunityDeleted(String opportunity) {
        String locator = "//td[text()='" + opportunity + "']";
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath(locator));
        Assert.assertTrue(elements.isEmpty());
    }

    public void createOptionPreCondition(){
        for(int i=0;i<3;i++){
        driver.findElement(By.cssSelector("button[accesskey='c']")).click();
            SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Person"+ ++i);
            SeleniumUtils.waitPlease(2);
//        driver.findElement(By.xpath("//div[@class='o_input_dropdown']//input")).sendKeys("Customer"+i+1);
//            SeleniumUtils.waitPlease(2);
            driver.findElement(By.cssSelector("input[name='planned_revenue']")).clear();
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.cssSelector("input[name='planned_revenue']")).sendKeys("150");
            SeleniumUtils.waitPlease(2);
//            driver.findElement(By.cssSelector("#ui-id-54>a")).click();
//            SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(createCusromerLocator)).click();
            SeleniumUtils.waitPlease(2);
//         driver.findElement(By.xpath(lastCreateButton)).click();
//            SeleniumUtils.waitPlease(2);
            --i;
            }

    }

//    public double calculateTotalRevenue() {
//        int oppCount = driver.findElements(By.xpath("//tbody/tr[2]")).size()-1;
//        double sum=0.0;
//        List<WebElement> rowLocators=new ArrayList<>();
//
//        for (int i = 0; i < oppCount; i++) {
//            rowLocators = driver.findElements(By.cssSelector("tbody>tr:nth-of-type(" + (i + 2) + ")>td:nth-of-type(2)"));
//        }
//        for(int i=0;i<rowLocators.size();i++){
//            sum+=Double.parseDouble(rowLocators.get(i).getText().replaceAll("\\D+",""));
//        }
//        return sum;
//    }

   public double sumOfElements(List<String> list){
       double sum=0;
       for(int i=1; i<list.size();i++){
           String nums =list.get(i).replaceAll("\\D+","");
           sum += Double.parseDouble(nums);
       }
       return sum;
    }
}