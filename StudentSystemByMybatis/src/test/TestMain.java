package test;

import dao.StudentDao;
import domain.Student;

public class TestMain {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        Student student = new Student(11, "宋江", "男", 39);
        dao.insert(student);
    }
}
