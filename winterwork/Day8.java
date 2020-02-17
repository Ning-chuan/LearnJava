package winterwork;

import java.util.TreeSet;

public class Day8 {
    //4 加一
    //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    //你可以假设除了整数 0 之外，这个整数不会以零开头。
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }


    //5 第三大的数
    //给定一个非空数组，返回此数组中第三大的数。
    //如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
    public int thirdMax(int[] nums) {
        //
        TreeSet<Integer> set = new TreeSet<>();
        for(int v:nums){
            set.add(v);
            if(set.size()>3){
                set.remove(set.first());
            }
        }
        return set.size()<3?set.last():set.first();
    }
}
