package staticproxy;

public class StarProxyTest {
    public static void main(String[] args) {
        StarProxy proxy = new StarProxy(new Star());
        //调用方法都是通过代理而不是明星
        proxy.bookTicket();
        proxy.collectMoney();
        proxy.confer();
        proxy.signContract();
        proxy.sing();
    }
}
//共同接口
interface Stars{
    void confer();//面谈

    void signContract();//签合同

    void bookTicket();//订票

    void sing();//唱歌

    void collectMoney();//收钱
}
//具体明星（被代理类）
class Star implements Stars{
    public void confer() {
    }

    public void signContract() {
    }
    public void bookTicket() {
    }
    public void sing() {
        System.out.println("明星唱歌ing~~");
    }
    public void collectMoney() {
    }
}
//明星经纪人（代理类）
class StarProxy implements Stars{

    private Stars realStar;//聚合一个 接口对象！！！ 作为属性
    public StarProxy(Stars realStar){
        this.realStar = realStar;
    }

    public void confer() {
        System.out.println("经纪人代明星面谈");
    }
    public void signContract() {
        System.out.println("经纪人代明星签合同");
    }
    public void bookTicket() {
        System.out.println("经纪人代明星订票");
    }
    public void sing() {
        System.out.println("经纪人告知明星唱歌");
        realStar.sing();//调用接口对象的sing()方法 因为多态效果 实际调用的时候是真实明星的sing()
    }
    public void collectMoney() {
        System.out.println("经纪人代明星收钱");
    }
}