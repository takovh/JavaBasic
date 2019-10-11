package cn.zhang.net.tcp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ��ˣ�Ⱥ�� + ˽�ģ�
 * �����û�ID
 * 1.�����ͻ��ˣ���������+�������ݣ�����ָ�������� + �˿ڣ���ʱ��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * 2.�������� + ��������
 * bug:�������Ҫ��ǰ����������Լ����ǳ�֮����ܵ�½
 * @author tako_
 *
 */
public class Demo04Client {
	private static String name = "";
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 9999);
		setName();
		new Thread(new Demo04Send(client, name)).start();//һ��·��
		new Thread(new Demo04Recieve(client)).start();//һ��·��
	}
	
	private static void setName() throws IOException {
		System.out.print("����������ǳƣ�");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine();
		while(name.equals("")) {
			System.out.print("�ǳ���Ч������������:");
			br = new BufferedReader(new InputStreamReader(System.in));
			name = br.readLine();
		}
	}
}
