package datastructure.Queue;

import java.util.Scanner;

public class ArrayQueueTest{
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);
        Scanner input = new Scanner(System.in);
        char key;
        boolean loop = true;
        while(loop){
            System.out.println("s(show):展示队列所有元素");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加一个数据");
            System.out.println("g(get):取一个数据");
            System.out.println("p(peek):查看队列的第一个数据");
            System.out.println("-----请输入操作项-----");
            key = input.next().charAt(0);
            switch(key){
                case 's':
                    aq.show();
                    break;
                case 'e':
                    input.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据");
                    int value = input.nextInt();
                    aq.add(value);
                    break;
                case 'g':
                    try {
                        int getValue= aq.get();
                        System.out.printf("取出的数据是：%d\n",getValue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    aq.peek();
                    break;
                default:
                    System.out.println("非法输入！");
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public ArrayQueue(int arrMaxSize){
        //队列构造器
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向第一个数据的前一位
        rear = -1;//指向最后一个数据
    }

    //=========================================================

    //判断队列是否已满
    public boolean isFull(){
        return rear == arr.length-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }


    //添加元素
    public void add(int num){
        if(isFull()){
            System.out.println("队列已满，无法添加元素。");
        }else {
            arr[++rear] = num;
        }
    }

    //获取一个元素
    public int get(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列没有元素可取啦~");
            //抛出异常以后该方法会结束 不会再执行下面的代码
        }
        return arr[++front];
    }

    //展示队列所有元素
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空，展示不得");
        }
        int index = 0;
        for(int i = front;i<rear;i++){
            System.out.printf("queue[%d]=%d\n",index++,arr[i+1]);
        }
    }

    //显示队列的第一个数据（只是显示，不是取出来）
    public void peek(){
        if(isEmpty()){
            System.out.println("空空如也~");
        }
        System.out.printf("%d\n",arr[front+1]);
    }


}