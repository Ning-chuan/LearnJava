package testtimer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    int count = 0;//记录执行次数

    private ArrayList<String> userBox = new ArrayList<>();
    {
        userBox.add("王晨曦");
        userBox.add("陈浩然");
        userBox.add("崔林森");
        userBox.add("苟犇");
        userBox.add("卡麦力");
    }

    public void test() throws ParseException {

        System.out.println("准备启动");
        Timer t = new Timer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = sdf.parse("2020-02-09 09:28:00");
        t.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("第"+(++count)+"次执行");
                for(int i=0;i<userBox.size();i++){
                    System.out.println("给"+userBox.get(i)+"发送短信：[高跟鞋紧身裤，我是宇哥你记住]");
                }
                System.out.println("当前轮次执行完毕");
            }

        },startTime,2500);
    }


    public static void main(String[] args){
        TestTimer tt = new TestTimer();
        try {
            tt.test();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
