package local.wtf.requestautotest.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comall.requestautotest.dao.TestCaseDao;
import com.comall.requestautotest.domain.Parameter;
import com.comall.requestautotest.domain.Testsuite;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;

@Service("testsuiteservice")
public class TestsuiteService {

	@Autowired
	private TestCaseDao testCaseDao;
	
	@Autowired
	private TestCaseService testCaseService;
	
	public void runTestsuite(Testsuite testsuite){
		String includetcid = testsuite.getIncludetcid();		
		String[] cs = includetcid.split(",");
		WebClient webClient = new WebClient();
		WebClientOptions webClientOptions = webClient.getOptions();
		/*********customsize weboption*******/
		webClientOptions.setUseInsecureSSL(true);
		webClientOptions.setDoNotTrackEnabled(true);
		webClientOptions.setJavaScriptEnabled(false);
		webClientOptions.setCssEnabled(false);
		webClientOptions.setThrowExceptionOnScriptError(false);
		webClientOptions.setTimeout(15000);
		webClientOptions.setRedirectEnabled(false);
		webClientOptions.setThrowExceptionOnFailingStatusCode(false);
		webClientOptions.setPrintContentOnFailingStatusCode(false);		
		List<String> errlist = new ArrayList<String>();
		List<Parameter> paralist = new ArrayList<Parameter>();
		for(String s:cs){			
			if(!testCaseService.runCase(testCaseDao.geTestCasebyId(Integer.parseInt(s)),webClient,errlist,paralist))
				break;
		}
		webClient.close();
	}
}
