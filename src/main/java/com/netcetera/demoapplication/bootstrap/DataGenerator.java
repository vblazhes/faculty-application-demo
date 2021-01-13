package com.netcetera.demoapplication.bootstrap;

import com.netcetera.demoapplication.model.Course;
import com.netcetera.demoapplication.model.Professor;
import com.netcetera.demoapplication.repository.CoursesRepository;
import com.netcetera.demoapplication.repository.ProfessorsRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator {

    private final CoursesRepository coursesRepository;
    private final ProfessorsRepository professorsRepository;

    private List<Professor> professors;
    private List<Course> courses;

    DataGenerator(CoursesRepository coursesRepository, ProfessorsRepository professorsRepository) {
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.coursesRepository = coursesRepository;
        this.professorsRepository = professorsRepository;
    }

    @PostConstruct
    public void init() {

        Professor professor1 = new Professor(1L,"Professor","Dimitar","Trajanov");
        Professor professor2 = new Professor(2L,"Assistant Professor","Milosh","Jovanovikj");
        Professor professor3 = new Professor(1L,"Master Instructor","Nasi","Jofche");

        professors.add(professor1);
        professors.add(professor2);
        professors.add(professor3);

        Course course1 = new Course("CSES628","Service Oriented Architectures");
        Course course2 = new Course("CSEW702","Web Based Systems");
        Course course3 = new Course("CSES629","Data Warehouses");
        Course course4 = new Course("CSES612","Electronic and Mobile Commerce - Spring Advanced Course");
        Course course5 = new Course("CSEW506","Web Programing - Spring Course");
        Course course6 = new Course("CSEW519","Mobile Platforms and Programing");
        Course course7 = new Course("CSES627","Sensors System");
        Course course8 = new Course("CSEW303","Probability and Statistics");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);
        courses.add(course8);

        if(coursesRepository.count() == 0 && professorsRepository.count() == 0){
            professorsRepository.saveAll(professors);
            coursesRepository.saveAll(courses);
        }
    }
}
