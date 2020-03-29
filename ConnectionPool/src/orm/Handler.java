package orm;


import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


public class Handler {

    /**
     *
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
    //处理obj是map集合的情况
    //public void






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


}
