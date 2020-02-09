package testreflect;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args){
        try {
            Class clazz = Class.forName("testreflect.Person");
            Person p = (Person)clazz.newInstance();

            int m = clazz.getModifiers();//获取类的修饰符
//            每一个修饰符 用一个整数来进行表示
//            0开始---0 1 2 4 8 16 32 64 128 256 512
//            0--默认不写  1--public  2--private  4--protected
//            8--static   16--final  32--synchronized  64volatile
//            128--transient  256--native  512--interface  1024--abstract
            System.out.println(m);
            System.out.println(clazz.getSimpleName());//获取类名
            System.out.println(clazz.getName());//获取类全名
            System.out.println(clazz.getPackage());//获取包名





//            Field f= clazz.getDeclaredField("name");
//            System.out.println(f.getName());
//            f.setAccessible(true);
//            f.set(p,"宁川");
//            System.out.println(f.get(p));

//            ArrayList<String> list = new ArrayList<>();
//            Class clazz = ArrayList.class;
//            Class c = clazz.getSuperclass();//获取当前类的父类
//            while(c!=null){
//                System.out.println(c.getName());
//                c = c.getSuperclass();
//            }


//            Class[] classes = clazz.getInterfaces();//获取当前clazz的所有接口
//            for(Class s:classes){
//                System.out.println(s.getName());
//            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
