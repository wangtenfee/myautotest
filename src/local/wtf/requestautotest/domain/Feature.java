package local.wtf.requestautotest.domain;

/**@author wangtengfei
 *        Table: t_feature
Create Table: CREATE TABLE `t_feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����������',
  `featurename` varchar(40) NOT NULL COMMENT '����ģ��������ҵ����',
  `detailinfo` varchar(256) DEFAULT NULL COMMENT '��ϸ��Ϣ',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ�䣬Ĭ������',
  `includedfeature` int(11) NOT NULL COMMENT '��ʾ�ù��������ĸ�ҵ�������ӣ��ο���������',
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
