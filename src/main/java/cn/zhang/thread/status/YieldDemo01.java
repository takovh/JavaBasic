package cn.zhang.thread.status;

/**
 * 
 * @author tako_
 *
 */
public class YieldDemo01 extends Thread{
	public static void main(String[] args) {
		YieldDemo01 demo = new YieldDemo01();
		Thread t = new Thread(demo);//����
		t.start();//����
		//CPU��������
		for(int i=0;i<500;i++) {
			if(i%20==0) {
				//��ͣ���߳�main
				Thread.yield();
			}
			System.out.println("main..." + i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<500;i++) System.out.println("yield..." + i);
	}
}
