package linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {

    }
}


//定义一个单链表 管理我们的英雄节点
class SingleLinkedList{

}

//定义英雄节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {//为了方便展示 重写toString方法
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
