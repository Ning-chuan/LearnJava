package orm;

import domain.Student;
import pool.ConnectionPool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SqlSession {
    /**
     * 这个类用作纯JDBC和sql语句的操作
     */

    private Handler handler = new Handler();


    //方法一: 类似Mybatis
    public void myUpdate(String sql,Object obj) throws Exception {
        //sql为我们规定的格式 需要解析成可用的 因此设计一个专门解析的方法
        SqlAndKey sak = handler.analyzeSql(sql);
        String newSql = sak.getSql();
        ArrayList<String> keyList = sak.getKeyList();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getMyConnection();
        PreparedStatement pstat = conn.prepareStatement(newSql);

        //设计方法 按照keys给sql语句的问号逐个赋值 需要用到反射
        for(int i=0;i<keyList.size();i++){
            Class clazz = obj.getClass();

            Field f = clazz.getDeclaredField(keyList.get(i));
            f.setAccessible(true);
            pstat.setObject(i+1,f.get(obj));
        }
        pstat.executeUpdate();
        pstat.close();
        conn.close();
    }


    //方法二：

}
