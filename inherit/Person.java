package inherit;

public class Person extends Animal{
    public void eat(){
        super.eat();
        System.out.println("人类的吃饭方法");
    }
}
