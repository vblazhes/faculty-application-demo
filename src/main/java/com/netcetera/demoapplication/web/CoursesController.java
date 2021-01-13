package com.netcetera.demoapplication.web;

import com.netcetera.demoapplication.model.Course;
import com.netcetera.demoapplication.service.CoursesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CoursesService coursesService;

    CoursesController(CoursesService coursesService){
        this.coursesService = coursesService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return coursesService.getAllCourses();
    }

    @GetMapping("/{code}")
    public Course getCourseByCode(@PathVariable("code") String code){
        return coursesService.getCourseByCode(code);
    }

}
