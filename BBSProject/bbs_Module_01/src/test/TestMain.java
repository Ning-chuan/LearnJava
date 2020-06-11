package test;

import domain.Student;
import newdao.StudentDao;
import orm.SqlSession;

public class TestMain {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectOne(1);
        System.out.println(student);


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
