package com.netcetera.demoapplication.service;

import com.netcetera.demoapplication.model.Professor;

import java.util.List;

public interface ProfessorsRepository {

    List<Professor> getAllProfessors();

    Professor getProfessorById(Long id);

    Professor save(Professor professor);

    Professor deleteById(Long id);
}
