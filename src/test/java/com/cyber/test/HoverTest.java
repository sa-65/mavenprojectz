package com.cyber.test;

import com.cyber.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class HoverTest extends TestBase {

    @Test

    public void myHeart() throws InterruptedException{
        driver.get("https://amazon.com/");
        WebElement signIn=driver.findElement(By.xpath("//span[.='Hello. Sign in']"));

       Thread.sleep(3000);

       //MOVING THE MOUSE ON TOP OF THE GIVEN ELEMENT
       actions.moveToElement(signIn).perform();

       driver.findElement(By.xpath("//span[.='Your Hearts']")).click();
        Thread.sleep(3000);

        assertTrue(driver.getTitle().contains("Interesting"));

    }


    @Test
    public void test2(){
        driver.get("https://amazon.com/");
        WebElement help=driver.findElement(By.xpath("(//a[.='Help'])[2]"));
        actions.moveToElement(help).perform();

    }
}
