package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtons {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        driver.manage().window().maximize();

        //verify blue and red not checked

        // verify blue and red not checked
        WebElement blue=driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red=driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));
        System.out.println("DEFAULT");
        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());
        // check blue
        System.out.println("Clicking on blue");
        blue.click();
        Thread.sleep(3000);
        // verify blue checked, red not checked
        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());
        // check red
        System.out.println("Clicking red");
        red.click();
        Thread.sleep(3000);
        // verify blue not checked, red is checked
        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());


    }
}
