package cn.zhang.thread.create;

/**
 * �Ƽ�ʹ��Runnable�����߳�
 * 1�����ⵥ�̳еľ�����
 * 2�����ڹ�����Դ
 * 
 * 
 * ʹ��Runnable�����߳�
 * 1.��ʵ��Runnable�ӿ� + ��дrun()  -->��ʵ��ɫ��
 * 2.�������߳� ʹ�þ�̬����
 * 	1��������ʵ��ɫ
 * 	2�����������ɫ + ��ʵ��ɫ����
 * 	3������.start()�����߳�
 * @author tako_
 *
 */
public class Programmer implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) System.out.println("�ô����С�����");
	}
	
}
