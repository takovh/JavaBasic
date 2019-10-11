package cn.zhang.server.demo02;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ����������������
 * ʹ��Response+Request+servlet
 * @author tako_
 *
 */
public class Server {
	private ServerSocket server;
	public static String BLANK = " ";
	public static String CRLF = "\r\n";
	private boolean isShutDown = false;
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	/**
	 * ��������
	 */
	public void start(int port) {		
		try {
			server= new ServerSocket(port);		
			this.recieve();
		} catch (IOException e) {
			e.printStackTrace();
			stop();
		}	
	}
	public void start() {		
		start(8888);	
	}
	/**
	 * ���տͻ���
	 */
	private void recieve() {
		try {
			while(!isShutDown) {
				new Thread(new Dispatcher(server.accept())).start();
			}		
		} catch (IOException e) {
			e.printStackTrace();
			stop();
		}
	}
	/**
	 * ֹͣ������
	 */
	public void stop() {
		isShutDown = true;
		CloseUtil.closeSocket(server);
	}
}
