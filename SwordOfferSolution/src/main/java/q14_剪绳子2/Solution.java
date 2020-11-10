package q14_剪绳子2;

/**
 * LeetCode地址：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
