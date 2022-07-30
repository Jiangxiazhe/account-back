package com.longjiang.jiangxia.demo1.daoentity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName goods_day_price
 */
@TableName(value ="goods_day_price")
@Data
public class GoodsDayPrice implements Serializable {
    /**
     * 主键Id
     */
    @TableId(type = IdType.AUTO)
//    @JsonIgnore
    private Integer id;

    /**
     * 商品Id
     */
    @ApiModelProperty("商品Id")
    private Integer goodId;

    /**
     * 日期
     */
    @ApiModelProperty("日期")
    private Date date;

    /**
     * 预期买入价格
     */
    @ApiModelProperty("预期买入价格")
    private BigDecimal buyPrice;

    /**
     * 预期卖出价格
     */
    @ApiModelProperty("预期卖出价格")
    private BigDecimal sellPrice;

    /**
     * 0->删除，1->存活
     */
    @TableLogic
    @JsonIgnore
    private Integer deleteStatus;

    /**
     * 删除时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @JsonIgnore
    private Date deleteTime;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    private Integer creator;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }


}