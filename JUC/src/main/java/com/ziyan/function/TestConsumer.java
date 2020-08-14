package com.ziyan.function;

import java.util.function.Consumer;

/**
 * Consumer消费型接口，接收一个参数，不返回值
 */
public class TestConsumer {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        //lambda表达式：
        //Consumer<String> consumer = s -> System.out.println(s);

        //方法引用：
        Consumer<String> consumer = System.out::println;

        consumer.accept("haha");
    }
}
