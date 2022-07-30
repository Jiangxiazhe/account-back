package com.longjiang.jiangxia.demo1.enumset;

public enum UserType {

    SUPPLIER(0, "供应商"),
    CUSTOMER(1, "客户")
    ;

    int type;
    String desc;

    UserType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
