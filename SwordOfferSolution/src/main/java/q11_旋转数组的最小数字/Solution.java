package q11_旋转数组的最小数字;

public class Solution {


    //方法一：从后往前，暴力匹配
    public int minArray1(int[] numbers) {
        //temp指针默认指向最后一位
        int temp = numbers.length - 1;
        while (temp > 0 && numbers[temp] >= numbers[temp - 1])
            //指针前移
            temp--;
        return numbers[temp];
    }

    //方法二：二分+暴力匹配法
    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                //最小值一定在右侧，且一定不是mid，所以 left = mid + 1
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                //最小值一定在左侧，但不确定mid是不是最小值，所以 right = mid
                right = mid;
            } else {
                //不能确定在左侧还是右侧，暴力缩小范围
                right--;
            }
        }
        return numbers[left];
    }
}
