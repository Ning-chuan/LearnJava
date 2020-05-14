package stack;

public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}
//用数组实现一个栈
class ArrayStack{
    private int maxSize;
    private int[] array;
    private int top;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        array = new int[this.maxSize];
        top = -1;//指向栈顶 初始化为-1
    }

    //判断栈是否已满
    public boolean ifFull(){
        return top == maxSize-1;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    public void put(int value){
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

    public void show(){
        if(isEmpty()){
            System.out.println("空空如也");
        }
        for(int i = top;i >= 0;i--){
            System.out.println(array[i]);
        }
    }

}