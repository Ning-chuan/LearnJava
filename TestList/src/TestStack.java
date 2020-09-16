import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
    }

    /**
     * 用于测试：List的remove()方法
     */
    @Test
    public void testListRemove(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(3);

        //arrayList.remove(2);//按索引删除
        boolean res = arrayList.remove(new Integer(2));//删除元素
        System.out.println(res);//false
        System.out.println(arrayList);
    }


}
