package sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

//        int[] arr = new int[]{1,9,4,6,15,6,3,-5};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        long time1 = System.currentTimeMillis();
        selectSort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);//3062


    }

    //思路： 以升序排列为例
    //第一次选择把最小的数放在第一位 第二次选择把倒数第二小的数放在第二位 依次类推
    //直到第length-1次选择完毕 数组排序成功
    private static void selectSort(int[] arr) {
        int temp;//用于值交换
        //外层循环控制选择的轮次
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //里层循环 每一次都把从i到最后一位的值比较一遍 找到本次的最小值索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //循环完毕 把当前位和最小位的值交换
            if (minIndex != i) {
                //交换之前先判断一下 如果minIndex == i则不必交换
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
