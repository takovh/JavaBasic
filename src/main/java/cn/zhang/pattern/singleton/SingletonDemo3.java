package cn.zhang.pattern.singleton;

/**
 * ���Ծ�̬�ڲ���ʵ�ֵ���ģʽ
 * �̰߳�ȫ�ҵ���Ч�ʸ�
 * @author tako_
 *
 */
public class SingletonDemo3 {
	private static class SingletonClassInstance {
		private static final SingletonDemo3 instance = new SingletonDemo3();
	}
	private SingletonDemo3() {
		
	}
	public static synchronized SingletonDemo3 getInstance() {
		return SingletonClassInstance.instance;
	}
}
