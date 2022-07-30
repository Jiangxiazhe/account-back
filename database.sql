
create table if not exists goods_day_price
(
    id            int auto_increment comment '主键Id'
        primary key,
    good_id       int                                     not null comment '商品Id',
    date          date                                    not null comment '日期',
    price         decimal(10,2)                                 not null comment '价格',
    delete_status int       default 1                     not null comment '0->删除，1->存活',
    delete_time   timestamp default '0000-00-00 00:00:00' null comment '删除时间',
    create_time   timestamp default CURRENT_TIMESTAMP     not null comment '创建时间',
    creator       int                                     null comment '创建人',
    constraint goods_day_price_id_uindex
        unique (id),
    constraint goods_day_price_pk
        unique (id),
    constraint goods_price_record_pk_2
        unique (good_id)
);

create index goods_day_price_index
    on goods_day_price (date);

create index goods_price_record_good_id_date_index
    on goods_day_price (good_id, date);


create table if not exists goods
(
    id        int auto_increment,
    name      varchar(16)           not null,
    buy_price       decimal(10,2) default 0 not null comment '商品预期买入价格' ,
    sell_price       decimal(10,2) default 0 not null comment '商品预期卖出价格' ,
    unit_type int      default 1    null comment '单位类型：1->市斤，2->公斤，3->件',
    unit_desc char(16) default '市斤' null comment 'example:"市斤","公斤","件"',
    type      int                   null comment '预留值',
    constraint goods_list_id_uindex
        unique (id),
    constraint goods_list_name_uindex
        unique (name)
);

create table  if not exists person
(
    Id            int auto_increment
        primary key,
    type          int      default 1                 not null comment '类型：0->供应商,1->客户',
    contact       varchar(256)                       not null comment '联系方式',
    name          char(32)                           not null comment '姓名',
    address       varchar(256)                       null comment '地址',
    comment       varchar(256)                       null comment '描述，备注',
    delete_status int      default 1                 not null comment '0->删除，1->存活',
    delete_time   datetime default CURRENT_TIMESTAMP null comment '删除时间',
    update_time   datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    create_time   datetime default CURRENT_TIMESTAMP not null,
    constraint Person_Id_uindex
        unique (Id)
);


create table if not exists  deal_record
(
    id          int auto_increment
        primary key,
    date        date   not null comment '日期' ,
    good_id     int    not null comment '商品Id',
    good_name   varchar(16)  comment '商品名称' ,
    type        int not null comment '类型：0->supplier,1->customer' ,
    buy_price       decimal(10,2) default 0 not null comment '商品预期买入价格' ,
    sell_price       decimal(10,2) default 0 not null comment '商品预期卖出价格' ,
    amount      decimal(10,2) default 0 not null comment '商品名称' ,
    person_id   int           not null,

    constraint deal_record_id_uindex
        unique (id),
    constraint deal_record_person_id_fk
        foreign key (person_id) references person (id),
    constraint deal_record_goods_id_fk
        foreign key (good_id) references goods (id)
);