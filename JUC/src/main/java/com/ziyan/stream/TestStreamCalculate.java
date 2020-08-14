package com.ziyan.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现！
 * 现在有5个用户！筛选：
 * 1、ID 必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名字母倒着排序
 * 5、只输出一个用户！
 */
public class TestStreamCalculate {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 22);
        User u2 = new User(2, "b", 23);
        User u3 = new User(3, "c", 24);
        User u4 = new User(4, "d", 25);
        User u5 = new User(6, "e", 26);

        //用集合把用户存起来
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);

        //lambda表达式、链式编程、函数式接口、stream流计算
        users.stream()
                .filter(u -> u.getNum()%2==0)
                .filter(u ->u.getAge()>23)
                .map(u -> u.getName().toUpperCase())
                .sorted((uu1,uu2) -> uu2.compareTo(uu1))
                .limit(1)
                .forEach(System.out::println);
        
    }
}
