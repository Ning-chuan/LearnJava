package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * 专门读取配置文件的类
 */
public class ConfigurationReader {
    //集合用来存储读取到的文件
    private static HashMap<String,String> map = new HashMap<>();

    static{
        try {
            Properties pro = new Properties();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("Configuration.properties");
            pro.load(is);
            Enumeration en = pro.propertyNames();
            while(en.hasMoreElements()){
                String key = (String) en.nextElement();
                String value = pro.getProperty(key);
                map.put(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key){
        return map.get(key);
    }
    public static Integer getInteger(String key){
        return new Integer(map.get(key));
    }
}
