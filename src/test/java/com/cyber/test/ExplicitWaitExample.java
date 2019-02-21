package com.cyber.test;

import com.cyber.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

    @Test
    public void test(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        //click on enable
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']/button")).click();

        //just creating object does not happen yet
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        //wait.until(), this is when wait happens
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("Hello world");
    }
}
