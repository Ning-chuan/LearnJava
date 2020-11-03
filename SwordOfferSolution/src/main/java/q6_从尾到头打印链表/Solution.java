package q6_从尾到头打印链表;

import java.util.Stack;

public class Solution {
    //方法一：
    public int[] reversePrint1(ListNode head) {
        //记录节点个数
        int count = 0;
        ListNode tempNode = head;
        //获取链表长度
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        //根据链表长度，创建结果数组
        int[] res = new int[count];
        //临时指针重新指向头节点
        tempNode = head;
        //再次遍历链表把节点的值倒序存入数组
        while (tempNode != null) {
            res[--count] = tempNode.val;
            tempNode = tempNode.next;
        }
        return res;
    }

    //方法二：
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
