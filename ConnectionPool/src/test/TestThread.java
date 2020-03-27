package test;

public class TestThread extends Thread{
    public void run(){
        //模拟ConnectionPool的使用
        MyConnection mc = ConnectionPool.getInstance().getMyConnection();
        System.out.println(mc);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mc.setCanUsed(true);//假设mc使用5秒之后释放 设置状态为可用
    }
}
