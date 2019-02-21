package com.cyber.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {

    @Test
    public void login(){
        System.out.println("login");
        Assert.assertTrue(false );
    }

    @Test(dependsOnMethods = "login")
    public void buySth(){
        System.out.println("buy buy baby");
    }



    @Test
    public void homePage(){
        System.out.println("home page");
    }

}
