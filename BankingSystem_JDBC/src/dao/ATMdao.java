package dao;

import domain.User;

import java.sql.*;

public class ATMdao {

    private String className = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/atm?serverTimezone=CST";


    //设计一个方法 删除一条记录
    public boolean delete(String name){
        int result = 0;
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        String sql = "DELETE FROM USERS WHERE ANAME=?";
        try {

            Class.forName(className);
            conn = DriverManager.getConnection(url,"root","root");
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,name);
            result = pstat.executeUpdate();
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
        if(result==1){
            return true;
        }else{
            return false;
        }
    }



    //设计一个方法 新增一条记录
    public boolean insert(User user){
        int result = 0;
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        String sql = "INSERT INTO USERS VALUES(?,?,?)";
        try {

            Class.forName(className);
            conn = DriverManager.getConnection(url,"root","root");
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,user.getName());
            pstat.setString(2,user.getPassword());
            pstat.setFloat(3,user.getBalance());
            result = pstat.executeUpdate();
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
        if(result==1){
            return true;
        }else{
            return false;
        }
    }



    //设计一个方法 更新一条记录
    public boolean update(User user){
        int result = 0;
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        String sql = "UPDATE USERS SET APASSWORD=?,ABALANCE=? WHERE ANAME=?;";
        try {

            Class.forName(className);
            conn = DriverManager.getConnection(url,"root","root");
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,user.getPassword());
            pstat.setFloat(2,user.getBalance());
            pstat.setString(3,user.getName());
            result = pstat.executeUpdate();
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
        if(result==1){
            return true;
        }else{
            return false;
        }
    }






    //设计一个方法 选中一条记录
    public User selectOne(String name){
        User user = null;
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM USERS WHERE ANAME=?";
        try {

            Class.forName(className);
            conn = DriverManager.getConnection(url,"root","root");
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,name);
            rs = pstat.executeQuery();
            if(rs.next()){
                user = new User();
                user.setName(rs.getString("aname"));
                user.setPassword(rs.getString("apassword"));
                user.setBalance(rs.getFloat("abalance"));
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
        return user;
    }
}
