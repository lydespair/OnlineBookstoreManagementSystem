create database if not exists bookseller;
use bookseller;

create table if not exists book
(
    ISBW         varchar(50)   not null comment '书号'
        primary key,
    book_name    varchar(20)   not null comment '图书名字',
    type         tinyint       not null comment '图书分类 1-文学小说 2-社科经管 3-幼儿童书 4-生活艺术 5-行业职业 ',
    publisher    varchar(20)   not null comment '出版社',
    price        float         not null comment '价格',
    author       varchar(20)   not null comment '作者',
    publish_date date          not null comment '出版时间',
    count        int           not null comment '库存',
    image        varchar(50)   null comment '图书封面',
    `describe`   varchar(1000) null comment '简介',
    sales        int default 0 not null comment '销量',
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
    user_id     bigint                             not null comment '用户名',
    book_id     bigint                             not null comment '图书编号',
    order_count int                                not null comment '订单数量',
    price       int                                not null comment '价格',
    create_time datetime                           not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null comment '修改时间',
    state       tinyint  default 0                 not null comment '状态(0-未付款 1-已支付)',
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
    address       varchar(50) null comment '地址',
    tel           char(11)    null comment '联系号码',
    email         varchar(20) null comment '邮箱',
    constraint user_pk
        unique (tel),
    constraint user_pk1
        unique (user_name)
)
    comment '用户表';


insert into user (user_id, user_name, user_password, address, tel, email)
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
       (12, 'test', '666', '广东广州', '42352356366', null),
       (14, '369789', '666', '广东深圳', '13001000020', null),
       (17, '命名映射', '999', '江苏南京', '11301000323', null),
       (19, 'Giftia', '000111', null, null, null),
       (20, 'Giftia02', '000111', null, null, null);

insert into book (ISBW, book_name, type, publisher, price, author, publish_date, count, image, 'describe', sales)
values ('9787020104345', '悲惨世界-(全三册)', 1, '人民文学出版社', 110, '雨果', '1992-06-01', 50, null,
        '《悲惨世界(上中下)(精)》是雨果在流亡期间写的长篇小说，是他的代表作，也是世界文学宝库的珍品之一。 《悲惨世界(上中下)(精)》通过冉阿让等人的悲惨遭遇以及冉阿让被卞福汝主教感化后一系列令人感动的事迹，深刻揭露和批判了19世纪法国封建专制社会的腐朽本质及其罪恶现象，对穷苦人民在封建重压下所遭受的剥削欺诈和残酷迫害表示了悲悯和同情。',
        350),
       ('9787020127894', '围城', 1, '人民文学出版社', 36, '钱锺书', '2017-07-01', 100, null,
        '《围城》延续了鲁迅揭露“国民性”的文化批判之路。嬉笑怒骂、妙趣横生的小说语言，幽微复杂、真实琐屑的心理袒露，新奇玄妙、令人叹服的修辞譬喻，关乎生活又指涉情感的多层意蕴，让《围城》成为中国三十年来横贯常销畅销小说之首，亦成为现当代小说史上不可跨越的翘楚之作。',
        145),
       ('9787229100605', '三体', 1, '重庆出版社', 26, '刘慈欣', '2016-06-01', 256, null, '本书讲述了，“文化大革命”如火如荼进行的同时，军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但无人料到，地球文明向宇宙发出的**声啼鸣，彻底改变了人类的命运。
四光年外，为了生存挣扎的“三体文明”接收到了地球发来的信息。在运用超技术锁死地球人的基础科学之后，三体人庞大的宇宙舰队开始向地球进发……',
        1580),
       ('9787516811689', '老人与海', 1, '台湾出版社', 12.9, '[美]海明威', '2016-10-01', 64, null,
        '《老人与海》故事的背景是在20世纪中叶的古巴。主人公是一位名叫圣地亚哥的老渔夫，配角是一个叫马诺林的小孩。风烛残年的老渔夫一连八十四天都没有钓到一条鱼，但他仍不肯认输，而是充满着奋斗的精神，终于在第八十五天钓到一条身长十八尺，体重一千五百磅的大马林鱼。大鱼拖着船往海里走，老人依然死拉着不放，即使没有水，没有食物，没有武器，没有助手，左手抽筋，他也丝毫不灰心。经过两天两夜之后，他终于杀死大鱼，把它拴在船边。但许多鲨鱼立刻前来抢夺他的战利品。他一一地杀死它们，到最后只剩下一支折断的舵柄作为武器。结果，大鱼仍难逃被吃光的命运，最终，老人筋疲力尽地拖回一副鱼骨头。他回到家躺在床上，只好从梦中去寻回那往日美好的岁月，以忘却残酷的现实。',
        468),
       ('9787533960919', '尘埃落定', 1, '浙江文艺出版社', 49, '阿来', '2020-09-01', 200, null, '《尘埃落定》是近年来诺贝尔文学奖呼声极高的重量级作家阿来的长篇代表作，荣获第五届茅盾文学奖，也是当代中国文坛畅销不衰的经典之作。
在小说中，一个声势显赫的藏族老麦其土司，在酒后和汉族太太生了一个傻瓜儿子。这个人人都认定的傻子与现实生活格格不入，却有着超越时代的预感能力和举止。在其他土司遍种罂粟时，傻子少爷突然建议改种麦子，结果鸦片供过于求，无人问津，大批饥民投奔麦其麾下，麦其家族的领地和人口达到少见的规模，傻子少爷也因此而娶到了美貌的妻子塔娜，并开辟了康巴地区个边贸集市。然而当傻子少爷回到麦其土司官寨后，一场家族内部关于继承权的腥风血雨却悄然拉开了帷幕……',
        69),
       ('9787544291170', '百年孤独', 1, '南海出版公司', 55, '[哥伦比亚]加西亚·马尔克斯', '2017-08-01', 30, null, '《百年孤独》是魔幻现实主义文学的代表作，描写了布恩迪亚家族七代人的传奇故事，以及加勒比海沿岸小镇马孔多的百年兴衰，反映了拉丁美洲一个世纪以来风云变幻的历史。作品融入神话传说、民间故事、宗教典故等因素，巧妙地糅合了现实与虚幻，展现出一个瑰丽的想象世界，成为20世纪重要的经典文学巨著。1982年加西亚·马尔克斯获得诺贝尔文学奖，奠定*文学大师的地位，很大程度上便是凭借《百年孤独》的巨大影响。

', 71);