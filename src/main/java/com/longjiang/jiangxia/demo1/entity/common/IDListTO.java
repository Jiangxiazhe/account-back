package com.longjiang.jiangxia.demo1.entity.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ApiModel
@Data
public class IDListTO {
    @ApiModelProperty(value = "Id列表")
    List<Integer> id;

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }
}
