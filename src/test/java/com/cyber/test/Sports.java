package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sports {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        driver.manage().window().maximize();

        WebElement footBall=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));
        System.out.println("Football is selected "+footBall.isSelected());

        WebElement soccer=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        System.out.println("Soccer is selected "+soccer.isSelected());

        WebElement baseBall=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input"));
        System.out.println("Baseball is selected: "+baseBall.isSelected());

        WebElement basketBall=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input"));
        System.out.println("Basketball is selected: "+basketBall.isSelected());

        WebElement hockey=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input"));
        System.out.println("Hockey selected: "+hockey.isSelected());

        WebElement waterPolo=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input"));
        System.out.println("WaterPolo selected: "+waterPolo.isSelected());

        Random random = new Random();
        int rand = random.nextInt(6);
        List<WebElement> randomSport = new ArrayList<WebElement>();
        randomSport.add(baseBall);
        randomSport.add(basketBall);
        randomSport.add(footBall);
        randomSport.add(hockey);
        randomSport.add(soccer);
        randomSport.add(waterPolo);

        randomSport.get(rand).click();

        System.out.println("=================================");

        WebElement football2 = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));
        System.out.println("Football is selected: " + football2.isSelected());

        WebElement baseball2 = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input"));
        System.out.println("Baseball is selected: " + baseball2.isSelected());

        WebElement basketball2 = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input"));
        System.out.println("Basketball is selected: " + basketball2.isSelected());

        WebElement hockey2 = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input"));
        System.out.println("Hockey is selected: " + hockey2.isSelected());

        WebElement soccer2 = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        System.out.println("Soccer is selected: " + soccer2.isSelected());

        WebElement waterPolo2 = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input"));
        System.out.println("Water Polo is selected: " + waterPolo2.isSelected());




    }
}
