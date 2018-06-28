package com.pe.glossaire.service;

import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.repository.AcronymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcronymService {

    @Autowired
    private AcronymRepository repository;

    public Iterable<Acronym> retrieve(){
        return repository.findAll();
    }

    public Iterable<Acronym> retrieveByName(String name){
        return  repository.findByName(name);
    }

    public void create(Acronym acronym){

        repository.save(acronym);
    }
}

