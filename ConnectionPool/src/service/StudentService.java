package service;

import dao.StudentDao;
import domain.Student;

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


//    //方法二 SpringJDBC方式
//    public void insert(Student student) throws Exception {
//        dao.insert(student);
//    }
//
//    public void update(Student student) throws Exception {
//        dao.update(student);
//    }
}
