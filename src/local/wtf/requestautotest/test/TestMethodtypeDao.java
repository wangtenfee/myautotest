package local.wtf.requestautotest.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import local.wtf.requestautotest.dao.MethodtypeDao;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestMethodtypeDao {
	
	@Autowired
	private MethodtypeDao methodtypeDao;
	
	@Test
	public void testgetmethodtpebyid(){
		int id=1;
		assertEquals(id,methodtypeDao.getMethodtypeById(id).getId());
	}
}
