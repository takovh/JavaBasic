package cn.zhang.net.tcp.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * 1.�����ͻ��ˣ�����ָ�������� + �˿ڣ���ʱ��������
 * 2.׼������	double-->�ֽ�����
 * 3.�������� + ��������
 * @author tako_
 *
 */
public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.�����ͻ��ˣ�����ָ�������� + �˿ڣ���ʱ��������
		Socket client = new Socket("localhost", 8888);
		//2.��������
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();//����ʽ����
		System.out.println(echo);
		*/
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	}
}
