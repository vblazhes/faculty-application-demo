package com.netcetera.demoapplication.repository;

import com.netcetera.demoapplication.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorsRepository extends JpaRepository<Professor,Long> {
}
