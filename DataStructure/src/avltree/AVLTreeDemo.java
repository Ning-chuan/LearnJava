package tree.avltree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10,11,7,6,8,9};
        AVLTree tree = new AVLTree();
        for (int value : arr) {
            tree.addNode(new Node(value));
        }

        System.out.println("中序遍历：");
        tree.inOrder();
        System.out.println("AVL树根节点为：" + tree.getRoot());//8

        System.out.println("当前树的高度为：" + tree.getHeight());//3
        System.out.println("左子树的高度为：" + tree.getRoot().leftHeight());//2
        System.out.println("右子树的高度为：" + tree.getRoot().rightHeight());//2

    }
}

//以二叉排序树为基础的二叉平衡树类
class AVLTree {

    Node root;

    public Node getRoot() {
        return root;
    }

    //方法：获取当前树的高度
    public int getHeight() {
        if (root == null) {
            return 0;
        }
        return root.height();
    }

    //添加节点的方法
    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            addNode(root, node);
            //当添加完一个结点后，如果:(右子树的高度-左子树的高度)>1,左旋转
            if ((root.rightHeight() - root.leftHeight()) > 1) {
                //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
                if (root.right != null && root.right.leftHeight() > root.right.rightHeight()) {
                    //先对根节点的右子树右旋
                    root.right.rightRotate();
                }
                //左旋
                root.leftRotate();
            }
            //逻辑与上面正好对应
            if ((root.leftHeight() - root.rightHeight()) > 1) {
                if(root.left != null && root.left.rightHeight() > root.left.leftHeight()){
                    root.left.leftRotate();
                }
                root.rightRotate();
            }
        }
    }

    //自身递归调用的添加方法
    private void addNode(Node temp, Node target) {
        if (target == null) {
            return;
        }
        if (target.value < temp.value) {
            if (temp.left == null) {
                temp.left = target;
            } else {
                addNode(temp.left, target);
            }
        } else {
            //target值不小于temp 放在右边
            if (temp.right == null) {
                temp.right = target;
            } else {
                addNode(temp.right, target);
            }
        }
    }

    // 中序遍历方法
    public void inOrder() {
        if (this.root == null) {
            System.out.println("空树，遍历个寂寞");
        } else {
            inOrder(root);
        }
    }

    private void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.println(node);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    //删除节点方法：
    public void delNode(int value) {
        Node target = search(value);
        if (target == null) {
            System.out.println("没有找到要删除的节点");
            return;
        }
        Node parent = searchParent(value);
        if (target.left == null && target.right == null) {
            //情况一：要删除的节点是叶子节点
            if (parent != null) {
                if (parent.left == target) {
                    //该节点是父节点的左子节点
                    parent.left = null;
                } else {
                    //该节点是父节点的右子节点
                    parent.right = null;
                }
            } else {
                //要删除的节点是根节点
                root = null;
            }
        } else if (target.left != null && target.right != null) {
            //情况二：要删除的节点右两个子树
            //  找到目标节点左子树值最大的节点
            Node maxLeftChildNode = this.findLeftMaxNode(target);
            System.out.println("最大左子节点：" + maxLeftChildNode);
            //  删除左子树最大节点
            delNode(maxLeftChildNode.value);
            //  用左子树最大节点的值覆盖目标节点
            target.value = maxLeftChildNode.value;
        } else {
            //情况三：要删除的节点只有一个子树
            if (parent != null) {
                if (target.left != null) {
                    //目标节点只有左子树
                    if (parent.left == target) {
                        parent.left = target.left;
                    } else {
                        parent.right = target.left;
                    }
                } else {
                    //目标节点只有右子树
                    if (parent.left == target) {
                        parent.left = target.right;
                    } else {
                        parent.right = target.right;
                    }
                }
            } else {
                //要删除的节点是根节点
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
    }

    //找到左子树值最大的节点
    private Node findLeftMaxNode(Node target) {
        if (target.left == null) {
            return null;
        }
        Node temp = target.left;
        while (temp.right != null) {
            temp = temp.right;
        }
        //循环结束 temp指向了左子树最大的节点
        return temp;
    }

    //方法：根据value找到目标节点
    public Node search(int value) {
        if (root == null) {
            System.out.println("空树");
            return null;
        } else {
            return search(root, value);
        }
    }

    private Node search(Node node, int value) {
        //和当前节点比较
        if (node.value == value) {
            return node;
        }
        //分两种情况处理
        if (value < node.value) {
            //小于当前节点的值 比较左子节点
            if (node.left != null) {
                //向左递归查找
                return search(node.left, value);
            } else {
                //左子节点为空 说明不存在
                return null;
            }
        } else {
            //大于当前节点的值 比较右子节点
            if (node.right != null) {
                //向右递归查找
                return search(node.right, value);
            } else {
                //右子节点为空 说明不存在
                return null;
            }
        }
    }

    //方法：寻找目标节点的父节点
    public Node searchParent(int value) {
        if (root == null || root.value == value) {
            //根节点为空 或者根节点即为目标节点 这两种情况都不存在父节点 返回空
            return null;
        } else {
            return searchParent(root, value);
        }
    }

    private Node searchParent(Node node, int value) {
        if (node.left != null && node.left.value == value ||
                node.right != null && node.right.value == value) {
            return node;
        }
        if (value < node.value) {
            if (node.left != null) {
                return searchParent(node.left, value);
            } else {
                return null;
            }
        } else {
            if (node.right != null) {
                return searchParent(node.right, value);
            } else {
                return null;
            }
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public String toString() {
        return "Node=[value=" + value + "]";
    }

    //方法：返回以当前节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }
    //方法：求当前节点左子树高度
    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }
    //方法：求当前节点右子树高度
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    //方法：左旋
    public void leftRotate() {
        if (this.right == null) {
            System.out.println("没有右子节点，不能左旋");
            return;
        }
        //1.以当前节点的值创建一个新节点
        Node newNode = new Node(this.value);
        //2.新节点的左子节点 指向 当前节点的左子节点
        newNode.left = this.left;
        //3.新节点的右子节点 指向 当前节点右子节点的左子节点
        newNode.right = this.right.left;
        //4.把当前节点右子节点的值赋给当前节点（让右子节点覆盖当前节点）
        this.value = this.right.value;
        //5.当前节点指向其右子节点的右子节点
        this.right = this.right.right;
        //6.当前节点左子节点指向新节点
        this.left = newNode;
    }

    //方法：右旋  步骤对比左旋
    public void rightRotate() {
        if (this.left == null) {
            System.out.println("没有左子节点，无法右旋");
            return;
        }
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.right = newNode;
        this.left = this.left.left;
    }

}
