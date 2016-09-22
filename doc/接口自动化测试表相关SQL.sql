create table t_user(
   userId INT NOT NULL AUTO_INCREMENT,
   userName VARCHAR(100) NOT NULL,
   password VARCHAR(40) NOT NULL,
   credits INT,
   lastIp VARCHAR(40),
   lastVisit DATE,
   PRIMARY KEY ( userId )
);

create table t_userlog(
   loginLogId INT NOT NULL AUTO_INCREMENT,
   userId INT,
   ip VARCHAR(40),
   loginDate DATE,
   PRIMARY KEY ( loginLogId )
);

--创建测试用例表
mysql>  show create table t_testcase \G;
       Table: t_Testcase
Create Table: CREATE TABLE `t_testcase` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `casename` varchar(100) NOT NULL COMMENT '请求名，一条请求也是一个测试用例，所以称为用例名',
  `taskinjira` varchar(20) DEFAULT NULL COMMENT '所属的任务，这个任务号可以从jira中获得，由用户输入',
  `httptypeid` int(4) NOT NULL DEFAULT '1' COMMENT '是HTTP还是HTTPS，1表示http://,0表示https://',
  `headers` text COMMENT '请求头文件，如果没有特殊的头信息，那么该字段可以为空，',
  `url` text NOT NULL COMMENT '请求的URL',
  `methodtypeid` int(20) NOT NULL COMMENT '请求的方法，可以是get也可以是post方法',
  `body` text COMMENT '该请求的Body，也可以当作测试数据来用，如果请求是post方法，那么该数据就直接放到body里，如果请求是get方法，那么该数据直接跟在请求后面与URL用？隔开。该字段可以为空，虽然测试数据是必须的，当该字段为空时，测试数据就在URL里面。',
  `expectresult` text,
  `lb` varchar(100) DEFAULT NULL COMMENT '查找期望结果的左边界', 
  `rb` varchar(100) DEFAULT NULL COMMENT '查找期望结果的右边界',
  `relycaseid` int(11) DEFAULT NULL COMMENT '该请求依赖的请求，自连接，参考的本表的ID',
  `isrelied` tinyint(1) NOT NULL DEFAULT '0' COMMENT '该请求是否被其它请求依赖，0给否，1表示是，如果是1，需要用该列的ID去t_related查找关系表',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `featureid` int(11) DEFAULT NULL COMMENT '该请求所属的功能，外键，参考了t_feature表',
  `baseurlid` int(11) NOT NULL COMMENT '外键，参考t_baseurl的ID，存储基础IP，如10.6.8.58',
  PRIMARY KEY (`id`),
  UNIQUE KEY `casename` (`casename`),
  KEY `fk_tc_f` (`featureid`),
  KEY `fk_tc_r` (`relycaseid`) USING BTREE,
  KEY `fk_tc_mt` (`methodtypeid`),
  KEY `fk_tc_ht` (`httptypeid`),
  KEY `fk_tc_bu` (`baseurlid`),
  CONSTRAINT `t_testcase_ibfk_6` FOREIGN KEY (`baseurlid`) REFERENCES `t_baseurl` (`id`),
  CONSTRAINT `t_testcase_ibfk_1` FOREIGN KEY (`featureid`) REFERENCES `t_feature` (`id`),
  CONSTRAINT `t_testcase_ibfk_4` FOREIGN KEY (`methodtypeid`) REFERENCES `t_methodtype` (`id`),
  CONSTRAINT `t_testcase_ibfk_5` FOREIGN KEY (`httptypeid`) REFERENCES `t_httptype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
--创建测试业务表
mysql> show create table t_feature \G;
*************************** 1. row ***************************
       Table: t_feature
Create Table: CREATE TABLE `t_feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `featurename` varchar(256) NOT NULL,
  `detailinfo` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `includedfeature` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tft_if` (`includedfeature`),
  CONSTRAINT `t_feature_ibfk_1` FOREIGN KEY (`includedfeature`) REFERENCES `t_feature` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8

alter table t_testsuite add create_time timestamp default CURRENT_TIMESTAMP;

--查看MYSQL的表建表语句，该表可以查看表的建表语句。
show create table T_TESTCASE \G
--创建业务表，记录业务的ID，详细信息等
create table t_feature(
	`id` int not null auto_increment,
	`featurename` varchar(256) NOT NULL,
	`detailinfo` varchar(256) DEFAULT NULL,
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--下面SQL用于将表t_feature的incluedfeature列
alter table t_feature add foreign key fk_ft_incluedfeatue(incluedfeature) references t_feature(id);
--增加外键
mysql> alter table t_testcase add foreign key fk_tc_rc(relycaseid) references t_testcase(id);
 alter table t_testcase drop foreign key t_testcase_ibfk_2
 alter table t_testcae drop key fk_tc_rc
 
 create table t_baseurl(
	id int not null primary key auto_increment comment '主键，自增',
	urlname varchar(40) not null unique comment '基础URL名',
	url varchar(40) not null unique comment '基础URL,或者IP',
	create_time timestamp not null default CURRENT_TIMESTAMP COMMENT '创建时间'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into t_baseurl(urlname,url) values('webftest1','10.6.8.58');
insert into t_baseurl(urlname,url) values('webftest2','10.6.8.59');
insert into t_baseurl(urlname,url) values('passportipftest','10.6.8.71');

CREATE TABLE `t_testsuite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testsuitename` varchar(100) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `testsuitename` (`testsuitename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建两个用例的关系表
create table `t_related`(
	id int not null auto_increment primary key,
	scope enum('url','body','headers') default 'body' not null comment '表示从哪里查找关联的值，枚举类型，现在为url,body,headers',
	pcase int not null comment '该请求的响应里的某些值要给scase用',
	scase int not null comment '该请求的参数要依赖于pcase的返回',
	lb varchar(256) not null comment '给定的左边界值',
	rb varchar(256) not null comment '给定的右边界值',
	lbisregex tinyint(1) default 0 comment '0表示给定的边界不是正则表达式，1表示是正则表达式，默认为0',
	rbisregex tinyint(1) default 0 comment '0表示给定的边界不是正则表达式，1表示是正则表达式，默认为0'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '该表存储用例之间的关系图';

foreign key(pcase) references t_testcase(id) on delete cascade on update cascade),
foreign key(scase) references t_testcase(id) on delete cascade on update cascade),

