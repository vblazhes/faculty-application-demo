package com.netcetera.demoapplication.bootstrap;

import com.netcetera.demoapplication.model.Course;
import com.netcetera.demoapplication.model.Professor;
import com.netcetera.demoapplication.model.Student;
import com.netcetera.demoapplication.repository.CoursesRepository;
import com.netcetera.demoapplication.repository.ProfessorsRepository;
import com.netcetera.demoapplication.repository.StudentsRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class DataGenerator {

    private final CoursesRepository coursesRepository;
    private final ProfessorsRepository professorsRepository;
    private final StudentsRepository studentsRepository;

    private List<Professor> professors;
    private List<Course> courses;
    private List<Student> students;

    DataGenerator(CoursesRepository coursesRepository, ProfessorsRepository professorsRepository, StudentsRepository studentsRepository) {
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();

        this.coursesRepository = coursesRepository;
        this.professorsRepository = professorsRepository;
        this.studentsRepository = studentsRepository;
    }

    @PostConstruct
    public void init() {

        Professor professor1 = new Professor(1L,"Professor","Dimitar","Trajanov", new HashSet<>());
        Professor professor2 = new Professor(2L,"Assistant Professor","Milosh","Jovanovikj",new HashSet<>());
        Professor professor3 = new Professor(3L,"Master Instructor","Nasi","Jofche",new HashSet<>());

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

        Student student1 = new Student("161010","Vladimir","Blazheski",22);
        Student student2 = new Student("161011","Nikola","Maroski",23);
        Student student3 = new Student("161012","Fisnik","Limani",23);
        Student student4 = new Student("161002","Marjan","Ralevski",22);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        if(coursesRepository.count() == 0 && professorsRepository.count() == 0){
            professorsRepository.saveAll(professors);
            coursesRepository.saveAll(courses);
            studentsRepository.saveAll(students);

//            professor1.getCourses().add(course1);
//            professor1.getCourses().add(course2);
//            professor1.getCourses().add(course4);
//            professor2.getCourses().add(course3);
//            professor2.getCourses().add(course5);
//            professor2.getCourses().add(course6);
//            professor3.getCourses().add(course7);
//            professor3.getCourses().add(course8);

            professor1.addCourse(course1);
            professor1.addCourse(course2);
            professor1.addCourse(course4);
            professor2.addCourse(course3);
            professor2.addCourse(course5);
            professor2.addCourse(course6);
            professor3.addCourse(course7);
            professor3.addCourse(course8);

            professorsRepository.saveAll(professors);
            coursesRepository.saveAll(courses);
        }
    }
}
