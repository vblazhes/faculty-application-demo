package com.netcetera.demoapplication.web;

import com.netcetera.demoapplication.model.Professor;
import com.netcetera.demoapplication.service.ProfessorsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/professor")
public class ProfessorsController {

    ProfessorsService professorsService;

    ProfessorsController(ProfessorsService professorsService){
        this.professorsService = professorsService;
    }

    @GetMapping
    public List<Professor> getAllProfessors(){
        return professorsService.getAllProfessors();
    }

    @GetMapping("/{professor_id}")
    public Professor getProfessorById(@PathVariable("professor_id") Long id){
        return professorsService.getProfessorById(id);
    }

}
