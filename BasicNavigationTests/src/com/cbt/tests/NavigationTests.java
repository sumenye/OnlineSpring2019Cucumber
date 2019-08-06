package com.cbt.tests;

import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import com.cbt.utilities.BrowserFactory1;

public class NavigationTests {

    public static void main(String[] args)  {

        NavigationTests.testSafari();
       // NavigationTests.testChrome();
       // NavigationTests.testFirefox();
    }

    private static void testFirefox() {
        WebDriver driver3 = BrowserFactory1.getDriver("firefox");
        driver3.get("http://www.google.com");
        //  Thread.sleep(2000);
        String title1=  driver3.getTitle();
        driver3.navigate().to("http://etsy.com");
        // Thread.sleep(2000);
        String title2=  driver3.getTitle();
        driver3.navigate().back();
        System.out.println( StringUtility.verifyEquals(title1,title2));
        driver3.close();
    }

    private static void testChrome() {
        WebDriver driver2 = BrowserFactory1.getDriver("chrome");
        driver2.get("http://www.google.com");
        // Thread.sleep(2000);
        String title1=  driver2.getTitle();
        driver2.navigate().to("http://etsy.com");
        // Thread.sleep(2000);
        String title2=  driver2.getTitle();
        driver2.navigate().back();
        System.out.println( StringUtility.verifyEquals(title1,title2));
        driver2.close();
    }

    private static void testSafari() {
        WebDriver driver2 = BrowserFactory1.getDriver("safari");
        driver2.get("http://www.google.com");
        // Thread.sleep(2000);
        String title1=  driver2.getTitle();
        driver2.navigate().to("http://etsy.com");
        // Thread.sleep(2000);
        String title2=  driver2.getTitle();
        driver2.navigate().back();
        System.out.println( StringUtility.verifyEquals(title1,title2));
        driver2.close();
    }


}
