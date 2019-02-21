package com.cyber.pageObjects;

import com.cyber.pages.HomePage;
import com.cyber.utilities.ConfigurationReader;
import com.cyber.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTestWithProperties extends TestBase {


    @Test
    public void readPropertyTest(){
        driver.get(ConfigurationReader.getProperty("url"));
        HomePage homePage=new HomePage();
        String username=ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        homePage.login(username,password);


    }

}
