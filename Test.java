public class Test {

//    引用类型传递：
//    public void changeArray(int[] x){
//        System.out.println("方法执行开始："+x[2]);
//        x[2] = 6;
//        System.out.println("方法执行开始："+x[2]);
//    }
//    public static void main(String[] args){
//        Test t = new Test();
//        int[] a = new int[]{6,8,10};
//        t.changeArray(a);
//        System.out.println("main方法中a最终的值为："+a[2]);
//    }
//    基本类型传递:
//    public int changeNum(int x){
//        System.out.println("方法执行开始："+x);
//        x = 10;
//        System.out.println("方法执行开始："+x);
//        return x;
//    }
//    public static void main(String[] args){
//        Test t = new Test();
//        int a = 1;
//        a = t.changeNum(a);
//        System.out.println("main方法中a最终的值为："+a);
//    }
//    形参和实参
//    形参可以理解为方法执行时的临时变量空间  x
//    实参可以理解为方法调用时传递进去的参数  a
//    方法调用时会将实参的内容传递给形参
//    如果内容是基本类型  传递的 是值    形参改变  实参不变
//    如果内容是引用类型  传递的 是引用  形参改变  实参跟着改变
}
