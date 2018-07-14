# 创建表
create table category_ (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
) engine = InnoDB auto_increment = 1 default charset = utf8mb4;

create table product_ (
	  id int(11) not null auto_increment,
    name varchar(32) default null,
    price double default null,
    cid int(11) default null,
    primary key (id)
) engine = InnoDB auto_increment = 1 default charset = utf8mb4;

create table order_(
	id int(11) not null auto_increment,
    code varchar(32) default null,
    primary key (id)
)engine = InnoDB auto_increment = 1 default charset = utf8mb4;

create table order_item_(
	id int(11) not null auto_increment,
    oid int(11),
    pid int(11),
    number int(11),
    primary key (id)
)engine = InnoDB auto_increment = 1 default charset = utf8mb4;

# 准备数据
delete from category_;
insert into category_ values(null,'category1');
insert into category_ values(null,'category2');
insert into category_ values(null,'category3');
insert into category_ values(null,'category4');
insert into category_ values(null,'category5');
