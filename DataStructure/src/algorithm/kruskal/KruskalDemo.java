package algorithm.kruskal;

public class KruskalDemo {
    //表示边的个数
    private int edgeNum;
    //表示顶点的数组
    private char[] vertexes;
    //表示顶点个数
    private int vertexNum;
    //邻接矩阵表示边之间的关系
    private int[][] matrix;
    //INF表示两个顶点之间不连通
    private static final int INF = Integer.MAX_VALUE;

    //构造器：
    public KruskalDemo(char[] vertexes, int[][] matrix) {
        //为了安全都采用深拷贝的方式赋值
        //1.记录顶点个数
        this.vertexNum = vertexes.length;
        //2.初始化顶点数组：
        this.vertexes = new char[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            this.vertexes[i] = vertexes[i];
        }
        //3.初始化矩阵：
        this.matrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //4.初始化边数：
        for (int i = 0; i < vertexNum; i++) {
            //从i+1开始 即只统计右上三角部分 避免了重复和自身的统计
            for (int j = i + 1; j < vertexNum; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //测试：
    public static void main(String[] args) {
        char[] vertexes = {'A','B','C','D','E','F','G'};
        int matrix[][] = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        KruskalDemo kruskalDemo = new KruskalDemo(vertexes,matrix);
        kruskalDemo.showMatrix();
        kruskalDemo.kruskal();

    }

    //核心算法：
    public void kruskal(){
        //记录结果的数组，边数一定是：顶点个数—1
        Edge[] res = new Edge[vertexNum - 1];
        //结果数组的索引
        int index = 0;
        //1.获取图中所有的边并排序
        Edge[] edges = getEdges();
        sortEdges(edges);
        //2.遍历排好序的边，如果没有构成回路（不是同一个终点），就加入结果数组
        //  ends存储每个节点终点的索引，因为一开始一条边都没有加入，所以所有节点的终点都是自身，即数组元素都为0
        int[] ends = new int[vertexNum];
        for (int i = 0; i < edges.length; i++) {
            //2.1获取当前边 两个节点的索引
            int p1 = indexOfVertex(edges[i].start);
            int p2 = indexOfVertex(edges[i].end);
            //2.2获取两个节点的终点
            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            //2.3如果终点不同，即不能构成回路，加入结果数组
            if(m != n){
                res[index++] = edges[i];
                //注意加入这条边后，不要忘了设置m的终点为n，因为n的终点是自己，所以不用再设置n了
                ends[m] = n;
            }
        }
        //输出求出的结果 边【E,F】 边【C,D】 边【D,E】 边【B,F】 边【E,G】 边【A,B】
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    //==============================================================================
    //为核心算法服务的方法：
    //方法：获取顶点的索引
    public int indexOfVertex(char vertex){
        for (int i = 0; i < vertexNum; i++) {
            if(vertexes[i] == vertex){
                return i;
            }
        }
        //没有找到 返回-1
        return -1;
    }

    //方法：获取某个顶点在最小生成树中的终点
    //ends表示存储每个节点终点的数组  index表示某个节点的索引
    public int getEnd(int[] ends,int index){
        while(ends[index] != 0){
            index = ends[index];
        }
        //退出循环，这个节点的终点是0，就说明这个节点没有终点，他自己就是终点
        return index;
    }

    //方法：获取图中所有的边
    public Edge[] getEdges() {
        //记录结果的数组
        Edge[] edges = new Edge[edgeNum];
        //索引
        int index = 0;
        for (int i = 0; i < vertexNum; i++) {
            //从i+1开始 即只统计右上三角部分 避免了重复和自身的统计
            for (int j = i + 1; j < vertexNum; j++) {
                if (matrix[i][j] != INF) {
                    //由于是从 i+1 开始的，所以较前的点是i 后点是j
                    edges[index++] = new Edge(vertexes[i], vertexes[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //方法：把边按其权重升序排列
    public void sortEdges(Edge[] edges) {
        //采用冒泡排序：
        Edge temp;
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    //方法：展示矩阵
    public void showMatrix(){
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    //内部类 表示一条边
    private class Edge {
        private char start;
        private char end;
        private int weight;

        public Edge(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        public String toString(){
            return "边【"+this.start+","+this.end+"】权重=>"+this.weight;
        }
    }
}
