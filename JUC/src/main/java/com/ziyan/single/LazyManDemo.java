package com.ziyan.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazyManDemo {
    public static void main(String[] args) {
        try {
            //利用反射直接找到其构造方法，创建对象，破坏单例
            Class<LazyMan> lazyManClass = LazyMan.class;
            Constructor<LazyMan> constructor = lazyManClass.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            LazyMan lazyMan = constructor.newInstance();
            LazyMan lazyMan1 = LazyMan.getInstance();
            LazyMan lazyMan2 = LazyMan.getInstance();
            System.out.println(lazyMan);
            System.out.println(lazyMan1);
            System.out.println(lazyMan2);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

class LazyMan{
    //私有构造方法
    private LazyMan(){

    }
    private static LazyMan instance;
    public static LazyMan getInstance(){
        if(instance == null) {
            synchronized (LazyMan.class) {
                if (instance == null) {
                    instance = new LazyMan();
                }
            }
        }
        return instance;
    }
}
