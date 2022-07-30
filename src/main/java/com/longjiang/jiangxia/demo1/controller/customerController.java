package com.longjiang.jiangxia.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.*;
import com.longjiang.jiangxia.demo1.entity.Response;
import com.longjiang.jiangxia.demo1.service.impl.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @Author:liangjl
 * @Date:2020-08-16
 * @Description:用户控制层
 */
@RestController
@RequestMapping("/customers")
public class customerController {


    private CustomerServiceImpl customerService;
    private SupplierServiceImpl supplierService;

    @Autowired
    private CustomerMapper customerMapper;


    @Autowired
    public void Inject(
            CustomerServiceImpl customerService,
            SupplierServiceImpl supplierService,
            GoodsListServiceImpl goodsListService

    ){
        this.customerService=customerService;
        this.supplierService=supplierService;
    }


    @PostMapping(value = "/add")
    public Response<String> addCustomer(@RequestBody Customer customer){
        System.out.println(customer.toString());
        customerService.save(customer);
        return Response.rspData("showUser");
    }

    @PostMapping(value = "/list")
    public Response<List<Customer>> ReturnCus(){
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name");
        List<Customer> customerList = customerMapper.selectList(queryWrapper);
        return Response.rspData(customerList);
    }

    @PostMapping(value = "/customerList")
    public Response<Page<Customer>> ReturnCustomerList(@RequestBody Customer customer){
        Page<Customer> ipage = new Page<>(customer.pageCurrent,customer.pageSize);
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "contact", "address");
        Page<Customer> customerList = customerMapper.selectPage(ipage,queryWrapper);
        return Response.rspData(customerList);
    }



}