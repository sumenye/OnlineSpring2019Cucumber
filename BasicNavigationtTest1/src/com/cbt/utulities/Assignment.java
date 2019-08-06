package com.cbt.utulities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void test(){
        WebElement blueBtn  = driver.findElement(By.id("blue"));
        WebElement blackBtn = driver.findElement(By.id("black"));
        if(blueBtn.isSelected())
            blackBtn.click();
        if(blackBtn.isEnabled() && (!blueBtn.isEnabled()))
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
    }
}
