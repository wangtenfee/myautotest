package com.comall.requestautotest.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.comall.requestautotest.domain.Testsuite;

@Repository
public class TestsuiteDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**@author wangtengfei
	 * @function 通过ID获取Testsuite对象
	 * */
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
