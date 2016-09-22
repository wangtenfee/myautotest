package com.comall.requestautotest.domain;

/**@author wangtengfei
 * @建表语句
 *        Table: t_feature
Create Table: CREATE TABLE `t_feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `featurename` varchar(40) NOT NULL COMMENT '功能模块名或者业务名',
  `detailinfo` varchar(256) DEFAULT NULL COMMENT '详细信息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，默认生成',
  `includedfeature` int(11) NOT NULL COMMENT '表示该功能属于哪个业务，自连接，参考本表主键',
  PRIMARY KEY (`id`),
  UNIQUE KEY `featurename` (`featurename`),
  KEY `fk_tft_if` (`includedfeature`),
  CONSTRAINT `t_feature_ibfk_1` FOREIGN KEY (`includedfeature`) REFERENCES `t_feature` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
 * 
 * */

public class Feature {
	private int id;
	private String featurename;
	private String includedfeature;
	private String detailinfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeaturename() {
		return featurename;
	}
	public void setFeaturename(String featurename) {
		this.featurename = featurename;
	}
	public String getIncludedfeature() {
		return includedfeature;
	}
	public void setIncludedfeature(String includedfeature) {
		this.includedfeature = includedfeature;
	}
	public String getDetailinfo() {
		return detailinfo;
	}
	public void setDetailinfo(String detailinfo) {
		this.detailinfo = detailinfo;
	}
	
}
