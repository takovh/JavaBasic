package cn.zhang.pattern.singleton;

/**
 * ���Զ���ʽ����ģʽ
 * �̰߳�ȫ
 * @author tako_
 *
 */
public class SingletonDemo1 {
	private static SingletonDemo1 instance = new SingletonDemo1();//���ʼ��ʱ���������������
	private SingletonDemo1() {
		
	}
	public static SingletonDemo1 getInstance() {
		return instance;
	}
}
