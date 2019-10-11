package cn.zhang.net.tcp.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * �����߳�
 * @author tako_
 *
 */
public class Demo02Recieve implements Runnable {
	//������
	private DataInputStream dis;
	//�̱߳�ʶ
	private boolean isRunning = true;
	
	public Demo02Recieve() {}
	public Demo02Recieve(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			isRunning = false;
			CloseUtil.close(dis);
		}
	}
	/**
	 * ��������
	 * @return
	 */
	public String recieve() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			isRunning = false;
			CloseUtil.close(dis);
		}
		return msg;	
	}
	@Override
	public void run() {
		while(isRunning) {
			System.out.println(recieve());
		}
	}

}
