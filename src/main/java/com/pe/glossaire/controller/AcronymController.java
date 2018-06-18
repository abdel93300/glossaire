package com.pe.glossaire.controller;

import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.service.AcronymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AcronymController {

    @Autowired
    private AcronymService acronymService;

    @GetMapping("/acronyms")
    public String acronym(Model model){
        List<Acronym> acronyms = acronymService.retrieve();
        model.addAttribute("acronyms", acronyms);
        return "acronyms";
    }
}


