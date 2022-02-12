package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;

//server
@RestController
@Log4j2
public class HeaderBodyServices {

    //REQUEST HEADER
    //Amaç: Client header oluşturup server'a gönderir
    //http://localhost:8090/service/server/header
    @GetMapping("/service/server/header")
    public ResponseEntity<?> getHeader(
            @RequestHeader(value="key_header", defaultValue = "default header") String gelenHeader
    ){

        String headerData = gelenHeader;
        log.info(headerData);
        return  ResponseEntity.ok(headerData);
    }

    //RESPONSE HEADER
    //Amaç: Server header oluşturup client'a gönderir
    //http://localhost:8090/service/server/responseheader
    @GetMapping("/service/server/responseheader")
    public ResponseEntity<?> getResponseHeader(){

        return ResponseEntity.ok()
                .header("key_response","Serverden gelen header response")
                .body("@RestController: gelen veri");
    }

    //////////////

    //REQUEST COOKIE
    //Amaç: Clientın cookie oluşturup server'a göndermesi
    //http://localhost:8090/service/server/cookie
    @GetMapping("/service/server/cookie")
    public ResponseEntity<?> getRequestCookie(
            @RequestHeader(value="key_cookie", defaultValue = "default cookie") String gelenCookie
    ){

        String cookieData = gelenCookie;
        log.info(cookieData);
        return  ResponseEntity.ok(cookieData);
    }

    //RESPONSE COOKIE
    //Amaç: Server cookie oluşturup client'a gönderir
    //http://localhost:8090/service/server/responsecookie
    @GetMapping("/service/server/responsecookie")
    public ResponseEntity<?> getResponseCookie(){

        return ResponseEntity.ok()
                .header("key_cookie","Serverden gelen cookie response")
                .body("@RestController: gelen veri");
    }


}
