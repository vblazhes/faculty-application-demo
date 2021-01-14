package com.netcetera.demoapplication.web;

import com.netcetera.demoapplication.model.Student;
import com.netcetera.demoapplication.service.StudentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private final StudentsService studentsService;

    StudentsController(StudentsService studentsService){
        this.studentsService = studentsService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentsService.getAllStudents();
    }

    @GetMapping("/{student_id}")
    public Student getStudentByIndex(@PathVariable("student_id") String index){
        return studentsService.getStudentByIndex(index);
    }

}
