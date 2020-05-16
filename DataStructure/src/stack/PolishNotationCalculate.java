package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotationCalculate {
    public static void main(String[] args) {
        //实现后缀表达式的计算
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //定义一个后缀表达式 事先约定以空格隔开
        String postfixExpression = "30 4 + 5 * 6 -";

        List<String> list = putToList(postfixExpression);

        int res = calculate(list);
        System.out.println(res);
    }

    //把表达式装到一个List集合中
    public static List putToList(String expression){
        List<String> list = new ArrayList<>();
        String[] values = expression.split(" ");
        for(String value:values){
            list.add(value);
        }
        return list;
    }

    //计算的方法
    public static int calculate(List<String> expressionList){
        //创建一个栈支持我们的运算
        Stack<String> stack = new Stack<>();
        for(String item:expressionList){
            if(item.matches("\\d+")){
                //是数字
                stack.push(item);
            }else{
                //是操作符
                //从栈取出两个数进行运算，结果再存入栈中
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch(item){
                    case "+":
                        res = num2+num1;
                        break;
                    case "-":
                        res = num2-num1;
                        break;
                    case "*":
                        res = num2*num1;
                        break;
                    case "/":
                        res = num2/num1;
                        break;
                    default:
                        throw new RuntimeException("暂不支持该操作符");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
