package com.innova.controller;

import com.innova.entity.ComputerEntity;
import com.innova.entity.PersonEntity;
import com.innova.repository.IDelivedQueryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonDelivedQueryController {

    @Autowired
    IDelivedQueryRepository delivedQueryRepository;

    //http://localhost:8090/person/create
    @GetMapping("/person/create")
    @ResponseBody
    public String getSavePerson(){

        for(int i=0; i<=10; i++){
            PersonEntity entity = PersonEntity.builder()
                    .personId(0L)
                    .personName("person" + i)
                    .personPrice(100 + i)
                    .build();
            delivedQueryRepository.save(entity);
        }
        return PersonEntity.class +  "Ekleme başarılı";
    }

    //http://localhost:8090/person/find/starts/a
    @GetMapping("/person/find/starts/{starts}")
    @ResponseBody
    public String getFindStartsPerson(
            @PathVariable(name="starts") String starts){

        var iterable = delivedQueryRepository.findByPersonNameStartingWith(starts);

        for(PersonEntity item : iterable){
            log.info(item);
        }

        return iterable + "" ;
    }

    //http://localhost:8090/person/find/ends/n0
    @GetMapping("/person/find/ends/{ends}")
    @ResponseBody
    public String getFindEndsPerson(
            @PathVariable(name="ends") String ends){

        var iterable = delivedQueryRepository.findByPersonNameEndsWith(ends);

        for(PersonEntity item : iterable){
            log.info(item);
        }

        return iterable + "" ;
    }
}
