package com.ziyan.single;

/**
 * 静态内部类实现单列模式：
 */
public class Holder {
    //私有构造方法
    private Holder(){}
    //静态内部类
    //  1：加载外部类Holder时并不会立即加载静态内部类InnerHolder,只有调用getInstance()时才加载，可以保证懒加载。
    //  2：JVM初始化对象时是单线程的，可以保证多线程操作时的安全
    private static class InnerHolder{
        private static final Holder holder = new Holder();
    }
    //共有给外部调用的获取实例的方法
    public static Holder getInstance(){
        return InnerHolder.holder;
    }
}
