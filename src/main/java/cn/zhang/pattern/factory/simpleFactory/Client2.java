package cn.zhang.pattern.factory.simpleFactory;

/**
 * �򵥹��������
 * @author tako_
 *
 */
public class Client2 {
	public static void main(String[] args) {
		Car c1 = CarFactory.creatCar("�µ�");
		Car c2 = CarFactory.creatCar("���ǵ�");
		
		c1.run();
		c2.run();
	}
}
