package com.comall.requestautotest.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.comall.requestautotest.domain.Related;


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
	
	/**@function:插入数据 
	 * */
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
	 * function: 通过 pcase and scase获取两个用例的所有关系
	 */
	public List<Related> getRlsByPcsAndScs(int scase,int pcase){
		List<Related> relateds = null;
		String sql = "select * from t_related where pcase = ? and scase = ?";
		Object[] args = new Object[]{scase,pcase};
		relateds = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Related>(Related.class));
		return relateds;
	}
	
	/**
	 * function: 通过 pcase获取所有父用例为pcase的关系
	 */
	public List<Related> getRlsByPcs(int pcase){
		List<Related> relateds = null;
		String sql = "select * from t_related where pcase = ?";
		Object[] args = new Object[]{pcase};
		relateds = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Related>(Related.class));
		return relateds;
	}
	
	/**
	 * function: 通过 scase获取所有子用例为scase的关系
	 */
	public List<Related> getRlsByScs(int scase){
		List<Related> relateds = null;
		String sql = "select * from t_related where scase = ?";
		Object[] args = new Object[]{scase};
		relateds = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Related>(Related.class));
		return relateds;
	}
	
	/**
	 *function: 查询关系表中pcase的纪录
	 **/
	public int getPcaseCount(int pcase){
		int count = 0;
		String sql ="select count(id) from t_related where pscase = ?";
		Object[] args = new Object[]{pcase};
		count = jdbcTemplate.queryForInt(sql, args);
		return count;
	}
	
	/**
	 *function: 查询关系表中scase的纪录
	 **/
	public int getScaseCount(int scase){
		int count = 0;
		String sql ="select count(id) from t_related where pscase = ?";
		Object[] args = new Object[]{scase};
		count = jdbcTemplate.queryForInt(sql, args);
		return count;
	}	
}
