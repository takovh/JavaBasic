package cn.zhang.collection.begin;

import java.util.HashSet;
import java.util.Set;

/**
 * ����Set���÷���
 * @author ����
 *
 */
public class TestSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("aaa");
		System.out.println(set.size());
		set.remove("aaa");
		System.out.println(set.contains("aaa"));
	}
}
