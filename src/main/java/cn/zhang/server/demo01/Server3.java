package cn.zhang.server.demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ����������������
 * ����+��Ӧ
 * @author tako_
 *
 */
public class Server3 {
	private ServerSocket server;
	public static String BLANK = " ";
	public static String CRLF = "\r\n";
	public static void main(String[] args) {
		Server3 server = new Server3();
		server.start();
	}
	/**
	 * ��������
	 */
	public void start() {		
		try {
			server= new ServerSocket(8888);		
			this.recieve();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ���տͻ���
	 */
	@SuppressWarnings("unused")
	private void recieve() {
		try {
			Socket client = server.accept();			
			String msg = null;//���տͻ��˵�������Ϣ
			
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			//���տͻ��˵�������Ϣ
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			//��Ӧ
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP��Ӧʾ��</title></head><body>Hello Tomcat!</body></html>");
			StringBuilder response = new StringBuilder();
			//1.HTTPЭ��汾��״̬���롢����
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2.��Ӧͷ��Respons Head��
			response.append("Server:tencent Server/0.0.1").append(CRLF);
			response.append(new Date()).append(CRLF);//"Data:Mon,7Jan2019 13:18:00 GMT"
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			response.append("Content-length:").append(responseContext.toString().getBytes().length).append(CRLF);//���ĳ��ȣ��ֽڳ���
			//3.����֮ǰ
			response.append(CRLF);
			//4.����
			response.append(responseContext);
			
			//�����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ֹͣ������
	 */
	public void stop() {
		
	}
}
