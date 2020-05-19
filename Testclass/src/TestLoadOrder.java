public class TestLoadOrder {
    public static void main(String[] args) {
        new Leaf();
        new Leaf();
    }
}

class Root{
    static{
        System.out.println("Root类的类初始化块");
    }
    {
        System.out.println("Root类的实例初始化块");
    }
    public Root(){
        System.out.println("Root的无参数构造器");
    }
}

class Mid extends Root{
    static{
        System.out.println("Mid类的类初始化块");
    }
    {
        System.out.println("Mid类的实例初始化块");
    }
    public Mid(){
        System.out.println("Mid的无参数构造方法");
    }
    public Mid(String msg){
        //this();
        System.out.println("Mid带String参数的构造方法，参数是："+msg);
    }
}

class Leaf extends Mid{
    static{
        System.out.println("Leaf类的类初始化块");
    }
    {
        System.out.println("Leaf类的实例初始化块");
    }
    public Leaf(){
        super("大哥，真帅啊！");
        System.out.println("Leaf的构造方法");
    }
}


