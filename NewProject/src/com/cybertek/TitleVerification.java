package com.cybertek;

import java.util.*;
import org.openqa.selenium.WebDriver;


public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        List<String> titles = new ArrayList<>(); // list where I am gonna store titles
        List<String> actualUrls = new ArrayList<>(); // list where I am gonna store page urls
        for(String url: urls){
            driver.get(url);
            try {
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            titles.add(driver.getTitle()); // I am adding page title into list, for every website
            actualUrls.add(driver.getCurrentUrl());
        }
        String expectedTitle = "Practice";
        for(String title:titles){
            if(title.equals(expectedTitle)){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
                System.out.println("Expected title: "+expectedTitle);
                System.out.println("Actual title: "+title);
            }
        }
        driver.close();
    }
}

