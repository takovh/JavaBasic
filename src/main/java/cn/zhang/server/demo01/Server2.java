package cn.zhang.server.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * post
 * @author tako_
 *
 */
public class Server2 {
	private ServerSocket server;
	public static void main(String[] args) {
		Server2 server = new Server2();
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
