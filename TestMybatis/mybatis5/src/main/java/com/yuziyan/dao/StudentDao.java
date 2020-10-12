package com.yuziyan.dao;

import com.yuziyan.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudents();

    Student getStudentById1(int id);


    Student getStudentById2(int id);

}
