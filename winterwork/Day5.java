package winterwork;

import java.util.HashSet;

public class Day5 {
    //4 给定一个整数数组，判断是否存在重复元素。
    //如果任何值在数组中出现至少两次，函数返回 true。
    //如果数组中每个元素都不相同，则返回 false。
    public boolean containsDuplicate(int[] nums) {
        //方法一
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]==nums[j]){
//                    return true;
//                }
//            }
//        }
//        return false;

        //方法二
        //对于平衡二叉搜索树（Java 中的 TreeSet 或 TreeMap），search 和 insert 的时间复杂度均为 O(log n)。
        //对于哈希表（Java 中的 HashSet 或 HashMap），search 和 insert 的平均时间复杂度为 O(1)。
        //因此，通过使用哈希表，我们可以达到在线性时间复杂度解决问题。
        HashSet<Integer> set = new HashSet<>(nums.length);
        for(int v:nums){
            if(set.contains(v)){
                return true;
            }
            set.add(v);
        }
        return false;
    }


    //5 你的朋友正在使用键盘输入他的名字 name。
    // 偶尔，在键入字符 char 时，按键可能会被长按，而字符可能被输入 1 次或多次。
    //你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
    public boolean isLongPressedName(String name, String typed) {
        int len_n = name.length();//name长度
        int len_t = typed.length();//typed长度
        if(len_n>len_t){
            return false;
        }
        int p1 = 0;//name指针
        int p2 = 0;//typed指针
        while(p1<len_n && p2<len_t){
            if(name.charAt(p1)==typed.charAt(p2)) {//若果相等，统一后移比下一个
                p1++;
                p2++;
            }else{//如果不相等，typed指针后移一个
                p2++;
            }
        }
        if(p1==len_n){//p1的值加到了name的长度 说明name中每一个字符都可以在typed中找到
            return true;
        }
        return false;
    }

}
