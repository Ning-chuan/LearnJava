package stack;

public class Calculate {
    public static void main(String[] args) {
        String ex = "7*2*2-5+9/3-4";
        int index = 0;//用于遍历表达式
        ArrayStack2 numStack = new ArrayStack2(20);
        ArrayStack2 operStack = new ArrayStack2(20);

        int num1 = 0;//计算时，接收数栈中的数
        int num2 = 0;//计算时，接收数栈中的数
        char cur = ' ';//记录当前字符
        char oper = ' ';//计算时，接收符号栈中的符号
        while(index != ex.length()){
            cur = ex.charAt(index++);
            if(isOper(cur)){
                if(operStack.isEmpty()){
                    operStack.push(cur);
                }else if (priority(cur) <= priority((char)operStack.peek())){
                    //此时 当前符号优先级 小于/等于 上一个符号的优先级
                    //从数栈取出两个值 并且从操作符栈去除一个操作符做计算 结果入数栈
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    oper = (char)operStack.pop();
                    int res = cal(num2,num1,oper);//在原表达式中num2应当在num1的左边 所以此处先传num2
                    numStack.push(res);
                    //计算完毕 当前操作符入符号栈
                    operStack.push(cur);
                }else{
                    //当前操作符优先级高 直接入操作符栈
                    operStack.push(cur);
                }
            }else{
                //cur是数字 按照ascii码转换成对应数字应该减去48
                numStack.push(cur-48);
            }
        }
        while(!operStack.isEmpty()){
            //只要运算符栈不为空 就一直计算
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = (char)operStack.pop();
            int res = cal(num2,num1,oper);//在原表达式中num2应当在num1的左边 所以此处先传num2
            numStack.push(res);
        }
        //上面循环结束之后 符号栈空了 数栈只剩下一个数 这个数就是表达式的结果
        System.out.println("表达式的结果为："+numStack.peek());
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

    //判断字符是否是一个操作符
    private static boolean isOper(char value){
        return value == '*' || value == '/' || value == '+' || value == '-';
    }

    //四则运算方法
    private static int cal(int num1,int num2,char oper){
        int res = 0;
        if(oper == '*'){
            res = num1 * num2;
        }else if(oper == '/'){
            res = num1 / num2;
        }else if(oper == '+'){
            res = num1 + num2;
        }else if(oper == '-'){
            res = num1 - num2;
        }else{
            throw new RuntimeException("暂不支持该运算符");
        }
        return res;
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
