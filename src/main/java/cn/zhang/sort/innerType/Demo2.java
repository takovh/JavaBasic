package cn.zhang.sort.innerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		System.out.println("==============String����===============");
		String[] arr = {"a","abcd","abc","def"};
		Utils.sort(arr);//����
		System.out.println(Arrays.toString(arr));
		
		System.out.println("==============List����===============");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		Utils.sort(list);
		System.out.println(list);
		
		System.out.println("==============ʹ��Comparator��������===============");
		String[] arr2 = {"a","abcd","abc","def"};
		Utils.sort(arr2, new StringCompare());//����
		System.out.println(Arrays.toString(arr2));
	}
}
