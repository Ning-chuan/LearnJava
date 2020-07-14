package tree.binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int value : arr) {
            binarySortTree.addNode(new Node(value));
        }
        System.out.println("删除节点前，二叉树为：");
        binarySortTree.inOrder();

        binarySortTree.delNode(2);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(90);

        System.out.println("删除节点后，二叉树为：");
        binarySortTree.inOrder();
    }

}

class BinarySortTree{
    Node root;

    public Node getRoot() {
        return root;
    }
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

    //删除节点方法：
    public void delNode(int value) {
        Node target = search(value);
        if(target == null){
            System.out.println("没有找到要删除的节点");
            return;
        }
        Node parent = searchParent(value);
        if (target.left == null && target.right == null) {
            //情况一：要删除的节点是叶子节点
            if(parent != null){
                if(parent.left == target){
                    //该节点是父节点的左子节点
                    parent.left = null;
                }else{
                    //该节点是父节点的右子节点
                    parent.right = null;
                }
            }else{
                //要删除的节点是根节点
                root = null;
            }
        } else if (target.left != null && target.right != null) {
            //情况二：要删除的节点右两个子树 找到该节点左子树值最大的节点 覆盖目标节点
            if(parent != null){
                findLeftMaxNode(target);
            }else{
                //要删除的节点是根节点

            }
        } else {
            //情况三：要删除的节点只有一个子树
            if(parent != null){
                if(parent.left != null){
                    //目标节点是父节点的左子树
                    if(target.left != null){
                        parent.left = target.left;
                    }else{
                        parent.left = target.right;
                    }
                }else{
                    //目标节点是父节点的右子树
                    if(target.left != null){
                        parent.right = target.left;
                    }else{
                        parent.right = target.right;
                    }
                }
            }else{
                //要删除的节点是根节点
                if(root.left != null){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        }
    }

    //找到左子树值最大的节点
    private void findLeftMaxNode(Node target) {

    }

    //方法：根据value找到目标节点
    public Node search(int value){
        if(root == null){
            System.out.println("空树");
            return null;
        }else{
            return search(root, value);
        }
    }
    private Node search(Node node,int value){
        //和当前节点比较
        if(node.value == value){
            return node;
        }
        //分两种情况处理
        if(value < node.value){
            //小于当前节点的值 比较左子节点
            if (node.left != null) {
                //向左递归查找
                return search(node.left, value);
            }else{
                //左子节点为空 说明不存在
                return null;
            }
        }else{
            //大于当前节点的值 比较右子节点
            if (node.right != null) {
                //向右递归查找
                return search(node.right, value);
            }else{
                //右子节点为空 说明不存在
                return null;
            }
        }
    }

    //方法：寻找目标节点的父节点
    public Node searchParent(int value){
        if(root == null || root.value == value){
            //根节点为空 或者根节点即为目标节点 这两种情况都不存在父节点 返回空
            return null;
        }else{
            return searchParent(root, value);
        }
    }
    private Node searchParent(Node node,int value){
        if(node.left != null && node.left.value == value ||
                node.right != null && node.right.value == value){
            return node;
        }
        if(value < node.value){
            if(node.left != null){
                return searchParent(node.left, value);
            }else{
                return null;
            }
        }else{
            if(node.right != null){
                return searchParent(node.right, value);
            }else{
                return null;
            }
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

