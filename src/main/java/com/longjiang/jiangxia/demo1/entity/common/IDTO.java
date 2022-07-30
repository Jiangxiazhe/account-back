package com.longjiang.jiangxia.demo1.entity.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ApiModel(value = "com.longjiang.jiangxia.demo1.entity.common.IDTO")
@Data
public class IDTO {
    @ApiModelProperty(value = "Id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
