package com.ziyan.function;

import java.util.function.Supplier;

/**
 * Supplier供给型接口，不需要接收参数，有返回值
 */
public class TestSupplier {
    public static void main(String[] args) {
        //泛型规定的是返回值类型
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "哈哈";
//            }
//        };
        Supplier<String> supplier = () -> "haha";
        System.out.println(supplier.get());
    }
}
