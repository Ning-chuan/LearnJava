package testannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestMain {
    public static void main(String[] args){

        MySpring ms = new MySpring();

        User user = (User)ms.getBean("testannotation.User");
        System.out.println(user.getUsername()+"--"+user.getPassword()+"--"+user.getBalances());

        Question q = (Question)ms.getBean("testannotation.Question");
        System.out.println(q.getTitle()+"--"+q.getAnswer());


        Person p = (Person)ms.getBean("testannotation.Person");
        System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());








//        Object obj = null;
//        try {//通过反射获取注解信息
//            Class clazz = Class.forName("testannotation.Person");
//            Constructor con = clazz.getConstructor();
//            //获取构造方法上的注解
//            Annotation a = con.getAnnotation(MyAnnotation.class);
//            Class aclazz = a.getClass();//获取注解类
//            Method am= aclazz.getMethod("value");//获取注解内的value方法
//            String[] values = (String[])am.invoke(a);
//            for(String v:values){
//                System.out.println(v);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
