package testmethod;

import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args){
        Class clazz = Person.class;
        try {
            Person p = (Person)clazz.newInstance();
            Method m = clazz.getMethod("eat",String.class);
            System.out.println(m.getName());
            int mm = m.getModifiers();
            System.out.println(mm);
            Class c = m.getReturnType();
            System.out.println(c.getName());

            Class[] pts = m.getParameterTypes();//获取参数列表类型
            Class[] ets = m.getExceptionTypes();//获取抛出异常类型


//            m.invoke(p,"鱼香肉丝");

//            Method m = clazz.getDeclaredMethod("test");
//            m.setAccessible(true);//私有方法需要先声明可以被访问
//            m.invoke(p);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
