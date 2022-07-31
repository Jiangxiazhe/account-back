package com.longjiang.jiangxia.demo1.entity;

import com.longjiang.jiangxia.demo1.daoentity.DealRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "商品流记录")
public class DealRecordTO extends DealRecord {
    @ApiModelProperty(value = "商品名称")
    protected String goodName;

    @ApiModelProperty(value = "任务名称")
    protected String personName;

    @ApiModelProperty(value = "单位描述")
    protected String goodUnitDesc;


    @Override
    public String getGoodName() {
        return goodName;
    }

    @Override
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getGoodUnitDesc() {
        return goodUnitDesc;
    }

    public void setGoodUnitDesc(String goodUnitDesc) {
        this.goodUnitDesc = goodUnitDesc;
    }
}
