package local.wtf.requestautotest.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import local.wtf.requestautotest.dao.TestsuiteDao;
import local.wtf.requestautotest.service.TestsuiteService;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTestSuiteService {
	
	@Autowired
	private TestsuiteService testsuiteService;
	
	@Autowired
	private TestsuiteDao testsuiteDao;
	
	@Test
	public void testRunTestsuite(){
		testsuiteService.runTestsuite(testsuiteDao.geTestsuitebyId(2));
	}
}
