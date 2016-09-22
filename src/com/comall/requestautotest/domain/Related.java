package com.comall.requestautotest.domain;

/**
 * @author wangtengfei
 * @建表语句
       Table: t_related
Create Table: CREATE TABLE `t_related` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paraname` varchar(100) NOT NULL COMMENT '参数名，关联值',
  `searchscope` enum('url','body','headers') NOT NULL DEFAULT 'body' COMMENT '表示从哪里查找关联的值，枚举类型，现在为url,body,headers',
  `applyscope` enum('url','body','headers') NOT NULL DEFAULT 'body' COMMENT '表示查找出来的参数应用在目标请求的哪个区域，枚举类型，现在为url,body,headers',
  `pcase` int(11) NOT NULL COMMENT '该请求的响应里的某些值要给scase用',
  `scase` int(11) NOT NULL COMMENT '该请求的参数要依赖于pcase的返回',
  `lb` varchar(256) NOT NULL COMMENT '给定的左边界值',
  `rb` varchar(256) NOT NULL COMMENT '给定的右边界值',
  `lbisregex` tinyint(1) DEFAULT '0' COMMENT '0表示给定的边界不是正则表达式，1表示是正则表达式，默认为0',
  `rbisregex` tinyint(1) DEFAULT '0' COMMENT '0表示给定的边界不是正则表达式，1表示是正则表达式，默认为0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='该表存储用例之间
的关系图'
 * 
 * */
public class Related {
	private int id;
	private String paraname;
	private String searchscope;
	private String applyscope;
	private int pcase;
	private int scase;
	private String lb;
	private String rb;
	private boolean lbisregex;
	private boolean rbisregex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParaname() {
		return paraname;
	}
	public void setParaname(String paraname) {
		this.paraname = paraname;
	}
	public String getSearchscope() {
		return searchscope;
	}
	public void setSearchscope(String searchscope) {
		this.searchscope = searchscope;
	}
	public String getApplyscope() {
		return applyscope;
	}
	public void setApplyscope(String applyscope) {
		this.applyscope = applyscope;
	}
	public int getPcase() {
		return pcase;
	}
	public void setPcase(int pcase) {
		this.pcase = pcase;
	}
	public int getScase() {
		return scase;
	}
	public void setScase(int scase) {
		this.scase = scase;
	}
	public String getLb() {
		return lb;
	}
	public void setLb(String lb) {
		this.lb = lb;
	}
	public String getRb() {
		return rb;
	}
	public void setRb(String rb) {
		this.rb = rb;
	}
	public boolean isLbisregex() {
		return lbisregex;
	}
	public void setLbisregex(boolean lbisregex) {
		this.lbisregex = lbisregex;
	}
	public boolean isRbisregex() {
		return rbisregex;
	}
	public void setRbisregex(boolean rbisregex) {
		this.rbisregex = rbisregex;
	}
	
	
}
