package myutil;

import java.util.Random;

public class TestUtil {
    public static void main(String[] args){
        //Math类  所属包 java.lang 使用时不需要导包
        //该类提供的方法和属性都是static 直接 类名. 就可以调用
        System.out.println(Math.abs(-0.2));//绝对值
        System.out.println(Math.ceil(1.3));//向上取整
        System.out.println(Math.floor(1.3));//向下取整
        System.out.println(Math.rint(1.3));//邻近的整数
        System.out.println(Math.rint(1.5));//距离相等 返回偶数
        System.out.println(Math.round(1.3));//四舍五入
        System.out.println(Math.max(1.3,5));//比较
        System.out.println(Math.pow(2,5));//a的b次方
        System.out.println(Math.sqrt(16));//开方

        //Random类 所属包 java.util 需要import导入
        Random r = new Random();
        int value = r.nextInt(5);//随机数 [0,5) bound必须是正数
        //如果不传参数 范围将是int的取值范围
        //如果想要负数区间 可以进行如下操作
        System.out.println((r.nextInt(5))-5);//[-5,0)

    }
}
