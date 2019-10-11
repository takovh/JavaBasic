package cn.zhang.net.tcp.socket;

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
public class MultiServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//1.��������� + �˿�
		ServerSocket server = new ServerSocket(8888);//���񲻹رգ�����Ҫserver.close()		
		while(true) {
			//2.���տͻ��˵����� ����ʽ ����
			//accept()
			//The method blocks until a connection is made. 
			Socket socket = server.accept();
			System.out.println("һ���ͻ��˽�������");//���������http:localhost:8888
			//3.�������� + ��������
			String message = "��ӭʹ��";
			//�����			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(message);
			dos.flush();
		}		
	}
}
