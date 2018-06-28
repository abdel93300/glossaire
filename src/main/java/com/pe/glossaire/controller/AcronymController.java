package com.pe.glossaire.controller;


import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.model.AcronymForm;
import com.pe.glossaire.model.Description;
import com.pe.glossaire.service.AcronymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class AcronymController {

    @Value("${error.message}")
    private String errorMessage;

    @Autowired
    private AcronymService acronymService;


    @GetMapping("/acronyms")
    public String acronym(Integer nombre, Model model) {

        Iterable<Acronym> acronyms = acronymService.retrieve();
        model.addAttribute("acronyms", acronyms);
        model.addAttribute("nombre", "100");
        return "acronyms";
    }
    @GetMapping("/acronyms/{name}")
    public String searchAcronyms(Integer nombre, Model model) {
        Iterable<Acronym> acronyms = acronymService.retrieveByName("name");
        model.addAttribute("acronyms", acronyms);
        model.addAttribute("nombre", "100");
        return "acronyms";
    }

    @GetMapping("/acronymAdd")
    public String showAcronymAddPage(Model model) {

        Acronym acronym = new Acronym();
        model.addAttribute("acronym", acronym);
        return "acronymAdd";
    }

    @PostMapping("/acronymAdd")
    public String saveAcronym(@Valid @ModelAttribute Acronym acronym, Model model, Integer nombre) {

        String name = acronym.name;

        String shortD = acronym.description.getShortD();
        String longD= acronym.description.getLongD();

        String creation =  LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String author="Abdel Nemmiche";
        Boolean obsolete=false;
        String keyword1 = acronym.getKeyword1();
        String keyword2 = acronym.getKeyword2();
        String keyword3 = acronym.getKeyword3();

        if (name != null && shortD.length() > 0 //
                && name != null && shortD.length() > 0) {
            Description description=new Description(shortD,longD);
            acronymService.create(acronym);

            Iterable<Acronym> acronyms = acronymService.retrieve();
            model.addAttribute("nombre", "100");
            model.addAttribute("acronyms", acronyms);

            return "acronyms";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "acronymAdd";
    }


}



