package local.wtf.requestautotest.util;

import java.util.List;
import java.util.Map;
import com.gargoylesoftware.htmlunit.util.NameValuePair;



public class StringUtil{
	
	//�����ַ���
	public String findStr(String string,String lb,String rb){
		
		if (string == null || string.equals("")) {
			System.out.println("the string is not invalid!!!");
			return string;
		}
		
		int strLen = string.length(); 
		int indexLb = 0;
		int indexRb = 0;
		
		if (lb == null && rb == null) {
			return string;
		}else if (lb == null && rb != null) {
			indexRb = string.indexOf(rb); 
			return string.substring(0,indexRb);
		}else if (lb != null && rb == null) {
			indexLb = string.indexOf(lb);
			if ((indexLb + lb.length()) > strLen) {
				return "lb is too long!!!";
			}
			return string.substring(indexLb+lb.length());
		}else {
//System.out.println("****\n"+string+"\n****"+lb);
			if (string.indexOf(lb) < 0) {
				return "nomatch";
			}
			indexLb = string.indexOf(lb) + lb.length();
			if ((indexLb + lb.length()) > strLen) {
				return "nomatch";
			}
			indexRb = indexLb + string.substring(indexLb).indexOf(rb);
			//System.out.println(indexLb+"xxxx"+indexRb);
			if (indexLb >= indexRb) {
				return "nomatch";
			} else {
				return string.substring(indexLb,indexRb);
			}		
		}		 
	}//findstr
	

	
	public boolean isSussess(String response,String expectResult,String lb,String rb){
		boolean result = false;
		if (expectResult == null) {
			expectResult = response;
		}
		result = expectResult.equals(findStr(response, lb, rb));
		return result;
	}
	
	public Map<String, String> header2Map(String headers){
		//will be implement in the future
		return null;
	}

	public String headers2String(List<NameValuePair> headers) {
		String result = null;
		for (NameValuePair nameValuePair : headers) {
			result += nameValuePair.getName()+",";
			result += nameValuePair.getValue()+";";
		}
		return result;
	}
	
	public int[] toIntArr(String includetcid ){
		int len = includetcid.length();
		if ( len < 3 || (len%2 == 0)) {
			return null;
		}
		len = (len+1)/2;
		int[] ids = new int[len];
		String[] args = includetcid.split(",");
		for (int i = 0; i < ids.length; i++) {
			ids[i] = Integer.parseInt(args[i]);
		}
		return ids;
	}
	
	
	
}
