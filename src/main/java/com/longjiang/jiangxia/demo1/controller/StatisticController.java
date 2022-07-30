package com.longjiang.jiangxia.demo1.controller;


import com.longjiang.jiangxia.demo1.service.impl.DealRecordServiceImpl;
import com.longjiang.jiangxia.demo1.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private GoodsServiceImpl goodsService;
    private DealRecordServiceImpl dealRecordService;


    @Autowired
    public void Inject(
            GoodsServiceImpl goodsService,
            DealRecordServiceImpl dealRecordService
    ){
        this.goodsService=goodsService;
        this.dealRecordService=dealRecordService;

    }



}
