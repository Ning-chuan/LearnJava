package utilclass;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class JDK8DateTimeFormatterTest {
    /**
     * 用于测试：DateTimeFormatter类 
     */
    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //把LocalDateTime格式化为指定格式的字符串
        String formatStr = formatter.format(LocalDateTime.now());//2020-09-15 03:57:38
        System.out.println("formatStr = " + formatStr);
        
        //把指定字符串解析成日期
        TemporalAccessor parse = formatter.parse("2020-06-06 06:06:00");
        System.out.println("parse = " + parse);
        
        
    }
}
