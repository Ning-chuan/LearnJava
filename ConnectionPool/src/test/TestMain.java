package test;

import domain.Student;
import pool.ConnectionPool;
import service.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws Exception {
        StudentService service = new StudentService();
//        service.insert(new Student(6," FLY","男",19));
//        Map<String,Object> map = new HashMap<>();
//        map.put("sid",6);
//        map.put("sname","渡劫");
//        map.put("sex","男");
//        map.put("sage",19);
//        service.update(map);
//        service.insert(new Student(7,"花满楼","男",19));
//        service.insert(7,"花满楼","男",18);
        service.delete(5);




//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        Connection conn = connectionPool.getMyConnection();
//        PreparedStatement pstat = conn.prepareStatement("SELECT * FROM PERSON;");
//        ResultSet rs = pstat.executeQuery();
//        while(rs.next()){
//            System.out.println(rs.getString("username")+"--"+rs.getString("address"));
//        }
//        conn.close();
//        pstat.close();
//        rs.close();


//        TestThread t1 = new TestThread();
//        TestThread t2 = new TestThread();
//        TestThread t3 = new TestThread();
//        TestThread t4 = new TestThread();
//        TestThread t5 = new TestThread();
//        TestThread t6 = new TestThread();
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();



//        long t1 = System.currentTimeMillis();
//        ConnectionPool cp = ConnectionPool.getInstance();
//        MyConnection mc = cp.getMyConnection();
//        long t2 = System.currentTimeMillis();
//        mc.setCanUsed(false);
//        Connection conn = mc.getConnection();
//        PreparedStatement pstat = conn.prepareStatement("SELECT * FROM PERSON;");
//        ResultSet rs = pstat.executeQuery();
//        while(rs.next()){
//            System.out.println(rs.getString("username")+"--"+rs.getString("address"));
//        }
//
//        long t3 = System.currentTimeMillis();
//        System.out.println(t2-t1);
//        System.out.println(t3-t2);
//        pstat.close();
//        rs.close();
//        mc.setCanUsed(true);
//
//        System.out.println("========================================");
//
//        long t4 = System.currentTimeMillis();
//        MyConnection mc1 = cp.getMyConnection();
//        long t5 = System.currentTimeMillis();
//        mc1.setCanUsed(false);
//        Connection conn1 = mc1.getConnection();
//        PreparedStatement pstat1 = conn1.prepareStatement("SELECT * FROM PERSON;");
//        ResultSet rs1 = pstat1.executeQuery();
//        while(rs1.next()){
//            System.out.println(rs1.getString("username")+"--"+rs1.getString("address"));
//        }
//
//        long t6 = System.currentTimeMillis();
//        System.out.println(t5-t4);
//        System.out.println(t6-t5);
//        pstat1.close();
//        rs1.close();
//        mc1.setCanUsed(true);



//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=CST","root","root");
//        PreparedStatement pstat = conn.prepareStatement("SELECT * FROM PERSON;");
//        ResultSet rs = pstat.executeQuery();
//        while(rs.next()){
//            System.out.println(rs.getString("username")+"--"+rs.getString("address"));
//        }
//        conn.close();
//        pstat.close();
//        rs.close();
    }
}
