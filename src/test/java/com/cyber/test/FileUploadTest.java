package com.cyber.test;

import com.cyber.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class FileUploadTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        String path="C:\\Users\\zeki\\Downloads\\SalesJan2009.csv";

        chooseFile.sendKeys(path);

        driver.findElement(By.id("file-submit")).click();

        assertTrue(driver.findElement(By.xpath("//h3[.='File Uploaded!']")).isDisplayed());


    }



}
