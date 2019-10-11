package cn.zhang.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * 1.�����ͻ��ˣ���������+�������ݣ�����ָ�������� + �˿ڣ���ʱ��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * 2.׼������	double-->�ֽ�����
 * 3.�������� + ��������
 * @author tako_
 *
 */
public class Demo01Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.�����ͻ��ˣ�ָ�������� + �˿ڣ���ʱ��������
		Socket socket = new Socket("localhost", 9999);//��server��������
		
		//����̨������
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));//client������������
		String info = console.readLine();//info <-- ������������
		//�����
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(info);
		dos.flush();
		//������
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String message = dis.readUTF();
		System.out.println(message);
	}
}
