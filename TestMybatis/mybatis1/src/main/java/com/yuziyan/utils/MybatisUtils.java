package com.yuziyan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    //一个工程最好只有一个SqlSessionFactory对象 设计为单例的
    private static SqlSessionFactory sqlSessionFactory;
    
    static{
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //SqlSessionFactoryBuilder对象只使用一次 最好放在方法（代码块）作用域
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlSession(){
        //每个线程（会话）最好独有一个SqlSession对象 所以每次获取时都创建新的
        return sqlSessionFactory.openSession();
    }
}
