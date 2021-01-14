package com.netcetera.demoapplication.repository;

import com.netcetera.demoapplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student,String> {
}
