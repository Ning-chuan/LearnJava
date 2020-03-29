package orm;

import domain.Student;
import pool.ConnectionPool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Handler {


    /**
     *
     */


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
