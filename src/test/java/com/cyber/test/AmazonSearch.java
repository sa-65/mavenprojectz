package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();

        String searchTerm="charger";
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("charger"+ Keys.ENTER);

        //#1
       // String actual=driver.findElement(By.id("twotabsearchtextbox")).getText();
        //#2
        String actual=driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
        //#3
       // String actual=driver.findElement(By.id("twotabsearchtextbox")).getAttribute("innerHTML");

        if(actual.equals(searchTerm)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actual = " + actual);
            System.out.println("expected = " + searchTerm);

        }



    }
}
