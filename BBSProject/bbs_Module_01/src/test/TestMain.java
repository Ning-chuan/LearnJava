package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestMain {

    public static Date randomDate(String startDate, String endDate){
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        try {
            Date start = format.parse(startDate);
            Date end = format.parse(endDate);
            long newTime = start.getTime() + (long)(Math.random()*(end.getTime() - start.getTime()));
            return new Date(newTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

//        Date randomDate = randomDate("2018-1-1","2020-7-7");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String result = format.format(randomDate);
//        System.out.println(result);

        /* 批量新增数据：
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bbs?useSSL=false&characterEncoding=UTF-8";
        String username = "root";
        String password = "root";
        String sql = "INSERT INTO T_POST(TITLE,CONTENT,DATE,STATUS,BOARDID) VALUES(CONCAT('.NET技术贴',?),'内容：.net技术测试贴',?,?,7);";

        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            pstat = conn.prepareStatement(sql);
            //利用for循环插入10条数据
            for (int i = 0; i < 5; i++) {
                //设置标题序号
                pstat.setInt(1,i+1);
                //设置随机日期
                pstat.setDate(2,new java.sql.Date(randomDate("2020-1-1","2020-7-7").getTime()));
                //设置状态
                if(i < 1){
                    pstat.setString(3,"置顶");
                }else if(i < 3){
                    pstat.setString(3,"精华");
                }else {
                    pstat.setString(3,"普通");
                }
                pstat.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(pstat != null) {
                    pstat.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        */






        /*
        SqlSession sqlSession = new SqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectOne(1);
        System.out.println(student);
        */

        //=============================================
        /*
            封装了简单的连接池和ORM框架
            1.配置文件放在src下，名字叫做configuration.properties
              里面配置的您看一下就能懂，驱动，连接，账号，密码
              还有个初始化最小连接个数，连接被占用时等待的时间
            2.核心类是SqlSession，模拟的MyBatis使用方式
              里面提供了增删改，查询单条，查询多条的方法
              dao包中的StudentDao写了两种执行方式
              一种是动态列表形式配合带?参数SQL
              一种是对象参数形式配合带#{}参数SQL

              newdao包中是在方式二基础上实现的注解配置
              基于注解的形式只能做单个表格操作
              若多表联合查询，只能采用自定义rowmapper方式了
              相对而言比较麻烦

              参数和返回值支持 基本类型 String类型 map类型 domain类型
              main方法中只做了基于注解的demo演示
         */

    }
}
