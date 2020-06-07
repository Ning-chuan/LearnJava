package dynamicproxy;

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
