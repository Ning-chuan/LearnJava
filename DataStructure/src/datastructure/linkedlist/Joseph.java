package datastructure.linkedlist;

public class Joseph {
    public static void main(String[] args) {
        //测试一把
        CircleLinkedList list = new CircleLinkedList();
        list.initCircle(25);
        list.josephQuestion(5,7);
    }
}

//定义一个环形链表
class CircleLinkedList{
    private Boy first = null;
    private int nums = 0;

    //根据人数（节点个数）构建圈大小（环形链表长度）的方法
    public void initCircle(int nums){
        if(nums < 1){
            System.out.println("没你这样玩的~");
            return;
        }
        Boy cur = null;//辅助指针 指向尾节点
        for(int i = 1;i<=nums;i++){
            //new一个新节点准备插到尾端
            Boy newBoy = new Boy(i);
            if(i == 1){
                first = newBoy;
                first.setNext(first);
                cur = first;
            }
            cur.setNext(newBoy);
            newBoy.setNext(first);
            cur = newBoy;
        }
        this.nums = nums;
    }

    //遍历展示环形链表
    public void show(){
        if(first == null){
            System.out.println("空空如也");
            return;
        }
        //为了不影响链表本身结构 定义一个指针辅助遍历
        Boy cur = first;
        while(true){
            System.out.printf("当前小孩节点为：%d\n",cur.getNo());
            if(cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }

    //约瑟夫问题：
    //设编号为1, 2，... n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数，数到m的那个人出列，
    //它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，
    //求出队编号的序列。
    //例如总共有5人，从编号为3(k==3)的人开始数数，数到2(m==2)的人出列
    /**
     *
     * @param startNo  从第几个小孩开始数数
     * @param countNum  数几下
     */
    public void josephQuestion(int startNo,int countNum){
        if(this.nums == 0 || startNo < 1 || startNo > this.nums){
            System.out.println("数据有误，不能玩这个游戏");
            return;
        }
        //由于是单向环形链表 进行小孩出圈的操作时 必须知道其前一个节点
        //所以我们定义一个help指针 通过循环让其指向first的前一个节点 方便后续的小孩出圈操作
        Boy help = first;
        while(help.getNext() != first){
            help = help.getNext();
        }
        //数数之前  先让first移动到k（开始报数节点）处
        //因为first已经指向了第一个节点 所以只需要移动k-1次
        //例如总共有5人，从编号为3的人开始数数，那么first只需要移动两次，就指向了编号为3的人
        for(int i = 0;i < startNo-1;i++){
            first = first.getNext();
            help = help.getNext();
        }
        //开始数数 每次循环移动m-1次 first就指向了需要出圈的小孩
        while(true) {
            for (int i = 0; i < countNum - 1; i++) {
                //移动m-1次
                first = first.getNext();
                help = help.getNext();
            }
            System.out.println("出圈小孩编号为：" + first.getNo());
            if (help == first) {
                break;//此时圈里只剩最后一个小孩
            }
            //出圈操作
            help.setNext(first.getNext());
            first = help.getNext();

        }
    }
}

//节点类
class Boy{
    private int no;
    private Boy next;

    public Boy() {
    }
    public Boy(int no) {
        this.no = no;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
}