--创建methodtype表
create table t_methodtype(
	id int not null auto_increment primary key,
	methodtype varchar(20) not null unique comment 'method type,e.g. post get put'
);
insert into t_methodtype(methodtype) values('get');
insert into t_methodtype(methodtype) values('post');
alter table t_testcase add foreign key fk_tc_mt(methodtypeid) references t_methodtype(id);
--创建httptype表
create table t_httptype(
	id int not null auto_increment primary key,
	httptype varchar(20) not null unique comment 'http type,e.g. http https'
);
insert into t_httptype(httptype)values('https');
insert into t_httptype(httptype)values('http');

--创建t_parameters表，已放弃在数据库中建表，做成对象了。
create table t_parameters(
	id int not null auto_increment primary key,
	relycase int not null references t_Testcase(id) comment '外键，参考t_testcase的主键ID',
	paraname varchar(40) not null comment '关联的参数名',
	scope enum('url','body','headers') default 'body' not null comment '表示从哪里查找关联的值，枚举类型，现在为url,body,headers',	
)

--创建t_result测试结果表

create table t_user(
	id int primary key auto_increment,
	username varchar(20) not null,
	password varchar(20),
	departmentid int not null references t_department(id),
	create_time timestamp not null default current_timestamp comment '创建时间'
);
alter table t_user add email varchar(40) not null ;
--部门表
create table t_department(
	id int primary key auto_increment,
	departname varchar(40) not null,
	create_time timestamp not null default current_timestamp comment '创建时间'
);
--SUITE result
create table t_suiteresult(
	id int primary key auto_increment,
	testsuiteid int references t_testsuite(id),
	userid int references t_user(id),
	create_time timestamp not null default current_timestamp comment '创建时间'
);

--CASE result
create table t_caseresult(
	id int primary key auto_increment,
	caseid int references t_testcae(id),
	suiteres int references t_suiteresult(id),
	resultid int references t_result(id),
	errormsg text,
	create_time timestamp not null default current_timestamp comment '创建时间'
);

--结果类型表,待定
create table t_result(
	id int not null primary key auto_increment,
	result varchar(10)
);
insert into t_result(result)values('PASS');
insert into t_result(result)values('FAIL');
insert into t_result(result)values('BLOCK');
insert into t_result(result)values('N/A');

--创建position表
create table t_position(
	id int primary key auto_increment,
	position enum('HEADER','URL','BODY') not null unique  comment '位置表' --这个enum还得写在最前面
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '该表存储用例之间的关系图';
insert into t_position(position)values('HEADER');
insert into t_position(position)values('URL');
insert into t_position(position)values('BODY');




