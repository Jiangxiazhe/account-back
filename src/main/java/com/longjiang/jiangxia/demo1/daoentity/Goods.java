package com.longjiang.jiangxia.demo1.daoentity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName goods
 */
@TableName(value ="goods")
@Data
@ApiModel
public class Goods implements Serializable {
    /**
     * 
     */
//    @JsonIgnore
    private Integer id;

    /**
     * 
     */
    @ApiModelProperty("商品名")
    private String name;

    /**
     * 单位类型：1->市斤，2->公斤，3->件
     */
    @ApiModelProperty("单位类型：1->市斤，2->公斤，3->件")
    private Integer unitType;

    /**
     * 预期买入价格
     */
    @ApiModelProperty("预期价格")
    private BigDecimal buyPrice;

    /**
     * 预期卖出价格
     */
    @ApiModelProperty("预期卖出价格")
    private BigDecimal sellPrice;

    /**
     * example:"市斤","公斤","件"
     */
    @ApiModelProperty("单位描述:\"市斤\",\"公斤\",\"件\"")
    private String unitDesc;

    /**
     * 预留值
     */
    @JsonIgnore
    private Integer type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUnitType() == null ? other.getUnitType() == null : this.getUnitType().equals(other.getUnitType()))
            && (this.getUnitDesc() == null ? other.getUnitDesc() == null : this.getUnitDesc().equals(other.getUnitDesc()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUnitType() == null) ? 0 : getUnitType().hashCode());
        result = prime * result + ((getUnitDesc() == null) ? 0 : getUnitDesc().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", unitType=").append(unitType);
        sb.append(", unitDesc=").append(unitDesc);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}