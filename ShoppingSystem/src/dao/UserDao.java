package dao;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/shopping?serverTimezone=CST";
    String userName = "root";
    String password = "root";


    public User selectOne(String uname){
            User user = null;
        String sql = "SELECT UNAME,UPASSWORD FROM USERS WHERE UNAME=?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,userName,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,"uname");
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                String upassword = rs.getString("upassword");
                user = new User(uname,upassword);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
