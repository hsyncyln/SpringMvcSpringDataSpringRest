package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;

@Log4j2
@RestController
@RequestMapping("/servlet")
public class ServletExamples {

    @Autowired
    private ServletContext servletContext;

    // http://localhost:8090/servlet/info
    @GetMapping("/info")
    public ResponseEntity<?> getServletInformation(){

        String secretData = servletContext.getInitParameter("secretinformation");
        return ResponseEntity.ok(secretData);
    }
}
