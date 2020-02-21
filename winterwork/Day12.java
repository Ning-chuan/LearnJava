package winterwork;

public class Day12 {
    //4 最短无序连续子数组
        //https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
        public int findUnsortedSubarray(int[] nums) {
            int start = 0;
            int end = nums.length-1;
            while(nums[start]<nums[start+1]){
                start++;
            }
            while(nums[end] > nums[end-1]){
                end--;
            }
            return end-start+1;
    }
}
