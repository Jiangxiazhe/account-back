package com.longjiang.jiangxia.demo1.entity.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "通用分页请求，attachment根据需要传递,具体查看api接口说明")
public class PageWithAttach<T> {
    @ApiModelProperty("关键字")
    private String keyWord;
    @ApiModelProperty("附加属性")
    private T attachment;

    /**
     * 每页显示条数，默认 10
     */
    @ApiModelProperty("每页显示条数，默认 10")
    protected long size = 10;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    protected long current = 1;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public T getAttachment() {
        return attachment;
    }

    public void setAttachment(T attachment) {
        this.attachment = attachment;
    }


    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }
}
