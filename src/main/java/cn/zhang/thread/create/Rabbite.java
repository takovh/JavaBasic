package cn.zhang.thread.create;

/**
 * ģ���������
 * 1.�������߳� �̳�Tread + ��дrun(�߳���)
 * 2.ʹ���̣߳������������ + ����.start()�߳�����
 * @author tako_
 *
 */
public class Rabbite extends Thread {
	@Override
	public void run() {
		//�߳���
		for(int i=0;i<100;i++) {
			System.out.println("��������" + i + "��");
		}
	}

}
class Tortoise extends Thread {
	@Override
	public void run() {
		//�߳���
		for(int i=0;i<100;i++) {
			System.out.println("�ڹ�����" + i + "��");
		}
	}

}
