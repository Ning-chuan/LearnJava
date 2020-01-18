package myenum;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        MyDay myDay = MyDay.friday;

//        Day day = Day.friday;
//        Day d = Day.valueOf("monday");//获取目标枚举对象
//        System.out.println(d.name()+"--"+d.ordinal());
          //ordinal()方法获取序号
//        Day[] days = Day.values();//获取所有枚举对象
//        for(Day x:days){
//            System.out.println(x.name()+"--"+x.ordinal());
//        }
        //输入一个字符串monday  输出对应的信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个星期的英文单词:");
        String key = input.nextLine();
        Day day = Day.valueOf(key);//通过输入的英文单词找到对应的枚举对象
        switch(day){
            case monday:
                System.out.println("您输入的是星期1");
                break;
            case tuesday:
                System.out.println("您输入的是星期2");
                break;
            case wednesday:
                System.out.println("您输入的是星期3");
                break;
            case thursday:
                System.out.println("您输入的是星期4");
                break;
            case friday:
                System.out.println("您输入的是星期5");
                break;
            case saturday:
                System.out.println("您输入的是星期6");
                break;
            case sunday:
                System.out.println("您输入的是星期7");
                break;
            default:
                System.out.println("出现错误");
        }
    }
}
