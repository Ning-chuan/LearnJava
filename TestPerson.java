public class TestPerson{
    public static void main(String[] args){
        Person a = new Person();
        a.name = "王振宇";
        a.age = 18;
        a.sex = "男";
        a.height = 179;
        Person b = a;
        b.name = "崔林森";
        b.age = 22;
        b.sex = "女";
        b.height = 190;
        System.out.println(a.name+"今年"+a.age+"性别"+a.sex+"身高"+a.height);
        System.out.println(b.name+"今年"+b.age+"性别"+b.sex+"身高"+b.height);
    }
}
