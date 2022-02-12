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

    // REQUEST HEADER
    //clientın Servera gizli olarak data göndermesi ->> token vs.
    //http://localhost:8090/controller/client/header
    @GetMapping("/controller/client/header")
    @ResponseBody
    public String getHeaderController() {

        String url = "http://localhost:8090/service/server/header";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("key_header", "Ben gizli bir bilgiyim");

        HttpEntity<String> httpEntity = new HttpEntity<String>("Bu data verisi", httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return response.toString();
    }

    //RESPONSE HEADER
    //Serverın Clienta gizli olarak data göndermesi ->> token vs.
    //http://localhost:8090/controller/client/responseheader
    @GetMapping("/controller/client/responseheader")
    @ResponseBody
    public String getResponseHeaderController() {

        String url = "http://localhost:8090/service/server/responseheader";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> data = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String gelenData = data.getHeaders().getFirst("key_response");
        String body = data.getBody();
        return "@Controller (Client) -> \n Body: " + body + "\n GelenData: " + gelenData;
    }

    //////////////////

    //REQUEST COOKIE
    //Serverın Clienta gizli olarak data göndermesi ->> token vs.
    //http://localhost:8090/controller/client/cookie
    @GetMapping("/controller/client/cookie")
    @ResponseBody
    public String getRequestCookieController() {

        String url = "http://localhost:8090/service/server/cookie";
        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.COOKIE, "key_cookie=cookieValue");

        HttpEntity<String> httpEntity = new HttpEntity<String>("Bu data verisi", httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        String result = response.getBody();
        return "@Controller (Client): " + result;
    }

    //RESPONSE COOKIE
    //Serverın Clienta gizli olarak cookie göndermesi
    //http://localhost:8090/controller/client/responsecookie
    @GetMapping("/controller/client/responsecookie")
    @ResponseBody
    public String getResponseCookieController() {

        String url = "http://localhost:8090/service/server/responsecookie";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> data = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String gelenData = data.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        String body = data.getBody();

        return "@Controller (Client) -> \n Body: " + body + "\n GelenData: " + gelenData;
    }
}