package cn.takovh.javaBasic.c_10_server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
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
	 * 启动方法
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
	 * 接收客户端
	 */
	@SuppressWarnings("unused")
	private void recieve() {
		try {
			Socket client = server.accept();
			StringBuilder sb = new StringBuilder();
			String msg = null;//接收客户端的请求信息
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length()>0) {
				sb.append(msg);
				sb.append("\r\n");
				if(null==msg) break;
			}
			//接收客户端的请求信息
			String requestInfo = sb.toString().trim();
			System.out.println(requestInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 停止服务器
	 */
	public void stop() {
		
	}
}
