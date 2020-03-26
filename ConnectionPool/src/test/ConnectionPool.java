package test;

import java.util.ArrayList;

public class ConnectionPool {
    private ConnectionPool(){

    }
    private static ConnectionPool connectionPool;
    public static ConnectionPool getInstance(){
        if(connectionPool==null){
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    private static final int DEFAULT_CONNECTIONS = 10;
    private ArrayList<MyConnection> list = new ArrayList<>();
    {
        while(list.size()< DEFAULT_CONNECTIONS){
            list.add(new MyConnection());
        }
    }

    //设计一个方法 让别人从池中获取MyConnection对象
    public MyConnection getMyConnection(){
        MyConnection result = null;
        for(MyConnection mc:list){
            if(mc.isCanUsed()==true){
                result = mc;
                break;
            }
        }
        return result;
    }
}
