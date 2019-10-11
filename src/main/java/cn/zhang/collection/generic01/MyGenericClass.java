package cn.zhang.collection.generic01;

/**
 * 	�Զ��巺����/�ӿ�/����
 * @author tako_
 * 1. <>  ������д��ĸ�������ܼ���֮��
 * 2.
 * T Type
 * K V Key Value
 * E Element
 * 3.ע�⣺���Ͳ���ʹ���ھ�̬������
 * 4.ע�⣺���Ͳ���ʹ����ȫ�ֳ�����
 * 5.ʹ��ʱ����������ָ���������ͣ�����Ϊ��������
 * 6.�Ƿ�������Ҳ�ɶ��巺�ͷ���
 */
public class MyGenericClass<T> {
	private T javase;

	public MyGenericClass(T javase) {
		super();
		this.javase = javase;
	}

	public T getJavase() {
		return javase;
	}

	public void setJavase(T javase) {
		this.javase = javase;
	}
	
}
