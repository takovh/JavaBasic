package cn.zhang.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * �ּ�洢��1:N
 * ͳ�Ƶ��ʳ��ֵĴ���
 * this is a cat and that is a mice and where is the food ?
 * 
 * ˼·��
 * 1.�ָ��ַ���
 * 2.�ּ�洢
 * 3.��Ҫ��鿴���ʳ��ֵĴ���
 * 4.�����������
 * @author tako_
 *
 */
public class MapDemo02 {
	public static void main(String[] args) {
		//1.�ָ��ַ���
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//2.�ּ�洢
		Map<String, Letter> map = new HashMap<String, Letter>();
		for(String key : arr) {
			if(!map.containsKey(key)) {
				map.put(key, new Letter(key));
			}
			Letter value = map.get(key);
			value.setCount(value.getCount()+1);
		}
		//3.��Ҫ��鿴���ʳ��ֵĴ���
		for(String key : map.keySet()) {
			Letter value = map.get(key);
			System.out.println(key + "--->" + value.getCount());
		}
	}
}
