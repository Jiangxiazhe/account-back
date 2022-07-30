package com.longjiang.jiangxia.demo1.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.*;
import com.longjiang.jiangxia.demo1.entity.Response;
import com.longjiang.jiangxia.demo1.mapper.*;
import com.longjiang.jiangxia.demo1.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:liangjl
 * @Date:2020-08-16
 * @Description:用户控制层
 */
@RestController
@RequestMapping("/suppliers")
public class supplierController {


    private SupplierServiceImpl supplierService;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private GoodsListMapper goodsListMapper;
    @Autowired
    private CustomerGoodsMapper customerGoodsMapper;
    @Autowired
    private SupplierGoodsMapper supplierGoodsMapper;

    @Autowired
    public void Inject(SupplierServiceImpl supplierService){
        this.supplierService=supplierService;
    }



    @PostMapping(value = "/add")
    public Response<String> addSupplier(@RequestBody Supplier supplier){
        System.out.println(supplier.toString());
        supplierService.save(supplier);
        return Response.rspData("showUser");
    }

    @PostMapping(value = "/list")
    public Response<List<Supplier>> ReturnSup(){
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name");
        List<Supplier> suppliersList = supplierMapper.selectList(queryWrapper);
        return Response.rspData(suppliersList);
    }






    @PostMapping(value = "/supplierList")
    public Response<Page<Supplier>> ReturnSupplierList(@RequestBody Supplier supplier){
        Page<Supplier> ipage = new Page<>(supplier.pageCurrent,supplier.pageSize);
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "contact", "address");
        Page<Supplier> supplierList = supplierMapper.selectPage(ipage,queryWrapper);
        return Response.rspData(supplierList);
    }


}