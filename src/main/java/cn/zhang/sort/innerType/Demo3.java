package cn.zhang.sort.innerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ʹ��Collections�������ıȽ�
 * @author tako_
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		System.out.println("==============List����-��Comparator===============");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		Collections.sort(list, new StringCompare());
		System.out.println(list);
		
		System.out.println("==============List����-Ĭ��===============");
		list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		Collections.sort(list);
		System.out.println(list);
		
	}
}
