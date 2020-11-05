package q10_青蛙跳台阶问题;

/**
 * LeetCode地址：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int a = 1, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
