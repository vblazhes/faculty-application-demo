package com.netcetera.demoapplication.service;

import com.netcetera.demoapplication.model.Student;

import java.util.List;

public interface StudentsService {

    List<Student> getAllStudents();

    Student getStudentByIndex(String index);

    Student save(Student student);

    void deleteStudentByIndex(String index);
}
