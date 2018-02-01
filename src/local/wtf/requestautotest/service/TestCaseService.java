package local.wtf.requestautotest.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comall.requestautotest.dao.BaseurlDao;
import com.comall.requestautotest.dao.HttptypeDao;
import com.comall.requestautotest.dao.MethodtypeDao;
import com.comall.requestautotest.dao.RelatedDao;
import com.comall.requestautotest.dao.TestCaseDao;
import com.comall.requestautotest.domain.Parameter;
import com.comall.requestautotest.domain.Position;
import com.comall.requestautotest.domain.Related;
import com.comall.requestautotest.domain.TestCase;
import com.comall.requestautotest.util.StringUtil;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;

@Service("testCaseService")
public class TestCaseService {
	
	@Autowired
	private BaseurlDao baseurlDao;
	@Autowired
	private TestCaseDao testCaseDao;	
	@Autowired
	private HttptypeDao httptypeDao;	
	@Autowired
	private RelatedDao relatedDao;
	@Autowired
	private MethodtypeDao methodtypeDao;	
	
	private WebClient webClient;

	/**@author wangtengfei
	 * @function:�����ڳ�����ִ�в�����������������t_testsuite����ʱִ�в����������÷���Ϊ���صķ�����
	 * @time 20160602
	 * */
	public boolean runCase(TestCase testCase,WebClient webClient,List<String> errList,List<Parameter> paramList) {
		boolean result = false;
		//��ȡurl���ͣ� ��http����https
		String url = httptypeDao.getHttptypeById(testCase.getHttptypeid()).getHttptype();
		//��ȡbaseurl���ͣ����ĸ���������
		url = url + baseurlDao.getBaseurlById(testCase.getBaseurlid()).getUrl();
		//ƴ����ʵ�ʵ�URL
		url = url + testCase.getUrl();
		String body = testCase.getBody();
		
		//Ӧ�ù���ֵ,
		if (paramList != null && paramList.size()>0) {
			for (Parameter parameter : paramList) {
				if(parameter.getScaseid()==testCase.getId()){
					String paraname = "{"+parameter.getParaName()+"}";
					switch (parameter.getPositon().toString()) {
					case "URL":
						url = url.replace(paraname, parameter.getValue());						
						break;
					case "BODY":
						body = body.replace(paraname, parameter.getValue());
						break;
					default:
						errList.add("method not supported!!!");
						break;
					}
				}
			}
		}
		//WebRequest webRequest = null;
		//ִ������
		try {
System.out.println("*********************start excute "+url+"************************");
			WebRequest webRequest = new WebRequest(new java.net.URL(url));
			//���÷���
			webRequest.setHttpMethod(HttpMethod.valueOf(methodtypeDao.getMethodtypeById(testCase.getMethodtypeid()).getMethodtype()));
			//����������
			if (testCase.getBody() != null) {
System.out.println("************body:"+body+"****************");				
				webRequest.setRequestBody(body);
			}
			
			//���������ȡ��Ӧ��ͬʱ������Ӧͷ����Ӧ��
			String response = "";
			String resHeader = "";
			String resBody = "";
			WebResponse webResponse = webClient.getPage(webRequest).getWebResponse();
			String searchscope = testCase.getSearchscope();
			if (searchscope.equals(Position.BODY.toString())) {
				response = webResponse.getContentAsString();
				resBody = response;
			}else if (searchscope.equals(Position.HEADER.toString())) {
				response = new StringUtil().headers2String(webResponse.getResponseHeaders());
				resHeader = response;
			}else{
				errList.add("region not supported!!!");
				return false;
			}
			//������Ӧ���ж������Ƿ�ִ�гɹ���
			String expectresult = testCase.getExpectresult();
			if (expectresult == null) {
				result = true;
			}else if (expectresult != null && (testCase.getLb() == null || testCase.getRb() == null)) {
				result = response.contains(expectresult);			
			}else {
				result = new StringUtil().isSussess(response,expectresult, testCase.getLb(), testCase.getRb());
			}
if(!result){System.out.println(response);}			
//System.out.println(response);
			//���ҳ������������еĹ����������еĹ���ֵ�������Ϣ����ɶ��󣬷ŵ������б��
			List<Related> relatedList = new ArrayList<Related>();
			relatedList = relatedDao.getRlsByPcs(testCase.getId());
			if (!relatedList.isEmpty()) {
				for (Related related : relatedList) {
					Parameter parameter = new Parameter();
					parameter.setParaName(related.getParaname());
					parameter.setPositon(Position.valueOf(related.getApplyscope().toUpperCase()));
					parameter.setPcaseid(related.getPcase());
					parameter.setScaseid(related.getScase());
					if (related.getSearchscope().equals(Position.HEADER.toString())) {
						parameter.setValue(new StringUtil().findStr(resHeader, related.getLb(), related.getRb()));
					}else if(related.getSearchscope().equals(Position.BODY.toString())){
						parameter.setValue(new StringUtil().findStr(resBody, related.getLb(), related.getRb()));
					}
					paramList.add(parameter);				
				}
			}			
		} catch (FailingHttpStatusCodeException | IOException e1) {
			errList.add(e1.getMessage());
			e1.printStackTrace();		
		}
System.out.println(result);		
		return result;
	}
	
