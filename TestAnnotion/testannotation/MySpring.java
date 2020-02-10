package testannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MySpring {
    public Object getBean(String className){
        Object obj = null;
        try {
            //
            Class clazz = Class.forName(className);
            Constructor con = clazz.getConstructor();
            obj = con.newInstance();
            //获取构造方法上的注解类
            Annotation a = con.getAnnotation(MyAnnotation.class);
            Class aclazz = a.getClass();
            Method am = aclazz.getMethod("value");
            String[] values = (String[])am.invoke(a);//获取注解类内的信息

            //找到每一属性对应的set方法并赋值
            Field[] fields = clazz.getDeclaredFields();//找到所有的属性
            for(int i=0;i<fields.length;i++){
                //找到set方法
                String fn = fields[i].getName();
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(fn.substring(0,1).toUpperCase());
                setMethodName.append(fn.substring(1));//拼完set方法的名字

                Method fm = clazz.getMethod(setMethodName.toString(),fields[i].getType());

                fm.invoke(obj,fields[i].getType().getConstructor(String.class).newInstance(values[i]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
