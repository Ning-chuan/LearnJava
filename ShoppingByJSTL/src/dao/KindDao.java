package dao;

import domain.Kind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KindDao {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/shopping?serverTimezone=CST";
    String userName = "root";
    String password = "root";
    public ArrayList<Kind> selectAllKinds(){
        ArrayList<Kind> kindList = new ArrayList<>();
        String sql = "SELECT KID,KNAME FROM KINDS";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,userName,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                Integer kid = rs.getInt("kid");
                String kname = rs.getString("kname");
                Kind kind = new Kind(kid,kname);
                kindList.add(kind);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kindList;
    }





}
