package com.netcetera.demoapplication.service.Impl;

import com.netcetera.demoapplication.model.Professor;
import com.netcetera.demoapplication.model.exception.ProfessorNotFoundException;
import com.netcetera.demoapplication.repository.ProfessorsRepository;
import com.netcetera.demoapplication.service.ProfessorsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorsServiceImpl implements ProfessorsService {

    ProfessorsRepository professorsRepository;

    ProfessorsServiceImpl(ProfessorsRepository professorsRepository){
        this.professorsRepository = professorsRepository;
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorsRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorsRepository.findById(id).orElseThrow(ProfessorNotFoundException::new);
    }

    @Override
    public Professor save(Professor professor) {
        return professorsRepository.save(professor);
    }

    @Override
    public void deleteProfessorById(Long id) {
        professorsRepository.deleteById(id);
    }
}
