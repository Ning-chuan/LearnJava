package tree.binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int value : arr) {
            binarySortTree.addNode(new Node(value));
        }
        binarySortTree.inOrder();
    }

}

class BinarySortTree{
    Node root;

    //添加节点的方法
    public void addNode(Node node){
        if(root == null){
            root = node;
        }else{
            addNode(root,node);
        }
    }
    //自身递归调用的方法
    private void addNode(Node temp,Node target){
        if(target == null){
            return;
        }
        if(target.value < temp.value){
            if(temp.left == null){
                temp.left = target;
            }else{
                addNode(temp.left,target);
            }
        }else{
            //target值不小于temp 放在右边
            if(temp.right == null){
                temp.right = target;
            }else{
                addNode(temp.right,target);
            }
        }
    }

    // 中序遍历方法
    public void inOrder(){
        if (this.root == null) {
            System.out.println("空树，遍历个寂寞");
        }else{
            inOrder(root);
        }
    }
    private void inOrder(Node node){
        if(node.left != null){
            inOrder(node.left);
        }
        System.out.println(node);
        if(node.right != null){
            inOrder(node.right);
        }
    }

}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public String toString(){
        return "Node=[value="+value+"]";
    }
}

