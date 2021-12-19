drop database if exists yonghedb;
create database if not exists yonghedb charset utf8;
use yonghedb;
drop table if exists tb_order;
drop table if exists tb_door;
create table tb_door(
id int primary key auto_increment,
name varchar(100),
tel varchar(100),
addr varchar(225)
);
insert into tb_door values("1","永和大王（北三环西路店）","010-62112313","北三环西路甲18号院");
insert into tb_door values("2","永和大王（知春路店）","010-82974223","知春路29号大运省都");
create table tb_order(
id int(11) primary key AUTO_INCREMENT,
door_id int (11),
order_no varchar(50),
order_type varchar(50),
pnum int,
cashier varchar(50),
order_time  timestamp NOT NULL DEFAULT "2001-11-11 11:11:11",
pay_time  timestamp NOT NULL DEFAULT "2001-11-11 11:11:11",
pay_type varchar(50),
price double,
foreign key(door_id) REFERENCES tb_door(id)
);
insert into tb_order values(1,1,"P001","食堂",1,"里斯","2019-01-23 13:01:26","2019-01-23 13:01:26","微信支付",49.00);
insert into tb_order values(2,2,"P001","食堂",1,"里斯","2019-01-23 13:01:26","2019-01-23 13:01:26","微信支付",49.00);
