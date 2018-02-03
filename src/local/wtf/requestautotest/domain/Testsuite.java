package local.wtf.requestautotest.domain;

/**@author wangtengfei
 * 
*************************** 1. row ***************************
       Table: t_testsuite
Create Table: CREATE TABLE `t_testsuite` (
  `id` int(11) NOT NULL AUTO_INCREMENT 
  `testsuitename` varchar(100) NOT NULL, 
  `includetcid` varchar(100) NOT NULL ,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
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
