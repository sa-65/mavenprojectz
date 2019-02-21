package com.cyber.test;
import com.cyber.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class WebTablesExample extends TestBase {


    //prints whole table
    @Test
    public void printWholeTable() {
        login();


        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());


    }

    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    //prints the headers of table
    @Test
    public void printAllHeaders(){
        login();
        //find the headers
        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody//th"));

        for(WebElement header:headers){
            System.out.println(header.getText());
        }
    }


    @Test
    public void printRows(){
        login();
        List<WebElement> allRows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        //print number of rows
        System.out.println("Number of rows: "+allRows.size());

        //prints whole rows
        for(WebElement row:allRows){
            System.out.println(row.getText());
        }

        //print the specific row
        System.out.println("Second row");
        System.out.print(allRows.get(1).getText());
    }

    //prints table size" columns and rows in the table
    @Test
    public void printTableSize(){
        login();
        List<WebElement> allRows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        //print number of rows
        System.out.println("Number of rows: "+allRows.size());

        //prints number of cloumns
        List<WebElement> columns=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/th"));
        System.out.println("columns "+columns.size());

    }

    //prints a row without using a list
    @Test

    public void printRow2(){
        login();

        WebElement row=driver.findElement(By.xpath(
                                "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));
        System.out.println(row.getText());
    }


    //prints all the cells of a row whose index in the xpath
    @Test
    public void printAllCellInOneRow(){
        login();

        List<WebElement> cells=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

        for(WebElement cell:cells){
            System.out.println(cell.getText());

        }
    }

    @Test
    public void printByCordinates(){
        login();

        WebElement cell=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[10]"));
        System.out.println(cell.getText());

        System.out.println();

        System.out.println(getCell(6,11).getText());

    }


    public WebElement getCell(int row,int col){
        String xpath="//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";

        return driver.findElement(By.xpath(xpath));
    }


    //print all the values in single column
    @Test
    public void printColumn(){
        login();
        List<WebElement> allnames=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for (WebElement name:allnames){
            System.out.println(name.getText());
        }
    }


    ///find the select checkbox for a given name
    @Test
    public void selectCheckbox(){
        login();
        WebElement checkBox=driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]/input"));
        System.out.println(checkBox.isSelected());//false
        checkBox.click();
        System.out.println(checkBox.isSelected());//true
    }

    /**
     *
     * 1.verify that name 'Mark Smith' exist in the names column
     * 2. verify that city 'Whitestone, British' exist in the cities column
     * */

    @Test
    public void test(){
        login();
        int nameIndex=getColumnIndex("Name");
        System.out.println(nameIndex);

        List<WebElement> allNames=driver.findElements(By.xpath(
                            "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));

        boolean found=false;


        for (int i = 0; i <allNames.size() ; i++) {
            if(allNames.get(i).getText().equals("Mark Smith")){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);

        found=false;
        int cityIndex=getColumnIndex("City");
        List<WebElement> allCities=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+cityIndex+"]"));

        for (int i = 0; i <allCities.size() ; i++) {
            if(allCities.get(i).getText().equals("Whitestone, British")){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);


    }

    public int getColumnIndex(String column){

        List<WebElement> allHeader=driver.findElements(
                    By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (int i = 0; i <allHeader.size() ; i++) {
            if(allHeader.get(i).getText().equals(column)){
                return i+1;
            }

        }

        return 0;
    }


}