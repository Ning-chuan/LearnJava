package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {

//        int[] arr = new int[]{1,9,4,6,15,3,-5};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }


        long time1 = System.currentTimeMillis();
        bubbleSort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);//10805


//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        System.out.println("排序前的时间为：" + simpleDateFormat.format(date1));
//
//        bubbleSort(arr);
//
//        Date date2 = new Date();
//        System.out.println("排序后的时间为："+simpleDateFormat.format(date2));

    }

    private static void bubbleSort(int[] arr) {
        int temp;//交换位置时使用
        boolean flag = false;//用一个标记优化代码
        //外层循环控制轮次
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环每一次冒出一个最大值
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            //如果循环结束 标记没有改变 说明一次也没有交换 即顺序已经ok
            if (!flag) {
                break;
            } else {
                //如果标记变了 需要恢复一下标记 用于下一轮的判断
                flag = false;
            }
        }
    }
}
