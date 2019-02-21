package com.cyber.test;

import com.cyber.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame("iframeResult");


        //#1 CREATE ACTION OBJECT
       // Actions actions = new Actions(driver);

        //#2 IDENTIFY THE WEBELEMENT ON WHICH WE DOUBLE CLICK

        WebElement text=driver.findElement(By.id("demo"));

        //DOUBLE CLICK ON ELEMENT
            //we ne
        actions.doubleClick(text).perform();

        Assert.assertTrue(text.getAttribute("style").contains("red"));
    }
}
