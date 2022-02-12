package com.innova.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//client
@Controller
public class HeaderBodyController {

    //clientın Servera gizli olarak data göndermesi ->> token vs.
    //http://localhost:8090/controller/client/header
    @GetMapping("/controller/client/header")
    @ResponseBody
    public  String getHeaderController1(){

        String url = "http://localhost:8090/service/server/header";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("key_header","Ben gizli bir bilgiyim");

        HttpEntity<String> httpEntity = new HttpEntity<String>("Bu data verisi", httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,String.class);
        return  response.toString();
    }
}
