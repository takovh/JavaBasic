package cn.zhang.server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * get
 * @author tako_
 *
 */
public class Server1 {
	private ServerSocket server;
	public static void main(String[] args) {
		Server1 server = new Server1();
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
			StringBuilder sb = new StringBuilder();
			String msg = null;//���տͻ��˵�������Ϣ
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length()>0) {
				sb.append(msg);
				sb.append("\r\n");
				if(null==msg) break;
			}
			//���տͻ��˵�������Ϣ
			String requestInfo = sb.toString().trim();
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
