package cn.zhang.collection.generic03;

import java.util.ArrayList;
import java.util.List;

/**
 * extends�����͵�����<= �����������
 * 1.һ���������Ʋ���
 * 2. ����ʹ������������ϣ�һ�㶼�Ƕ�ȡ����
 * 3.����
 * 	List<Fruit> -->List<? extends Fruit>
 *  List<Apple> -->List<? extends Fruit>
 *  List<? extends Apple> -->List<? extends Fruit>
 *  ���ܴ�ţ�
 *  List<?>
 *  List<? extends Object>
 * 
 * @author tako_
 *
 */

public class ExtendsTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//extendsΪ����
		Test<Fruit> t1 = new Test<Fruit>();
		Test<Apple> t2 = new Test<Apple>();
		Test<Pear> t3 = new Test<Pear>();
		
		//���÷���
		List<? extends Fruit> list1 = new ArrayList<Fruit>();
		test(list1);
		List<Fruit> list2 = new ArrayList<Fruit>();
		test(list2);
		List<Apple> list3 = new ArrayList<Apple>();
		test(list3);
		//? extends Apple
		List<? extends Apple> list4 = new ArrayList<FujiApple>();
		test(list4);
		//?Ϊʲô���У���Ϊ<?>��ͬ��<? extends Object>
		List<?> list5 = new ArrayList<Fruit>();
		List<? extends Object> list6 = new ArrayList<Fruit>();
		//test(list5);
	}
	
	//? extends Fruit
	public static void test(List<? extends Fruit> list) {
		/*list.add(new Apple());
		list.add(new FujiApple());
		list.add(new Pear());
		list.add(new Fruit());*/
		
		list.addAll(null);
	}
	//������
	static class Test<T extends Fruit>{
		
	}
}
