package local.wtf.requestautotest.domain;

/**
 * @author wangtengfei
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
