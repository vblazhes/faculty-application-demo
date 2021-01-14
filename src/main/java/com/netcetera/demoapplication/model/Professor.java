package com.netcetera.demoapplication.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String firstName;

    private String lastName;

//    /** The way to map unidirectional OneToMany **/
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "professor_id")
//    Set<Course> courses;

    /**
     * The way to map BiDirectional OneToMany
     **/
    @OneToMany(
            mappedBy = "professor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        courses.add(course);
        course.setProfessor(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.setProfessor(null);
    }

}
