package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class MixedAnnatation {

    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        System.out.println("ASetting up the drivers here");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Opening a browser");
        driver=new ChromeDriver();
        System.out.println("go to webside and login");


        driver.get("https://www.google.com/");

    }

    @Test
    public void testOne() {
        System.out.println("Testing test testing account info");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("log out");
        System.out.println("closing browser");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("report everything");
    }
    @Test
    public void testTwo(){
        System.out.println("Testing testing payment");
    }

}
