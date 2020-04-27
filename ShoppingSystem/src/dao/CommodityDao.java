package dao;

import domain.Commodity;
import domain.Kind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommodityDao {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/shopping?serverTimezone=CST";
    String userName = "root";
    String password = "root";

    //获取一类商品
    public ArrayList<Commodity> selectCommodity(Integer kid){
        ArrayList<Commodity> commodityList = new ArrayList<>();
        String sql = "SELECT CID,CNAME,CPRICE,KID FROM COMMODITY WHERE KID=?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,userName,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,kid);
            ResultSet rs =  pstat.executeQuery();
            while(rs.next()){
                Commodity commodity = new Commodity();
                commodity.setCid(rs.getInt("cid"));
                commodity.setCname(rs.getString("cname"));
                commodity.setCprice(rs.getFloat("cprice"));
                //下面的kind也可以去掉
                Kind kind = new Kind();
                kind.setKid(rs.getInt(kid));
                commodity.setKind(kind);
                commodityList.add(commodity);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commodityList;
    }


}
