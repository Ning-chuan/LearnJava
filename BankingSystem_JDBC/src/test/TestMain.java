package test;

public class TestMain {
    public static void main(String[] args){
        TestATM ta = new TestATM();
        String result = ta.login("张三","333");
        System.out.println(result);
    }
}
