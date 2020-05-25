package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {

//        int[] arr = new int[]{1,9,4,6,15,6,3,7};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[800000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*80000000);
        }

        long time1 = System.currentTimeMillis();
        radixSort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);
        //八十万数据548毫秒 八百万数据565毫秒 八千万数据会出现OutOfMemoryError

    }

    //基数排序思路：
    //将数组所有元素统一为同样的数组长度，数位短的数前面补零。然后从最低位开始，依次进行一轮排序。
    //这样从最低位到最高位排完后，数组就变成一个有序序列。
    private static void radixSort(int[] arr){
        //1.计算出最大值的位数
        int max = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = (""+max).length();

        //2.创建需要的数组
        //  创建一个二维数组 外层10列正好代表0-9十个桶
        //  每一列的行数设置为arr.length个（极端情况：数组中全部元素的某一位都等于一个数时）
        int[][] bucket = new int[10][arr.length];
        //  创建一个数组 记录每一个桶中存放元素的个数 一开始都为零
        int[] countBucket = new int[10];

        //3.开始循环操作
        //最大数有几位 就循环几轮  第一轮：个位  第二轮：十位  第三轮：百位
        for(int i = 0;i < maxLength;i++){
            //循环处理每一个元素的当前位
            for(int j = 0;j < arr.length;j++){
                //计算出元素当前位的数字
                int curPosDigit = arr[j]/(int)Math.pow(10,i)%10;
                //把元素存入对应的桶中
                bucket[curPosDigit][countBucket[curPosDigit]] = arr[j];
                //计数器加一
                countBucket[curPosDigit]++;
            }
            //把桶中的元素依次放回去
            int index = 0;//往数组复制元素时用
            for(int k = 0;k < 10;k++){
                if(countBucket[k] != 0){
                    for(int l = 0;l < countBucket[k];l++){
                        arr[index++] = bucket[k][l];
                    }
                    //每一次复制完之后把当前位的计数器清零！！！ 整个循环结束之后 所有计数器清零
                    countBucket[k] = 0;
                }
            }
        }
    }
}
