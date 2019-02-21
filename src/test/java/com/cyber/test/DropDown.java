package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        //1-We have to locate an element with tag select
        WebElement selectElement=driver.findElement(By.id("dropdown"));

        //2-Create a select object using webelement
        Select list= new Select(selectElement);



        //3-Get the selected option
        String selectedOption= list.getFirstSelectedOption().getText();
        System.out.println(selectedOption);

        //4-Print all available options
        List<WebElement> options=list.getOptions();
        System.out.println("options.size() = "+options.size());


        for(WebElement option:options){
            System.out.println(option.getText());
        }

        //5-Select different option
            //1.by visible text
//        list.selectByVisibleText("Option 1");
//        System.out.println("Selected option "+
//                list.getFirstSelectedOption().getText());
//        Thread.sleep(3000);

            //2.by  index
        list.selectByIndex(2);
        System.out.println("Selected option "+
                list.getFirstSelectedOption().getText());
//
//            //3.by value attribute
//        list.selectByValue("1");
//        System.out.println("Selected option "+
//                list.getFirstSelectedOption().getText());



    }
}
