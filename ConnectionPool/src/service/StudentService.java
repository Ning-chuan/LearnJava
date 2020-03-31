package service;

import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import dao.StudentDao;
import domain.Student;
import orm.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDao dao = new StudentDao();


    //方法一 Mybatis方式
    public void insert(Student student) throws Exception {
        dao.insert(student);
    }
    public void delete(int sid) throws Exception {
        dao.delete(sid);
    }
    public void update(Student student) throws Exception {
        dao.update(student);
    }
    public Student selectOne(int sid) throws IllegalAccessException, NoSuchFieldException, SQLException {
        return dao.selectOne(sid);
    }
    public List<Student> selectList() throws IllegalAccessException, NoSuchFieldException, SQLException {
        return dao.selectList();
    }


//    //方法二 SpringJDBC方式
//    public void insert(Student student) throws Exception {
//        dao.insert(student);
//    }
//
//    public void update(Student student) throws Exception {
//        dao.update(student);
//    }
//    public Student selectOne(int sid) throws IllegalAccessException, NoSuchFieldException, SQLException {
//        return dao.selectOne(sid);
//    }
//    public List<Student> selectList() throws IllegalAccessException, NoSuchFieldException, SQLException {
//        return dao.selectList();
//    }
}
