package myutil;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {
    public static void main(String[] args){
        //返回当前系统时间与计算机元年之间的毫秒差
        //1970-1-1  00:80:00
        long time = System.currentTimeMillis();
        System.out.println(time);

        Date date1 = new Date(1579789674299L);
        Date date2 = new Date();
        System.out.println(date2);
        //Date重写了toString 上面打印输出是 格林威治格式Thu Jan 23 22:30:11 CST 2020
        boolean x = date1.before(date2);
        boolean y = date1.after(date2);
        System.out.println(x+"--"+y);
        date1.setTime(1559789674299L);
        long reTime = date1.getTime();
        System.out.println(date2.compareTo(date1));//若date2在date1之后结果是1 反之为-1

        //2020-1-23 23:10:06
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String v = sdf.format(date2);
        System.out.println(v);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        calendar.set(calendar.YEAR,2018);
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);//从零开始数
        int day = calendar.get(calendar.DAY_OF_MONTH);
        System.out.println(year+"-"+month+"-"+day);
        TimeZone tz = calendar.getTimeZone();
        System.out.println(tz);
        System.out.println(tz.getID());
        System.out.println(tz.getDisplayName());
    }
}
