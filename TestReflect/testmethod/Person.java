package testmethod;

public class Person {
    public Person(){
        System.out.println("我是Person无参数的构造方法");
    }


    public void eat(){
        System.out.println("我是Person的吃饭方法");
    }

    public void eat(String str){
        System.out.println("我是Person带"+str+"参数的吃饭方法");
    }

    private void test(){
        System.out.println("我是Person的私有方法");
    }


}
