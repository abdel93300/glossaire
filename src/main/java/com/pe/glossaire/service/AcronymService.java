package com.pe.glossaire.service;

import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.model.Description;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcronymService {

    public List<Acronym> retrieve(){

        Acronym acronym = new Acronym();
        Description description = new Description("shortD", "longD");
        acronym.setDescription(description);
        acronym.setCreation("creation");
        acronym.setAuthor("author");
        String[] keyWords = {"keyword1","keyword3"};
        acronym.setMotClefs(keyWords);
        acronym.setName("name");
        acronym.setObsolete(false);



        Acronym acronym1 = new Acronym();
        Description description1 = new Description("shortD", "longD");
        acronym1.setDescription(description1);
        acronym1.setCreation("creation");
        acronym1.setAuthor("author");
        String[] keyWords1 = {"keyword1","keyword3"};
        acronym1.setMotClefs(keyWords1);
        acronym1.setName("name");
        acronym1.setObsolete(false);

        List<Acronym> acronyms = new ArrayList<>();
        acronyms.add(acronym);
        acronyms.add(acronym1);


        return acronyms;
    }
}
