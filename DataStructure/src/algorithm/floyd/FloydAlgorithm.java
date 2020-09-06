package algorithm.floyd;

import java.util.Arrays;

public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;//用这个常量表示两点无法连通
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        Graph graph = new Graph(vertex, matrix);
        graph.show();

        graph.floyd();

        System.out.println();
        graph.show();

    }
}

class Graph{
    private int length;
    private char[] vertex;//顶点数组
    private int[][] dis;//存储各个顶点之间的距离 最后的结果也存储在里面
    private int[][] pre;//存储到达此节点的前驱节点

    public Graph(char[] vertex,int[][] matrix){
        this.length = vertex.length;
        this.vertex = vertex;
        this.dis = matrix;

        //初始化前驱节点
        this.pre = new int[length][length];
        for (int i = 0; i < this.length; i++) {
            Arrays.fill(pre[i],i);//默认前驱节点都是自身
        }
    }
    
    //展示图
    public void show(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(vertex[i] + "到" + vertex[j] + "距离:" + dis[i][j] + ",前驱:" + vertex[pre[i][j]]+"\t\t");
            }
            System.out.println();
        }
    }

    //佛洛依德算法：
    //求出各个顶点到其他各个顶点的距离
    public void floyd(){
        int len = 0;//记录距离的变量
        //核心：三层for循环
        //最外层循环把各个顶点作为中间节点的情况考虑一遍[A,B,C,D,E,F]
        for (int k = 0; k < this.length; k++) {
            //出发顶点i  [A,B,C,D,E,F]
            for (int i = 0; i < this.length; i++) {
                //到达顶点j  [A,B,C,D,E,F]
                for (int j = 0; j < this.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if(len < dis[i][j]){
                        //如果k作为中间节点，i到j的距离小于之前i到j的距离，那么更新dis和pre
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
