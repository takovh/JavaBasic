package cn.zhang.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * ��ȡ��Դ��Դ����
 * @author tako_
 *
 */
public class URLDemo02 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");//��ҳ--Ĭ����Դ	
		//��ȡ��Դ--������
		/*utf-8����
		InputStream is = url.openStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
		is.close();
		*/
		//ʹ��ת����
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/tmp/baidu.html"),"utf-8"));
		String message = null;
		while(null!=(message=br.readLine())) {
			//System.out.println(message);
			bw.append(message);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
