package com.innova.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {

    @Autowired
    _01_BeanBasic beanBasic;

    @Autowired
    _02_BeanScope beanScope;

    @Autowired
    _03_BeanInitialDestroy beanIntialDestroy1;

    @Autowired
    _03_BeanInitialDestroy beanIntialDestroy2;

    // http://localhost:8090/bean/basic
    @GetMapping("/bean/basic")
    @ResponseBody
    public String getBeanBasic(){
        return beanBasic.beanBasic()+"";
    }

    // http://localhost:8090/bean/scope
    @GetMapping("/bean/scope")
    @ResponseBody
    public String getBeanScope(){
        return beanBasic.beanBasic().hashCode()+" ??? "+beanScope.beanScope().hashCode();
    }

    // http://localhost:8090/bean/initialdestroy
    @GetMapping("/bean/initialdestroy")
    @ResponseBody
    public String getBeanInitialDestroy(){
        return beanIntialDestroy1.beanInitialDestroy().hashCode()+" ??? "+beanIntialDestroy2.beanInitialDestroy().hashCode();
    }

}