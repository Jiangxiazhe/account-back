package com.flong.springboot.mydomain.controller;

import com.alibaba.fastjson.JSON;
import com.flong.springboot.mydomain.entity.Customers;
import com.flong.springboot.mydomain.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @Author:liangjl
 * @Date:2020-08-16
 * @Description:用户控制层
 */
@RestController
@RequestMapping("/customers")
public class customerController {

    @Autowired
    private CustomerMapper customerMapper;


//    @RequestMapping(value="/add",method=RequestMethod.POST)
    @PostMapping(value = "/add")
    public String testShowUser(@RequestBody Customers customer){
        System.out.println(customer.toString());
        return "showUser";
    }

}