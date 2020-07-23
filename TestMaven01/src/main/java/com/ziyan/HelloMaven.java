package com.ziyan;

public class HelloMaven {

    public int add(int v1,int v2){
        return v1 + v2;
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(10, 20);
        System.out.println(res);
    }
}
