package myspring;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpring {
    public Object getBean(String className){
        Object obj = null;
        Scanner input = new Scanner(System.in);
        try {
            Class clazz = Class.forName(className);
            obj = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for(Field f:fields){
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(f.getName().substring(0,1).toUpperCase());
                setMethodName.append(f.getName().substring(1));

                Class fieldClass = f.getType();

                Method setMethod = clazz.getMethod(setMethodName.toString(),fieldClass);

                System.out.println("请给"+f.getName()+"赋值");
                String value = input.nextLine();


                Constructor con = fieldClass.getConstructor(String.class);

                setMethod.invoke(obj,con.newInstance(value));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