	/**@author wangtengfei
	 * @function:���ڵ���ִ�в�������ʱ�����ڳ����еĲ�һ���ĵط����ڸ÷���û�й�������б�
	 * @time 20160602
	 * */	
	public boolean runCase(TestCase testCase,WebClient webClientPa,List<String> errListPa){
		
		boolean result = false;
		// ��ȡurl���ͣ� ��http����https
		String url = httptypeDao.getHttptypeById(testCase.getHttptypeid()).getHttptype();
		// ��ȡbaseurl���ͣ����ĸ���������
		url = url + baseurlDao.getBaseurlById(testCase.getBaseurlid()).getUrl();
		// ƴ����ʵ�ʵ�URL
		url = url + testCase.getUrl();
		String body = testCase.getBody();
		webClient = new WebClient();
		WebClientOptions webClientOptions = webClient.getOptions();
		List<String> errList = new ArrayList<String>();
		if(webClientPa != null){
			webClient = webClientPa;
		}
		if (errListPa != null) {
			errList = errListPa;
		}
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
		WebRequest webRequest = null;
		//ִ������
		try {
			webRequest = new WebRequest(new java.net.URL(url));
			//���÷���
			webRequest.setHttpMethod(HttpMethod.valueOf(methodtypeDao.getMethodtypeById(testCase.getMethodtypeid()).getMethodtype()));
		} catch (MalformedURLException e1) {
			errList.add(e1.getMessage());
			e1.printStackTrace();		
		}
		
		//����������
		if (testCase.getBody() != null) {
			webRequest.setRequestBody(body);
		}
		//���������ȡ��Ӧ��ͬʱ������Ӧͷ����Ӧ��
		String response = null;
		try {
			WebResponse webResponse = webClient.getPage(webRequest).getWebResponse();
			String searchscope = testCase.getSearchscope();
			if (searchscope.equals(Position.BODY.toString())) {
				response = webResponse.getContentAsString();
			}else if (searchscope.equals(Position.HEADER.toString())) {
				response = new StringUtil().headers2String(webResponse.getResponseHeaders());
			}else{
				errList.add("region not supported!!!");
			}			
		} catch (FailingHttpStatusCodeException | IOException e) {
			errList.add(e.getMessage());
			e.printStackTrace();
		}
				
		//handle the response
		String expectresult = testCase.getExpectresult();
		String uniquestring = testCase.getUniquestring();
		if (expectresult == null && uniquestring == null) {
			result = true;
		}else if (expectresult != null) {
			result = new StringUtil().isSussess(response,expectresult, testCase.getLb(), testCase.getRb());			
		}else {
			result = response.contains(uniquestring);
		}
		System.out.println("*******response*********"+response);
		System.out.println("********result**********"+result);
		return result;
	}
	
	/**@author wangtengfei
	 * @function ���ڴ��������Ӧͷ������Ӧ�������
	 * */
	public String[] getParameters(Related related){
		String[] args=null;
		//int length = 
		return args;
	}

	public TestCaseDao getTestCaseDao() {
		return testCaseDao;
	}

	public void setTestCaseDao(TestCaseDao testCaseDao) {
		this.testCaseDao = testCaseDao;
	}
}

