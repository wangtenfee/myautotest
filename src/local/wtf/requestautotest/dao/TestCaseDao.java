package local.wtf.requestautotest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.comall.requestautotest.domain.TestCase;

@Repository
public class TestCaseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void insertTestcase(TestCase testCase) {
		String sqlStr = "insert into t_testcase "
				+ " (casename,taskinjira,httptypeid,headers,url,methodtypeid,body,expectresult,lb,rb,relycaseid,featureid,baseurlid,searchscope) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = new Object[]{
			testCase.getCasename(),
			testCase.getTaskinjira(),
			testCase.getHttptypeid(),
			testCase.getHeaders(),
			testCase.getUrl(),
			testCase.getMethodtypeid(),
			testCase.getBody(),
			testCase.getExpectresult(),
			testCase.getLb(),
			testCase.getRb(),
			testCase.getRelycaseid(),
			testCase.getFeatureid(),
			testCase.getBaseurlid(),
			testCase.getSearchscope(),
			testCase.getUniquestring()
		};
		jdbcTemplate.update(sqlStr,args);
	}
	

	public TestCase geTestCasebyId(int id){
		final TestCase testCase = new TestCase();
		String sqlStr = "select * from t_testcase t where t.id=?";
		jdbcTemplate.query(sqlStr, new Object[] {id},
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						testCase.setId(rs.getInt("id"));
						testCase.setCasename(rs.getString("casename"));
						testCase.setTaskinjira(rs.getString("taskinjira"));
						testCase.setHeaders(rs.getString("headers"));
						testCase.setUrl(rs.getString("url"));
						testCase.setMethodtypeid(rs.getInt("methodtypeid"));
						testCase.setBody(rs.getString("body"));
						testCase.setExpectresult(rs.getString("expectresult"));
						testCase.setLb(rs.getString("lb"));
						testCase.setRb(rs.getString("rb"));
						testCase.setRelycaseid(rs.getInt("relycaseid"));
						testCase.setIsrelied(rs.getBoolean("isrelied"));
						testCase.setHttptypeid(rs.getInt("httptypeid"));
						testCase.setFeatureid(rs.getInt("featureid"));
						testCase.setBaseurlid(rs.getInt("baseurlid"));
						testCase.setSearchscope(rs.getString("searchscope"));
						testCase.setUniquestring(rs.getString("uniquestring"));
					} 
				});
		return testCase;
	}
	
	//casename��Ψһ�ġ�����ͨ��casename���ҵ�����
	public TestCase geTestCasebyName(String casename){
		final TestCase testCase = new TestCase();
		String sqlStr = "select * from t_testcase t where t.casename=?";
		jdbcTemplate.query(sqlStr, new Object[] {casename},
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						testCase.setId(rs.getInt("id"));
						testCase.setCasename(rs.getString("casename"));
						testCase.setTaskinjira(rs.getString("taskinjira"));
						testCase.setHeaders(rs.getString("headers"));
						testCase.setUrl(rs.getString("url"));
						testCase.setMethodtypeid(rs.getInt("methodtypeid"));
						testCase.setBody(rs.getString("body"));
						testCase.setExpectresult(rs.getString("expectresult"));
						testCase.setLb(rs.getString("lb"));
						testCase.setRb(rs.getString("rb"));
						testCase.setRelycaseid(rs.getInt("relycaseid"));
						testCase.setIsrelied(rs.getBoolean("isrelied"));
						testCase.setHttptypeid(rs.getInt("httptypeid"));
						testCase.setFeatureid(rs.getInt("featureid"));
						testCase.setBaseurlid(rs.getInt("baseurlid"));
						testCase.setSearchscope(rs.getString("searchscope"));
						testCase.setUniquestring(rs.getString("uniquestring"));
					} 
				});
		return testCase;
	}	
	
	public int getMatchById(int id) {
		String sqlStr = " SELECT count(id) FROM t_testcase tc"
				+ " WHERE tc.id =? ";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] {id});
	}
	
	public int getMatchByName(String casename) {
		String sqlStr = " SELECT count(id) FROM t_testcase tc"
				+ " WHERE tc.casename =? ";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] {casename});
	}
	
}
