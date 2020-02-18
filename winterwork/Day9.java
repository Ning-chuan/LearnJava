package winterwork;

import java.util.HashMap;
import java.util.Map;

public class Day9 {
    //4 两数之和
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    public int[] twoSum(int[] nums, int target) {
        //方法二
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{i,map.get(complement)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");



//        //方法一
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
    }

        //5 二进制求和
        //给定两个二进制字符串，返回他们的和（用二进制表示）。
        //输入为非空字符串且只包含数字 1 和 0。
        public String addBinary(String a, String b) {
            if(a.length()<b.length()){
                return addBinary(b,a);//保证a的长度大于b 便于下面的循环
            }
            StringBuilder result = new StringBuilder();
            int carry = 0;//定义进位 刚开始时为零
            int i = a.length()-1;
            int j = b.length()-1;
            while(i>-1){
                if(a.charAt(i)=='1'){
                    carry++;
                }
                if(j>-1 && b.charAt(j)=='1'){
                    carry++;
                }
                i--;
                j--;
                result.append((carry%2==0)?'0':'1');
                carry /= 2;//计算下一次循环的进位
            }
            if(carry==1){
                result.append('1');
            }
            return result.reverse().toString();
        }
}
