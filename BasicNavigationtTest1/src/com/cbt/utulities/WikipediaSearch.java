package com.cbt.utulities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaSearch {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup(); //Set system properties.

        WebDriver driver = new ChromeDriver();//open browser.

        driver.navigate().to("https://www.wikipedia.org/");

        WebElement searchField = driver.findElement(By.id("searchInput"));

        searchField.sendKeys("selenium webdriver");

        library.sleep(2);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button"));

        searchButton.click();

        WebElement searchItem = driver.findElement(By.linkText("Selenium (software)"));

        searchItem.click();

        String titleE= driver.getCurrentUrl();

        if (titleE.endsWith("x")) {
            System.out.print("Passed");
        } else
            System.out.print("Failed");


        driver.quit();
    }
