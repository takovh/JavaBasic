package cn.zhang.pattern.factory.simpleFactory;

/**
 * ������û���ù���ģʽ������µ���
 * @author tako_
 *
 */
public class Client1 {
	public static void main(String[] args) {
		Car c1 = new Audi();
		Car c2 = new Byd();
		
		c1.run();
		c2.run();
	}
}
