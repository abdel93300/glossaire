package com.pe.glossaire.repository;

import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.service.AcronymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcronymServiceImpl implements AcronymService {

    @Autowired
    private AcronymRepository acronymRepository;

    @Override
    public List<Acronym> listAll() {
        List<Acronym> acronyms = new ArrayList<>();
        acronymRepository.findAll().forEach(acronyms::add); //fun with Java 8
        return acronyms;
    }
}
