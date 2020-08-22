package com.ziyan.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }

}
class Test{
    public static void main(String[] args) {
        try {
            //尝试通过反射破坏枚举的单例
            //1.获取枚举类构造器（通过jad工具的反编译命令 -sjava 得到真实枚举类反编译后的类，看到它的构造器有两个参数）
            //Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor();
            Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);


            //NoSuchMethodException: com.ziyan.single.EnumSingle.<init>()
            //IllegalArgumentException: Cannot reflectively create enum objects
            EnumSingle enumSingle = constructor.newInstance();
            System.out.println(enumSingle);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}