package algorithm.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
//        String str = "ABCABB";
//        int[] next = getNext(str);
//        System.out.println(Arrays.toString(next));

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = getNext(str2);
        System.out.println(Arrays.toString(next));//[0, 0, 0, 0, 1, 2, 0]

        int i = KMPSearch(str1, str2, next);
        System.out.println(i);

    }

    public static int KMPSearch(String str1, String str2, int[] next) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            //注意：下面的while循环是核心代码
            while (count > 0 && str1.charAt(i) != str2.charAt(count)) {
                count = next[count-1];
            }
            if (str2.charAt(count) == str1.charAt(i)) {
                if(count == str2.length()-1){
                    return i-count;
                }
                count++;
            }
        }
        return -1;
    }

    /**
     * 求字符串的部分匹配表
     */
    public static int[] getNext(String str) {
        int[] next = new int[str.length()];
        int matchLength = 0;
        for (int i = 1; i < str.length(); i++) {
            //注意：下面的while循环是核心代码
            while (matchLength > 0 && str.charAt(matchLength) != str.charAt(i)) {
                matchLength = next[matchLength - 1];
            }
            if (str.charAt(matchLength) == str.charAt(i)) {
                matchLength++;
            }
            next[i] = matchLength;
        }
        return next;
    }
}
