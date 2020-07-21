package datastructure.stack;

import java.util.Scanner;

public class SingleLinkedListStackDemo {
    public static void main(String[] args) {
        //测试一把
        SingleLinkedListStack stack = new SingleLinkedListStack();
        Scanner input = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while (loop) {
            System.out.println("请输入操作项:");
            System.out.println("push:新增");
            System.out.println("pop:取值");
            System.out.println("peek:看一看栈顶的值");
            System.out.println("show:展示栈中的数据");
            System.out.println("exit:退出程序");
            key = input.next();
            switch (key) {
                case "pop":
                    try {
                        Object res = stack.pop();
                        System.out.println("取出的值为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("请输入要存入的数：");
                    Object value = input.next();
                    stack.push(value);
                    break;
                case "peek":
                    try {
                        Object res = stack.peek();
                        System.out.println("栈顶的值为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "show":
                    stack.show();
                    break;
                case "exit":
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


//单链表实现栈
class SingleLinkedListStack {
    private Node top = new Node();

    //判断栈是否为空
    public boolean isEmpty(){
        return top.next == null;
    }

    //新增
    public void push(Object value){
        Node newNode = new Node();
        newNode.value = value;
        if(isEmpty()){
            top.next = newNode;
        }else{//采用头插法 方便出栈操作
            newNode.next = top.next;
            top.next = newNode;
        }
    }

    //取值
    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("空空如也~");
        }
        //把要返回的值保存起来
        Object res = top.next.value;
        //把最后加入（链表第一个节点）的节点删除
        top.next = top.next.next;
        return res;
    }

    //看一看栈顶的值
    public Object peek(){
        if(isEmpty()){
            throw new RuntimeException("--栈为空--");
        }
        return top.next.value;
    }

    //展示栈中的数据
    public void show(){
        if(isEmpty()){
            System.out.println("空空如也~");
            return;
        }
        Node temp = top.next;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}

//定义一个节点类
class Node {
    public Object value;
    public Node next;
}
