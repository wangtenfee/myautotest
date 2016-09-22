package com.comall.requestautotest.domain;

/**
 * @author wangtengfei
 * @建表语句
 *        Table: t_baseurl
Create Table: CREATE TABLE `t_baseurl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `urlname` varchar(40) NOT NULL COMMENT '基础URL名',
  `url` varchar(40) NOT NULL COMMENT '基础URL,或者IP',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

  PRIMARY KEY (`id`),
  UNIQUE KEY `urlname` (`urlname`),
  UNIQUE KEY `url` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
 * 
 * 
 * 
 * */

public class Baseurl {
	
	private int id;
	private String urlname;
	private String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrlname() {
		return urlname;
	}
	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
