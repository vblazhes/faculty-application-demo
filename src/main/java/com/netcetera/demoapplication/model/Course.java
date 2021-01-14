package com.netcetera.demoapplication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    private String code;

    private String name;

    @ManyToOne
    private Professor professor;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Student> students;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        return code != null && code.equals(((Course)o).getCode());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
