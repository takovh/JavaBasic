package cn.zhang.collection.generic02;

/**
 * 	���͸��࣬������Ϊ������
 * 1.�������෺�� -->����Ϊ����
 * 2.���������෺�� -->���ఴ��ʵ�ּ���
 * 
 * 	���Լ��������� -->��λ�ö���
 * 	������д���������ͣ��游�����
 * 	�����������������ͣ����������
 * 	������ʹ�ø�������ԣ��游�����
 * 	������ʹ���Լ������ԣ����������
 * @author tako_
 *
 */
public abstract class Father<T1, T2> {
	T1 age;
	public abstract void test(T2 name);
}

//����
//1.ȫ������
class C1<T1, T2, A, B> extends Father<T1, T2>{

	@Override
	public void test(T2 name) {
		/*this.age -->T1*/	
	}	
}
//2.���ֱ���
class C2<T2> extends Father<Integer, T2>{

	@Override
	public void test(T2 name) {
		/*this.age -->Integer*/
	}
}
//������ -->����ʵ��
//1.��������
class C3 extends Father<Integer, String>{

	@Override
	public void test(String name) {
		/*this.age -->Integer*/
	}	
}
//2.û�����ͣ�����Object
@SuppressWarnings("rawtypes")
class C4 extends Father{

	@Override
	public void test(Object name) {
		/*this.age -->Object*/
	}	
}