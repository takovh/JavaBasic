package cn.takovh.javaBasic.c_09_net.tcp.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 1.创建客户端：必须指定服务器 + 端口，此时就在连接
 * 2.准备数据	double-->字节数组
 * 3.接收数据 + 发送数据
 * @author tako_
 *
 */
public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建客户端：必须指定服务器 + 端口，此时就在连接
		Socket client = new Socket("localhost", 8888);
		//2.接收数据
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();//阻塞式方法
		System.out.println(echo);
		*/
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	}
}
