package com.longjiang.jiangxia.demo1.enumset;

import javax.swing.*;

public enum GoodUnit {

    JIN(0, "市斤"),
    KG(1, "公斤"),
    JIAN(2,"件")
    ;

    int type;
    String desc;

    GoodUnit(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static   GoodUnit getEnum(int ordinal){
        switch (ordinal){
            case 0:
                return JIN;
            case 1:
                return KG;
            case 2:
                return JIAN;
            default:
                return null;
        }
    }
}
