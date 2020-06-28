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

-- 创建角色表，用于多对多查询案例
DROP TABLE IF exists `role`;
create table `role`(
	`id` int(11) not null comment '编号',
	`role_name` varchar(30) default null comment '角色名称',
	`role_desc` varchar(60) default null comment '角色描述',
	primary key (`id`)
)engine=InnoDB default charset=utf8;

-- 添加数据
insert into `role`(`id`, `role_name`, `role_desc`) values (1, '院长', '管理整个学院'), (2, '总裁', '管理整个公司'), (3, '校长', '管理整个学校');

# 创建用户角色表，也就是中间表
# uid和rid是复合主键，同时也是外键
drop table if exists `user_role`;
create table `user_role`(
	`uid` int(11) not null comment '用户编号',
	`rid` int (11) not null comment '角色编号',
	primary key (`uid`, `rid`),
	key `FK_Reference_10` (`rid`),
	constraint `FK_Reference_10` foreign key (`rid`) references `role`(`id`),
	constraint `FK_Reference_9` foreign key (`uid`) references `user` (`id`)
)engine=InnoDB default charset=utf8;

-- 添加用户角色数据
insert into `user_role`(`uid`, `rid`) values (41, 1), (45, 1),(41, 2);


# springMVC视频最后整合SSM

-- 创建数据库（文件夹）
create database ssmTest default charset utf8;
-- 创建表
CREATE TABLE account(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	MONEY DOUBLE
);

-- 插入数据
insert into account(name, money) values("Jack", 1000), ("Michel", 1500), ("Mike", 2000);

