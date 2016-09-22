package com.comall.requestautotest.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.comall.requestautotest.dao.TestsuiteDao;
import com.comall.requestautotest.domain.Position;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTestSuiteDao {

	@Autowired
	private TestsuiteDao testsuiteDao;
	
	@Test
	public void testGetbyId(){
		assertEquals("login",testsuiteDao.geTestsuitebyId(1).getTestsuitename());
	}
	
	//@Test
	public void testPosition(){
		System.out.println(Position.BODY);
	}
	
	
}
