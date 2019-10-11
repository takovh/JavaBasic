package cn.zhang.collection.generic03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ����Ƕ��
 * @author tako_
 *
 */
public class StudentApp {
	public static void main(String[] args) {
		Student<String> stu = new Student<String>();
		stu.setScore("����");
		System.out.println(stu.getScore());
		
		//����Ƕ��
		SchoolClass<Student<String>> class1 = new SchoolClass<Student<String>>();
		class1.setStu(stu);
		stu = class1.getStu();
		String score = stu.getScore();
		System.out.println(score);
		
		//HashMap -->ʹ���˷��͵�Ƕ��
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "java300");
		map.put("1815283001", "����");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "-->" +value);
		}
	}
}
