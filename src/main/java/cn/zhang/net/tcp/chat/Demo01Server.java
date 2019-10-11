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
public class Demo01Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//1.��������� + �˿�
		ServerSocket server = new ServerSocket(9999);//���񲻹رգ�����Ҫserver.close()
		Socket socket = server.accept();//�õ����ӹ�����һ��client��*socket*
		
		//д������
		//������
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String message = dis.readUTF();
		//�����
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("������-->" + message);
		dos.flush();

	}
}
