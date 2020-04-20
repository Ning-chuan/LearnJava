package dao;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//dao层 负责读写数据
public class AtmDao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/atm?serverTimezone=CST";
    private String userName = "root";
    private String password = "root";

    public User selectOne(String aname) {

        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM USERS WHERE ANAME=?";
        User user = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                user = new User();
                user.setAname(rs.getString("aname"));
                user.setApassword(rs.getString("apassword"));
                user.setAbalance(rs.getFloat("abalance"));
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
