package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitEmail {
    public static void main(String[] args) throws InterruptedException {

        /*go to https://the-internet.herokuapp.com/forgot_password
    verify enter email and submit
    verify email sent message on the next page*/



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");
        WebElement input=driver.findElement(By.id("email"));

        //#1
        //input.sendKeys("someemail@someemail.com"+ Keys.ENTER);

        //#2
        //input.sendKeys("someemail@someemail.com"+ Keys.BACK_SPACE);

        //#3
        input.sendKeys("someemail@someemail.com");
        input.submit();

        String expected="Your e-mail's been sent!";
        String actual=driver.findElement(By.id("content")).getText();
        System.out.println(actual);


        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actual = " + actual);
            System.out.println("expected = " + expected);
        }






    }
}
