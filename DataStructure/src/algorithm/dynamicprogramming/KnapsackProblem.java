package algorithm.dynamicprogramming;

public class KnapsackProblem {
    public static void main(String[] args) {
        //分别表示吉他G、音响S、电脑L的重量
        int[] w = {1, 4, 3};
        //分别表示吉他G、音响S、电脑L的价格
        int[] value = {1500, 3000, 2000};
        int size = 4;//背包容量
        int num = w.length;//物品个数
        //v[i][j]表示前i个物品中能装入容量为j的背包的组合最大价值
        int[][] v = new int[num + 1][size + 1];
        //用于标记物品的存放情况
        int[][] mark = new int[num + 1][size + 1];

        //遍历v
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }

        //动态规划求解：
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (j < w[i - 1]) {
                    //注意i从1开始，所以物品索引应该时i-1
                    //此时物品重量比背包的容量还大，肯定不能加此物品，最大价值使用上一次计算的值
                    v[i][j] = v[i - 1][j];
                } else {
                    //此时物品重量小于等于背包容量，最大价值需要进行如下计算
                    //参数一：不加此物品的最大价值； 参数二：加入此物后的最大价值
                    //v[i][j] = Math.max(v[i-1][j],value[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i - 1][j] < value[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = value[i - 1] + v[i - 1][j - w[i - 1]];
                        //此时加入了物品，需要修改标记
                        mark[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //遍历v
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("======================================");
        //输出价值最大时，哪些物品放入了背包
        int i = mark.length - 1;//行最大值 即从最后一个物品开始
        int j = mark[0].length - 1;//列最大值 即从容量最大开始
        while (i > 0 && j > 0) {
            if(mark[i][j] == 1){
                System.out.println("第"+i+"个物品放入背包");
                j -= w[i-1];//减去该物品的重量
            }
            i--;//看上一个物品
        }


        /*
        //遍历mark
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[0].length; j++) {
                System.out.print(mark[i][j] + "\t");
            }
            System.out.println();
        }

         */



    }
}
