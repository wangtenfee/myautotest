package com.comall.requestautotest.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comall.requestautotest.dao.TestCaseDao;
import com.comall.requestautotest.domain.TestCase;
import com.comall.requestautotest.service.TestCaseService;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestsTestcaseDao {
	
	@Qualifier("testCaseService")
	@Autowired
	private TestCaseService testCaseService;
	
	@Autowired
	private TestCaseDao testCaseDao;
	
//	@Test
//	public void testGeTestCasebyId() {
//		int id=1;
//		assertEquals(id,testCaseService.findCaseByID(id).getId());
//	}
//	
//	@Test
//	public void testgetMatchById(){
//		int id=1;
//		assertEquals(1, testCaseDao.getMatchById(id));
//	}
//	
//	@Test
//	public void testgetMatchByName(){
//		String name = "receivepassport_do";
//		assertEquals(1, testCaseDao.getMatchByName(name));
//	}
//	
//	@Test
//	public void testgeTestCasebyName(){
//		String casename = "receivepassport_do";
//		assertEquals(casename, testCaseDao.geTestCasebyName(casename).getCasename());
//	}
	
	@Test
	public void testinsertTestcase(){
		String casename = "xxx";
		TestCase testCase = new TestCase();
		testCase.setBody("xx");
		testCase.setCasename(casename);
		testCase.setExpectresult("xx");
		testCase.setUrl("xx");
		testCase.setMethodtypeid(1);
		testCase.setBaseurlid(1);	
		testCase.setHttptypeid(1);
		testCaseDao.insertTestcase(testCase);
		assertEquals(casename, testCaseDao.geTestCasebyName(casename).getCasename());
	}
	
}
