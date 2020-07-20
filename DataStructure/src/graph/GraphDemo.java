package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphDemo {
    public static void main(String[] args) {
        /*
        String[] vertexes = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(5);
        //添加顶点
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,0,1);
        //graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(2,0,1);
        //graph.insertEdge(2,1,1);
        graph.insertEdge(3,1,1);
        graph.insertEdge(4,1,1);

        //展示邻接矩阵
        graph.showEdges();

        graph.dfs();
        */


        String[] vertexes = {"1", "2", "3", "4", "5","6","7","8"};
        Graph graph = new Graph(8);
        //添加顶点
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }

        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        //展示邻接矩阵
        graph.showEdges();

        System.out.println("深度优先遍历：");
        graph.dfs();

        System.out.println("广度优先遍历：");
        graph.bfs();


    }
}

class Graph{
    //存储节点（顶点）的集合
    private ArrayList<String> vertexList;
    //保存邻接矩阵
    private int[][] edges;
    //保存边的数目
    private int edgeNum;

    private boolean[] isVisited;

    //构造方法
    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
    }

    //方法：添加节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //方法：添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNum++;
    }
    //方法：展示邻接矩阵
    public void showEdges(){
        for(int[] row : edges){
            System.out.println(Arrays.toString(row));
        }
    }
    //方法：返回边的数目
    public int getEdgeNum(){
        return edgeNum;
    }

    //方法：深度优先遍历
    public void dfs(){
        //boolean数组每个元素对应每个顶点(节点)的访问状态
        isVisited = new boolean[vertexList.size()];
        //遍历顶点集合 只要有顶点没有被访问过 就进行深度遍历
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    private void dfs(boolean[] isVisited, int i) {
        System.out.print(vertexList.get(i)+"-->");//输出当前节点
        isVisited[i] = true;//标记为已访问
        int w = firstNeighbor(i);//找到第一个邻接节点（索引）
        while(w != -1){//说明找到了邻接节点
            if(!isVisited[w]){
                //以w为顶点为当前节点进行深度优先遍历
                dfs(isVisited,w);
            }
            //找下一个邻接节点
            w = nextNeighbor(i,w);
        }
    }

    //方法：广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        //0.定义所需变量
        int u;//头节点下标
        int w;//邻接节点下标
        LinkedList queue = new LinkedList();//充当队列 存储已经遍历过的节

        //1.输出当前节点
        System.out.print(vertexList.get(i) + "->");
        //2.标记当前节点为已访问
        isVisited[i] = true;
        //3.当前节点入队列
        queue.addLast(i);
        //4.只要队列还有节点，就遍历当前节点那一‘层’的节点，操作如下：
        while (!queue.isEmpty()) {
            //4.1取出队列头节点u
            u = (int) queue.removeFirst();
            //4.2循环遍历u后面的所有邻接节点
            //  找出u的第一个邻接节点w
            w = firstNeighbor(u);
            while (w != -1) {
                //找到了
                if(!isVisited[w]){
                    //没有被访问过
                    System.out.print(vertexList.get(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //找继w后 u的下一个邻接节点
                w = nextNeighbor(u,w);
            }
        }
    }
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }

    }


    //方法：找到第一个邻接节点  index表示当前节点的索引 返回值为第一个邻接节点的索引
    private int firstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i] > 0){
                return i;
            }
        }
        //没找到
        return -1;
    }

    //方法：找到v节点从w节点开始的下一个邻接节点  （w是v的一个邻接节点）
    private int nextNeighbor(int v,int w){
        for (int i = w+1; i < vertexList.size(); i++) {
            if(edges[v][i] > 0){
                return i;
            }
        }
        return -1;
    }

}
