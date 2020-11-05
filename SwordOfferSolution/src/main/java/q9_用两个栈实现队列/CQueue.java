package q9_用两个栈实现队列;

import java.util.LinkedList;

/**
 * LeetCode地址：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 */
public class CQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        //栈1只负责进
        stack1.add(value);
    }

    public int deleteHead() {
        //栈2不为空，要删除的就是它的栈顶元素
        if (!stack2.isEmpty()) return stack2.pop();
        //栈2为空，把栈1的元素依次弹出，放入栈2
        while (!stack1.isEmpty())
            stack2.add(stack1.pop());
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
