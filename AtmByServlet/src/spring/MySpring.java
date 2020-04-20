package spring;

import java.util.HashMap;

//管理对象
public class MySpring {

    //应当有一个集合 里面存着类名和对应的对象 我们采用HashMap集合
    private static HashMap<String,Object> objectMap = new HashMap<>();

    public static <T>T getBean(String className){
        T result = (T) objectMap.get(className);
        if(result==null){
            //说明集合中没有这个对象 需要我们同过反射创建对象
            try {
                Class clazz = Class.forName(className);
                result = (T)clazz.newInstance();
                objectMap.put(className,result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
