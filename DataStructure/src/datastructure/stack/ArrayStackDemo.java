package datastructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一把
        ArrayStack stack = new ArrayStack(4);
        Scanner input = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while(loop){
            System.out.println("请输入操作项:");
            System.out.println("push:新增");
            System.out.println("pop:取值");
            System.out.println("peek:看一看栈顶的值");
            System.out.println("show:展示栈中的数据");
            System.out.println("exit:推出程序");
            key = input.next();
            switch (key){
                case "pop" :
                    try {
                        int res = stack.pop();
                        System.out.println("取出的值为："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push" :
                    System.out.println("请输入要存入的数：");
                    int value = input.nextInt();
                    stack.push(value);
                    break;
                case "peek" :
                    try {
                        int res = stack.peek();
                        System.out.println("栈顶的值为："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "show" :
                    stack.show();
                    break;
                case "exit" :
                    input.close();
                    loop = false;
                    break;
                default:
                    System.out.println("请输入正确的操作项！");
                    break;
            }
        }
        System.out.println("程序退出~");
    }
}
//用数组实现栈
class ArrayStack{
    private int maxSize;
    private int[] array;
    private int top = -1;//指向栈顶 初始化为-1

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        array = new int[this.maxSize];
    }

    //判断栈是否已满
    public boolean ifFull(){
        return top == maxSize-1;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(ifFull()){
            System.out.println("栈已满，无法加入");
            return;
        }
        array[++top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空，无法取值");
        }
        return array[top--];
    }

    //看一看栈顶的值使多少
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return array[top];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("空空如也");
        }
        for(int i = top;i >= 0;i--){
            System.out.printf("datastructure.stack[%d]=%d\n",i,array[i]);
        }
    }

}