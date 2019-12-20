DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
  create_time datetime  NULL DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (id)
);

truncate table user;

INSERT INTO user (id, name, age, email,create_time) VALUES
(1, 'Jone', 18, 'test1@baomidou.com',DATE_FORMAT('2019-12-20 01:11:12','%Y-%m-%d %H:%i:%S')),
(2, 'Jack', 20, 'test2@baomidou.com',DATE_FORMAT('2019-12-19 01:11:12','%Y-%m-%d %H:%i:%S')),
(3, 'Tom', 28, 'test3@baomidou.com',DATE_FORMAT('2019-12-17 01:11:12','%Y-%m-%d %H:%i:%S')),
(4, 'Sandy', 21, 'test4@baomidou.com',DATE_FORMAT('2019-12-10 01:11:12','%Y-%m-%d %H:%i:%S')),
(6, '张飞', 33, 'zhangfei@baomidou.com',DATE_FORMAT('2019-12-09 01:11:12','%Y-%m-%d %H:%i:%S')),
(5, 'Billie', 24, 'test5@baomidou.com',DATE_FORMAT('2019-12-09 01:11:12','%Y-%m-%d %H:%i:%S'));