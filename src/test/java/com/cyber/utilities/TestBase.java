package com.cyber.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import static org.junit.Assert.*;



import java.util.concurrent.TimeUnit;

    public abstract class TestBase {
    protected Actions actions;
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Faker faker;

    @BeforeMethod
    public void setUpClass(){
        driver = Driver.getDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS    );
        softAssert=new SoftAssert();
        actions=new Actions(driver);
        faker=new Faker();
    }



    @AfterMethod
    public void tearDownMethod(){
       // Driver.closeDriver();
        softAssert.assertAll();

    }
}
