package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotationCalculate {
    public static void main(String[] args) {
        //实现后缀表达式（逆波兰表达式）的计算
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //定义一个后缀表达式 事先约定以空格隔开
//        String postfixExpression = "30 4 + 5 * 6 -";
//
//        List<String> list = putToList(postfixExpression);
//
//        int res = calculate(list);
//        System.out.println(res);


        //中缀表达式转后缀表达式
        String nifixExpression = "(30+4)*5-6";
        List<String> nifixList = parseToNifixExpressionList(nifixExpression);
        System.out.println(nifixList);
        List<String> postfixList = parseToPostfixExpression(nifixList);
        System.out.println(postfixList);
        System.out.println("计算的结果为:"+calculate(postfixList));



    }

    //把约定好的（以空格为分隔符）的表达式装到一个List集合中
    private static List<String> putToList(String expression){
        List<String> list = new ArrayList<>();
        String[] values = expression.split(" ");
        for(String value:values){
            list.add(value);
        }
        return list;
    }

    //计算的方法
    private static int calculate(List<String> expressionList){
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

    //中缀表达式转后缀表达式的方法 以集合的方式返回
    private static List<String> parseToPostfixExpression(List<String> neList){
        //创建一个栈 用于存储运算符
        Stack<String> operStack = new Stack<>();
        //创建一个List 用于保存结果
        List<String> resultList = new ArrayList<>();
        for(String item:neList){
            if(item.matches("\\d+")){
                //是数字
                resultList.add(item);
            }else{
                //是一个操作符
                //与符号栈栈顶符号做比较
                if(operStack.size()==0 || item.equals("(") || operStack.equals("(") || priority(item.charAt(0))>priority(operStack.peek().charAt(0))){
                    //当符号栈为空  或当前符号为'('  或符号栈栈顶为'('  或当前符号优先级大于栈顶符号优先级时 直接入符号栈
                    operStack.push(item);
                }else if(item.equals(")")){
                    //依次弹出符号栈符号 并加到数字集合中 直到遇到'('为止 丢弃这一对括号
                    while(!operStack.peek().equals("(")){
                        resultList.add(""+operStack.pop());
                    }
                    operStack.pop();//把'('丢弃
                }else{
                    //此时只有一种情况：当前运算符的优先级小于或者等于栈顶运算符 这时需要把栈顶运算符加到结果结合中
                    //因为加完一次后还需要再与新的栈顶操作符作比较 所以用循环
                    while(operStack.size()!=0 && priority(item.charAt(0)) <= priority(operStack.peek().charAt(0))){
                        resultList.add(operStack.pop());
                    }
                    //循环结束 可能有以下几种情况：
                    //  1.运算符栈为空
                    //  2.当前操作符优先级大
                    //  3.遇到了（
                    //这几种情况都需要把运算符加入到栈中
                    operStack.push(item);
                }
            }
        }
        //循环结束 把剩余的运算符依次加入到结果集合中
        while(operStack.size()!=0){
            resultList.add(operStack.pop());
        }
        return resultList;
    }

    //把字符串表达式转换成集合形式
    private static List<String> parseToNifixExpressionList(String nifixExpression){
        List<String> list = new ArrayList<>();
        char cur;
        String str;//保存多位数
        int index = 0;//遍历表达式字符串
        while(index<nifixExpression.length()){
            cur = nifixExpression.charAt(index);
            if(cur>=48 && cur<=57){
                //是数字
                str = "";//置空
                while(cur>=48 && cur<=57){
                    str += cur;
                    index++;
                    if(index==nifixExpression.length()){
                        break;
                    }
                    cur = nifixExpression.charAt(index);
                }
                list.add(str);
            }else{
                //是符号
                list.add(""+cur);
                index++;
            }
        }
        return list;
    }

    //返回运算符优先级的方法
    private static int priority(char oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }
        return -1;
    }

}
