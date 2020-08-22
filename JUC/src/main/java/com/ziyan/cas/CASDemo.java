package com.ziyan.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        //CAS:compareAndSet(比较并交换)
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //参数一：期望值；参数二：更新值   如果达到了期望值，就更改为更新值
        System.out.println(atomicInteger.compareAndSet(2020,2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.getAndIncrement());//增加后变为2022
        System.out.println(atomicInteger.compareAndSet(2020,2021));
        System.out.println(atomicInteger.get());
    }
}
