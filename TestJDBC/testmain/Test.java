package testmain;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args){
//        //标准流程：
//        try {
//            //1.导包 （将mysql-connector-java.jar文件导入到当前工程里）
//            //2.加载驱动类 Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");//加载Driver类中的静态元素
//            //3.获取连接
//            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=CST";
//            Connection conn = DriverManager.getConnection(url,"root","root");
//            //4.创建状态参数(流)
//            Statement stat = conn.createStatement();
//            //5.执行数据库操作
//            stat.executeUpdate("insert into emp(empno,ename) values(9999,'wzy')");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



        try {
            String className = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=CST";
            String user = "root";
            String password = "root";
            String sql = "delete from emp where empno=8888";
            //String sql = "insert into emp(empno,ename) values(8888,'wzy')";
            //1.导包 （将mysql-connector-java.jar文件导入到当前工程里 新建一个lib包 粘贴进去）
            //2.加载驱动类 Driver 有以下几种方式

            Class.forName(className);//1
            //DriverManager.registerDriver(new Driver());//2
            //new Driver();//3 直接创建驱动对象也可以达到
            //System.setProperty("jdbc.driver","com.mysql.cj.jdbc.Driver");// 4
            //3.获取连接

            Connection conn = DriverManager.getConnection(url,user,password);
            //4.创建状态参数 (流)
            Statement stat = conn.createStatement();
            //5.执行数据库操作
            int count = stat.executeUpdate(sql);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
