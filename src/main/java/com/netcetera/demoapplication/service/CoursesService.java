package com.netcetera.demoapplication.service;

import com.netcetera.demoapplication.model.Course;

import java.util.List;

public interface CoursesService {

    List<Course> getAllCourses();

    Course getCourseByCode(String code);

    Course save(Course course);

    void deleteCourseByCode(String code);

}
