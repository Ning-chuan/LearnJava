package linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        //测试一把
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList list = new SingleLinkedList();
        list.show();
        list.add(hero1);
        list.add(hero3);
        list.add(hero2);
        list.add(hero4);
        list.show();

        list.del(3);
        list.del(4);
        list.del(1);
        list.del(2);
        System.out.println("删除后链表为：");
        list.show();

    }
}


//定义一个单链表 管理我们的英雄节点
class SingleLinkedList{
    //定义一个头节点 头节点始终不动 不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点 （不考虑排名，直接添加在链表末尾）
    public void add(HeroNode node){
        //因为head节点不能动 所以需要定义一个临时指针 用于遍历寻找尾节点
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        //出循环时temp.next为空 说明temp是最后一个节点
        temp.next = node;
    }

    //按英雄编号添加节点
    public void addByNo(){
         
    }

    //删除节点
    public void del(int no){
        HeroNode temp = head;
        while(temp.next != null){
            if(temp.next.no == no){
                //此时temp是所要删除节点的前一个节点
                temp.next = temp.next.next;
                return;
            }
            //指针后移
            temp = temp.next;
        }
        System.out.println("链表中没有该编号的英雄");
    }

    //展示链表
    public void show(){
        HeroNode temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
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
