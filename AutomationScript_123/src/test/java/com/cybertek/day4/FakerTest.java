package com.cybertek.day4;
import com.github.javafaker.Faker;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.safari.SafariDriver;

public class FakerTest {

    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://practice.cybertekschool.com");

        Faker faker = new Faker();
        String fact = faker.chuckNorris().fact();
        System.out.println(fact);
        System.out.println(faker.artist().name());
    }
}