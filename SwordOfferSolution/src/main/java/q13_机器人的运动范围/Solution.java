package q13_机器人的运动范围;

/**
 * LeetCode地址：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        //boolean数组标记是否访问过
        boolean[][] visited = new boolean[m][n];
        return DFS(0, 0, m, n, k, visited);
    }


    private int DFS(int i, int j, int m, int n, int k, boolean[][] visited) {
        //终止条件
        if (i < 0 || i >= m || j < 0 || j >= n || get(i) + get(j) > k || visited[i][j]) return 0;
        //设置当前节点已访问过
        visited[i][j] = true;
        //回溯返回值：1 + 下方搜索的可达解总数 + 右方搜索的可达解总数
        return 1 + DFS(i + 1, j, m, n, k, visited) + DFS(i, j + 1, m, n, k, visited);

    }

    //获取数位之和
    private int get(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
