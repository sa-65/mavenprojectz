package com.cyber.pageObjects;

import com.cyber.pages.HomePage;
import com.cyber.utilities.ConfigurationReader;
import com.cyber.utilities.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.junit.Assert.*;


public class ErrorMessageValidationTest extends TestBase {
    HomePage homepage = new HomePage();



    @Test
    public void wrongEmailTest(){
        driver.get(ConfigurationReader.getProperty("url"));
       // driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homepage.userName.sendKeys(faker.name().username());
        homepage.password.sendKeys("test");
        homepage.loginButton.click();


        String actualError=homepage.errorMessage.getText();
        assertEquals(actualError,"Invalid Login or Password.");

    }


    @Test
    public void wrongPasswordTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homepage.userName.sendKeys("Tester");
        homepage.password.sendKeys(faker.internet().password());
        homepage.loginButton.click();


        String actualError=homepage.errorMessage.getText();
        assertEquals("Invalid Login or Password.",actualError);
    }

    @Test
    public void blankUserName(){
        homepage.open();
        homepage.login("","test");

        String actualError=homepage.errorMessage.getText();
        assertEquals(actualError,"Invalid Login or Password.");
    }


}
