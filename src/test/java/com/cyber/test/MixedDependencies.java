package com.cyber.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MixedDependencies {

    @Test
    public void openBrowser(){
        System.out.println("opening browser");
    }

    @Test(dependsOnMethods = "openBrowser" )
    public void login(){
        System.out.println("login");
        //Assert.assertTrue(false);
    }


    @AfterMethod
    public void cleanUp(){
        System.out.println("close browser");
    }
}
