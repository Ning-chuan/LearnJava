import java.util.Scanner;

public class FunctionTask {
//    //*10.设计一个方法 用来实现用户登录认证(二维数组当作小数据库)
//    private String[][] data = {{"宁川","888"},{"西安科技大学","666"},{"建筑设计","555"},};
//    //private 私有的
//    //如果把数据写在方法里，每一次调用方法时都需要重新创建，写成属性就可以避免这个问题
//    public String register(String user,String password){
//        String result = "用户名或密码错误";//代码优化
//        for(int i=0;i<data.length;i++){
//            if(user.equals(data[i][0])){
//                if(password.equals(data[i][1])){
//                    result = "登陆成功";
//                }
//                break;
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入您的用户名：");
//        String user = input.nextLine();
//        System.out.println("请输入您的密码：");
//        String password = input.nextLine();
//        FunctionTask f = new FunctionTask();
//        String result = f.register(user,password);
//        System.out.println(result);
//    }
//    //*9.设计一个方法  用来给数组元素排序(冒泡排序算法)
//    public void sequenceArray(int[] a,String order){
//        //因为改的是堆内存里数组元素的顺序，所以不需要返回值
//        for(int i=1;i<a.length;i++){
//            for(int j=a.length-1;j>=i;j--){
//                if((order.equals("升序") && a[j] < a[j - 1]) || (order.equals("降序") && a[j] > a[j - 1])) {
//                    //代码优化(重点)
//                        a[j] = a[j] ^ a[j - 1];
//                        a[j - 1] = a[j] ^ a[j - 1];
//                        a[j] = a[j] ^ a[j - 1];
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] array = {5,4,9,16,7,3,6,13,66,30,2,6};
//        FunctionTask f = new FunctionTask();
//        f.sequenceArray(array,"降序");
//        for(int v:array){
//            System.out.println(v);
//        }
//
//    }

//    //8.设计一个方法  用来存储给定范围内的素数(2-100)
//    public int[] primeNum(int start,int end){
//        if(end<0 || start>end){
//            return null;
//        }
//        int[] tempArray = new int[((end-start)/2)+1];
//        int begin = 2;
//        if(start>1){
//            begin = start;
//        }
//        int index = 0;
//        for(int num=begin;num<=end;num++){
//            boolean a = true;
//            for(int j=2;j<num/2;j++){
//                if(num%j==0){
//                    //System.out.println(num+"不是素数");
//                    a = false;
//                    break;
//                }
//            }
//            if(a){
//                //System.out.println(num+"是素数");
//                tempArray[index++] = num;
//            }
//        }
//        int[] primeArray = new int[index];
//        for(int i=0;i<primeArray.length;i++){
//            primeArray[i] = tempArray[i];
//        }
//        tempArray = null;
//        return primeArray;
//    }
//
//    public static void main(String[] args) {
//        FunctionTask f = new FunctionTask();
//        int[] primeArray = f.primeNum(2,150);
//        for(int v:primeArray){
//            System.out.println(v);
//        }
//    }
//    //7.设计一个方法  用来去掉数组中的0元素
//    public int[] noZeroArray(int[] a){
//        int index = 0;
//        int[] x = new int[a.length];
//        for(int i=0;i<a.length;i++){
//            if(a[i]!=0){
//                x[index++] = a[i];
//            }
//        }
//        int[] finalArray = new int[index];
//        for(int i=0;i<finalArray.length;i++){
//            finalArray[i] = x[i];
//        }
//        x = null;
//        return  finalArray;
//    }
//
//    public static void main(String[] args) {
//        int[] oldArray = new int[]{1,2,3,0,0,4,5,0,6,0,7};
//        FunctionTask f = new FunctionTask();
//        int[] newArray = f.noZeroArray(oldArray);
//        for(int v:newArray){
//            System.out.println(v);
//        }
//
//    }
//    //6.设计一个方法  用来将一个数组按照最大值位置拆分
//    public int[][] combineArray(int[] array){
//        int max = array[0];
//        int index = 0;
//        for(int i=1;i<array.length;i++){
//            if(max<array[i]){
//                max = array[i];
//                index = i;
//            }
//        }
//        int[] a = new int[index];
//        int[] b = new int[array.length-a.length-1];
//        for(int i=0;i<a.length;i++){
//            a[i] = array[i];
//        }
//        for(int i=0;i<b.length;i++){
//            b[i] = array[a.length+1+i];
//        }
//        return new int[][]{a,b};
//
//    }
//        //5.设计一个方法  用来合并两个数组
//        public int[] combineArray(int[] a,int[] b){
//            int[] x = new int[a.length+b.length];
//            for(int i=0;i<x.length;i++){
//                if(i<a.length){
//                    x[i] = a[i];
//                }else{
//                    x[i] = b[i-a.length];
//                }
//            }
//            return x;
//        }
//
//    public static void main(String[] args) {
//        int[] a = {1,5,6,8,9,};
//        int[] b = {11,15,26,18,};
//        FunctionTask f = new FunctionTask();
//        int[] x = f.combineArray(a,b);
//        for(int v:x){
//            System.out.println(v);
//        }
//
//    }
//    //4.设计一个方法  用来找寻给定的元素是否在数组内存在(Scanner输入一个)
//    public String FindArray(int[] array,int value){
//        //方法一：
//        String result = "您要找的值数组中不存在";
//        for(int i=0;i<array.length;i++){
//            if(value==array[i]){
//                result = "您要找的值数组中存在";
//                break;
//            }
//        }
//        //方法二：
////        String result = "您要找的值数组中存在";
////        for(int i=0;i<array.length;i++){
////            if(value==array[i]){
////                break;
////            }
////            if(i==array.length-1){
////                result = "您要找的值数组中不存在";
////            }
////        }
//        return result;
//
//    }
//
//    public static void main(String[] args) {
//        int[] a = {1,2,3,4,5,6,7,8,9};
//        FunctionTask f = new FunctionTask();
//        String result = f.FindArray(a,8);
//        System.out.println(result);
//    }




