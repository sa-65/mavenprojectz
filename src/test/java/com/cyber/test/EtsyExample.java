package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class  EtsyExample {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();
        WebElement input =driver.findElement(By.id("search-query"));
        input.sendKeys("baby");
        WebElement submit=driver.findElement(By.xpath("//button[@value='Search']"));
        submit.click();


    }
}
