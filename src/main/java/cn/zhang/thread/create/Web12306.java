package cn.zhang.thread.create;

public class Web12306 implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(num<=0) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + "������" + num--);
		}
	}
	public static void main(String[] args) {
		
		//��ʵ��ɫ
		Web12306 web = new Web12306();
		//����
		Thread t1 = new Thread(web, "·�˼�");
		Thread t2 = new Thread(web, "·����");
		Thread t3 = new Thread(web, "·�˱�");
		t1.start();
		t2.start();
		t3.start();
	}
}
