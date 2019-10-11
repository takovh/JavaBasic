package cn.zhang.server.demo02;

import java.io.IOException;
import java.net.Socket;

/**
 * һ����������Ӧ����һ��Dispatcher����
 * @author tako_
 *
 */
public class Dispatcher implements Runnable{
	private Socket client;
	private Request req;
	private Response rep;
	private int code=200;
	public Dispatcher(Socket client) {
		this.client = client;
		try {
			req = new Request(client.getInputStream());
			rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			code = 500;
			return ;
		}
	}
	
	@Override
	public void run() {
		Servlet serv = new Servlet();
		serv.service(req, rep);
		try {
			rep.pushToClient(code);//���͵��ͻ���
		} catch (IOException e) {
			e.printStackTrace();
		}
		CloseUtil.closeSocket(client);
	}
}
