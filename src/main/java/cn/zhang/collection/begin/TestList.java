package cn.zhang.collection.begin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Dog{
	
}

public class TestList {
	/**
	 * û�ӷ��ͻ��л�ɫ����
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);//��װ���Զ�װ��
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		list.remove("aaa");
		System.out.println(list.size());
		list.add(list2);
		System.out.println(list.size());
		for(Object e : list)  System.out.println(e);

	}
}
