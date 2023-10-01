create database if not exists bookseller;
use bookseller;

create table if not exists book
(
    book_id      bigint auto_increment comment '图书编号'
        primary key,
    type         varchar(5)   not null comment '图书分类',
    ISBW         varchar(50)  null comment '书号',
    publisher    varchar(20)  not null comment '出版社',
    price        float        not null comment '价格',
    author       varchar(10)  not null comment '作者',
    publish_date date         not null comment '出版时间',
    count        int          not null comment '库存',
    image        varchar(50)  null comment '图书封面',
    `describe`   varchar(100) null comment '简介',
    constraint book_pk1
        unique (ISBW)
)
    comment '图书信息表';

create table if not exists manager
(
    admin_id   bigint auto_increment comment '管理员id'
        primary key,
    admin_name varchar(10) not null comment '管理员姓名',
    admin_pwd  varchar(20) not null comment '管理员密码'
)
    comment '管理员表';

create table if not exists massage
(
    user_id       bigint auto_increment comment '用户名'
        primary key,
    text          varchar(500)      not null comment '留言文本',
    time          datetime          not null comment '留言时间',
    message_check tinyint default 1 not null comment '是否已读 1-已读 2-未读'
)
    comment '留言管理表';

create table if not exists `order`
(
    order_id    bigint auto_increment comment '订单号'
        primary key,
    book_id     bigint            not null comment '图书编号',
    user_id     bigint            not null comment '用户名',
    order_count int               not null comment '订单数量',
    price       int               not null comment '价格',
    user_check  tinyint default 1 not null comment '用户确认(0-提交订单 1-修改确认)',
    post_time   datetime          not null comment '提交时间',
    admin_check tinyint default 0 not null comment '管理员确认(0-用户未提交 1-未发货 2-已发货 3-已完成)',
    constraint Order_pk1
        unique (book_id),
    constraint Order_pk2
        unique (user_id)
)
    comment '订单表';

create table if not exists user
(
    user_id       bigint auto_increment comment '用户名'
        primary key,
    user_name     varchar(10) not null comment '用户姓名',
    user_password varchar(20) not null comment '密码',
    address       varchar(50) not null comment '地址',
    tel           char(11)    null comment '联系号码',
    email         varchar(20) null comment '邮箱',
    constraint user_pk
        unique (tel)
)
    comment '用户表';

insert into user
    (user_id, user_name, user_password, address, tel, email)
values (1, 'Tom', '123456', '湖北武汉', '11111111111', '111111111@qq.com'),
       (2, 'jiangly', '666666', '北京', '13000000876', 'www123@outlook.com'),
       (3, 'atri', 'liketi', 'Tokyo', '50000020001', 'www123@outlook.com'),
       (4, 'ala', '534534634', '北京', '13000005876', 'www123@outlook.com'),
       (5, 'user1', '0111111', '北京', '13000040876', 'www123@outlook.com'),
       (6, 'user2', '0222222', '北京', '13000030876', 'www123@outlook.com'),
       (7, 'user3', '0333333', '北京', '12000030876', 'www123@outlook.com'),
       (8, 'user5', '0555555', '北京', '13004000843', 'www123@outlook.com'),
       (9, 'user6', '0666666', '北京', '13001000876', 'www123@outlook.com'),
       (10, 'user7', '0777777', '北京', '13110000876', 'www123@outlook.com'),
       (11, 'user8', '8888888', '北京', '13004000871', 'www123@outlook.com')
