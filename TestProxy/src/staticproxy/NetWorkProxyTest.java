package staticproxy;

public class NetWorkProxyTest {
    public static void main(String[] args) {
        //1.创建一个真实类对象（真实服务器）
        Server server = new Server();
        //2.创建代理类对象，被代理类对象作为参数 （代理服务器）
        ServerProxy serverProxy = new ServerProxy(server);
        //3.调用代理类的目标方法（浏览方法）
        serverProxy.browse();
    }
}

//接口
interface NetWork{
    void browse();
}

//被代理类
class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("真实服务器的浏览方法");
    }
}

//代理类
class ServerProxy implements NetWork{

    private NetWork work;//聚合共同的接口作为属性
    public ServerProxy(NetWork work){
        this.work = work;
    }

    public void browse(){
        System.out.println("进行浏览之前的一些准备、检查工作");
        work.browse();
        System.out.println("浏览完毕");
    }
}
