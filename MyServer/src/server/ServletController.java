package server;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;


//这个类是为了管理findController方法
//因为我们希望在ServerHandler类中只进行读取与解析的操作 所以把findController抽离出来

public class ServletController {

    //设置一个集合属性缓存web.properties信息  以后要找直接在该集合里面找就行了 不用每一次都读取文件
    private static HashMap<String, String> controllerNameMap = new HashMap<>();

    //我们希望设置一个集合来管理Controller对象 因为我们只使用Controller对象里面的一个方法 没有必要每一次都创建新的对象
    private static HashMap<String, HttpServlet> controllerObjectMap = new HashMap<>();
    //上面采用延迟加载的方式（懒汉式）
    //也可以使用立即加载方式 即上面两个属性只保留controllerObjectMap
    //在初始化时就把全部的Controller对象加载出来 但是这样会在程序在开始执行时耗费一些性能

    static {//初始化缓存信息
        try {
            Properties pro = new Properties();
            pro.load(new FileReader("src//web.properties"));
            Enumeration en = pro.propertyNames();
            while (en.hasMoreElements()) {
                String content = (String) en.nextElement();
                String realControllerName = pro.getProperty(content);
                controllerNameMap.put(content, realControllerName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //找Controller干活
    public static void findController(HttpServletRequest request, HttpServletResponse response) {
        String content = null;
        try {
            //找到request对象里content属性之后利用反射找到对应的Controller控制器
            //我们需要的是content对应Controller控制器的类全名 但是url中不可能写类全名 原因如下
            //（因为在url中 . 符号后面的内容被认为是前面内容的类型 而不是路径）
            //所以我们需要自定义一个properties文件存储content资源对应的Controller控制器类全名信息
            content = request.getContent();
            HttpServlet controllerObject = controllerObjectMap.get(content);
            if (controllerObject == null) {
                //说明这个集合中没有这个controller对象 需要通过反射创建一个对象
                //在缓存集合中找真实Controller类名
                String realControllerName = controllerNameMap.get(content);
                if (realControllerName != null) {//说明找到了真实类名
                    Class clazz = Class.forName(realControllerName);
                    controllerObject = (HttpServlet) clazz.newInstance();
                    controllerObjectMap.put(content, controllerObject);
                }
            }


            Class clazz = controllerObject.getClass();
            Method method = clazz.getMethod("service", HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(controllerObject, request, response);
        } catch (ClassNotFoundException e) {
            response.write("请求的"+content+"Controller不存在");
        }catch (NoSuchMethodException e) {
            response.write("402 没有可以执行的方法");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
