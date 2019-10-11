package cn.zhang.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * �ּ�洢��1:N
 * ͳ�Ƶ��ʳ��ֵĴ���
 * this is a cat and that is a mice and where is the food ?
 * 
 * ˼·��
 * 1.�ָ��ַ���
 * 2.�ּ�洢
 * 3.��Ҫ��鿴���ʳ��ֵĴ���
 * 
 * @author tako_
 *
 */
public class MapDemo01 {
	public static void main(String[] args) {
		//1.�ָ��ַ���
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//2.�ּ�洢
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String key : arr) {
			//System.out.println(key);
			if(!map.containsKey(key)) {
				map.put(key, 1);
			}else {//�Ѿ�����
				map.put(key, map.get(key)+1);
			}
		}
		//3.��Ҫ��鿴���ʳ��ֵĴ���
		Set<String> keySet = map.keySet();
		//��ȡ����
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key + "-->" + value);
		}
	}
}
