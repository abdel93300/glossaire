package com.pe.glossaire.controller;


import com.google.common.collect.Lists;
import com.pe.glossaire.model.Acronym;
import com.pe.glossaire.model.Description;
import com.pe.glossaire.repository.AcronymRepository;
import com.pe.glossaire.service.AcronymService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Controller
public class AcronymController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${contact.mailto}")
    private String mailto;

    @Value("${error.message}")
    private String errorMessage;

    @Autowired
    private AcronymService acronymService;

    @Autowired
    private AcronymRepository acronymRepository;

    @GetMapping("/acronyms")
    public String acronym(Long nombre, Model model, String dateJour) {

        Iterable<Acronym> acronyms = acronymService.retrieve();
        List<Acronym> acronymsL = Lists.newArrayList(acronyms);

        acronymsL.sort(Comparator.comparing(Acronym::getName));

        nombre=acronyms.spliterator().getExactSizeIfKnown();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate localDate = LocalDate.now();
        dateJour=dtf.format(localDate);

        model.addAttribute("dateJour", dateJour);
        model.addAttribute("acronyms", acronymsL);
        model.addAttribute("nombre", nombre);
        model.addAttribute("mailto", mailto);
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
    public String showAcronymAddPage(Long nombre, Model model, String dateJour ) {

        Iterable<Acronym> acronyms = acronymService.retrieve();

        List<Acronym> acronymsL = Lists.newArrayList(acronyms);
        acronymsL.sort(Comparator.comparing(Acronym::getName));

        nombre=acronyms.spliterator().getExactSizeIfKnown();

        Acronym acronym = new Acronym();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate localDate = LocalDate.now();
        dateJour=dtf.format(localDate);

        model.addAttribute("dateJour", dateJour);
        model.addAttribute("acronym", acronym);
        model.addAttribute("nombre", nombre);
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

    @GetMapping("/acronymEdit")
    public String editAcronymPage(Model model, @RequestParam(value = "idAcronym") Long idAcronym) {

        Optional<Acronym> acronym = acronymService.findById(idAcronym);

        model.addAttribute("acronym", acronym);
        return "acronymEdit";
    }

}



