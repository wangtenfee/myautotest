package local.wtf.requestautotest.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import local.wtf.requestautotest.domain.Baseurl;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */
@Repository
public class BaseurlDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get baseurl by id
	public Baseurl getBaseurlById(int id){
		//Baseurl baseurl = new Baseurl();
		Baseurl baseurl = null;
		String sql = "select * from t_baseurl t where t.id=?";
//		jdbcTemplate.query(sqlStr, new Object[]{id},new RowCallbackHandler() {
//			public void processRow(ResultSet rs) throws SQLException {
//				baseurl.setId(rs.getInt("id"));
//				baseurl.setUrl(rs.getString("url"));
//				baseurl.setUrlname(rs.getString("urlname"));
//			}
//		});
		Object[] args = new Object[]{id};
		baseurl = jdbcTemplate.queryForObject(sql, args,new BeanPropertyRowMapper<Baseurl>(Baseurl.class));
		return baseurl;
	}
}
