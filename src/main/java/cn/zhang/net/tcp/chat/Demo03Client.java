package cn.zhang.net.tcp.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ��ˣ�Ⱥ�ģ�
 * 1.�����ͻ��ˣ���������+�������ݣ�����ָ�������� + �˿ڣ���ʱ��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * 2.�������� + ��������
 * @author tako_
 *
 */
public class Demo03Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.�����ͻ���
		Socket client = new Socket("localhost", 9999);
		new Thread(new Demo02Send(client)).start();//һ��·��
		new Thread(new Demo02Recieve(client)).start();//һ��·��
	}
}
