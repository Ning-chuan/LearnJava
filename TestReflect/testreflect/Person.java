package testreflect;

public class Person {
    private String name;
    public int age;

    public String toString(){
        return "{"+this.name+","+this.age+"}";
    }
}
