public class FunctionTask {
    //10.设计一个方法 用来实现用户登录认证(二维数组当作小数据库)
    public String register(String user,String password){
        String[][] data = {{"宁川","888"},{"西安科技大学","666"},{"建筑设计","555"},};
        String result = null;
        boolean a = true;
        for(int i=0;i<data.length;i++){
            if(user.equals(data[i][0])){
                if(password.equals(data[i][1])){
                    result = "登陆成功";
                    a = false;
                }
                break;
            }
        }
        if(a){
            result = "用户名或密码错误";
        }
        return result;
    }

    public static void main(String[] args) {
        FunctionTask f = new FunctionTask();
        String result = f.register("建筑设计","555");
        System.out.println(result);
    }
//    //9.设计一个方法  用来给数组元素排序(冒泡排序算法)
//    public int[] sequenceArray(int[] a,String order){
//
//        for(int i=1;i<a.length;i++){
//            for(int j=a.length-1;j>=i;j--){
//                if(order.equals("升序")) {
//                    if (a[j] < a[j - 1]) {
//                        a[j] = a[j] ^ a[j - 1];
//                        a[j - 1] = a[j] ^ a[j - 1];
//                        a[j] = a[j] ^ a[j - 1];
//                    }
//                }
//                if(order.equals("降序")) {
//                    if (a[j] > a[j - 1]) {
//                        a[j] = a[j] ^ a[j - 1];
//                        a[j - 1] = a[j] ^ a[j - 1];
//                        a[j] = a[j] ^ a[j - 1];
//                    }
//                }
//            }
//        }
//        return a;
//    }
//
//    public static void main(String[] args) {
//        int[] array = {5,4,9,16,7,3,6,13,66,30,2,6};
//        FunctionTask f = new FunctionTask();
//        int[] finalArray = f.sequenceArray(array,"降序");
//        for(int v:finalArray){
//            System.out.println(v);
//        }
//
//    }

//    //8.设计一个方法  用来存储给定范围内的素数(2-100)
//    public int[] savePrime(){
//        int[] temporaryArray = new int[50];
//        int index = 0;
//        for(int num=2;num<99;num++){
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
//                temporaryArray[index++] = num;
//            }
//        }
//        int[] finalArray = new int[index];
//        for(int i=0;i<finalArray.length;i++){
//            finalArray[i] = temporaryArray[i];
//        }
//        return finalArray;
//    }
//
//    public static void main(String[] args) {
//        FunctionTask f = new FunctionTask();
//        int[] primeArray = f.savePrime();
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
//    public int[] combineArray(int[] a,int[] b){
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
//    public boolean FindArray(int a){
//
//    }
//
//
//
//
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
