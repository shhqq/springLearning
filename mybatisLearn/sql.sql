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


-- day03 多表查询
# 一个用户可以对应多个账号，每个账号只能属于一个用户
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	`id` int(11) not null auto_increment,
	`username` varchar(32) not null comment '用户名称',
	`birthday` datetime default null comment '生日',
	`sex` char(1) default null comment '性别',
	`address` varchar(256) default null comment '地址',
	primary key (`id`)
)engine=InnoDB default charset=utf8;

# 导入数据
insert into `user` (`id`, `username`,`birthday`,`sex`,`address`) values (41,'老王','2018-02-27 17:47:08','男','北京'),(42,'小二王','2018-03-02 15:09:37','女','北京金燕龙'),(43,'小二王','2018-03-04 11:34:34','女','北京金燕龙'),(45,'传智播客','2018-03-04 12:04:06','男','北京金燕龙'),(46,'老王','2018-03-07 17:37:26','男','北京'),(48,'小马宝莉','2018-03-08 11:44:00','女','北京修正');

# 创建账户表，外键为uid，关联用户表的id
drop table if exists `account`;
create table `account`(
	`id` int(11) not null comment '',
	`uid` int(11) default null comment '',
	`money` double default null comment '',
	primary key (`id`),
	key `FK_Reference_8` (`uid`),
	constraint `FK_Reference_8`	 FOREIGN key (`uid`) references `user` (`id`)
) engine=InnoDB default charset=utf8;

# 导入数据
insert  into `account`(`id`,`uid`,`money`) values (1,46,1000),(2,45,1000),(3,46,2000);




