package cn.zhang.server.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * ʹ��Response+Request
 * @author tako_
 *
 */
public class Server5 {
	private ServerSocket server;
	public static String BLANK = " ";
	public static String CRLF = "\r\n";
	public static void main(String[] args) {
		Server5 server = new Server5();
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
	private void recieve() {
		try {
			Socket client = server.accept();			
			//����
			Request req = new Request(client.getInputStream());
			
			//��Ӧ
			Response rep = new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP��Ӧʾ��</title></head><body>");
			rep.println("��ӭ��").println(req.getParameter("uname")).println("�����ˣ�");
			rep.println("</body></html>");
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
