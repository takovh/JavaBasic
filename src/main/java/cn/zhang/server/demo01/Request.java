package cn.zhang.server.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * ��װrequest
 * ��������
 * @author tako_
 *
 */
public class Request {
	private String method;//����ʽ
	private String url;//������Դ
	private Map<String,List<String>> parameterMapValues;//�������
	//�ڲ�
	public static String CRLF = "\r\n";
	@SuppressWarnings("unused")
	private InputStream is;
	private String requestInfo;
	
	public Request() {
		method = "";
		url = "";
		parameterMapValues = new HashMap<String,List<String>>();
		requestInfo = "";
	}
	public Request(InputStream is) {
		this();
		this.is = is;
		try {
			byte[] data = new byte[20480];
			int len = is.read(data);
			requestInfo = new String(data,0,len);
		} catch (IOException e) {
			return ;
		}
		//����ͷ��Ϣ
		parseRequestInfo();
	}
	//����ͷ��Ϣ
	private void parseRequestInfo() {
		requestInfo = requestInfo.trim();
		if(null==requestInfo||requestInfo.equals("")) return ;
		/**
		 * =========================================
		 * ����Ϣ�����зֽ��������ʽ������·�������������get���ܴ��ڣ�
		 * GET /index.html?uname=zhangyu&pwd=123 HTTP/1.1
		 * POST /index.html HTTP/1.1
		 * ���Ϊpst��ʽ�� ������������������
		 * ========================================= 
		 */
		String paramString = "";//�����������
		//1.��ȡ�������
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		int idx = requestInfo.indexOf("/");// /��λ��
		this.method = firstLine.substring(0, idx).trim();
		String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("post")) {
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}else if(this.method.equalsIgnoreCase("get")) {
			if(urlStr.contains("?")) {//�Ƿ���ڲ���
				String[] urlArray = urlStr.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1];//�����������
			}else {
				this.url = urlStr;
			}
		}
		//2.�����������װ��Map��
		if(paramString.equals("")) return ;
		parseParams(paramString);
	}
	private void parseParams(String paramString) {
		//�ָ�
		StringTokenizer token = new StringTokenizer(paramString, "&");
		while(token.hasMoreTokens()) {
			String[] keyValues = token.nextToken().split("=");
			String key = keyValues[0].trim();
			String value = decode(keyValues[1].trim(),"GBK");
			if(!parameterMapValues.containsKey(key)) parameterMapValues.put(key, new ArrayList<String>());
			List<String> values = parameterMapValues.get(key);
			values.add(value);
		}
	}
	/**
	 * �����������
	 * @param value
	 * @param code
	 * @return
	 */
	private String decode(String value, String code) {
		try {
			return java.net.URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����ҳ���name��ȡ��Ӧ�Ķ��ֵ
	 */
	public String[] getParameterValues(String name) {
		List<String> values = null;
		if((values=parameterMapValues.get(name))==null) return null;
		else return values.toArray(new String[0]);
	}
	/**
	 * ����ҳ���name��ȡ��Ӧ��ֵ
	 */
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(null==values) return null;
		return 	values[0];
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
