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
public class Demo02Send implements Runnable {
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	private boolean isRunning = true;
	
	//������
	public Demo02Send() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	public Demo02Send(Socket client) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
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
	public void send() {
		String message = getMessageFromConsole();
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
		while(isRunning) send();
	}
}
