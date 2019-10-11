package cn.zhang.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ���ڷ�������
 * @author tako_
 *
 */
public class Demo04Send implements Runnable {
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	private boolean isRunning = true;
	
	//������
	public Demo04Send() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	public Demo04Send(Socket client, String name) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			send(name);
		} catch (IOException e) {
			e.printStackTrace();
			isRunning = false;
			CloseUtil.close(dos, console);
		}
	}
	
	//�ӿ���̨��������
	private String getMessageFromConsole() {
		String str = "";
		try {
			str = console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	//��������
	public void send(String message) {
		try {
			if( null!=message && !message.equals("")) {
				dos.writeUTF(message);
				dos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			isRunning = false;
			CloseUtil.close(dos, console);
		}		
	}
	//�߳���
	@Override
	public void run() {
		while(isRunning) send(getMessageFromConsole());
	}
}
