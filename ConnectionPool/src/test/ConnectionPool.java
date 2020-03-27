package test;

import java.util.ArrayList;

public class ConnectionPool {
    //单例模式
    private ConnectionPool(){

    }
    private static ConnectionPool connectionPool;
    public static ConnectionPool getInstance(){
        if(connectionPool==null){
            synchronized(ConnectionPool.class) {
                if(connectionPool==null) {//双重判定
                    connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }


    private static final int DEFAULT_CONNECTIONS = 10;

    private ArrayList<MyConnection> connectionList = new ArrayList<>();
    {
        Integer minCount = ConfigurationReader.getInteger("minCount");
        if(minCount==null){
            minCount = DEFAULT_CONNECTIONS;
        }
        while(connectionList.size()< minCount){
            connectionList.add(new MyConnection());
        }
    }

    //设计方法 让别人从连接池获取MyConnection对象
    private MyConnection getMc(){
        MyConnection result = null;
        for(MyConnection mc: connectionList){
            synchronized (mc) {
                if (mc.isCanUsed() == true) {
                    mc.setCanUsed(false);
                    result = mc;
                    break;
                }
            }
        }
        return result;
    }

    //设计方法 间隔时间获取连接
    public MyConnection getMyConnection(){
        MyConnection result = this.getMc();
        int waitTime = ConfigurationReader.getInteger("waitTime");
        int count = 0;
        while(result==null && count<waitTime*10){
            try {
                Thread.sleep(100);
                result = this.getMc();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(result==null){
            throw new ConnectionPoolBusyException("连接池正忙，请稍后重试");
        }
        return result;
    }
}
