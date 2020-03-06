package dao;

import damain.Dept;
import damain.Emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class EmpDao {

    String className = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test?serverTimezone=CST";


    //设计一个方法 查询每个部门的人数(分组查询)
    //domain对象不在合适 选用HashMap<String,Object>存储一行的记录
    //String记录列名字 Object记录该列对应的值
    //把每一行的记录存储在ArrayList中 并返回
    public ArrayList<HashMap<String,Object>> selectGroupByDeptno(){
        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        try {
            String sql = "SELECT DEPTNO,COUNT(EMPNO) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO ASC;";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,"root","root");
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,Object> map = new HashMap<>();
                map.put("deptno",rs.getInt("deptno"));
                map.put("count(empno)",rs.getInt("count(empno)"));
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



    //设计一个方法 联合查询emp和dept
    public ArrayList<Emp> selectEmpAndDept() {
        ArrayList<Emp> result = new ArrayList<Emp>();
        try {
            String sql = "SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO";
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,"root","root");
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getFloat("sal"));
                emp.setComm(rs.getFloat("comm"));
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDeptcme(rs.getString("deptcme"));
                dept.setLoc(rs.getString("loc"));
                emp.setDept(dept);
                result.add(emp);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    //分页查询的方法
    //需要知道起  1始行索引(一般是用户点击确定)  2每页展示行数(前端工程师确定 这里假设每页展示5行)
//    public ArrayList<Emp> selectByPaging(int startIndex) {
//        ArrayList<Emp> result = new ArrayList<Emp>();
//        try {
//            String sql = "SELECT * FROM EMP LIMIT ?,5";
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,"root","root");
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            pstat.setInt(1,startIndex);
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                emp.setDeptno(rs.getInt("deptno"));
//                result.add(emp);
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }



    //模糊查询的方法 like
//    public ArrayList<Emp> selectForLike(String letter) {
//        ArrayList<Emp> result = new ArrayList<Emp>();
//        try {
//            //String sql = "SELECT * FROM EMP WHERE ENAME LIKE ?";
//            String sql = "SELECT * FROM EMP WHERE ENAME LIKE \"%\"?\"%\"";
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,"root","root");
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            //pstat.setString(1,"%"+letter+"%");//方法一
//            pstat.setString(1,letter);//方法二
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                emp.setDeptno(rs.getInt("deptno"));
//                result.add(emp);
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }




    //读取emp所有记录的方法
//    public ArrayList<Emp> selectAllEMP() {
//        ArrayList<Emp> result = new ArrayList<Emp>();
//        try {
//            String sql = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP;";
//            Class.forName(className);
//            Connection conn = DriverManager.getConnection(url,"root","root");
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEmpno(rs.getInt("empno"));
//                emp.setEname(rs.getString("ename"));
//                emp.setJob(rs.getString("job"));
//                emp.setMgr(rs.getInt("mgr"));
//                emp.setHiredate(rs.getDate("hiredate"));
//                emp.setSal(rs.getFloat("sal"));
//                emp.setComm(rs.getFloat("comm"));
//                emp.setDeptno(rs.getInt("deptno"));
//                result.add(emp);
//            }
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}
