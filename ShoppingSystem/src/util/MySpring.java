package util;

import java.util.HashMap;
import java.util.Map;

public class MySpring {
    //存储对象的集合
    private static HashMap<String,Object> objectMap = new HashMap<>();

    public static <T>T getBean(String className){
        T obj = (T)objectMap.get(className);
        if(obj==null){
            try {
                Class clazz = Class.forName(className);
                obj = (T)clazz.newInstance();
                objectMap.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
