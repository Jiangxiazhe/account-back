package com.longjiang.jiangxia.demo1.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.*;
import com.longjiang.jiangxia.demo1.entity.common.IDListTO;
import com.longjiang.jiangxia.demo1.entity.common.PageWithAttach;
import com.longjiang.jiangxia.demo1.entity.common.Response;
import com.longjiang.jiangxia.demo1.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/goods")
public class GoodsController {

    private GoodsServiceImpl goodsService;

    @Autowired
    public void Inject(
            GoodsServiceImpl goodsService
    ){
        this.goodsService=goodsService;

    }


    @PostMapping(value = "/add")
    public Response<String> addGoods(@RequestBody Goods goods) {

        if(goodsService.save(goods)){
            return Response.success("添加商品成功");
        }else{
            return Response.fail("添加商品失败");
        }
    }

    @PostMapping(value = "/delete")
    public Response<String> deleteGoods(@RequestBody IDListTO idListTO){
        if(goodsService.removeBatchByIds(idListTO.getId())){
            return Response.success("删除商品成功");
        }else{
            return Response.fail("删除商品失败");
        }
    }

    @PostMapping(value = "/modify")
    public Response<String> updateGoods(@RequestBody Goods good) {
        UpdateWrapper<Goods> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",good.getId());
        if(goodsService.update(good,updateWrapper)){
            return Response.success("更新商品成功");
        }else{
            return Response.fail("更新商品失败");
        }
    }

//    @PostMapping(value = "/one")
//    public Response<Page<Goods>> GetGoodsList(@RequestBody PageWithAttach<String> pageWithAttach){
//        Page<Goods> page = new Page<>(pageWithAttach.getCurrent(),pageWithAttach.getSize());
//        goodsService.page(page);
//        return Response.rspData(page);
//    }

    @PostMapping(value = "/list/page")
    public Response<Page<Goods>> GetGoodsList(@RequestBody PageWithAttach<String> pageWithAttach){
        Page<Goods> page = new Page<>(pageWithAttach.getCurrent(),pageWithAttach.getSize());
        goodsService.page(page);
        return Response.rspData(page);
    }


    @PostMapping(value = "/list/all")
    public Response<List<Goods>> GetAllPersonList(@RequestBody PageWithAttach<Integer> pageWithAttach){
        List<Goods> personList= goodsService.list();
        return Response.rspData(personList);
    }



}
