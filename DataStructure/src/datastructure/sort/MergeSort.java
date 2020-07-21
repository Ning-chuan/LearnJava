package datastructure.sort;

public class MergeSort {
    
    public static void main(String[] args) {

        int[] arr = new int[800000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        long time1 = System.currentTimeMillis();
        mergeSort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);//80万个数据125毫秒


//        int[] arr = new int[]{1,9,4,6,15,6,3,-5};
//        mergeSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序是稳定排序，也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
     * java中Arrays.datastructure.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
     * 从上文的图中可看出，每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。
     * 总的平均时间复杂度为O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
     *
     */

    private static void mergeSort(int[] arr){
        //统一创建一次临时数组 避免后面频繁创建
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }


    private static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);//左边归并排序 使左子序列有序
            mergeSort(arr,mid+1,right,temp);//右边归并排序 使右子序列有序
            merge(arr,left,right,temp);//将两个有序子数组合并
        }
    }
    
    private static void merge(int[] arr,int left,int right,int[] temp){
        int i = left;
        int mid = (left+right)/2;
        int j = mid+1;
        int count = 0;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[count++] = arr[i];
                i++;
            }else{
                temp[count++] = arr[j];
                j++;
            }
        }
        while(i <= mid){
            temp[count++] = arr[i++];
        }
        while(j <= right){
            temp[count++] = arr[j++];
        }
        //将排好序的临时数组的值赋给元素组
        count = 0;
        while(left <= right){
            arr[left++] = temp[count++];
        }
    }
    
}
