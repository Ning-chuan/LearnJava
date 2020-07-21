package datastructure.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,9,4,6,15,6,3,-5};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[8000000];
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = (int)(Math.random()*8000000);
//        }
//
//        long time1 = System.currentTimeMillis();
//        quickSort(arr,0,arr.length-1);
//        long time2 = System.currentTimeMillis();
//
//        System.out.println(time2-time1);//八十万141毫秒  八百万数据1265毫秒
    }

    //快速排序思路：
    //  找一个基准值(可以是左/右/中间/随机值) 把数组分成两部分 每次循环把小于中间值的都放在左边 大的都放在右边
    //  对已分开的两部分递归调用本方法 继续分 递归结束时 数组也排好了顺序
    //做法一:以左值为基准值
    private static void quickSort(int[] arr,int low,int high){
        if(low < high){
            int index = getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }
    private static int getIndex(int[] arr,int low,int high){
        int temp = arr[low];//基准值 以最左边为基准
        while(low < high){
            //从后向前 找到小于基准值的元素为止(在low<high的前提下)
            while(low < high && arr[high] >= temp){
                high--;
            }
            arr[low] = arr[high];
            //从前往后 找到大于基准值的元素为止(在low<high的前提下)
            while(low < high && arr[low] <= temp){
                low++;
            }
            arr[high] = arr[low];
        }
        //循环结束 low==high 这个位置即为基准值应当插入的位置
        arr[low] = temp;
        return low;
    }




    //做法二:
//    private static void quickSort(int[] arr,int left,int right){
//        int l = left;
//        int r = right;
//        int pivot = arr[(left+right)/2];
//        int temp;
//        while(l < r){
//            while(arr[l] < pivot){
//                l++;
//            }
//            while(arr[r] > pivot){
//                r--;
//            }
//            if(l >= r){
//                break;
//            }
//            temp = arr[l];
//            arr[l] = arr[r];
//            arr[r] = temp;
//            if(arr[r] == pivot){
//                l++;
//            }
//            if(arr[l] == pivot){
//                r--;
//            }
//        }
//        if(r == l){
//            r--;
//            l++;
//        }
//        if(r > left){
//            quickSort(arr,left,r);
//        }
//        if(l < right){
//            quickSort(arr,l,right);
//        }
//    }
}
