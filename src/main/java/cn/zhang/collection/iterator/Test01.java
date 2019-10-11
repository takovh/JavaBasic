package cn.zhang.collection.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		for(int i=0;i<list.size();i++) System.out.println(list.get(i));
		
		Set<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		
		/**
		 * whileѭ������
		 */
		System.out.println("*************whileѭ������*************");
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String str = (String)iter.next();//���ص�ǰָ��Ķ���ָ����һ������
			System.out.println(str);
		}
		
		/**
		 * forѭ������
		 */
		System.out.println("*************forѭ������*************");
		for(Iterator<String> iter2=set.iterator();iter2.hasNext(); ) {
			String str = (String)iter2.next();
			System.out.println(str);
		}
	}
}
