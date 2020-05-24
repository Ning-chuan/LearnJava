package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,9,4,6,15,6,3,-5};
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[800000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }

        long time1 = System.currentTimeMillis();
        shellSort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);//移位法16毫秒  交换法8013毫秒  80万个数据187毫秒
    }

    //希尔排序思路：
    //把数组按照步长（增量）分组  在每一组里使用插入排序
    //随着步长依次减小 数组变得部分有序 直到步长为1时 数组就排好了

    //移位法（比交换法快亿点点）  增量（步长）+ 直接插入排序
    private static void shellSort(int[] arr) {
        int cur;//保存当前位的值 后面比较的时候要用
        //设置增量gap（步长）
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //根据设置的增量 分组 每一组采用直接插入排序法
            for (int i = gap; i < arr.length; i++) {
                cur = arr[i];
                int j = i - gap;//从当前位的前一位开始比较（考虑步长）
                while (j >= 0 && arr[j] > cur) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                if (j != i - gap) {
                    arr[j + gap] = cur;
                }
            }
        }
    }


    //交换法（比冒泡排序稍快一点点） 增量（步长）+ 每次都交换
//    private static void shellSort(int[] arr){
//        int temp;
//        //设置步长（增量）
//        for (int gap = arr.length / 2;gap > 0;gap /= 2) {
//            //从当前位
//            for(int i = gap;i < arr.length;i++){
//                for(int j = i - gap;j >= 0;j -= gap){
//                    //从当前位的前一位开始比较 只要发现当前位小于前一位 就交换(考虑步长)
//                    if(arr[j+gap] < arr[j]){
//                        temp = arr[j+gap];
//                        arr[j+gap] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }
//    }

}
