package datastructure.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node node = createHuffmanTree(arr);
        node.preOrder();
    }

    //方法 把一个数组构成 哈夫曼树
    public static Node createHuffmanTree(int[] arr){
        //1.把数组中的每个值构成一个节点 放入list集合中 便于后续处理
        List<Node> nodeList = new ArrayList<>();
        for(int value : arr){
            nodeList.add(new Node(value));
        }
        while(nodeList.size() > 1) {
            //2.升序排序
            Collections.sort(nodeList);
            //3.取出根节点权值最小的两个子树
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);
            //4.以上面取出的两个节点 构建一个新的二叉树 根节点权值为两个节点权值之和
            Node newNode = new Node(leftNode.value + rightNode.value);
            newNode.left = leftNode;
            newNode.right = rightNode;
            //5.删除两个最小节点 添加新节点
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(newNode);
        }
        //循环结束 nodeList只剩一个节点 即为构成新的HuffmanTree的根节点
        return nodeList.get(0);
    }
}

//节点类
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    //前序遍历方法：
    public void preOrder(){
        preOrder(this);
    }
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
