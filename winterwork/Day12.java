package winterwork;

public class Day12 {
    //4 最短无序连续子数组
        //https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
        public int findUnsortedSubarray(int[] nums) {
            int max = nums[0];
            int min = nums[nums.length-1];
            int left = 0, right = -1;
            for(int i=0;i<nums.length;i++){
                if(max>nums[i]){
                    right = i;
                }else{
                    max = nums[i];
                }
                if(min<nums[nums.length-i-1]){
                    left = nums.length-i-1;
                }else{
                    min = nums[nums.length-i-1];
                }
            }
            return right-left+1;
    }

    //5 逆波兰表达式求值
    //根据逆波兰表示法，求表达式的值。
    //有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    public int evalRPN(String[] tokens) {












    }
}
