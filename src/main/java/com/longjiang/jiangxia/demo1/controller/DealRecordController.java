package com.longjiang.jiangxia.demo1.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longjiang.jiangxia.demo1.daoentity.DealRecord;
import com.longjiang.jiangxia.demo1.entity.common.IDListTO;
import com.longjiang.jiangxia.demo1.entity.common.PageWithAttach;
import com.longjiang.jiangxia.demo1.entity.common.Response;
import com.longjiang.jiangxia.demo1.service.impl.DealRecordServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hang
 * @since 2022-07-30
 */
@RestController
@RequestMapping("/v1/deal-record")
public class DealRecordController {

    private DealRecordServiceImpl dealRecordService;

    @Autowired
    public void Inject(
            DealRecordServiceImpl dealRecordService
    ) {
        this.dealRecordService = dealRecordService;

    }

    @PostMapping(value = "/add")
    public Response<String> addDeal(@RequestBody DealRecord dealRecord) {
        if (dealRecordService.save(dealRecord)) {
            return Response.success("添加商品成交记录成功");
        } else {
            return Response.fail("添加商品成交记录失败");
        }
    }

    @PostMapping(value = "/delete")
    public Response<String> deleteDealRecord(@RequestBody IDListTO idListTO) {
        if (dealRecordService.removeBatchByIds(idListTO.getId())) {
            return Response.success("删除商品成交记录成功");
        } else {
            return Response.fail("删除商品成交记录失败");
        }
    }

    @PostMapping(value = "/modify")
    public Response<String> modifyPerson(@RequestBody DealRecord dealRecord) {
        UpdateWrapper<DealRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", dealRecord.getId());
        if (dealRecordService.update(dealRecord, updateWrapper)) {
            return Response.success("更新商品成交记录成功");
        } else {
            return Response.fail("更新商品成交记录失败");
        }
    }


    @PostMapping(value = "/list/page")
    @ApiOperation(value = "分页获取,attachment参数须为整数，0为买入(供应商),1为卖出(客户)")
    public Response<Page<DealRecord>> GetPersonList(@RequestBody PageWithAttach<Integer> pageWithAttach) {
        Page<DealRecord> page = new Page<>(pageWithAttach.getCurrent(), pageWithAttach.getSize());
        if (pageWithAttach.getAttachment() == null) {
            dealRecordService.page(page);
            return Response.rspData(page);
        }
        QueryWrapper<DealRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("type", pageWithAttach.getAttachment());
        dealRecordService.page(page, wrapper);
        return Response.rspData(page);
    }
}
