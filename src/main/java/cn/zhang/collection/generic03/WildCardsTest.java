package cn.zhang.collection.generic03;

import java.util.ArrayList;
import java.util.List;

/**
 * ? -->ͨ��������Ͳ�ȷ�������������������β���
 * @author tako_
 *
 */
public class WildCardsTest {
	public static void main(String[] args) {
		//����
		List<?> list; 
		list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		list = new ArrayList<Object>();
		test(list);
	}
	public static void test(List<?> list) {
		
	}
}
