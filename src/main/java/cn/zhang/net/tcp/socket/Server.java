package cn.zhang.net.tcp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����
 * 1.��������� + �˿�
 * 2.���տͻ��˵����� ����ʽ
 * 3.�������� + ��������
 * @author tako_
 *
 */
public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//1.��������� + �˿�
		ServerSocket server = new ServerSocket(8888);//���񲻹رգ�����Ҫserver.close()
		//2.���տͻ��˵����� ����ʽ ����
		Socket socket = server.accept();
		System.out.println("һ���ͻ��˽�������");//���������http:localhost:8888
		//3.�������� + ��������
		//�����
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		String message = "��ӭʹ��";
		dos.writeUTF(message);
		dos.flush();
		/*
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(message);
		bw.newLine();
		bw.flush();
		*/
	}
}
