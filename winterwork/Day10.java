package winterwork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {
    //4 字符串转换整数
    //https://leetcode-cn.com/problems/string-to-integer-atoi/
    public int myAtoi(String str) {
        //方法一 正则表达式
//清空字符串开头和末尾空格（这是trim方法功能，事实上我们只需清空开头空格）
        str = str.trim();
        //java正则表达式
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(str);
        int value = 0;
        //判断是否能匹配
        if (m.find()){
            //字符串转整数，溢出
            try {
                value = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch (Exception e){
                //由于有的字符串"42"没有正号，所以我们判断'-'
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }
        return value;




//        char[] c = str.trim().toCharArray();
//        StringBuilder result = new StringBuilder();
//        //int i = 0;
//        for(int i=0;i<c.length;i++){
//            if((c[i]>=0 && c[i]<=9) || c[i]=='-' || c[i]=='+'){
//                result.append(c[i]);
//                for(int j=i+1;j<c.length;j++){
//                    if((c[j]>=0 && c[j]<=9)) {
//                        result.append(c[j]);
//                    }else{
//                        break;
//                    }
//                }
//            }
//        }
    }


    //5 在排序数组中查找元素的第一个和最后一个位置
    //给定一个按照升序排列的整数数组 nums ，和一个目标值 target 。
    //找出给定目标值在数组中的开始位置和结束位置。
    //你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1] .
    //https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length;
        while(left<right){//先寻找左边的(第一次出现的)index
            int mid = (left+right)/2;
            if (nums[mid]==target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }
        }
        if(left==nums.length || nums[left]!=target){
            return new int[]{-1,-1};//说明不存在，不必再寻找右值，直接返回
        }
        int start = left;
        //接下来寻找右边的index
        left = 0;
        right = nums.length;
        while(left<right){
            int mid = (left+right)/2;
            if (nums[mid]==target){
                left = mid+1;//只有这一行与寻找左值时不一样
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }
        }
        int end = left-1;
        return new int[]{start,end};
    }
}
