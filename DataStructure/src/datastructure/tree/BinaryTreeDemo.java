package datastructure.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建测试所需的英雄节点
        HeroNode hero1 = new HeroNode(1, "宋江");
        HeroNode hero2 = new HeroNode(2, "吴用");
        HeroNode hero3 = new HeroNode(3, "卢俊义");
        HeroNode hero4 = new HeroNode(4, "林冲");
        HeroNode hero5 = new HeroNode(5, "关胜");
        //手动建立树结构
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero3.setLeft(hero5);
        hero3.setRight(hero4);
        //创建二叉树并设置根节点
        HeroBinaryTree tree = new HeroBinaryTree();
        tree.setRoot(hero1);

//        //测试三种遍历
//        System.out.println("前序遍历结果：");
//        datastructure.tree.preOrder();
//        System.out.println("中序遍历结果：");
//        datastructure.tree.infixOrder();
//        System.out.println("后序遍历结果：");
//        datastructure.tree.postOrder();
//
//        System.out.println("=================================");
//        HeroNode res1 = datastructure.tree.preOrderSearch(5);
//        System.out.println("前序查找结果为"+res1);
//        System.out.println("=================================");
//        HeroNode res2 = datastructure.tree.infixOrderSearch(5);
//        System.out.println("中序查找结果为"+res2);
//        System.out.println("=================================");
//        HeroNode res3 = datastructure.tree.postOrderSearch(5);
//        System.out.println("后序查找结果为"+res3);
//        System.out.println("=================================");

        //测试删除节点
        System.out.println("删除前前序遍历");
        tree.preOrder();
        tree.delNode(13);
        System.out.println("删除后前序遍历");
        tree.preOrder();

    }

}

//以英雄为节点的二叉树类
class HeroBinaryTree{
    private HeroNode root;//根节点
    public void setRoot(HeroNode root){
        this.root = root;
    }

    //===========================================================================
    //前序遍历 （先输出，再左、右）
    public void preOrder(){
        if(this.root != null){
            preOrder(root);
        }else{
            System.out.println("当前英雄二叉树没有节点");
        }
    }
    //给自己使用的可递归调用的方法
    private void preOrder(HeroNode heroNode){
        //1.输出当前节点
        System.out.println(heroNode);
        //2.向左递归前序遍历
        if(heroNode.getLeft() != null){
            preOrder(heroNode.getLeft());
        }
        //3.向右递归前序遍历
        if(heroNode.getRight() != null){
            preOrder(heroNode.getRight());
        }
    }

    //中序遍历 （先左，然后输出，再右）
    public void infixOrder(){
        if(this.root != null){
            infixOrder(root);
        }else{
            System.out.println("当前英雄树没有节点");
        }
    }
    private void infixOrder(HeroNode heroNode){
        //1.递归中序遍历左子树
        if(heroNode.getLeft() != null){
            infixOrder(heroNode.getLeft());
        }
        //2.输出父节点
        System.out.println(heroNode);
        //3.递归中序遍历右子树
        if(heroNode.getRight() != null){
            infixOrder(heroNode.getRight());
        }
    }

    //后序遍历 （先左右，最后输出）
    public void postOrder(){
        if(this.root != null){
            postOrder(root);
        }else{
            System.out.println("当前英雄树没有节点");
        }
    }
    private void postOrder(HeroNode heroNode){
        //1.递归中序遍历左子树
        if(heroNode.getLeft() != null){
            postOrder(heroNode.getLeft());
        }
        //2.递归中序遍历右子树
        if(heroNode.getRight() != null){
            postOrder(heroNode.getRight());
        }
        //3.输出父节点
        System.out.println(heroNode);
    }

    //=============================================================================

    //前序查找
    public HeroNode preOrderSearch(int no){
        if(this.root != null){
            return preOrderSearch(root, no);
        }
        return null;
    }
    //供自己递归调用的前序查找方法
    private HeroNode preOrderSearch(HeroNode heroNode,int no){
        //1.和当前节点no比较
        System.out.println("前序查找即将进行比较~");//测试比较次数的语句
        if(heroNode.getNo() == no){
            return heroNode;
        }
        //2.如果no不相等，向左递归前序查找
        HeroNode res = null;
        if(heroNode.getLeft() != null){
            res = preOrderSearch(heroNode.getLeft(), no);
        }
        if(res != null){
            return res;
        }
        //3.如果左递归没有找到，向右递归前序查找
        if(heroNode.getRight() != null){
            res = preOrderSearch(heroNode.getRight(), no);
        }
        return res;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no){
        if(this.root != null){
            return infixOrderSearch(root, no);
        }
        return null;
    }
    //供自己递归调用的中序查找方法
    private HeroNode infixOrderSearch(HeroNode heroNode,int no){
        //左递归中序查找
        HeroNode res = null;
        if(heroNode.getLeft() != null){
            res = infixOrderSearch(heroNode.getLeft(), no);
        }
        if(res != null){
            return res;
        }
        //左递归没有找到，和当前节点no比较
        System.out.println("中序查找即将进行比较~");//测试比较次数的语句
        if(heroNode.getNo() == no){
            return heroNode;
        }
        //no不相等，右递归中序查找
        if(heroNode.getRight() != null){
            res = infixOrderSearch(heroNode.getRight(), no);
        }
        return res;
    }

    //后序查找
    public HeroNode postOrderSearch(int no){
        if(this.root != null){
            return postOrderSearch(root, no);
        }
        return null;
    }
    //供自己递归调用的后序查找方法
    private HeroNode postOrderSearch(HeroNode heroNode,int no){
        //左递归后序查找
        HeroNode res = null;
        if(heroNode.getLeft() != null){
            res = postOrderSearch(heroNode.getLeft(), no);
        }
        if(res != null){
            return res;
        }
        //左递归没有找到，右递归后序查找
        if(heroNode.getRight() != null){
            res = postOrderSearch(heroNode.getRight(), no);
        }
        if(res != null){
            return res;
        }
        //右递归没有找到，最后和当前节点no比较
        System.out.println("后序查找即将进行比较~");//测试比较次数的语句
        if(heroNode.getNo() == no){
            return heroNode;
        }
        return null;
    }
    //=========================================================================

    //删除节点 (规则：如果要删除的节点是叶子节点，直接删除；如果是非叶子节点，则删除该子树。)
    public void delNode(int no){
        if(root == null){
            System.out.println("空树，删除不得");
        }else if(root.getNo() == no){
            root = null;
        }else{
            delNode(root,no);
        }
    }
    /**
     * @param heroNode 当前节点
     * @param no 要删除的节点
     * @return -1表示没有找到要删除的节点  1表示删除成功
     */
    private int delNode(HeroNode heroNode, int no) {
        //1.判断当前节点左子节点是否是待删除节点，如果是，置为空
        if(heroNode.getLeft() != null && heroNode.getLeft().getNo() == no){
            heroNode.setLeft(null);
            return 1;
        }
        //2.判断当前节点右子节点是否是待删除节点，如果是，置为空
        if(heroNode.getRight() != null && heroNode.getRight().getNo() == no){
            heroNode.setRight(null);
            return 1;
        }
        //3.向左递归调用删除方法
        int res = -1;//接收结果，左递归完毕后用该结果进行判断，初始值给-1
        if(heroNode.getLeft() != null){
            res = delNode(heroNode.getLeft(),no);
        }
        if(res == 1){
            //说明删除成功了，就不执行后面的代码了
            return res;
        }
        if(heroNode.getRight() != null){
            res = delNode(heroNode.getRight(),no);
        }
        return res;
    }

}

//英雄节点类
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(){}
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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

