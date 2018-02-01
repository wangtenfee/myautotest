package local.wtf.requestautotest.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import local.wtf.requestautotest.dao.TestsuiteDao;
import local.wtf.requestautotest.service.TestsuiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTestSuiteService {
	
	@Autowired
	private TestsuiteService testsuiteService;
	
	@Autowired
	private TestsuiteDao TestsuiteDao;
	
	@Test
	public void testRunTestsuite(){
		testsuiteService.runTestsuite(TestsuiteDao.geTestsuitebyId(2));
	}
}
