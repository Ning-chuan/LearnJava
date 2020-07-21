package datastructure.tree.threaded;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "tom");
        HeroNode hero2 = new HeroNode(3, "jerry");
        HeroNode hero3 = new HeroNode(6, "bill");
        HeroNode hero4 = new HeroNode(8, "james");
        HeroNode hero5 = new HeroNode(10, "yellow");
        HeroNode hero6 = new HeroNode(14, "oral");

        ThreadedBinaryTree threadedTree = new ThreadedBinaryTree();
        threadedTree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero2.setLeft(hero4);
        hero2.setRight(hero5);
        hero3.setLeft(hero6);

        //中序线索化
        threadedTree.infixThreaded();
        System.out.println(hero5.getLeft());//3 jerry
        System.out.println(hero6.getLeft());//1 tom
        System.out.println(hero6.getRight());//6 bill
        System.out.println("===============================");
        threadedTree.showThreadedTree();

    }
}


//线索化二叉树类
class ThreadedBinaryTree {
    private HeroNode root;//根节点

    private HeroNode pre;//指向当前节点的前驱节点 线索化二叉树时需要使用

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    //===========================================================================
    //中序线索化二叉树：
    public void infixThreaded() {
        if (root == null) {
            System.out.println("空树，无法线索化");
            return;
        }
        infixThreaded(root);
    }

    private void infixThreaded(HeroNode node) {
        if (node == null) {
            return;
        }
        //1.线索化左边
        infixThreaded(node.getLeft());
        //2.线索化当前节点
        //  处理左边
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //  处理右边 不能直接用node.getRight()判断 因为即使判断为空后 无法确定setRight()是谁 所以利用pre判断
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //  下一次处理前，把当前节点赋给pre
        pre = node;
        //3.线索化右边
        infixThreaded(node.getRight());
    }

    //中序线索化后的遍历方法
    public void showThreadedTree() {
        HeroNode node = this.root;
        while (node != null) {
            //1.找到以node节点为根节点的子树需要第一个展示的节点 然后输出
            while(node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);
            //2.只要right为后继节点就一直输出 并且移动node
            while(node.getRightType() == 1){
                System.out.println(node.getRight());
                node = node.getRight();
            }
            //3.循环结束 说明不是后继节点 移动node后进行下一轮循环
            node = node.getRight();
        }
    }


    //===========================================================================
    //前序遍历 （先输出，再左、右）
    public void preOrder() {
        if (this.root != null) {
            preOrder(root);
        } else {
            System.out.println("当前英雄二叉树没有节点");
        }
    }

    //给自己使用的可递归调用的方法
    private void preOrder(HeroNode heroNode) {
        //1.输出当前节点
        System.out.println(heroNode);
        //2.向左递归前序遍历
        if (heroNode.getLeft() != null) {
            preOrder(heroNode.getLeft());
        }
        //3.向右递归前序遍历
        if (heroNode.getRight() != null) {
            preOrder(heroNode.getRight());
        }
    }

    //中序遍历 （先左，然后输出，再右）
    public void infixOrder() {
        if (this.root != null) {
            infixOrder(root);
        } else {
            System.out.println("当前英雄树没有节点");
        }
    }

    private void infixOrder(HeroNode heroNode) {
        //1.递归中序遍历左子树
        if (heroNode.getLeft() != null) {
            infixOrder(heroNode.getLeft());
        }
        //2.输出父节点
        System.out.println(heroNode);
        //3.递归中序遍历右子树
        if (heroNode.getRight() != null) {
            infixOrder(heroNode.getRight());
        }
    }

    //后序遍历 （先左右，最后输出）
    public void postOrder() {
        if (this.root != null) {
            postOrder(root);
        } else {
            System.out.println("当前英雄树没有节点");
        }
    }

    private void postOrder(HeroNode heroNode) {
        //1.递归中序遍历左子树
        if (heroNode.getLeft() != null) {
            postOrder(heroNode.getLeft());
        }
        //2.递归中序遍历右子树
        if (heroNode.getRight() != null) {
            postOrder(heroNode.getRight());
        }
        //3.输出父节点
        System.out.println(heroNode);
    }

