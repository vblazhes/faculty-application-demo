package com.netcetera.demoapplication.repository;

import com.netcetera.demoapplication.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
