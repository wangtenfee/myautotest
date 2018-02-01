package local.wtf.requestautotest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.comall.requestautotest.domain.Httptype;

@Repository
public class HttptypeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get httptype by id
	public Httptype getHttptypeById(int id){
		Httptype httptype = new Httptype();
		String sqlStr = "select * from t_httptype t where t.id=?";
		jdbcTemplate.query(sqlStr,new Object[]{id},new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				httptype.setId(rs.getInt("id"));
				httptype.setHttptype(rs.getString("httptype"));
			}
		});
		return httptype;
	}
}
