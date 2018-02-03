package local.wtf.requestautotest.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import local.wtf.requestautotest.domain.Testsuite;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */
@Repository
public class TestsuiteDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public Testsuite geTestsuitebyId(int id){
		Testsuite testsuite = null;
		String sql = "select * from t_testsuite where id=?";
		Object[] args = new Object[]{id};
//		jdbcTemplate.query(sql, args,
//				new RowCallbackHandler() {
//			public void processRow(ResultSet rs) throws SQLException {
//				testsuite.setId(rs.getInt("id"));
//				testsuite.setTestsuitename(rs.getString("testsuitename"));
//				testsuite.setIncludetcid(rs.getString("includetcid"));
//			}
//		});
		testsuite = jdbcTemplate.queryForObject(sql, args,new BeanPropertyRowMapper<Testsuite>(Testsuite.class));
		return testsuite;
	}
	
	
	
}
