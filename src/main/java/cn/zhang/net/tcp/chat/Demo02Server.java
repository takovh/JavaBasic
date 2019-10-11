package cn.zhang.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ˣ����ն���ͻ��ˣ�
 * 1.��������� + �˿�
 * 2.���տͻ��˵����� ����ʽ
 * 3.�������� + ��������
 * @author tako_
 *
 */
public class Demo02Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//1.��������� + �˿�
		ServerSocket server = new ServerSocket(9999);
		//2.���տͻ��˵����� ����ʽ
		Socket client = server.accept();//The method blocks until a connection is made. 
					
		DataInputStream dis = new DataInputStream(client.getInputStream());//������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());//�����
		
		//3.�������� + ��������
		while(true) {
			String message = dis.readUTF();//��������
			System.out.println(message);		
			dos.writeUTF("������-->" + message);//��������
			dos.flush();
		}
	}
}
