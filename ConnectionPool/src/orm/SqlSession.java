package orm;

import com.mysql.cj.result.Row;
import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlSession {
    /**
     * 这个类用作纯JDBC和sql语句的操作
     */

    private Handler handler = new Handler();

    //方法一: 类似Mybatis
    //让用户传一个我们规定好格式的sql语句 我们自己来解析
    //更新一条记录 增删改
    public void myUpdate(String sql,Object obj) throws Exception {
        //sql为我们规定的格式 需要解析成可用的 因此设计一个专门解析的方法 在Handler类里面
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
    //查询一条记录
    public <T>T selectOne(String sql,Object obj,Class resultType) throws IllegalAccessException, NoSuchFieldException, SQLException {
        Object result = null;
        SqlAndKey sak = handler.analyzeSql(sql);
        String newSql = sak.getSql();
        ArrayList<String> keyList = sak.getKeyList();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getMyConnection();
        PreparedStatement pstat = conn.prepareStatement(newSql);
        if(obj!=null){//说明语句中存在? 我们需要把?的值设置好 调用我们设计的方法
            pstat = handler.setValues(pstat,obj,keyList);
        }
        ResultSet rs = pstat.executeQuery();
        //我们需要根据resultType来处理结果 设计方法帮我们处理
        if(rs.next()){
            result = handler.handleResult(rs,resultType);
        }
        pstat.close();
        conn.close();
        rs.close();
        return (T)result;
    }
    public <T> List<T> selectList(String sql, Object obj, Class resultType) throws SQLException, NoSuchFieldException, IllegalAccessException {
        List<T> resultList = new ArrayList<>();

        SqlAndKey sak = handler.analyzeSql(sql);
        String newSql = sak.getSql();
        ArrayList<String> keyList = sak.getKeyList();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getMyConnection();
        PreparedStatement pstat = conn.prepareStatement(newSql);
        if(obj!=null){//说明语句中存在? 我们需要把?的值设置好 调用我们设计的方法
            pstat = handler.setValues(pstat,obj,keyList);
        }
        ResultSet rs = pstat.executeQuery();
        //我们需要根据resultType来处理结果 设计方法帮我们处理
        while(rs.next()){
            resultList.add((T)handler.handleResult(rs,resultType));
        }
        pstat.close();
        conn.close();
        rs.close();
        return resultList;
    }

//    //方法二:  SpringJDBC 方式
//    //让用户根据?顺序传一个对应的Object数组
//    public void myUpdate(String sql,Object... objs) throws Exception {
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        Connection conn = connectionPool.getMyConnection();
//        PreparedStatement pstat = conn.prepareStatement(sql);
//        if(objs != null) {
//            for (int i = 0; i < objs.length; i++) {
//                pstat.setObject(i + 1, objs[i]);
//            }
//        }
//        pstat.executeUpdate();
//        pstat.close();
//        conn.close();
//    }
//    //查询一条记录
//    public <T>T selectOne(String sql,RowMapper rm,Object... objs) throws IllegalAccessException, NoSuchFieldException, SQLException {
//        Object result = null;
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        Connection conn = connectionPool.getMyConnection();
//        PreparedStatement pstat = conn.prepareStatement(sql);
//        if(objs != null) {
//            for (int i = 0; i < objs.length; i++) {
//                pstat.setObject(i + 1, objs[i]);
//            }
//        }
//        ResultSet rs = pstat.executeQuery();
//        if(rs.next()){
//            result = rm.mapperRow(rs);
//        }
//        pstat.close();
//        conn.close();
//        return (T)result;
//    }
//    public <T> List<T> selectList(String sql,RowMapper rm,Object... objs) throws SQLException {
//        List<T> list = new ArrayList<>();
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        Connection conn = connectionPool.getMyConnection();
//        PreparedStatement pstat = conn.prepareStatement(sql);
//        if(objs != null) {
//            for (int i = 0; i < objs.length; i++) {
//                pstat.setObject(i + 1, objs[i]);
//            }
//        }
//        ResultSet rs = pstat.executeQuery();
//        while(rs.next()){
//            list.add((T)rm.mapperRow(rs));
//        }
//        pstat.close();
//        conn.close();
//        return list;
//    }

}
