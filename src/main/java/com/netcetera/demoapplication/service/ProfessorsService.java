package com.netcetera.demoapplication.service;

import com.netcetera.demoapplication.model.Professor;

import java.util.List;

public interface ProfessorsService {

    List<Professor> getAllProfessors();

    Professor getProfessorById(Long id);

    Professor save(Professor professor);

    void deleteProfessorById(Long id);
}
