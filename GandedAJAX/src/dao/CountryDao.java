package dao;

import domain.Country;

import java.sql.*;
import java.util.ArrayList;

public class CountryDao {

    public ArrayList<Country> selectAllCountry() {
        ArrayList<Country> countryList = new ArrayList<>();
        //jdbc连接过程
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/union_query?serverTimezone=UTC";
        String user = "root";
        String password = "root";
        String sql = "SELECT CID,CNAME FROM COUNTRY";
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName(driver);
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
            //获取状态参数
            pstat = conn.prepareStatement(sql);
            //执行查询
            rs = pstat.executeQuery();
            //把结果添加到结果集
            while (rs.next()) {
                countryList.add(new Country(rs.getInt("cid"), rs.getString("cname")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (pstat != null){
                try {
                    pstat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //返回结果
        return countryList;
    }
}
