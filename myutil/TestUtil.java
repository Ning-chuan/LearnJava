package myutil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

public class TestUtil {
    public static void main(String[] args){
        System.out.println(new TestUtil());
        //8个包装类(封装类)   都在java.lang包下  都继承Number
        //byte--Byte    short--Short    int--Integer     long--Long
        //float--Float  double--Double  char--Character  boolean--Boolean
//        Integer i1 = new Integer(16);//包装类
//        int value1 = i1.intValue();
//        //上面的 xxxValue();方法 将包装类类型转化为对应的基本类型(拆包)
//        System.out.println(value1);
//        //1.5版本之后  可以自动拆装包 写法如下
//        Integer i2 = 16;//自动包装
//        int value2 = new Integer(16);//自动拆包
//        System.out.println(Integer.parseInt("123"));
        Integer i1 = 10;//10自动包装成Integer对象
        Integer i2 = 10;
        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);
        System.out.println(i1==i2);//true-->false(大于127或小于-128时结果变为false)
        System.out.println(i1==i3);//false
        System.out.println(i3==i4);//false
        System.out.println(i1.equals(i2));//true
        System.out.println(i1.equals(i3));//true
        System.out.println(i3.equals(i4));//true




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
        System.out.println(r.nextInt(5));//[0,5)
        //随机数区间 [0,bound) bound必须是正数 否则出现如下异常
        //IllegalArgumentException
        //如果不传参数 范围将是int的取值范围
        //如果想要负数区间 可以进行如下操作
        System.out.println((r.nextInt(5))-5);//[-5,0)
        System.out.println(r.nextFloat());//[0.0,1.0)
        System.out.println(r.nextBoolean());

        //UUID类  java.util 需要import导包
        //除object类无任何继承关系
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());//数据库表格主键 primary key
        //上面产生一个32位的随机元素 每一个位置是一个16进制数字

        //BigInteger类 大整数  超过long范围  -2的63次方~2的63次方-1
        //java.math  需要import导入 继承自Number
        //通常用带String参数的构造方法创建对象
        BigInteger bi = new BigInteger("123");
        System.out.println(bi);
        //该类常用的四则运算方法
        //add()  subtract()  multiply()  divide()
        //阶乘方法测试如下
        TestUtil tu = new TestUtil();
        BigInteger bi1 = tu.factorial(15);
        System.out.println(bi1);

        //BigDecimal类 超过double取值范围  类似BigInteger类
        //java.math  需要import导入 继承自Number
        //通常用带String参数的构造方法创建对象
        //对象.setScale(2,BigDecimal.ROUND_DOWN)
        //上面两个参数前面是保留小数点后面的位数 后面是设置的模式
        BigDecimal bd = new BigDecimal("123.456");
        BigDecimal bd1 = bd.setScale(2,4);
        System.out.println(bd1);

    }
    //例子 利用BigInteger类设计一个计算给定数字阶乘的方法 如下
    public BigInteger factorial(int num){
        BigInteger result = new BigInteger("1");
        for(int i=1;i<=num;i++){
            result = result.multiply(new BigInteger(i+""));
        }
        return result;
    }
}
