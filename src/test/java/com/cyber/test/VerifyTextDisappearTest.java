package com.cyber.test;

import com.cyber.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class VerifyTextDisappearTest extends TestBase {

    @Test
    public void verify1() {
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");
        WebElement text = driver.findElement(By.id("myDIV"));
        assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//button[.='Toggle Hide and Show']"));
        button.click();
        assertFalse(text.isDisplayed());

    }

    @Test
    public void verify2() {
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");

        driver.switchTo().frame("iframeResult");
        WebElement text = driver.findElement(By.xpath("//body/p"));
        assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//body/button"));
        button.click();

        assertFalse(elementDisplayed(By.xpath("//Body/p")));
    }


    /**
     * takes locater and retuns if element matching this locator exist
     param By
     */
    public boolean elementDisplayed(By by){

        //try to find it
        //if can not find it,return false
        try{
            return driver.findElement(by).isDisplayed();
        }catch(NoSuchElementException e){

            System.out.println("Caugth exception");
            return false;
        }

    }

    public boolean elementDisplayededS(By by){
        return driver.findElements(by).isEmpty();
    }
}
