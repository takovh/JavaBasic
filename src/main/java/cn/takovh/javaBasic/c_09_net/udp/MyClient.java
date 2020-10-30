package cn.takovh.javaBasic.c_09_net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 * 1.创建客户端 + 端口
 * 2.准备数据
 * 3.打包（发送地点 + 端口）
 * 4.发送
 * 5.释放
 * @author tako_
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//1.创建客户端 + 端口
		DatagramSocket client = new DatagramSocket(6666);
		//2.准备数据
		String msg = "UDP编程";
		byte[] data = msg.getBytes();
		//3.打包（发送地点 + 端口）
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
		//4.发送
		client.send(packet);
		//5.释放
		client.close();
	}
}
