package local.wtf.requestautotest.domain;

/**
 * @author wangtengfei
 * @�������
 *        Table: t_baseurl
Create Table: CREATE TABLE `t_baseurl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����������',
  `urlname` varchar(40) NOT NULL COMMENT '����URL��',
  `url` varchar(40) NOT NULL COMMENT '����URL,����IP',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',

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
