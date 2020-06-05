package testreflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        //方式一：
        FileInputStream fis = new FileInputStream("src\\info.properties");//默认在当前工程根目录下找资源
        prop.load(fis);

        //方式二：
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();//获取系统类加载器 AppClassLoader
//        InputStream is = classLoader.getResourceAsStream("info.properties");//默认在src路径下找资源
//        prop.load(is);


        String name = prop.getProperty("name");
        String password = prop.getProperty("password");
        System.out.println("name="+name+",password="+password);

    }
}
