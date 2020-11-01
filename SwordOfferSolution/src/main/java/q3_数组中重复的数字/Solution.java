package q3_数组中重复的数字;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 方法一：hash表 + 循环
     * 时间复杂度：O(n)
     */
    public int findRepeatNumber1(int[] nums) {
        //1. 初始化map集合，用于存储数组中的数字
        HashMap<Integer, Integer> map = new HashMap<>();
        //2. 初始化repeat = -1用于存储重复的数字
        int repeat = -1;
        //3. 遍历数组
        for (int num : nums) {
            // 如果获取到了，说明之前存过，即当前元素重复了
            if (map.get(num) != null) {
                // 保存这个数字并打断循环
                repeat = num;
                break;
            }
            //把当前元素存入map
            map.put(num, 1);
        }
        //4. 循环结束，返回repeat
        return repeat;
    }

    /**
     * 方法二：临时数组
     */
    public int findRepeatNumber2(int[] nums) {
        int repeat = -1;
        int[] temp = new int[nums.length];
        for (int num : nums) {
            temp[num]++;
            if (temp[num] > 1) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 方法三：原地置换
     */
    public int findRepeatNumber3(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

/*    //方法三的第二种写法：
    public int findRepeatNumber3(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            //位置正确
            if (i == nums[i]) {
                continue;
            }
            //发现重复，直接返回
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            //交换
            temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
            //这里的i--是为了抵消掉上面的i++，
            //交换之后需要原地再比较
            i--;
        }
        return -1;
    }*/

}
