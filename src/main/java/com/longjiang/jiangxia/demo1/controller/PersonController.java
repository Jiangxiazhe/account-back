package com.longjiang.jiangxia.demo1.controller;

import com.longjiang.jiangxia.demo1.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonServiceImpl personService;


    @Autowired
    public void Inject(
            PersonServiceImpl personService
    ){
        this.personService=personService;
    }


}
