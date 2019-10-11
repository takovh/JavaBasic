package cn.zhang.server.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * ʹ��Response
 * @author tako_
 *
 */
public class Server4 {
	private ServerSocket server;
	public static String BLANK = " ";
	public static String CRLF = "\r\n";
	public static void main(String[] args) {
		Server4 server = new Server4();
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
			Response rep = new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP��Ӧʾ��</title></head><body>���չ�������Ǻû��ѣ�</body></html>");
			rep.pushToClient(200);
			
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
