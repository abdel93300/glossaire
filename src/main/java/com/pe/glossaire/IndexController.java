package com.pe.glossaire;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {


    @RequestMapping("/")
    public String index(Integer nombre, Model model){
        model.addAttribute("nombre", "100");
        return "index";
    }

}
