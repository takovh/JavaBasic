package cn.zhang.collection.generic02;

/**
 * 	���ͽӿ��뷺����ͬ��
 * @author tako_
 *
 */
public interface Comparator<T> {
	//ȫ�ֳ���
	public static final int MAX_VALUE = 1024;
	//�������󷽷�
	public abstract void test(T t);
}

//ʵ��
@SuppressWarnings("rawtypes")
class InterfC1<A> implements Comparator{

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
		
}
class InterfC2<A> implements Comparator<Integer>{

	@Override
	public void test(Integer t) {
		// TODO Auto-generated method stub
		
	}
	
}
class InterfC3<T, A> implements Comparator<T>{

	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
	
}