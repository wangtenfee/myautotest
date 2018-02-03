package local.wtf.requestautotest.domain;

/**
 * @author wangtengfei
       Table: t_related
Create Table: CREATE TABLE `t_related` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paraname` varchar(100) NOT NULL ,
  `searchscope` enum('url','body','headers') NOT NULL DEFAULT 'body' ,
  `applyscope` enum('url','body','headers') NOT NULL DEFAULT 'body' ,
  `pcase` int(11) NOT NULL ,
  `scase` int(11) NOT NULL ,
  `lb` varchar(256) NOT NULL ,
  `rb` varchar(256) NOT NULL ,
  `lbisregex` tinyint(1) DEFAULT '0' ,
  `rbisregex` tinyint(1) DEFAULT '0' ,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 
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
