package local.wtf.requestautotest.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import local.wtf.requestautotest.dao.RelatedDao;
import local.wtf.requestautotest.domain.Related;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestRelatedDao {
	
	@Autowired
	private RelatedDao relatedDao;
	
	//@Test
	public void testgetrelatedbyid(){
		int id=1;
		assertEquals(id,relatedDao.getRelatedbyId(id).getId());
	}
	
	@Test
	public void testGetRelatedListbyPcaseandScase(){
		
		List<Related> relateds = new ArrayList<Related>();
		int scase = 3;
		int pcase = 4;
		relateds = relatedDao.getRlsByPcsAndScs(scase, pcase);
		for (Related related : relateds) {
			System.out.println(related.getId());
		}
	}
	
	//@Test
	public void testinsertintoRelated(){
		Related related  = new Related();
		//paraname,searchscope,applyscope,pcase,scase,lb,rb
		related.setParaname("uuid");
		related.setSearchscope("body");
		related.setApplyscope("body");
		related.setPcase(3);
		related.setScase(4);
		related.setLb("uuid=");
		related.setRb("&");
		relatedDao.insertintoRelated(related);
		assertEquals("uuid",relatedDao.getRelatedbyId(2).getParaname());
	}

}
