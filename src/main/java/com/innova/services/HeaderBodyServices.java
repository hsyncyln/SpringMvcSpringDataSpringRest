package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//server
@RestController
@Log4j2
public class HeaderBodyServices {

    //http://localhost:8090/service/server/header
    @GetMapping("/service/server/header")
    public ResponseEntity<?> getHeader(
            @RequestHeader(value="key_header", defaultValue = "default header") String gelenHeader
    ){

        String headerData = gelenHeader;
        log.info(headerData);
        return  ResponseEntity.ok(headerData);
    }
}
