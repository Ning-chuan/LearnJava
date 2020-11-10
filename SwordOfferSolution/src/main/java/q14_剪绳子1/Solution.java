package q14_剪绳子1;

/**
 * LeetCode地址：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class Solution {
    public int cuttingRope(int n) {
        //n==2时结果为1  n==3时结果为2
        if (n <= 3) return n - 1;
        //a表示n中有多少个3
        int a = n / 3;
        //b为余数
        int b = n % 3;
        //情况一：余数为0，正好除尽，所以结果为3^a
        if (b == 0) return (int) Math.pow(3, a);
        //情况二：余数为1，因为 3*1 < 2*2，所以取出一个3和1组合，变为2*2，结果为(3^(a-1))*4
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        //情况三：余数为2，不再拆分
        return (int) Math.pow(3, a) * 2;
    }
}
