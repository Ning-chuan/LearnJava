package utilclass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateTime {
    /**
     * 测试：java.util.Date和java.sql.Date类
     */
    @Test
    public void testDate(){
       //java.util.Date
       //1.无参构造：
       Date date = new Date();
       System.out.println("date = " + date);
       //2.毫秒参数构造：
       Date date1 = new Date(592908457908L);
       System.out.println("date1 = " + date1);

       //java.sql.Date (这个类是java.util.Date的子类)
       //1.带毫秒参数构造：
       java.sql.Date date2 = new java.sql.Date(123987649848L);
       System.out.println("date2 = " + date2);

       //java.sql.Date可以直接用java.util.Date接收
       Date date4 = date2;
       System.out.println("date4 = " + date4);

       //把java.util.Date转换成java.sql.Date（通过带毫秒参数的构造器）
       java.sql.Date date3 = new java.sql.Date(date1.getTime());
       System.out.println("date3 = " + date3);
    }

    /**
     * 用于测试：SimpleDateFormat类的使用
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //默认空参构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();
        System.out.println("date = " + date);

        //格式化方法：Date ——> 字符串
        String formatDate = sdf.format(date);//20-9-14 下午4:36 （默认格式化成这种格式）
        System.out.println("formatDate = " + formatDate);
        //解析方法：字符串 --> Date
        Date parseDate = sdf.parse("19-9-14 下午1:00");
        System.out.println("parseDate = " + parseDate);
        
        //指定格式的构造器：
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //按照构造时指定的格式格式化：
        String formatDate1 = sdf1.format(date);
        System.out.println("formatDate1 = " + formatDate1);
        //把日期字符串解析成Date
        Date parseDate1 = sdf1.parse("2020-01-01 09:00:00");
        System.out.println("parseDate1 = " + parseDate1);
    }

    /**
     * 例题：字符串"2020-9-14"转换成java.sql.Date
     */
    @Test
    public void test() throws ParseException {
        String str = "2020-9-14";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = new java.sql.Date(sdf.parse(str).getTime());
        System.out.println("date = " + date);
    }
}
