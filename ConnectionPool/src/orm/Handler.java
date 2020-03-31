package orm;


import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Handler {

    /**
     * 为了支持SqlSession中方法一（Mybatis方式）的方法所设计的辅助类
     */

    //设计方法 按照keys给sql语句的问号逐个赋值 需要用到反射
    public PreparedStatement setValues(PreparedStatement pstat,Object obj,ArrayList<String> keyList) throws NoSuchFieldException, IllegalAccessException, SQLException {
        //分析Object可能有以下情况
        //int Integer  float Float  double Double  String  ArrayList  domain对象
        Class clazz = obj.getClass();
        if(clazz==int.class || clazz==Integer.class){
            pstat.setInt(1,(Integer)obj);
        }else if(clazz==float.class || clazz==Float.class){
            pstat.setFloat(1,(Float) obj);
        }else if(clazz==double.class || clazz==Double.class){
            pstat.setDouble(1,(Double)obj);
        }else if(clazz==String.class){
            pstat.setString(1,(String)obj);
        }else if(clazz.isArray()){
            //暂不处理
        }else if(obj instanceof Map){
            Map<String,Object> map = (Map)obj;
            for(int i=0;i<keyList.size();i++){
                pstat.setObject(i+1,map.get(keyList.get(i)));
            }
        }else {//说明obj是domain对象
            for (int i = 0; i < keyList.size(); i++) {
                Field f = clazz.getDeclaredField(keyList.get(i));
                f.setAccessible(true);
                pstat.setObject(i + 1, f.get(obj));
            }
        }
        return pstat;
    }


    //解析sql的方法 eg. INSERT INTO STUDENT VALUES(#{sid},#{sname},#{sex},#{sage})
    //需要返回解析后的sql和key 设计一个类将其包装起来
    public SqlAndKey analyzeSql(String sql){
        StringBuilder newSql = new StringBuilder();
        ArrayList<String> keys = new ArrayList<>();
        while(true){
            int left = sql.indexOf("#{");
            int right = sql.indexOf("}");
            if(left!=-1 && right!=-1 && left<right){
                newSql.append(sql.substring(0,left));
                newSql.append("?");
                keys.add(sql.substring(left+2,right));

            }else{
                //此分支说明没有符合格式的字符串 此时需要把剩余的串拼起来 然后结束循环
                newSql.append(sql);
                break;
            }
            sql = sql.substring(right+1);
        }
        return new SqlAndKey(newSql.toString(),keys);
    }

    //处理结果的方法
    //ResultSet是结果集 resultType是结果的类型 我们可以根据所需将结果的类型来分情况处理
    public Object handleResult(ResultSet rs, Class resultType) throws SQLException {
        Object result = null;
        if(resultType==int.class || resultType==Integer.class){
            result = rs.getInt(1);
        }else if(resultType==float.class || resultType==Float.class){
            result = rs.getFloat(1);
        }else if(resultType==double.class || resultType==Double.class){
            result = rs.getDouble(1);
        }else if(resultType==String.class){
            result  =rs.getString(1);
        }else if(resultType.isArray()){
            //暂不支持
        }else if(resultType==Map.class){
            result = this.handleMap(rs);
        }else{//以上都不是 说明是domain对象
            //另设方法处理
            result = this.handleDomain(rs,resultType);
        }
        return result;
    }

    private Map<String,Object> handleMap(ResultSet rs) throws SQLException {
        Map result = new HashMap();
        ResultSetMetaData rsmd = rs.getMetaData();
        for(int i=1;i<rsmd.getColumnCount();i++){
            String column = rsmd.getColumnName(i);
            Object value = rs.getObject(column);
            result.put(column,value);
        }
        return result;
    }
    private Object handleDomain(ResultSet rs,Class resultType) throws SQLException {
        Object obj = null;
        try {
            obj = resultType.newInstance();
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i=1;i<rsmd.getColumnCount();i++){
                //获取列名
                String column = rsmd.getColumnName(i);
                //获取属性
                Field field = resultType.getDeclaredField(column);
                field.setAccessible(true);
                field.set(obj,rs.getObject(column));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
