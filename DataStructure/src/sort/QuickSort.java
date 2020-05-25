package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,9,4,6,15,6,3,-5};
//        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        long time1 = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);//八十万141毫秒  八百万数据1297毫秒
    }

    //快速排序思路：
    //  找一个中间值 把数组分成两部分 每次循环把小于中间值的都放在左边 大的都放在右边
    //  对已分开的两部分递归调用本方法 继续分 递归结束时 数组也排好了顺序
    private static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        int temp;
        while(l < r){
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if(l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(arr[r] == pivot){
                l++;
            }
            if(arr[l] == pivot){
                r--;
            }
        }
        if(r == l){
            r--;
            l++;
        }
        if(r > left){
            quickSort(arr,left,r);
        }
        if(l < right){
            quickSort(arr,l,right);
        }
    }
}
