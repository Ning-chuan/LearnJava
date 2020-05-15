package stack;

public class Calculate {
    public static void main(String[] args) {
        String ex = "3+2*6-2";
        int index = 0;//用于遍历表达式
        ArrayStack2 numStack = new ArrayStack2(20);
        ArrayStack2 operStack = new ArrayStack2(20);

        char cur = ' ';
        while(true){
            cur = ex.charAt(index);
            if(isOper(cur)){
                if(priority(cur) <= priority((char)operStack.peek())){

                }else{

                }
            }
        }
    }

    //返回运算符优先级的方法
    public static int priority(char oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }
        return -1;
    }

    //判断字符是否是一个操作符
    public static boolean isOper(char value){
        return value == '*' || value == '/' || value == '+' || value == '-';
    }
}

//用之前创建好的栈 支持计算器的运算
class ArrayStack2{
    private int maxSize;
    private int[] array;
    private int top = -1;//指向栈顶 初始化为-1

    public ArrayStack2(int maxSize){
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
            System.out.printf("stack[%d]=%d\n",i,array[i]);
        }
    }

}
