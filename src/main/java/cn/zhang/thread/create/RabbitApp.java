package cn.zhang.thread.create;

/**
 * 
 * @author tako_
 *
 */
public class RabbitApp {
	public static void main(String[] args) {
		//1.�����������
		Rabbite rbt = new Rabbite();
		Tortoise tts = new Tortoise();
		//2.����start����
		rbt.start();
		tts.start();
	}
	
}
