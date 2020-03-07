package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Dao {

    private String className = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/union_query?serverTimezone=CST";


    //3.查询各地区城市人口平均数 按照人口平均数降序排列
    public ArrayList<HashMap<String,Object>> thirdTopic(){
        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        try {
            String sql = "SELECT ANAME,AVG(CITYSIZE) FROM CITY C INNER JOIN AREA A ON C.AID=A.AID GROUP BY A.AID ORDER BY AVG(CITYSIZE) DESC;";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,"root","root");
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,Object> map = new HashMap<>();
                map.put("aname",rs.getString("aname"));
                map.put("avg(citysize)",rs.getInt("avg(citysize)"));
                list.add(map);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //2.查询每个国家的城市个数 按照城市个数升序排列
    public ArrayList<HashMap<String,Object>> secondTopic(){
        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        try {
            String sql = "SELECT CNAME,COUNT(CITYID) FROM COUNTRY C INNER JOIN AREA A ON C.CID=A.CID INNER JOIN CITY ON A.AID=CITY.AID GROUP BY C.CID ORDER BY COUNT(CITYID) ASC;";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,"root","root");
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,Object> map = new HashMap<>();
                map.put("cname",rs.getString("cname"));
                map.put("count(cityid)",rs.getInt("count(cityid)"));
                list.add(map);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //1.查询人口数在1000到2000之间的城市所属在哪个地区
    public ArrayList<HashMap<String,Object>> firstTopic(){
        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        try {
            String sql = "SELECT CITYNAME,CITYSIZE,ANAME FROM CITY INNER JOIN AREA ON CITY.AID=AREA.AID WHERE CITYSIZE BETWEEN 1000 AND 2000;";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,"root","root");
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,Object> map = new HashMap<>();
                map.put("cityname",rs.getString("cityname"));
                map.put("citysize",rs.getInt("citysize"));
                map.put("aname",rs.getString("aname"));
                list.add(map);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }




}
