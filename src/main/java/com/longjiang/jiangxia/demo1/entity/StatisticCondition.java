package com.longjiang.jiangxia.demo1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@ApiModel(value = "统计信息条件,不需要该条件时可不传")
public class StatisticCondition {
    @ApiModelProperty(value = "开始日期,结束日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private List<LocalDate> dateRange;
    @ApiModelProperty(value = "任务Id")
    private Integer personId;
    @ApiModelProperty(value = "商品Id")
    private Integer goodId;

    @ApiModelProperty(value = "人物类型")
    private Integer type;


    public List<LocalDate> getDateRange() {
        return dateRange;
    }

    public void setDateRange(List<LocalDate> dateRange) {
        this.dateRange = dateRange;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
