package com.innova.controller;

import com.innova.entity.PersonEntity;
import com.innova.repository.IPersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Pageable;

@Controller
@Log4j2
public class PersonController {

    @Autowired
    IPersonRepository personRepository;

    //http://localhost:8090/person/paging
    @GetMapping("/person/paging")
    @ResponseBody
    public String getPagingPerson(){

        var pageable = PageRequest.of(0,4);
        Page<PersonEntity> entityPage = personRepository.findAll(pageable);

        for(var item : entityPage){
            log.info(item);
        }
        return entityPage +  "";
    }

    //http://localhost:8090/person/sorting/ascending
    @GetMapping("/person/sorting/ascending")
    @ResponseBody
    public String getSortingPerson(){

        Sort sort = Sort.by("personName");
        Iterable<PersonEntity> personEntities = personRepository.findAll(sort);

        for(var item : personEntities){
            log.info(item);
        }
        return personEntities +  " ";
    }

    //http://localhost:8090/person/sortingandpaging
    @GetMapping("/person/sortingandpaging")
    @ResponseBody
    public String getSortingAndPagingPerson(){

        var pageable = PageRequest.of(0,4,Sort.by("date").descending());
        Page<PersonEntity> personEntities = personRepository.findAll(pageable);

        for(var item : personEntities){
            log.info(item);
        }
        return personEntities +  " ";
    }
}
