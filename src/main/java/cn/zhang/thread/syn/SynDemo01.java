package cn.zhang.thread.syn;

public class SynDemo01 {
	public static void main(String[] args) {
		//��ʵ��ɫ
		Web12306 web = new Web12306();
		//����
		Thread t1 = new Thread(web, "·�˼�");
		Thread t2 = new Thread(web, "��ţ1");
		Thread t3 = new Thread(web, "��ţ2");
		
		t1.start();
		t2.start();
		t3.start();
	}	
}

class Web12306 implements Runnable {
	private int num = 100;
	private boolean flag = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			//test01();//����ȫ
			test02();//��ȫ
			//test03();//��ȫ
		}
	}
	
	//�̲߳���ȫ��
	public void test01() {
		if(num<=0) {
			flag = false;
		}else {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "�����ˣ���Ʊ" + --num);
		}		
	}
	//�̰߳�ȫ��
	public synchronized void test02() {
		if(num<=0) {
			flag = false;
		}else {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "�����ˣ���Ʊ" + --num);
		}
	}
	
	//�̰߳�ȫ��
	public synchronized void test03() {
		synchronized(this) {
			if(num<=0) {
				flag = false;
			}else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "�����ˣ���Ʊ" + --num);
			}
		}	
	}
}