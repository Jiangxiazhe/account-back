package com.longjiang.jiangxia.demo1.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.*;
import com.longjiang.jiangxia.demo1.entity.Response;
import com.longjiang.jiangxia.demo1.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private GoodsListServiceImpl goodsListService;
    @Autowired
    private SupplierMapper supplierMapper;

    private SupplierGoodsServiceImpl supplierGoodsService;
    private CustomerGoodsServiceImpl customerGoodsService;

    @Autowired
    public void Inject(
            GoodsListServiceImpl goodsListService,
            SupplierMapper supplierMapper,
            SupplierGoodsServiceImpl supplierGoodsService,
            CustomerGoodsServiceImpl customerGoodsService
    ){
        this.goodsListService=goodsListService;
        this.supplierMapper=supplierMapper;
        this.customerGoodsService=customerGoodsService;
        this.supplierGoodsService=supplierGoodsService;
    }


    @PostMapping(value = "/supplierGoods")
    public Response<String> addSupplierGoods(@RequestBody SupplierGoods supplierGoods) {
        System.out.println(supplierGoods.toString());
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").eq("name", supplierGoods.getPersonName());
        List<Supplier> supplierList = supplierMapper.selectList(queryWrapper);
        if (supplierList.size() == 1) {
            supplierGoods.setFkSupplier(supplierList.get(0).getId());
            supplierGoodsService.save(supplierGoods);
            return Response.rspData("showUser");
        } else {
            return Response.rspData("Error");
        }
    }

    @PostMapping(value = "/goodsList")
    public Response<String> addGoods(@RequestBody GoodsList goodsList){
        System.out.println(goodsList.toString());
        goodsListService.save(goodsList);
        return Response.rspData("showUser");
    }

    @PostMapping(value = "/customerGoods")
    public Response<String> addCustomerGoods(@RequestBody CustomerGoods customerGoods) {
        System.out.println(customerGoods.toString());
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").eq("name", customerGoods.getPersonName());
        List<Customer> customerList = customerMapper.selectList(queryWrapper);
        if (customerList.size() == 1) {
            customerGoods.setFkCustomer(customerList.get(0).getId());
            customerGoodsService.save(customerGoods);
            return Response.rspData("showUser");
        } else {
            return Response.rspData("Error");
        }
    }

    @PostMapping(value = "/customerGoodsList")
    public Response<Page<CustomerGoods>> ReturnGoodsList(@RequestBody CustomerGoods customerGoods){
        Page<CustomerGoods> ipage = new Page<>(customerGoods.pageCurrent,customerGoods.pageSize);
        QueryWrapper<CustomerGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "date", "good_name", "price", "amount")
                .between("date", customerGoods.dateRange.get(0),customerGoods.dateRange.get(1))
                .eq("good_name",customerGoods.getGoodName())
                .eq("person_name", customerGoods.getPersonName());
        Page<CustomerGoods> customerGoodsList = customerGoodsService.selectPage(ipage,queryWrapper);
        return Response.rspData(customerGoodsList);
    }

    @PostMapping(value = "/supplierGoodsList")
    public Response<Page<SupplierGoods>> ReturnGoodsList(@RequestBody SupplierGoods supplierGoods){
        Page<SupplierGoods> ipage = new Page<>(supplierGoods.pageCurrent,supplierGoods.pageSize);
        QueryWrapper<SupplierGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "date", "good_name", "price", "amount")
                .between("date", supplierGoods.dateRange.get(0),supplierGoods.dateRange.get(1))
                .eq("good_name",supplierGoods.getGoodName())
                .eq("person_name", supplierGoods.getPersonName());
        Page<SupplierGoods> supplierGoodsList = supplierGoodsMapper.selectPage(ipage,queryWrapper);
        return Response.rspData(supplierGoodsList);
    }

    @PostMapping(value = "/deteleSuppierGoodItem")
    public Response<String> deleteSupplierGoods(@RequestBody long id) {
        System.out.println(id);
        supplierGoodsService.removeById(id);
        return Response.rspData("showUser");
    }

    @PostMapping(value = "/deteleCustomerGoodItem")
    public Response<String> deleteCustomerGoods(@RequestBody long id) {
        System.out.println(id);
        customerGoodsService.removeById(id);
        return Response.rspData("showUser");
    }

    @PostMapping(value = "/goodManage")
    public Response<Page<GoodsList>> ReturnGoodsListList(@RequestBody GoodsList goodsList){
        Page<GoodsList> goodsListList = goodsListService.ReturnGoodsListList(goodsList);
        return Response.rspData(goodsListList);
    }


    @PostMapping(value = "/goodsName")
    public Response<List<GoodsList>> ReturnGoods(){
        QueryWrapper<GoodsList> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name");
        List<GoodsList> goodsListList = goodsListMapper.selectList(queryWrapper);
        return Response.rspData(goodsListList);
    }


}
