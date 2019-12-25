public class FunctionTask {
    //4.设计一个方法  用来找寻给定的元素是否在数组内存在(Scanner输入一个)





//    //3.设计一个方法  用来寻找数组中的极值(最大值 或 最小值)
//    public int extremumArray(int[] a,String b){
//        int value = a[0];
//        if(b.equals("最大值")){
//            for (int i = 1; i < a.length; i++) {
//                if (value < a[i]) {
//                    value = a[i];
//                }
//            }
//        }
//        if(b.equals("最小值")){
//            for (int i = 1; i < a.length; i++) {
//                if (value > a[i]) {
//                    value = a[i];
//                }
//            }
//        }
//        return value;
//    }
//
//    public static void main(String[] args) {
//        int[] a = new int[]{1,8,6,3,9,18,66,7,12};
//        FunctionTask f = new FunctionTask();
//        int max=f.extremumArray(a,"最大值");
//        System.out.println(max);
//
//    }


//    //2.设计一个方法  用来交换一个数组(头尾互换)
//    public void reversalArray(int[] a){
//        for(int i=0;i<a.length/2;i++){
//            a[i]=a[i]^a[a.length-1-i];
//            a[a.length-1-i]=a[i]^a[a.length-1-i];
//            a[i]=a[i]^a[a.length-1-i];
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

//    //1.设计一个方法  用来交换两个数组元素 a{1,2,3,4}  b{5,6,7,8}
//    public void exchangeArray(int[] a,int[] b){
//        for(int i=0;i<a.length;i++){
//            a[i]=a[i]^b[i];
//            b[i]=a[i]^b[i];
//            a[i]=a[i]^b[i];
//        }
//    }
//    public static void main(String[] args) {
//        FunctionTask x = new FunctionTask();
//        int[] c = new int[]{12,13,14,15,16};
//        int[] d = new int[]{32,33,34,35,36};
//        x.exchangeArray(c,d);
//        for(int v:c){
//            System.out.println(v);
//        }
//        for(int v:d){
//            System.out.println(v);
//        }
//    }
}
