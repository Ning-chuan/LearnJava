package hashtable;

import java.util.Scanner;

public class MyHashTableTest {
    public static void main(String[] args) {

        MyHashTable myHashTable = new MyHashTable(6);
        Scanner input = new Scanner(System.in);
        String key = "";
        while(true){
            System.out.println("=======请输入操作项========");
            System.out.println("add：添加员工");
            System.out.println("show：展示table");
            System.out.println("find：寻找员工");
            System.out.println("delete：删除员工");
            System.out.println("exit：退出程序");
            System.out.println("========================");
            key = input.next();
            switch(key){
                case "add":
                    System.out.println("请输入员工编号：");
                    int id = input.nextInt();
                    System.out.println("请输入员工名字：");
                    String name = input.next();
                    myHashTable.add(new Emp(id,name));
                    break;
                case "show":
                    myHashTable.showHashTable();
                    break;
                case "find":
                    System.out.println("请输入要查询的员工编号：");
                    int idFind = input.nextInt();
                    Emp res = myHashTable.find(idFind);
                    if (res != null) {
                        System.out.println(res);
                    }else{
                        System.out.println("要查询的员工不存在");
                    }
                    break;
                case "delete":
                    System.out.println("请输入要删除的员工编号：");
                    int idDel = input.nextInt();
                    myHashTable.delete(idDel);
                    break;
                case "exit":
                    input.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//
class MyHashTable{
    //定义一个员工数组类型的数组
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public MyHashTable(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[this.size];
        for (int i = 0; i < size; i++) {
            //通过循环依次给数组每个元素初始化一个链表
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加方法
    public void add(Emp emp){
        int place = this.hashFun(emp.id);
        empLinkedListArray[place].add(emp);
    }

    //展示方法
    public void showHashTable(){
        for (int i = 0; i < this.size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //寻找方法
    public Emp find(int id){
        int place = this.hashFun(id);
        return empLinkedListArray[place].find(id);
    }

    //删除方法
    public void delete(int id){
        int place = this.hashFun(id);
        empLinkedListArray[place].delete(id);
    }

    private int hashFun(int id){
        //采用取余作为一个简单的散列函数
        return id % size;
    }

}

//员工节点类
class Emp{
    int id;
    String name;
    Emp next;//指向下一个节点
    public Emp(){}
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
//员工单链表类
class EmpLinkedList{
    //头节点
    Emp head;

    //添加节点方法
    public void add(Emp emp){
        if (head == null) {
            head = emp;
            return;
        }
        //辅助指针 帮我们找到当前链表的尾节点
        Emp curEmp = head;
        while(curEmp.next != null){
            curEmp = curEmp.next;
        }
        //退出上面循环时 curEmp指向了尾节点
        //把新员工加到尾节点
        curEmp.next = emp;
    }

    //遍历展示链表
    public void list(int no){
        if(head == null){
            System.out.printf("第%d链表为空\n",no);
            return;
        }
        System.out.printf("第%d链表数据为：",no);
        Emp curEmp = head;
        while(curEmp != null){
            System.out.print(curEmp);
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //寻找员工
    public Emp find(int id){
        if(head == null){
            return null;
        }
        Emp curEmp = head;
        while(curEmp != null){
            if(curEmp.id == id){
                return curEmp;
            }
            curEmp = curEmp.next;
        }
        return null;
    }

    //删除员工
    public void delete(int id){
        if(head == null){
            System.out.println("链表为空");
            return;
        }
        if(head.id == id){
            head = null;
            return;
        }
        Emp curEmp = head;
        while(curEmp.next != null){
            if(curEmp.next.id == id){
                curEmp.next = curEmp.next.next;
                //curEmp.next.next = null;//释放 可以不做这个操作
                return;
            }
            curEmp = curEmp.next;
        }
        System.out.printf("不存在id=%d的员\n",id);
    }


}