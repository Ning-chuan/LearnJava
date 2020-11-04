package q7_重建二叉树;

import java.util.HashMap;

public class Solution {

    int[] preorder;
    //存放中序遍历元素值和对应索引 key=元素值 value=中序遍历索引
    HashMap<Integer, Integer> inIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int length = preorder.length;
        //中序遍历结果存入inIndexMap
        for(int i = 0; i < length; i++)
            inIndexMap.put(inorder[i], i);

        return buildTree(0, 0, length - 1);
    }

    /**
     *
     * @param nodePreIndex 当前节点在前序遍历数组中的索引
     * @param left 中序遍历左边界
     * @param right 中序遍历右边界
     * @return 生成的节点
     */
    TreeNode buildTree(int nodePreIndex, int left, int right) {
        if(left > right) return null;
        int nodeVal = preorder[nodePreIndex];
        //根据节点值创建当前节点
        TreeNode node = new TreeNode(nodeVal);
        //获取当前节点中序遍历的索引
        int nodeInIndex = inIndexMap.get(nodeVal);
        //递归创建当前节点的左、右子树
        node.left = buildTree(nodePreIndex + 1, left, nodeInIndex - 1);
        //nodeIndex-left表示左子树节点个数
        //nodePreIndex+nodeIndex-left+1 理解为：当前节点前序索引+左子树节点个数+1 也就是右子节点的索引
        node.right = buildTree(nodePreIndex + nodeInIndex - left + 1, nodeInIndex + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Solution().buildTree(preorder, inorder);
        System.out.println("treeNode = " + treeNode);
    }



}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}