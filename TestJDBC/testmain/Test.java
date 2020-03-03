package testmain;

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
//            Class.forName("com.mysql.cj.jdbc.Driver");
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



        //1.导包 （将mysql-connector-java.jar文件导入到当前工程里）
        //2.加载驱动类 Driver
        Class.forName("com.mqsql.");
    }
}
