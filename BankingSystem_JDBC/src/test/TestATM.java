package test;

import java.sql.*;

public class TestATM {
    //登录
    public String login(String name,String password){
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/atm?serverTimezone=CST";
            String sql = "SELECT NAME,PASSWORD FROM USERS WHERE NAME=?";
            Class.forName(className);
            conn = DriverManager.getConnection(url,"root","root");
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,name);
            rs = pstat.executeQuery();
            if(rs.next() && rs.getString("password").equals(password)){
                return "登陆成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(pstat!=null) {
                    pstat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "用户名或密码错误";
    }
}
