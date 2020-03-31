package dao;

import domain.Student;
import orm.SqlSession;

public class StudentDao {

    SqlSession sqlSession = new SqlSession();

    //方法一 自定sql规则 自己解析和赋值
    //新增
    public void insert(Student student) throws Exception {
        String sql = "INSERT INTO STUDENT VALUES(#{sid},#{sname},#{sex},#{sage})";
        sqlSession.myUpdate(sql,student);
    }
    //删除
    public void delete(int sid) throws Exception {
        String sql = "DELETE FROM STUDENT WHERE SID=#{sid}";
        sqlSession.myUpdate(sql,sid);
    }
    //修改
    public void update(Student student) throws Exception {
        String sql = "UPDATE STUDENT SET SNAME=#{sname},SEX=#{sex},SAGE=#{sage} WHERE SID=#{sid}";
        sqlSession.myUpdate(sql,student);
    }



//    //方法二 Object数组
//    //新增 方法二
//    public void insert(Student student) throws Exception {
//        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
//        sqlSession.myUpdate(sql,student.getSid(),student.getSname(),student.getSex(),student.getSage());
//    }
//    //删除
//    public void delete(int sid) throws Exception {
//        String sql = "DELETE FROM STUDENT WHERE SID=?";
//        sqlSession.myUpdate(sql,sid);
//    }
//    //修改 方法二
//    public void update(Student student) throws Exception {
//        String sql = "UPDATE STUDENT SET SNAME=?,SEX=?,SAGE=? WHERE SID=?";
//        sqlSession.myUpdate(sql,student.getSname(),student.getSex(),student.getSage(),student.getSid());
//    }
}
