--创建数据库，（文件夹）
create database mybatisTest default charset utf8;

-- 创建表
create table user(
	id int(11) not null auto_increment,
	username varchar(32) not null comment '用户名称',
	birthday datetime default null comment '生日',
	sex char(1) default null comment '性别',
	address varchar(256) default null comment '地址',
	primary key (`id`)
)engine=InnoDB default charset=utf8;

-- 插入数据
insert into `user`(id, username, birthday, sex, address) values
(41, '老王','2020-02-27 17:48:23', '男','北京'),
(42, '小二王','2020-06-27 12:48:23', '男','北京房山'),
(43, '小二王','2020-04-27 15:48:23', '男','北京房山'),
(44, '博客','2020-02-17 17:09:23', '女','北京'),
(45, '老王','2020-03-22 08:48:23', '女','北京昌平'),
(48, '王老五','2020-03-27 17:48:23', '男','北京怀柔');