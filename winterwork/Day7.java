package winterwork;

public class Day7 {
    //4 按奇偶排序数组
    //给定一个非负整数数组 A，返回一个数组，在该数组中，
    //A 的所有偶数元素之后跟着所有奇数元素。
    //你可以返回满足此条件的任何数组作为答案。
    //输入：[3,1,2,4]
    //输出：[2,4,3,1]
    //输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
    public int[] sortArrayByParity(int[] A) {
        //方法一
//        int[] ans = new int[A.length];
//        int start = 0;
//        int end = A.length-1;
//        for(int i=0;i<A.length;i++){
//            if(A[i]%2==0){
//                ans[start++]=A[i];
//            }else{
//                ans[end--]=A[i];
//            }
//        }
//        return ans;

        //方法二
        int i = 0;
        int j = A.length-1;
        while(i<j){
            if(A[i]%2>A[j]%2){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            if(A[i]%2==0){
                i++;
            }
            if(A[j]%2==1){
                j--;
            }
        }
        return A;
    }


    //5 寻找数组的中心索引
    //给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
    //我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
    //如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int v:nums){
            sum+=v;
        }
        int leftSum = 0;
        for(int i=0;i<nums.length;i++){
            if(leftSum==sum-nums[i]-leftSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }




}
