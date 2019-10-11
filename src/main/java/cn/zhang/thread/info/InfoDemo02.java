package cn.zhang.thread.info;

/**
 * ���ȼ�(������ʶ������Ⱥ�)
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5
 * MIN_PRIORITY 1
 * 
 * setPriority()
 * getPriority()
 * @author tako_
 *
 */
public class InfoDemo02 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		Thread p1 = new Thread(it1,"����1");
		MyThread it2 = new MyThread();
		Thread p2 = new Thread(it2,"����2");
		
		p1.setPriority(Thread.MIN_PRIORITY);
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		
		Thread.sleep(5);
		it1.stop();
		it2.stop();
	}
}
