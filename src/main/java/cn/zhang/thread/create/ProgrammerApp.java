package cn.zhang.thread.create;

/**
 * 
 * @author tako_
 *
 */
public class ProgrammerApp {
	
	public static void main(String[] args) {
		
		//1��������ʵ��ɫ
		Programmer pgm = new Programmer();
		// 2�����������ɫ + ��ʵ��ɫ����
		Thread proxy = new Thread(pgm);
		//	3������.start()�����߳�
		proxy.start();
		
		for(int i=0;i<100;i++) System.out.println("��QQ�С�����");
	}
}