    //=============================================================================

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return preOrderSearch(root, no);
        }
        return null;
    }

    //供自己递归调用的前序查找方法
    private HeroNode preOrderSearch(HeroNode heroNode, int no) {
        //1.和当前节点no比较
        System.out.println("前序查找即将进行比较~");//测试比较次数的语句
        if (heroNode.getNo() == no) {
            return heroNode;
        }
        //2.如果no不相等，向左递归前序查找
        HeroNode res = null;
        if (heroNode.getLeft() != null) {
            res = preOrderSearch(heroNode.getLeft(), no);
        }
        if (res != null) {
            return res;
        }
        //3.如果左递归没有找到，向右递归前序查找
        if (heroNode.getRight() != null) {
            res = preOrderSearch(heroNode.getRight(), no);
        }
        return res;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return infixOrderSearch(root, no);
        }
        return null;
    }

    //供自己递归调用的中序查找方法
    private HeroNode infixOrderSearch(HeroNode heroNode, int no) {
        //左递归中序查找
        HeroNode res = null;
        if (heroNode.getLeft() != null) {
            res = infixOrderSearch(heroNode.getLeft(), no);
        }
        if (res != null) {
            return res;
        }
        //左递归没有找到，和当前节点no比较
        System.out.println("中序查找即将进行比较~");//测试比较次数的语句
        if (heroNode.getNo() == no) {
            return heroNode;
        }
        //no不相等，右递归中序查找
        if (heroNode.getRight() != null) {
            res = infixOrderSearch(heroNode.getRight(), no);
        }
        return res;
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return postOrderSearch(root, no);
        }
        return null;
    }

    //供自己递归调用的后序查找方法
    private HeroNode postOrderSearch(HeroNode heroNode, int no) {
        //左递归后序查找
        HeroNode res = null;
        if (heroNode.getLeft() != null) {
            res = postOrderSearch(heroNode.getLeft(), no);
        }
        if (res != null) {
            return res;
        }
        //左递归没有找到，右递归后序查找
        if (heroNode.getRight() != null) {
            res = postOrderSearch(heroNode.getRight(), no);
        }
        if (res != null) {
            return res;
        }
        //右递归没有找到，最后和当前节点no比较
        System.out.println("后序查找即将进行比较~");//测试比较次数的语句
        if (heroNode.getNo() == no) {
            return heroNode;
        }
        return null;
    }
    //=========================================================================

    //删除节点 (规则：如果要删除的节点是叶子节点，直接删除；如果是非叶子节点，则删除该子树。)
    public void delNode(int no) {
        if (root == null) {
            System.out.println("空树，删除不得");
        } else if (root.getNo() == no) {
            root = null;
        } else {
            delNode(root, no);
        }
    }

    /**
     * @param heroNode 当前节点
     * @param no       要删除的节点
     * @return -1表示没有找到要删除的节点  1表示删除成功
     */
    private int delNode(HeroNode heroNode, int no) {
        //1.判断当前节点左子节点是否是待删除节点，如果是，置为空
        if (heroNode.getLeft() != null && heroNode.getLeft().getNo() == no) {
            heroNode.setLeft(null);
            return 1;
        }
        //2.判断当前节点右子节点是否是待删除节点，如果是，置为空
        if (heroNode.getRight() != null && heroNode.getRight().getNo() == no) {
            heroNode.setRight(null);
            return 1;
        }
        //3.向左递归调用删除方法
        int res = -1;//接收结果，左递归完毕后用该结果进行判断，初始值给-1
        if (heroNode.getLeft() != null) {
            res = delNode(heroNode.getLeft(), no);
        }
        if (res == 1) {
            //说明删除成功了，就不执行后面的代码了
            return res;
        }
        if (heroNode.getRight() != null) {
            res = delNode(heroNode.getRight(), no);
        }
        return res;
    }

}

//英雄节点类
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //为了线索化二叉树 加入两个属性
    private int leftType;// 0表示左子树/左子节点；1表示前驱节点；默认值为0
    private int rightType;// 0表示右子树/右子节点；1表示后继节点；默认值为0

    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}