package com.innova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    //http://localhost:8090/templates/birinci
    @GetMapping("templates/birinci")
    public String getThymeleaf1(){
        return "thymeleafpage1";
    }

    //http://localhost:8090/templates/ikinci
    @GetMapping("templates/ikinci")
    public String getThymeleaf2(Model model){
        model.addAttribute("mvc_key","Thymeleaf Modelden geldim");
        return "thymeleafpage2";
    }

}
