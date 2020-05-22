package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {

//        int[] arr = new int[]{1,9,4,6,15,6,3,-5};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        long time1 = System.currentTimeMillis();
        insertSort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);//719

    }

    //插入排序基本思路：
    //  把待排序数组看作一个有序表和无序表
    //  一开始有序表只有一个元素（即第一个元素） 无序表有n-1个元素（即数组剩下的所有元素）
    //  每一次排序操作中从无序表中取出第一个元素 与有序表进行比较 找到适当的位置插入
    //  最后形成一个有序数组
    private static void insertSort(int[] arr) {
        int insertIndex;
        int insertVal;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];//保存该次要插入的数 下面的循环要进行多次比较
            insertIndex = i-1;
            while(insertIndex >= 0 && arr[insertIndex] > insertVal){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //循环结束 insertIndex+1 的位置就是要插入的位置
            //插入之前做个简单的判断 如果insertIndex变了 才进行赋值
            if(insertIndex != i-1) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
