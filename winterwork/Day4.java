package winterwork;

public class Day4 {
    //4. 最后一个单词的长度
    //给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
    //如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
    //如果不存在最后一个单词，请返回 0 。
    //说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。4
    public int lengthOfLastWord(String s) {
        String newString = s.trim();
        String[] values = newString.split(" ");
        return values[values.length-1].length();
    }

    //5给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中
    //使得 num1 成为一个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //方法三： 双指针(从nums1的最后一位开始填)
        int p = m+n-1;//指向nums1的最后一位
        int p1 = m-1;//指向nums1有效元素的最后一个
        int p2 = n-1;//指向nums2有效元素的最后一个

        while(p1>=0 && p2>=0){
            nums1[p--] = (nums1[p1]>nums2[p2])?nums1[p1--]:nums2[p2--];
        }
        //上面循环结束 如果nums2中还有元素没有填进去(nums1中最小的元素也比nums2中元素大时会有这种情况)
        //把nums2中剩余的元素复制进nums1
        System.arraycopy(nums2,0,nums1,0,p2+1);


        //方法二 双指针
        //临时保存数组一的元素
//        int[] nums1_copy = new int[m];
//        System.arraycopy(nums1,0,nums1_copy,0,m);
//
//        int p = 0;//指向nums1
//        int p1 = 0;//指向nums1_copy
//        int p2 = 0;//指向nums2
//
//        while(p1<m && p2<n){
//            //从两个数组的第一个元素开始比较，把小的填进去。每填一次，相应的指针后移一个
//            nums1[p++] = (nums1_copy[p1]<nums2[p2])?nums1_copy[p1++]:nums2[p2++];
//        }
//        if(p1<m){
//            System.arraycopy(nums1_copy,p1,nums1,p,m-p1);
//        }
//        if(p2<n){
//            System.arraycopy(nums2,p2,nums1,p,n-p2);
//        }




        //方法一 冒泡排序 缺点:没有利用数组本身有序的特性
//        for(int i=0;i<n;i++){
//            nums1[m+i] = nums2[i];
//        }
//        for(int i=0;i<m+n;i++){
//            for(int j=m+n-1;j>i;j--){
//                if(nums1[j]<=nums1[j-1]){
//                    int temp = nums1[j];
//                    nums1[j] = nums1[j-1];
//                    nums1[j-1] = temp;
//                }
//            }
//        }
    }
}
