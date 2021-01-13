package com.netcetera.demoapplication.service.Impl;

import com.netcetera.demoapplication.model.Course;
import com.netcetera.demoapplication.model.exception.CourseNotFoundException;
import com.netcetera.demoapplication.repository.CoursesRepository;
import com.netcetera.demoapplication.service.CoursesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    CoursesServiceImpl(CoursesRepository coursesRepository){
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Course getCourseByCode(String code) {
        return coursesRepository.findById(code).orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public Course save(Course course) {
        return coursesRepository.save(course);
    }

    @Override
    public void deleteCourseByCode(String code) {
        coursesRepository.deleteById(code);
    }
}
