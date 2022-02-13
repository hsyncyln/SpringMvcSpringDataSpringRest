package com.innova.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class SecurityController {

    //PUBLIC
    // http://localhost:8090/security/public
    @GetMapping("/security/public")
    public String getPublic(){
        return "/public/index";
    }

    //PRIVATE
    // http://localhost:8090/security/private
    @GetMapping("/security/private")
    public String getPrivate(){
        return "/private/index";
    }


    // http://localhost:8090/security/success
    @GetMapping("/security/success")
    public String getSuccess(){
        return "success";
    }
}
