package com.cyber.test;

/*
* */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeDemo {

    @Test
    public  void test() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");

        //locate iframe
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
        //switch to iframe
        driver.switchTo().frame(iframe);

        WebElement text=driver.findElement(By.tagName("body"));
        text.clear();
        text.sendKeys("fdhdsshhjsdhh");

        driver.switchTo().parentFrame();

        //Elemental Selenium
        driver.findElement(By.linkText("Elemental Selenium")).click();


    }
    @Test
    public void setFrame() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebElement frame1 = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(frame1);

//        WebElement frame2 = driver.findElement(By.name("frame_left"));
//        driver.switchTo().frame(frame2);
//       // WebElement left = driver.findElement(By.)
//
//        WebElement frame3 = driver.findElement(By.name("frame_right"));
//        driver.switchTo().frame(frame3);
//
//        WebElement frame4 = driver.findElement(By.name("frame_middle"));
//        driver.switchTo().frame(frame4);
    }
}