//    //3.设计一个方法  用来寻找数组中的极值(最大值 或 最小值)
//    public int extremumArray(int[] array,boolean flag){//true表示找最大值，false表示找最小值
//        int value = array[0];
//            for (int i = 1; i < array.length; i++) {
//                if (flag && value < array[i]) {
//                    value = array[i];
//                } else if (!flag && value > array[i]) {
//                    value = array[i];
//                }
//            }
//        return value;
//    }
//
//    public static void main(String[] args) {
//        int[] a = new int[]{33,8,6,3,9,18,66,7,12};
//        FunctionTask f = new FunctionTask();
//        int min=f.extremumArray(a,false);
//        System.out.println(min);
//
//    }


//    //2.设计一个方法  用来交换一个数组(头尾互换)
//    public void reversalArray(int[] a){
//        for(int i=0;i<a.length/2;i++){
//            a[i]=a[i]^a[a.length-1-i];
//            a[a.length-1-i]=a[i]^a[a.length-1-i];
//            a[i]=a[i]^a[a.length-1-i];
//            //int temp = a[i];
//            //a[i] = a[a.length-1-i];
//            //a[a.length-1-i] = temp;
//        }
//    }
//    public static void main(String[] args) {
//        int[] b = new int[]{1,2,3,4,5,6,7,8,9};
//        FunctionTask f = new FunctionTask();
//        f.reversalArray(b);
//        for(int v:b){
//            System.out.println(v);
//        }
//    }

    //1.设计一个方法  用来交换两个数组元素 a{1,2,3,4}  b{5,6,7,8}
//    public int[][] exchangeArray(int[] a,int[] b){
//        //方式二：交换引用，长度不一致也好用，但是必须要有返回值接收。
//        int[] temp = a;
//        a = b;
//        b = temp;
//        int[][] x = {a,b};//因返回值只能有一个，所以用一个数组打包起来
//        return x;
        //方式一：不需要返回值，但是它占用性能多，而且只有在数组长度一致时才能换
        // public void exchangeArray(int[] a,int[] b){
//        for(int i=0;i<a.length;i++){
//            a[i]=a[i]^b[i];
//            b[i]=a[i]^b[i];
//            a[i]=a[i]^b[i];
//        }
//    }
//    public static void main(String[] args) {
//        FunctionTask f = new FunctionTask();
//        int[] c = new int[]{12,13,14,15,};
//        int[] d = new int[]{32,33,34,35,36};
//        int[][] value = f.exchangeArray(c,d);
//        c = value[0];
//        d = value[1];
//        for(int v:c){
//            System.out.println(v);
//        }
//        System.out.println("-----------");
//        for(int v:d){
//            System.out.println(v);
//        }
//    }
}
