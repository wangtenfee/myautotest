package com.comall.requestautotest.domain;

/**
 * @author wangtengfei
 * @建表语句
 *  
*************************** 1. row ***************************
       Table: t_Testcase
CREATE TABLE `t_testcase` (
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
 * 
 * */

public class TestCase {

	private int id;
	private String casename; /*constraint unique*/
	private String taskinjira; /*task number in the JIRA*/
	private String headers;
	private String url;
	private int methodtypeid; /*foreign key,references t_methodtype(id)*/
	private String body;
	private String expectresult;	/*expect result of the request*/
	private int relycaseid; /*foreign key references itself(id)*/
	private int featureid; /*foreign key references t_feature(id)*/
	private int baseurlid; /*foreign key,references t_baseurl(id)*/
	private String lb;	/*The left boundary of the parameter or the dynamic data*/
	private String rb;	/*The right boundary of the parameter or the dynamic data*/
	private boolean isrelied;	/*whether be relied by other case or not*/
	private int httptypeid; /*foreign key,references t_httptype(id)*/
	private String searchscope; /*the scope of the expect result*/
	private String uniquestring; /*the unique string exists in the response of the request to distinguish the request be processed successfully */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCasename() {
		return casename;
	}
	public void setCasename(String casename) {
		this.casename = casename;
	}
	public String getTaskinjira() {
		return taskinjira;
	}
	public void setTaskinjira(String taskinjira) {
		this.taskinjira = taskinjira;
	}
	public String getHeaders() {
		return headers;
	}
	public void setHeaders(String headers) {
		this.headers = headers;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getMethodtypeid() {
		return methodtypeid;
	}
	public void setMethodtypeid(int methodtypeid) {
		this.methodtypeid = methodtypeid;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getExpectresult() {
		return expectresult;
	}
	public void setExpectresult(String expectresult) {
		this.expectresult = expectresult;
	}
	public int getRelycaseid() {
		return relycaseid;
	}
	public void setRelycaseid(int relycaseid) {
		this.relycaseid = relycaseid;
	}
	public int getFeatureid() {
		return featureid;
	}
	public void setFeatureid(int featureid) {
		this.featureid = featureid;
	}
	public int getBaseurlid() {
		return baseurlid;
	}
	public void setBaseurlid(int baseurlid) {
		this.baseurlid = baseurlid;
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
	public boolean isIsrelied() {
		return isrelied;
	}
	public void setIsrelied(boolean isrelied) {
		this.isrelied = isrelied;
	}
	public int getHttptypeid() {
		return httptypeid;
	}
	public void setHttptypeid(int httptypeid) {
		this.httptypeid = httptypeid;
	}
	public String getSearchscope() {
		return searchscope;
	}
	public void setSearchscope(String searchscope) {
		this.searchscope = searchscope;
	}
	public String getUniquestring() {
		return uniquestring;
	}
	public void setUniquestring(String uniquestring) {
		this.uniquestring = uniquestring;
	}
	
	
}
