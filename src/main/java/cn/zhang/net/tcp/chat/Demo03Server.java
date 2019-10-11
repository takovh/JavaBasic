package cn.zhang.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ����ˣ�Ⱥ�ģ�
 * 1.��������� + �˿�
 * 2.���տͻ��˵����� ����ʽ
 * 3.�������� + ��������
 * @author tako_
 *
 */
public class Demo03Server {
	private List<MyChannel> allConnect  = new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException{
		new Demo03Server().connect();
	}
	
	@SuppressWarnings("resource")
	public void connect() throws IOException {
		// ��������� + �˿�
		ServerSocket server = new ServerSocket(9999);
		
		// �������� + ��������
		while (true) {
			Socket client = server.accept();// The method blocks until a connection is made.
			MyChannel channel = new MyChannel(client);
			allConnect.add(channel);
			new Thread(channel).start();//һ����·
		}
	}
	
	/**
	 * �ڲ��ࣺ����һ���ͻ���һ����·
	 * ������+�����
	 * ��������+��������
	 * @author tako_
	 *
	 */
	private class MyChannel implements Runnable {
		private DataInputStream dis;
		private DataOutputStream dos;
		@SuppressWarnings("unused")
		private boolean isRunning = true;
		//����������ʼ��
		public MyChannel(Socket client) {
			try {
				dis =  new DataInputStream(client.getInputStream());//������
				dos = new DataOutputStream(client.getOutputStream());//�����
			} catch (IOException e) {
				// e.printStackTrace();
				CloseUtil.close(dis, dos);
				isRunning = false;
			}
		}
		
		/***
		 * ��ȡ����
		 * @return
		 */
		private String recieve() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// e.printStackTrace();
				CloseUtil.close(dis);
				isRunning = false;
				allConnect.remove(this);
			}
			return msg;
		}
		
		/**
		 * ��������
		 */
		private void send(String msg) {
			if(null==msg||msg.equals("")) return;
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// e.printStackTrace();
				CloseUtil.close(dos);
				isRunning = false;
				allConnect.remove(this);
			}
		}
		
		/**
		 * ���͸������ͻ���
		 */
		private void sendToOthers(String msg) {
			//��������
			for(MyChannel member : allConnect) {
				if(member==this) continue;
				member.send(msg);
			}
		}

		@Override
		public void run() {
			while(true) {
				String msg = recieve();
				//System.out.println(msg);
				//send(msg);
				sendToOthers(msg);
			}
		}
	}

	
}
