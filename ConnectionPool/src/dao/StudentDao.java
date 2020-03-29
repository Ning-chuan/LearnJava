package dao;

import domain.Student;
import orm.SqlSession;

public class StudentDao {

    SqlSession sqlSession = new SqlSession();
    //新增的方法
    public void insert(Student student) throws Exception {
        String sql = "INSERT INTO STUDENT VALUES(#{sid},#{sname},#{sex},#{sage})";
        sqlSession.myUpdate(sql,student);
    }
    //新增的方法 方法二 Object数组
    public void insert(Object... obj) throws Exception {
        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
        sqlSession.myUpdate(sql,obj);
    }

    //修改的方法 方法一 自定sql规则 为了解析和赋值
    public void update(Object obj) throws Exception {
        String sql = "UPDATE STUDENT SET SNAME=#{sname},SEX=#{sex},SAGE=#{sage} WHERE SID=#{sid}";
        sqlSession.myUpdate(sql,obj);
    }

    //修改的方法 方法二 Object数组
    public void update(Object... obj) throws Exception {
        String sql = "UPDATE STUDENT SET SNAME=?,SEX=?,SAGE=? WHERE SID=?";
        sqlSession.myUpdate(sql,obj);
    }
}
