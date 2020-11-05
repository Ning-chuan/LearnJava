package q10_斐波那契数列;

import java.util.HashMap;

/**
 * LeetCode地址：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Solution {

    //方法一：额外数组
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] value = new int[n + 1];
        value[0] = 0;
        value[1] = 1;
        for (int i = 2; i <= n; i++) {
            //前提：(a + b) % p = (a % p + b % p) % p
            value[i] = (value[i - 1] + value[i - 2]) % 1000000007;
        }
        return value[n];
    }

    //方法二：动态规划
    public int fib2(int n) {
        if (n == 0) return 0;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
