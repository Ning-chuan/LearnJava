package myspring;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestMain {
    public static void main(String[] args){
        MySpring ms = new MySpring();
//        Person p = (Person) ms.getBean("myspring.Person");
//        System.out.println(p);

        Question q = (Question) ms.getBean("myspring.Question");
        System.out.println(q);
    }
}
