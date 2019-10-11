package cn.zhang.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * �ͻ���
 * 1.�����ͻ��� + �˿�
 * 2.׼������
 * 3.��������͵ص� + �˿ڣ�
 * 4.����
 * 5.�ͷ�
 * @author tako_
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//1.�����ͻ��� + �˿�
		DatagramSocket client = new DatagramSocket(6666);
		//2.׼������
		String msg = "UDP���";
		byte[] data = msg.getBytes();
		//3.��������͵ص� + �˿ڣ�
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
		//4.����
		client.send(packet);
		//5.�ͷ�
		client.close();
	}
}
