package local.wtf.requestautotest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import local.wtf.requestautotest.domain.Methodtype;

@Repository
public class MethodtypeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get methodtype by id
	public Methodtype getMethodtypeById(int id){
		Methodtype methodtype = new Methodtype();
		String sqlStr = "select * from t_methodtype t where t.id=?";
		jdbcTemplate.query(sqlStr,new Object[]{id},new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				methodtype.setId(rs.getInt("id"));
				methodtype.setMethodtype(rs.getString("methodtype"));
			}
		});
		return methodtype;
	}
}
