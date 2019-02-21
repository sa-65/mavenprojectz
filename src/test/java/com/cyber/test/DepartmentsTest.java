package com.cyber.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
1. open browser
2.go to https://amazon.com
3.verify that default dropdown option is all
4.verify that all options are sorted alphabetically
5.Click on the menu icon on the left
6.click on Full Store directory
7.capture all of the main department names in the page.
8.verify that departments names are sorted alphabetically
9.verify that all departments names are listed in the dropdown from step 4
 */

public class DepartmentsTest {
    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }


    @Test(priority = 0)
    public void testDefaultValue() {
        //FINDING ELEMENT WITH A SELECT TAG
        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));

        //CREATE A SELECT OBJECT
        allDepartments = new Select(selectElement);
       // select.selectByIndex(0);

        //GET THE CURRENT SELECTED OPTION
        String selectedOption = allDepartments.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "All Departments");

    }

    @Test(priority = 1)
    public void sortAlphabetically() {
    //using compareTo() method. we will compare each element in the list to the next one
        for (int i = 0; i < allDepartments.getOptions().size()-1 ; i++) {

        String current = allDepartments.getOptions().get(i).getText();
        String next = allDepartments.getOptions().get(i+1).getText();

            System.out.println("comparing: "+current+" with "+next);
                Assert.assertTrue(current.compareTo(next)<=0);

        }

    }

    //5.Click on the menu icon on the left
    //6.click on Full Store directory
    //7.capture all of the main department names in the page.

    @Test
    public void mainDepartmentsTest() throws InterruptedException {
        //5.Click on the menu icon on the left
        driver.findElement(By.cssSelector("i.hm-icon.nav-sprite")).click();

        Thread.sleep(2000);//we need to menu upload

        //6.click on Full Store directory
        driver.findElement(By.cssSelector("a[href='/gp/site-directory?ref_=nav_em_T1_0_2_2_33__fullstore']")).click();

        //7.capture all of the main department names in the page.
        List<WebElement> mainDepts=driver.findElements(By.cssSelector("h2.fsdDeptTitle"));

        for(WebElement option:mainDepts){
            System.out.println(option.getText());
        }

    }

    //8.verify that departments names are sorted alphabetically
    @Test
    public void sortAlphabetically2() {

        List<WebElement> mainDepts=driver.findElements(By.cssSelector("h2.fsdDeptTitle"));



        for (int i = 0; i < mainDepts.size()-1 ; i++) {
            String current2 = mainDepts.get(i).getText();
            String next2 = mainDepts.get(i+1).getText();

            System.out.println("comparing: "+current2+" with "+next2);
            Assert.assertTrue(current2.compareTo(next2)<=0);

        }

    }





}




