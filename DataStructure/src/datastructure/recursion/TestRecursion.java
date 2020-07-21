package datastructure.recursion;

public class TestRecursion {

    public static void main(String[] args) {

        print(5);

        System.out.println(factorial(4));

    }

    //打印问题
    private static void print(int num){
        if(num>2){
            print(num-1);
        }
        System.out.println("num="+num);
    }

    //阶乘问题
    private static int factorial(int num){
        if(num == 1){
            return 1;
        }
        return num*factorial(num-1);
    }

}
