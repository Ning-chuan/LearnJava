package datastructure.Queue;

import java.util.Scanner;

/**
 * 用数组实现可以循环的队列
 * */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueue caq = new CircleArrayQueue(4);
        //因为预留了一个位置 所以队列有效位数为3

        System.out.println("开始测试环形数组队列");
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
                    caq.show();
                    break;
                case 'e':
                    input.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据");
                    int value = input.nextInt();
                    caq.add(value);
                    break;
                case 'g':
                    try {
                        int getValue= caq.get();
                        System.out.printf("取出的数据是：%d\n",getValue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        System.out.printf("队列的第一个数据是：%d\n",caq.peek());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                default:
                    System.out.println("非法输入！");
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArrayQueue{
    private int[] arr;
    private int maxSize;
    private int front;//表示队列第一个数据的位置 初始值设为0
    private int rear;//表示队列最后一个数据的后一个位置 初始值设为0

    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;
        rear = 0;
    }

    //=========================================================
    //判断队列是否满
    public boolean isFull(){
        //因为希望空出一个空间作为约定 所以使用第二种判断条件
        //return rear%maxSize == front;
        return (rear+1)%maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加一个数据
    public void add(int num){
        if(isFull()){
            System.out.println("队列已满，添加不得");
        }else{
            arr[rear] = num;
            rear = (rear+1)%maxSize;//循环数组队列 必须考虑取模
        }
    }

    //取一个数据
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("可惜！队列为空，取不得。");
        }
        //所取的值是front位置的值没有问题
        //但是取完值以后我们还需要对front进行后移
        //如果此时 front==maxSize-1 那么后移之后front的值应该是0
        //所以要进行取模处理 处理之前需要把结果用一个临时变量保存起来
        int result = arr[front];
        front = (front+1)%maxSize;
        return result;
    }

    //显示队列所有数据
    public void show(){
        if(isEmpty()){
            System.out.println("可惜！队列为空，显示不得。");
        }else{
            for (int i = front;i<front+size();i++){
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
            }
//            //元素有效个数的计算方式
//            int values = (rear+maxSize-front)%maxSize; 计算有效个数单独封装一个方法
//            for(int i = 0;i<values;i++){
//                System.out.printf("datastructure.Queue[%d]=%d\n",i,arr[front]);
//                front = (front+1)%maxSize;
//            }
        }
    }
    //求出队列有效个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //获取第一个数据（只展示，不取出来）
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("可惜！队列为空，取不得。");
        }
        return arr[front];
    }
}