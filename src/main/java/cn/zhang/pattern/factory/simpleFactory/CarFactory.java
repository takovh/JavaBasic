package cn.zhang.pattern.factory.simpleFactory;

public class CarFactory {
	public static Car creatCar(String type) {
		if("�µ�".equals(type)) {
			return new Audi();
		}else if("���ǵ�".equals(type)) {
			return new Byd();
		}else {
			return null;
		}
	}
}
