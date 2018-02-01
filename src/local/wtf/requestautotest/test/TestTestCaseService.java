package local.wtf.requestautotest.test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.comall.requestautotest.dao.TestCaseDao;
import com.comall.requestautotest.domain.Parameter;
import com.comall.requestautotest.service.TestCaseService;
import com.gargoylesoftware.htmlunit.WebClient;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTestCaseService {
	
	
	@Autowired
	private TestCaseService testCaseService;
	@Autowired
	private TestCaseDao testCaseDao;
	
//	@Test
//	public void testhasMatchCaseByName(){
//		String casename = "sendlogin_do";
//		assertEquals(true,testCaseService.hasMatchCaseByName(casename));
//	}
	
//	@Test
//	public void testhasMatchCaseByid(){
//		int id=1;
//		assertEquals(true,testCaseService.hasMatchCaseById(id));
//	}
	
//	@Test
//	public void testfindCaseByID(){
//		int id=1;
//		assertEquals(id,testCaseService.findCaseByID(id).getId());
//	}
	
	@Test
	public void testRunTestcase(){
		//testCaseService.runCase(testCaseDao.geTestCasebyId(8),null,null);
		WebClient webClient = new WebClient();
		List<String> errlist = new ArrayList<String>();
		List<Parameter> paralist = new ArrayList<Parameter>();
		testCaseService.runCase(testCaseDao.geTestCasebyId(2),webClient,errlist,paralist);
		webClient.close();
//runCase(TestCase testCase,WebClient webClient,List<String> errList,List<Parameter> paramList) {		
	}
	
	
	
	
}
