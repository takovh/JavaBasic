package cn.zhang.thread.create;

/**
 * 推荐使用Runnable创建线程
 * 1）避免单继承的局限性
 * 2）便于共享资源
 * 
 * 
 * 使用Runnable创建线程
 * 1.类实现Runnable接口 + 重写run()  -->真实角色类
 * 2.启动多线程 使用静态代理
 * 	1）创建真实角色
 * 	2）创建代理角色 + 真实角色引用
 * 	3）调用.start()启动线程
 * @author tako_
 *
 */
public class Programmer implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) System.out.println("敲代码中。。。");
	}
	
}
