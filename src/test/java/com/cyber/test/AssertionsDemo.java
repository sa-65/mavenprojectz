package com.cyber.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
    @Test
    public void test1(){
        String a="A";
        String b="A";
        Assert.assertEquals(a,b);//comparing a to b
    }

    @Test
    public void test2(){
        String a="b";
        String b="b";
        Assert.assertEquals(a,b);//comparing a to b first param is actual second is expected
    }

//    @Test
//    public void test3(){
//        boolean b=1==1;
//
//        Assert.assertTrue(b);//comparing a to b first param is actual second is expected
//    }


    @Test
    public void test3(){
        String a="AD";
        String b="ADAFD";
        Assert.assertTrue(b.contains(a));//comparing a to b first param is actual second is expected
    }


}
