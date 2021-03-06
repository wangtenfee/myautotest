package local.wtf.requestautotest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import local.wtf.requestautotest.domain.Feature;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */
@Repository
public class FeatureDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get feature by id
	public Feature getFeaturebyId(int id){
		Feature feature = new Feature();
		String sqlStr = "select * from t_feature t where t.id=?";
		jdbcTemplate.query(sqlStr, new Object[]{id},new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				feature.setId(rs.getInt("id"));
				feature.setFeaturename(rs.getString("featurename"));
			}
		});
		return feature;
	}
}
