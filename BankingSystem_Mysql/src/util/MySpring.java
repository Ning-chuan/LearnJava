package util;

import java.util.HashMap;

public class MySpring {
    //该类用来控制对象

    //静态集合属性用来存储对象
    private static HashMap<String,Object> beanBox = new HashMap<>();

    //获取对象的方法
    public static <T>T getBean(String className) {
        T obj = null;
        try {
            obj = (T)beanBox.get(className);
            if(obj==null){//证明没有创建过
                Class clazz = Class.forName(className);
                obj = (T) clazz.newInstance();
                beanBox.put(className, obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
