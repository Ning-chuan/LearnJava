package myutil;

public class TestString {
    public static void main(String[] args){
        String s1 = "abcd";
        String s2 = "abcd";
        String s3 = new String("abcd");
        String s4 = new String("abcd");
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s3==s4);//false
        //String类将equals方法重写了  比较的是字符值
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s3.equals(s4));//true

    }
}
