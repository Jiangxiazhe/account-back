package com.longjiang.jiangxia.demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.GoodsDayPrice;
import com.longjiang.jiangxia.demo1.daoentity.Person;
import com.longjiang.jiangxia.demo1.entity.common.IDListTO;
import com.longjiang.jiangxia.demo1.entity.common.PageWithAttach;
import com.longjiang.jiangxia.demo1.entity.common.Response;
import com.longjiang.jiangxia.demo1.service.impl.GoodsDayPriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class GoodsDayPriceController {
    private GoodsDayPriceServiceImpl goodsDayPriceService;


    @Autowired
    public void Inject(
            GoodsDayPriceServiceImpl goodsDayPriceService
    ){
        this.goodsDayPriceService=goodsDayPriceService;
    }


    @PostMapping(value = "/add")
    public Response<String> addDayPrice(@RequestBody GoodsDayPrice goodsDayPrice){
        QueryWrapper<GoodsDayPrice> wrapper=new QueryWrapper<>();
        wrapper.eq("good_id",goodsDayPrice.getGoodId()).eq("date",goodsDayPrice.getDate());
        if(goodsDayPriceService.saveOrUpdate(goodsDayPrice,wrapper)){
            return Response.success("添加最新价格成功");
        }else{
            return Response.fail("添加最新价格失败");
        }
    }

//    @PostMapping(value = "/delete")
//    public Response<String> deleteDayPrice(@RequestBody IDListTO idListTO){
//        if(goodsDayPriceService.removeBatchByIds(idListTO.getId())){
//            return Response.success("删除价格记录成功");
//        }else{
//            return Response.fail("删除价格记录失败");
//        }
//    }

    @PostMapping(value = "/modify")
    public Response<String> modifyPerson(@RequestBody GoodsDayPrice goodsDayPrice){
        UpdateWrapper<GoodsDayPrice> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("good_id",goodsDayPrice.getGoodId()).eq("data",goodsDayPrice.getDate());
        if(goodsDayPriceService.update(goodsDayPrice,updateWrapper)){
            return Response.success("更新价格成功");
        }else{
            return Response.fail("更新价格失败");
        }
    }


    @PostMapping(value = "/list/page")
    public Response<Page<GoodsDayPrice>> GetGoodPriceList(@RequestBody PageWithAttach<Integer> pageWithAttach){
        Page<GoodsDayPrice> page = new Page<>(pageWithAttach.getCurrent(),pageWithAttach.getSize());
        QueryWrapper<GoodsDayPrice> wrapper = new QueryWrapper<>();
        wrapper.eq("type",pageWithAttach.getAttachment());
        goodsDayPriceService.page(page,wrapper);
        return Response.rspData(page);
    }

}
