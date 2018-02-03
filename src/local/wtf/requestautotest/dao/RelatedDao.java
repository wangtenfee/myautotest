package local.wtf.requestautotest.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import local.wtf.requestautotest.domain.Related;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */

@Repository
public class RelatedDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get related by id
	public Related getRelatedbyId(int id){
		Related related = null;
		String sqlStr = "select * from t_related t where t.id=?";
		related = jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<Related>(Related.class),new Object[]{id});
		return related;
	}	
	

	public void insertintoRelated(Related related){
		String sqlstr = "insert into t_related"
				+ " (paraname,searchscope,applyscope,pcase,scase,lb,rb)"
				+ " values(?,?,?,?,?,?,?)";
		Object[] args = new Object[]{
			related.getParaname(),
			related.getSearchscope(),
			related.getApplyscope(),
			related.getPcase(),
			related.getScase(),
			related.getLb(),
			related.getRb()
		};
		
		jdbcTemplate.update(sqlstr,args);
	}
	
	/**
	 * function: ͨ�� pcase and scase��ȡ�������������й�ϵ
	 */
	public List<Related> getRlsByPcsAndScs(int scase,int pcase){
		List<Related> relateds = null;
		String sql = "select * from t_related where pcase = ? and scase = ?";
		Object[] args = new Object[]{scase,pcase};
		relateds = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Related>(Related.class));
		return relateds;
	}
	

	public List<Related> getRlsByPcs(int pcase){
		List<Related> relateds = null;
		String sql = "select * from t_related where pcase = ?";
		Object[] args = new Object[]{pcase};
		relateds = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Related>(Related.class));
		return relateds;
	}
	

	public List<Related> getRlsByScs(int scase){
		List<Related> relateds = null;
		String sql = "select * from t_related where scase = ?";
		Object[] args = new Object[]{scase};
		relateds = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Related>(Related.class));
		return relateds;
	}
	

	public int getPcaseCount(int pcase){
		int count = 0;
		String sql ="select count(id) from t_related where pscase = ?";
		Object[] args = new Object[]{pcase};
		count = jdbcTemplate.queryForInt(sql, args);
		return count;
	}
	

	public int getScaseCount(int scase){
		int count = 0;
		String sql ="select count(id) from t_related where pscase = ?";
		Object[] args = new Object[]{scase};
		count = jdbcTemplate.queryForInt(sql, args);
		return count;
	}	
}
