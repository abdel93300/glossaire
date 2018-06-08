package com.pe.glossaire;

import com.pe.glossaire.Acronym;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class AcronymController {


    @GetMapping("/acronyms")


    public String productsList (Model model){

        String name = "ARE";
        Date creation = new Date();


        DateFormat cd = new SimpleDateFormat("dd/MM/yyyy");

        String creationDate = cd.format(creation);
        String summary = "summary de ARE";
        String definition = "définition longue de ARE";
        Description description = new Description(summary, definition);
        String author = "Abdel";
        boolean obsolete = false;
        String[] motClefs = {"Mot clé1", "Mot clé2", "Mot clé3"};
        List<Acronym> acronyms = new ArrayList<Acronym>();
        Acronym acronym = new Acronym(name, description, creationDate, author, obsolete, motClefs);

        acronyms.add(acronym);

        String name2 = "ARE";
        Date creation2 = new Date();


        DateFormat cd2 = new SimpleDateFormat("dd/MM/yyyy");

        String creationDate2 = cd.format(creation);
        String summary2 = "summary de ARE";
        String definition2 = "définition longue de ARE";
        Description description2 = new Description(summary, definition);
        String author2 = "Abdel";
        boolean obsolete2 = false;
        String[] motClefs2 = {"Mot clé1", "Mot clé2", "Mot clé3"};
        Acronym acronym2 = new Acronym(name, description, creationDate, author, obsolete, motClefs);
        acronyms.add(acronym2);
        model.addAttribute("acronyms", "acronyms");
        return "acronymList";
    }
}

