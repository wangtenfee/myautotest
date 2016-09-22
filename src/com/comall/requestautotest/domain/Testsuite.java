package com.comall.requestautotest.domain;

/**@author wangtengfei
 * @建表语句 
*************************** 1. row ***************************
       Table: t_testsuite
Create Table: CREATE TABLE `t_testsuite` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `testsuitename` varchar(100) NOT NULL COMMENT '用例集合名',
  `includetcid` varchar(100) NOT NULL COMMENT '该 条测试集包含哪些测试用例，存储的用例的ID,中间用逗号隔开，需要按测试用例执行的顺序存储',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，默认自动生成',
  PRIMARY KEY (`id`),
  UNIQUE KEY `testsuitename` (`testsuitename`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
1 row in set (0.00 sec)
 * */

public class Testsuite {
	

	private int id;
	private String testsuitename; /*constraint unique*/
	private String includetcid; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestsuitename() {
		return testsuitename;
	}
	public void setTestsuitename(String testsuitename) {
		this.testsuitename = testsuitename;
	}
	public String getIncludetcid() {
		return includetcid;
	}
	public void setIncludetcid(String includetcid) {
		this.includetcid = includetcid;
	}
	
}
