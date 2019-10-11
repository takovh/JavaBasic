package cn.zhang.thread.status;

/**
 * join:�ϲ��߳�
 * @author tako_
 *
 */
public class JoinDemo01 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 demo = new JoinDemo01();
		Thread t = new Thread(demo);//����
		t.start();//����
		//CPU��������
		for(int i=0;i<500;i++) {
			if(50==i) t.join();//main����
			System.out.println("main..." + i);
		}
	}
	@Override
	public void run() {
		for(int i=0;i<500;i++) System.out.println("join..." + i);
	}
}
