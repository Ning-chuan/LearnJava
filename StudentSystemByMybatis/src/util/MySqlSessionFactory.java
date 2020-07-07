package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {

    private static SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    private static SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));

    public static SqlSession getSqlSession(){
        return getSqlSession(false);//不传参数 默认不自动提交
    }

    public static SqlSession getSqlSession(Boolean flag){
        return factory.openSession(flag);//true自动提交  false不会自动提交
    }
}

