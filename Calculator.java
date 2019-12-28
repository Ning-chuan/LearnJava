import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Calculator {
//    1.设计一个类模拟一个计算器  做  加减乘除 方法  计算方法
//            控制台输出
//    请输入第一个数
//		1
//    请输入符号
//		+
//    请输入第二个数
//		2
//                3
//    请输入符号
//		-
//    请输入第二个数
//		2
//                1
    public double add(double a,double b){
        return a+b;
    }
    public double subtract(double a,double b){
        return a-b;
    }
    public double multiply(double a,double b){
        return a*b;
    }
    public double division(double a,double b){
        return a/b;
    }
    public void calculate() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        String one = input.nextLine();
        double a = Double.parseDouble(one);
        while(true){
            System.out.println("请输入运算符号：");
            String symbol = input.nextLine();
            if(symbol.equals("=")){
                System.out.println("计算完毕");
                break;
            }
            if(!(symbol.equals("+")||symbol.equals("-")||symbol.equals("*")||symbol.equals("/"))){
                System.out.println("符号有误，只能是 + - * / 其中一个");
                continue;
            }
            System.out.println("请输入第二个数：");
            String two = input.nextLine();
            double b = Double.parseDouble(two);
            switch(symbol) {
                case "+":
                    a = this.add(a,b);
                    break;
                case "-":
                    a = this.subtract(a,b);
                    break;
                case "*":
                    a = this.multiply(a,b);
                    break;
                case "/":
                    a = this.division(a,b);
                    break;
            }
            System.out.println(a);
        }
    }
}
