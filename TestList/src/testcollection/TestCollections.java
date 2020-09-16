package testcollection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    /**
     * Collection和Collections的区别：
     * Collection是单列集合接口，List、Set等集合接口都是实现与它
     * Collections是操作集合的工具类，它里面都是一些操作集合的静态工具方法
     */
    @Test
    public void test(){
        //测试Collections拷贝方法：
        //源List
        List srcList = new ArrayList();
        srcList.add(1111);
        srcList.add(33);
        srcList.add(55);
        srcList.add(66);
        srcList.add(999);
        srcList.add(456);

        //目标List
        //这个方法需要目标List的元素个数大于等于原数组 如果采用下面的方式新建目标数组会出如下异常
        //List destList = new ArrayList();//IndexOutOfBoundsException: Source does not fit in dest
        //正确且便捷的方式：
        List destList = Arrays.asList(new Object[srcList.size()]);
        System.out.println("destList = " + destList);

        Collections.copy(destList,srcList);

        System.out.println("destList = " + destList);


    }
}
