package winterwork;

public class Day2 {
    //4 移除元素
    //给定一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    //示例：给定 nums = [0,1,2,2,3,0,4,2], val = 2
    //函数应该返回新的长度5,并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
    //注意这五个元素可为任意顺序。
    //你不需要考虑数组中超出新长度后面的元素。
    public int removeElement(int[] nums, int val) {
        //方法一：
//        int i = 0;
//        for(int j=0;j<nums.length;j++){
//            if(nums[j]!=val){
//                nums[i++] = nums[j];
//            }
//        }
//        return i;

        //方法二：
        //示例：给定 nums = [0,1,2,2,3,0,4,2], val = 2
        //函数应该返回新的长度5,并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
        int i = 0;
        int n = nums.length;
        while(i<n){
            if(nums[i]==val){
                nums[i] = nums[n-1];
                n--;//数组长度减一
            }else{
                i++;
            }
        }
        return n;
    }

    //5 搜索插入位置
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    //如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //你可以假设数组中无重复元素。
    //输入: [1,3,5,7，9], 4
    //输出: 3
    public int searchInsert(int[] nums, int target) {
        //普通方法：
//        for(int i=0;i<nums.length;i++){
//            if(target<=nums[i]){
//                return i;
//            }
//        }
//        return nums.length;
        //二分查找：
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if(target<nums[(left+right)/2]){
                right = (left+right)/2-1;
            }else if(target>nums[(left+right)/2]){
                left = (left+right)/2+1;
            }else{
                return (left+right)/2;
            }
        }
        return left;
    }

    //========================================================================
    public static void main(String[] args){
        Day2 d = new Day2();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int length = d.removeElement(nums,2);
        System.out.println(length);
        for(int v:nums){
            System.out.println(v);
        }
    }
}
