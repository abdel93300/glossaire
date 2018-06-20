package com.pe.glossaire.controller;


import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.service.AcronymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AcronymController {

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

    @RequestMapping(value = { "/acronymAdd" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        Acronym acronym = new Acronym();
        model.addAttribute("acronym", acronym);

        return "acronymAdd";
    }

}



