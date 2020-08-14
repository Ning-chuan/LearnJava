package com.ziyan.function;

import java.util.function.Function;

/**
 * Function接口，有一个参数输入，有一个输出
 */
public class Demo01 {
    public static void main(String[] args) {
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };
        Function<String,String> function = s -> s;
        System.out.println(function.apply("哈哈"));
    }
}
