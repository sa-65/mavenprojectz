package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class JSAAllerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        //driver.close();
    }


    @Test
    public void oppsTest() throws InterruptedException {

        driver.get("https://sweetalert.js.org/");
        Thread.sleep(5000);

        //trigger the pop up
        driver.findElement(By.xpath("(//button[@class='preview'])[1]")).click();
        Thread.sleep(5000);

        //switch to alert
        Alert alert = driver.switchTo().alert();
        alert.accept();//clicking the ok on the pop up

    }



    @Test

    public void dismiss() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(1500);
        Alert alert=driver.switchTo().alert();
        alert.dismiss();//clicking cancel on a pop up
    }


    @Test
    public void alertText() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);

        Alert alert= driver.switchTo().alert();
        alert.sendKeys("Hello");//typing on the alert
        alert.accept();

    }


}
