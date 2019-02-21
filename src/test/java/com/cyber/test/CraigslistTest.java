package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CraigslistTest {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();


        driver.get("https://washingtondc.craigslist.org/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //driver.findElement(By.id("query")).sendKeys("corolla");
        //driver.findElement(By.linkText("electronics"));
        driver.findElement(By.partialLinkText("+garden")).click();



    }
}
