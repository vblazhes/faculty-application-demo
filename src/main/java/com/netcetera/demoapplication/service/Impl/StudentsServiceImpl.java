package com.netcetera.demoapplication.service.Impl;

import com.netcetera.demoapplication.model.Student;
import com.netcetera.demoapplication.model.exception.StudentNotFoundException;
import com.netcetera.demoapplication.repository.StudentsRepository;
import com.netcetera.demoapplication.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;

    StudentsServiceImpl(StudentsRepository studentsRepository){
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student getStudentByIndex(String index) {
        return studentsRepository.findById(index).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public Student save(Student student) {
        return studentsRepository.save(student);
    }

    @Override
    public void deleteStudentByIndex(String index) {
        studentsRepository.deleteById(index);
    }
}
