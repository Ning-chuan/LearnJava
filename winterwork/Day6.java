package winterwork;

import java.util.Arrays;
import java.util.Stack;

public class Day6 {
    //4 有序数组的平方
    //给定一个按非递减顺序排序的整数数组 A，
    //返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    public int[] sortedSquares(int[] A) {
        //方法二 双指针
        int start = 0;
        int end = A.length-1;
        int[] result = new int[A.length];
        int i = end;//记录填入result个数
        while(i>=0){//由于数组本身的特点 只能从后往前排
            if(A[start]*A[start]>=A[end]*A[end]){
                result[i--] = A[start]*A[start++];
            }else{
                result[i--] = A[end]*A[end--];
            }
        }
        return result;

        //方法一 先平方 再排序
//        for(int i=0;i<A.length;i++){
//            A[i] *= A[i];
//        }
//        Arrays.sort(A);
//        return A;
    }



    //5 仅仅反转字母
    //给定一个字符串 S，返回 “反转后的” 字符串
    //其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
    //输入："a-bC-dEf-ghIj"
    //输出："j-Ih-gfE-dCba"
    public String reverseOnlyLetters(String S) {
//        //方法一 反转指针
//        StringBuilder ans = new StringBuilder();
//        int j = S.length()-1;
//        for(int i=0;i<S.length();i++){
//            if(Character.isLetter(S.charAt(i))){
//                while(!Character.isLetter(S.charAt(j))){
//                    j--;
//                }
//                ans.append(S.charAt(j--));
//            }else{
//                ans.append(S.charAt(i));
//            }
//        }
//        return ans.toString();


        //方法二 字母栈
        Stack<Character> letters = new Stack();
        for(char v:S.toCharArray()){
            if(Character.isLetter(v)){
                letters.push(v);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char v:S.toCharArray()){
            if(Character.isLetter(v)){
                ans.append(letters.pop());
            }else{
                ans.append(v);
            }
        }
        return ans.toString();
    }
}
