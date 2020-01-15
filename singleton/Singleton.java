package singleton;

public class Singleton {
    //第一步：私有的构造方法，目的是不让其他人随便new对象
    private Singleton(){}
    //第二部：私有 静态 当前类对象作为属性
    private static Singleton singleton;
    //上一行singleton后面如果加 = new Singleton();属于 饿汉型（立即加载）
    //第三步：公有 静态 返回当前类对象 （此方法执行完毕，只返回了Singleton类对象引用的地址）
    public static Singleton getSingleton(){
        if(singleton==null) {//调用时才加载，属于懒汉型（延迟加载）
            singleton = new Singleton();
        }
        return singleton;
    }
}
