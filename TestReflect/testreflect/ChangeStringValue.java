package testreflect;

import java.lang.reflect.Field;

public class ChangeStringValue {
    public static void main(String[] args) {
        String str = "abc";
        Class clazz = str.getClass();
        try {
            Field f = clazz.getDeclaredField("value");
            f.setAccessible(true);//3.直接操作属性的值不可以 设置私有属性可以被操作
            char[] temp = (char[])f.get(str);
            temp[0]='王'; temp[1]='振'; temp[2]='宇';
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
