package com.longjiang.jiangxia.demo1.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.DealRecord;
import com.longjiang.jiangxia.demo1.entity.StatisticCondition;
import com.longjiang.jiangxia.demo1.entity.StatisticInfo;
import com.longjiang.jiangxia.demo1.entity.common.PageWithAttach;
import com.longjiang.jiangxia.demo1.entity.common.Response;
import com.longjiang.jiangxia.demo1.service.impl.DealRecordServiceImpl;
import com.longjiang.jiangxia.demo1.service.impl.GoodsServiceImpl;
import com.longjiang.jiangxia.demo1.service.impl.PersonServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/statistic")
public class StatisticController {

    private GoodsServiceImpl goodsService;
    private DealRecordServiceImpl dealRecordService;
    private PersonServiceImpl personService;


    @Autowired
    public void Inject(
            GoodsServiceImpl goodsService,
            DealRecordServiceImpl dealRecordService,
            PersonServiceImpl personService
    ){
        this.goodsService=goodsService;
        this.dealRecordService=dealRecordService;
        this.personService=personService;

    }

    @PostMapping(value = "/list/page")
    @ApiOperation(value = "分页获取,attachment参数须为条件参数,包含开始结束日期,")
    public Response<StatisticInfo> GetPersonList(@RequestBody PageWithAttach<StatisticCondition> pageWithAttach){
        StatisticInfo statisticInfo=dealRecordService.getStatistic(pageWithAttach);
        if(statisticInfo==null){
            return Response.fail("获取失败");
        }
        return Response.rspData(statisticInfo);
    }


}
