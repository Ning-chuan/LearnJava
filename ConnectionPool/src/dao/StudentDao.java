package dao;

import domain.Student;
import orm.SqlSession;

public class StudentDao {

    SqlSession sqlSession = new SqlSession();
    //新增的方法
    public void insert(Student student) throws Exception {
        String sql = "INSERT INTO STUDENT VALUES(#{sid},#{sname},#{sex},#{sage})";
        sqlSession.myUpdate(student,sql);
    }

    //修改的方法
    public void update(Student student) throws Exception {
        //自定sql规则 为了解析和赋值
        String sql = "UPDATE STUDENT SET SNAME=#{sname},SEX=#{sex},SAGE=#{sage} WHERE SID=#{sid}";
        sqlSession.myUpdate(student,sql);



//        String sql = "UPDATE STUDENT SET SNAME=?,SEX=?,SAGE=? WHERE SID=?";
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection conn = pool.getMyConnection();
//        PreparedStatement pstat = conn.prepareStatement(sql);
//        pstat.setString(1,student.getSname());
//        pstat.setString(2,student.getSex());
//        pstat.setInt(3,student.getSage());
//        pstat.setInt(4,student.getSid());
//        pstat.executeUpdate();
//        pstat.close();
//        conn.close();
    }
}
