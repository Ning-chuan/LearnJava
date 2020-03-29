package service;

import dao.StudentDao;
import domain.Student;

public class StudentService {
    private StudentDao dao = new StudentDao();



    public void insert(Student student) throws Exception {
        dao.insert(student);
    }
    public void insert(Object... obj) throws Exception {
        dao.insert(obj);
    }

    public void update(Object obj) throws Exception {
        dao.update(obj);
    }
    public void update(Object... obj) throws Exception {
        dao.update(obj);
    }
}
