package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ReallyCheckboxes {
    public static void main(String[] args) {

        /*go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
        verify monday is not selected
        select monday
        verify monday is selected
        unselect monday*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        driver.manage().window().maximize();

        WebElement monday=driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));

        monday.click();
        System.out.println(monday.isSelected());
        monday.click();
        System.out.println(monday.isSelected());
        monday.click();
        System.out.println(monday.isSelected());

        if(!monday.isSelected()){
            monday.click();
        }else{
            System.out.println("Monday is Already Selected");
        }



    }
}
