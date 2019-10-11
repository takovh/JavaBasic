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
 * bug:�������Ҫ��ǰ����������Լ����ǳ�֮����ܵ�½
 * @author tako_
 *
 */
public class Demo04Server {
	private List<MyChannel> allConnect  = new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException{
		new Demo04Server().connect();
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
			new Thread(channel).start();//ÿ���û�һ����·
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
		private boolean isRunning = true;
		private String name;
		//����������ʼ��
		public MyChannel(Socket client) {
			try {
				dis =  new DataInputStream(client.getInputStream());//������
				dos = new DataOutputStream(client.getOutputStream());//�����
				this.name = dis.readUTF();
				send("��ӭ����������ң�");
				sendToOthers("�ҽ����������ң�");
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
				System.out.println(this.name + "�뿪�������ң�");
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
				System.out.println(this.name + "�뿪�������ң�");
			}
		}
		
		/**
		 * ���͸������ͻ���
		 */
		private void sendToOthers(String msg) {
			//�Ƿ�Ϊ˽��(Լ��@name:Ϊ˽�ģ�����ΪȺ��)
			if(msg.startsWith("@")) {
				for(MyChannel member : allConnect) {
					String name = msg.substring(1,msg.indexOf(":"));
					String content = msg.substring(msg.indexOf(":")+1);
					if(member.name.equals(name)) member.send(this.name + "��������˵:" + content);
				}
			}else {
				//��������
				for(MyChannel member : allConnect) {
					if(member==this) continue;
					member.send(this.name + "��������˵��" + msg);
				}
			}
		}

		@Override
		public void run() {
			while(isRunning) {
				String msg = recieve();
				sendToOthers(msg);
			}
		}
	}

	
}
