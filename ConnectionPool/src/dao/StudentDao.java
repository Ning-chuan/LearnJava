package dao;

import domain.Student;
import orm.RowMapper;
import orm.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    public Student selectOne(int sid) throws IllegalAccessException, NoSuchFieldException, SQLException {
        String sql = "SELECT * FROM STUDENT WHERE SID=#{sid}";
        return sqlSession.selectOne(sql,sid,Student.class);
    }
    public List<Student> selectList() throws IllegalAccessException, NoSuchFieldException, SQLException {
        String sql = "SELECT * FROM STUDENT";
        return sqlSession.selectList(sql,null,Student.class);
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
//    public Student selectOne(Object... objs) throws IllegalAccessException, NoSuchFieldException, SQLException {
//        String sql = "SELECT * FROM STUDENT WHERE SID=?";
//        RowMapper rm = new RowMapper() {
//            @Override
//            public Object mapperRow(ResultSet rs) throws SQLException {
//                Student student = new Student();
//                student.setSid(rs.getInt("sid"));
//                student.setSname(rs.getString("sname"));
//                student.setSex(rs.getString("sex"));
//                student.setSage(rs.getInt("sage"));
//                return student;
//            }
//        };
//        return sqlSession.selectOne(sql,rm,objs);
//    }
//    public List<Student> selectList() throws SQLException {
//        String sql = "SELECT * FROM STUDENT";
//        RowMapper rm = new RowMapper() {
//            @Override
//            public Object mapperRow(ResultSet rs) throws SQLException {
//                Student student = new Student();
//                student.setSid(rs.getInt("sid"));
//                student.setSname(rs.getString("sname"));
//                student.setSex(rs.getString("sex"));
//                student.setSage(rs.getInt("sage"));
//                return student;
//            }
//        };
//        return sqlSession.selectList(sql,rm,null);
//    }
}
