package com.innova.controller;

import com.innova.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormValidationController {

    // http://localhost:8090/formurl
    @GetMapping("/formurl")
    public String getForm(Model model){
        model.addAttribute("key_form",new UserDto());
        return "formValidation";
    }

    // http://localhost:8090/formurl
    @PostMapping("/formurl")
    public String postForm(@Valid @ModelAttribute("key_form") UserDto dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(dto);
            return "formValidation";
        }
        else{
            //dbye yazılacak
            log.info(dto);
            return "success";
        }
    }
}
