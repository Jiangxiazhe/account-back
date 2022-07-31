package com.longjiang.jiangxia.demo1.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Map;

@ApiModel(value = "统计信息")
public class StatisticInfo {

    @ApiModelProperty(value = "金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "商品数量")
    private int goodsCount;

    @ApiModelProperty(value = "商品金额")
    private Map<String,BigDecimal> goodsAmount;

    @ApiModelProperty(value = "每日金额")
    private Map<String,BigDecimal> dailyAmount;

    @ApiModelProperty(value = "分页相关数据")
    private Page<DealRecordTO> pageData;


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Map<String, BigDecimal> getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Map<String, BigDecimal> goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Map<String, BigDecimal> getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(Map<String, BigDecimal> dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public Page<DealRecordTO> getPageData() {
        return pageData;
    }

    public void setPageData(Page<DealRecordTO> pageData) {
        this.pageData = pageData;
    }
}
