package orm;

import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SqlSession {
    /**
     * 这个类用作纯JDBC和sql语句的操作
     */

    private Handler handler = new Handler();

    //方法一:
    //让用户传一个我们规定好格式的sql语句 我们自己来解析
    //类似Mybatis
    public void myUpdate(String sql,Object obj) throws Exception {
        //sql为我们规定的格式 需要解析成可用的 因此设计一个专门解析的方法
        SqlAndKey sak = handler.analyzeSql(sql);
        String newSql = sak.getSql();
        ArrayList<String> keyList = sak.getKeyList();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getMyConnection();
        PreparedStatement pstat = conn.prepareStatement(newSql);
        if(obj!=null){//说明语句中存在? 我们需要把?的值设置好 调用我们设计的方法
            pstat = handler.setValues(pstat,obj,keyList);
        }
        pstat.executeUpdate();
        pstat.close();
        conn.close();
    }


    //方法二:
    //让用户根据?顺序传一个对应的Object数组
    public void myUpdate(String sql,Object... obj) throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection conn = connectionPool.getMyConnection();
        PreparedStatement pstat = conn.prepareStatement(sql);
        for(int i=0;i<obj.length;i++){
            pstat.setObject(i+1,obj[i]);
        }
        pstat.executeUpdate();
        pstat.close();
        conn.close();
    }
}
