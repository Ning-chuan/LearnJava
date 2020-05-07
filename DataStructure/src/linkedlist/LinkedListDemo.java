package linkedlist;

import java.util.Stack;

public class LinkedListDemo {
    public static void main(String[] args) {
        //测试一把
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(7,"秦明","霹雳火");
        HeroNode hero4 = new HeroNode(6,"林冲","豹子头");

        SingleLinkedList list = new SingleLinkedList();
        list.addByNo(hero1);
        list.addByNo(hero3);
        list.addByNo(hero2);
        //list.addByNo(hero2);
        list.addByNo(hero4);
        System.out.println("---------链表一展示---------");
        list.show();

        HeroNode hero5 = new HeroNode(5,"关胜","大刀");
        HeroNode hero6 = new HeroNode(4,"公孙胜","入云龙");
        HeroNode hero7 = new HeroNode(9,"小李广","花荣");
        HeroNode hero8 = new HeroNode(10,"柴进","小旋风");
        HeroNode hero9 = new HeroNode(13,"鲁智深","花和尚");
        SingleLinkedList list2 = new SingleLinkedList();
        list2.addByNo(hero5);
        list2.addByNo(hero6);
        list2.addByNo(hero7);
        list2.addByNo(hero8);
        list2.addByNo(hero9);
        System.out.println("---------链表二展示---------");
        list2.show();

        HeroNode newHead = combineList(list.getHead(),list2.getHead());
        System.out.println("---------合并后展示---------");
        reverseList(newHead);
        reversePrint(newHead);



//        //测试修改方法
//        list.update(new HeroNode(3,"小吴","加亮先生"));
//        System.out.println("----修改后的链表----");
//        list.show();
//
//        //测试计算节点个数方法
//        HeroNode head = list.getHead();
//        System.out.println("有效节点个数为:"+getLength(head));
//        //测试 找到倒数第k个节点方法
//        System.out.println("倒数第1个节点为："+findLastIndexNode(head,1));
//
//        reverseList(head);
//        list.show();
//
//        reversePrint(head);

//        list.del(3);
//        list.del(1);
//        System.out.println("删除后链表为：");
//        list.show();

    }

    //常见面试题
    //1.获取单链表节点个数(不包括头节点)
    /**
     *
     * @param head 链表头节点
     * @return 有效节点个数
     */
    public static int getLength(HeroNode head){
        int count = 0;
        HeroNode cur = head.next;
        while(cur != null){
            count++;
            cur = cur.next;//后移
        }
        return count;
    }

    //2.查找单链表中倒数第k个节点
    //需要的参数有：头节点、index
    //返回值：返回找到的节点
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //链表为空
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        //检查index
        if(index <= 0 || index>size){
            return null;
        }
        HeroNode temp = head.next;
        for(int i = 0;i<size-index;i++){
            temp = temp.next;
        }
        return temp;
    }

    //3.单链表的反转
    public static void reverseList(HeroNode head){
        //先判断 如果链表为空或者链表只有一个节点时 不用反转
        if(head.next == null || head.next.next == null){
            return;
        }
        //定义一个反转链表的头节点
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;//当前节点的指针
        HeroNode next = null;//记录当前节点的下一个节点，下面循环中后移指针的时候要用到
        while(cur != null){
            next = cur.next;
            //循环遍历原来的链表 每遍历一个节点 就把这个节点添加到反转链表的头
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //4.从尾到头打印表单
    //  如果使用上面的方法打印会破坏原有的链表结构
    //  采用栈内存先进后出的特点效率更好
    public static void reversePrint(HeroNode head){
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //5.合并两个本来有序的单链表
    public static HeroNode combineList(HeroNode headOne,HeroNode headTwo){
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode temp1 = headOne.next;
        HeroNode temp2 = headTwo.next;
        HeroNode tempNew = newHead;
        while(true){
            if(temp1 == null && temp2 == null){
                break;
            }
            if(temp1 == null){
                tempNew.next = temp2;
                break;
            }
            if(temp2 == null){
                tempNew.next = temp1;
                break;
            }
            if(temp1.no > temp2.no){
                tempNew.next = temp2;
                temp2 = temp2.next;
            }else{
                tempNew.next = temp1;
                temp1 = temp1.next;
            }
            tempNew = tempNew.next;
        }
        return newHead;
    }


}


//定义一个单链表 管理我们的英雄节点
class SingleLinkedList{
    //定义一个头节点 头节点始终不动 不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");
    public HeroNode getHead(){
        return this.head;
    }

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
    public void addByNo(HeroNode heroNode){
        //我们需要找到插入位置的前一个结点 才能完成插入
        HeroNode temp = head;
        boolean flag = false;//用于标记该英雄是否已经存在
        while(true){
            if(temp.next == null){
                //此时temp是最后一位
                break;
            }
            if(heroNode.no < temp.next.no){
                //此时temp指向目标位置的前一个节点
                break;
            }
            if(heroNode.no == temp.next.no){
                flag = true;
                break;
            }
            temp = temp.next;//指针后移
        }
        //循环结束，temp指向了合适的位置，插入之前，先判断flag标记
        if(flag){
        System.out.printf("编号为%d的英雄已经存在，添加不得~\n",heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息  根据no编号修改 no编号不可以修改
    public void update(HeroNode newHeroNode){
        HeroNode temp = head.next;
        while(temp != null){
            if(temp.no == newHeroNode.no){
                //找到了，修改一把
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                break;
            }
            temp = temp.next;
        }
        if(temp == null){
           System.out.printf("编号为%d英雄不存在，修改不得~",newHeroNode);
        }
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
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空~");
            return;
        }
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
