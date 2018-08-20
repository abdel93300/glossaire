package com.pe.glossaire.controller;

import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.service.AcronymService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class IndexController {
    @Autowired
    private AcronymService acronymService;

    @RequestMapping("/")
    public String index(Long nombre, Model model, String dateJour){
        Iterable<Acronym> acronyms = acronymService.retrieve();
        nombre=acronyms.spliterator().getExactSizeIfKnown();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate localDate = LocalDate.now();
        dateJour=dtf.format(localDate);
        model.addAttribute("dateJour", dateJour);
        model.addAttribute("nombre", nombre);
        model.addAttribute("mailto", mailto);
        return "index";
    }
}
