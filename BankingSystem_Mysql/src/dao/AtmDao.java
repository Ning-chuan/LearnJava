package dao;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AtmDao {

    private String className = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/atm?serverTimezone=CST";
    private String name = "root";
    private String password = "root";


    //删除一条信息
    public int delete(String aname){
        int result = 0;
        try {
            String sql = "DELETE FROM USERS WHERE ANAME=?";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,name,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            result = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //更新一条信息
    public int update(User user){
        int result = 0;
        try {
            String sql = "UPDATE USERS SET APASSWORD=?,ABALANCE=? WHERE ANAME=?";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,name,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,user.getApassword());
            pstat.setFloat(2,user.getAbalance());
            pstat.setString(3,user.getAname());
            result = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    //新增一条记录
    public int insert(User user){
        int result = 0;
        try {
            String sql = "INSERT INTO USERS VALUES(?,?,?)";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,name,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,user.getAname());
            pstat.setString(2,user.getApassword());
            pstat.setFloat(3,user.getAbalance());
            result = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    //选中一条记录 返回User对象
    public User selectOne(String aname){
        User user = null;
        try {
            String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM USERS WHERE ANAME=?";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,name,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                user = new User();
                user.setAname(rs.getString("aname"));
                user.setApassword(rs.getString("apassword"));
                user.setAbalance(rs.getFloat("abalance"));
                rs.close();
                pstat.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
