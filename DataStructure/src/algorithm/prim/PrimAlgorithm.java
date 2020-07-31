package algorithm.prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        MGraph graph = new MGraph(7);
        graph.vertex = new char[]{'A','B','C','D','E','F','G'};
        //初始化图的边 10000表示这条边不连通
        graph.setWeight(new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        });
        //展示图
        //graph.showGraph();

        getMST(graph,1);

    }

    /**
     * 利用普利姆算法(Prim)求最小生成树
     * MST: Minimum Cost Spanning Tree
     */
    public static void getMST(MGraph graph, int start) {
        //定义一个int[] 记录节点是否访问过  0:未访问(默认)   1:已访问
        int[] visited = new int[graph.vertexNum];
        //标记当前节点为已访问
        visited[start] = 1;

        //初始化minWeight为一个较大的数，便于后面替换
        int minWeight = 10000;
        //h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;

        //核心步骤：
        //最外层循环表示总共需要找 vertexNum-1 条边(n-1)
        for (int k = 1; k < graph.vertexNum; k++) {

            //里面两次循环的目标：找到已访问节点中与剩余未访问节点路径(权值)的最小值，并将此最短路径联通
            //外层循环可以理解为遍历已访问节点
            for (int i = 0; i < graph.vertexNum; i++) {
                //里层循环可以理解为遍历与已访问节点相连的未访问节点
                for (int j = 0; j < graph.vertexNum; j++) {
                    //前两个条件的意思是i节点必须是已访问节点，j必须是未访问节点，才能比较这两个节点间路径的大小
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            //上面两层循环结束，就找到了本次的最短路径以及顶点的下标
            System.out.println("边【"+graph.vertex[h1]+","+graph.vertex[h2]+"】==>权值："+minWeight);
            //标记h2为已访问 （h1已经访问过了，不用标记）
            visited[h2] = 1;
            //重置minWeight
            minWeight = 10000;
        }

    }
}

class MGraph {
    int vertexNum;//存放顶点个数
    char[] vertex;//存放顶点
    int[][] weight;//存放边，邻接矩阵的形式

    //构造方法：
    public MGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.vertex = new char[vertexNum];
        this.weight = new int[vertexNum][vertexNum];
    }

    //设置边的方法：
    public void setWeight(int[][] weight) {
        this.weight = weight;
    }

    //展示图的方法：
    public void showGraph(){
        if(weight == null){
            return;
        }
        for(int[] row : weight){
            System.out.println(Arrays.toString(row));
        }
    }
}
