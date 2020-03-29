package service;

import dao.StudentDao;
import domain.Student;

import java.sql.SQLException;

public class StudentService {
    private StudentDao dao = new StudentDao();



    public void insert(Student student) throws Exception {
        dao.insert(student);
    }

    public void update(Student student) throws Exception {
        dao.update(student);
    }
}
