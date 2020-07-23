package com.ziyan;

import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {

    @Test
    public void testAdd(){
        System.out.println("=====testAdd方法执行了=====");
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(10, 20);
        Assert.assertEquals(30,res);

    }
}
