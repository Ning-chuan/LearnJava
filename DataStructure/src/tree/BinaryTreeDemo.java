package tree;

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
        //测试三种遍历
        System.out.println("前序遍历结果：");
        tree.preOrder();
        System.out.println("中序遍历结果：");
        tree.infixOrder();
        System.out.println("后序遍历结果：");
        tree.postOrder();
    }

}

//以英雄为节点的二叉树类
class HeroBinaryTree{
    private HeroNode root;//根节点
    public void setRoot(HeroNode root){
        this.root = root;
    }
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

