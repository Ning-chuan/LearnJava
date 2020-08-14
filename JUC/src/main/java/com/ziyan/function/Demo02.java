package com.ziyan.function;

import java.util.function.Predicate;

/**
 * Predicate断定型接口，接受一个参数，返回一个布尔值
 */
public class Demo02 {
    public static void main(String[] args) {
        //判断字符串是否为空 （泛型规定的是传入参数类型）
        Predicate<String> predicate = str -> str.isEmpty();
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("哈哈"));
    }
}
