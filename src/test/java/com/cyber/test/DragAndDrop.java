package com.cyber.test;

import com.cyber.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {

    @Test
    public void test(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));


        //#1 way
        //actions.dragAndDrop(source,target).perform();

        //write the steps doing the drag and drop operation,
        //without using dragAndDrop(); method
        //when we use multiple actions we need to add build(); before the perform();
        //#2 way
        actions.clickAndHold(source).moveToElement(target).release().build().perform();


        //confirm the message
        String a=driver.findElement(By.xpath("//div[.='You did great!']")).getText();
        Assert.assertEquals(a,"You did great!");

    }
}
