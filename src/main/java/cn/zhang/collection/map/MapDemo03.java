package cn.zhang.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ����һ��Student�࣬���ԣ�name������no��ţ�score�ɼ�
 * ���ڽ����ɸ�Student�������List����ͳ�Ƴ�ÿ���༶���ֺܷ�ƽ����
 * �������������+�ּ�洢(1:N)
 * @author tako_
 *
 */
public class MapDemo03 {
	public static void main(String[] args) {
		//1.����
		List<Student> stuList = exam();
		//2.�����ɼ�
		Map<String, ClassRoom> map = count(stuList);
		//3.�鿴�ɼ����ܷ֡�ƽ���֣�
		view(map);
	}
	
	/**
	 * �鿴ÿ������ֺܷ�ƽ���� -->����map
	 */
	public static void view(Map<String, ClassRoom> map) {
		Set<String> keys = map.keySet();
		Iterator<String> keysIt = keys.iterator();
		while(keysIt.hasNext()) {
			String no = keysIt.next();
			ClassRoom room = map.get(no);
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println("�༶no:" + no + " �ܷ֣�" + total + " ƽ���֣�" + avg);
		}
	}
	
	/**
	 * ͳ�Ʒ���
	 * 1.�������
	 * 2.�ּ�洢
	 */
	public static Map<String, ClassRoom> count(List<Student> list){
		Map<String, ClassRoom> map = new HashMap<String, ClassRoom>();
		//1.����List
		for(Student stu : list) {
			String no = stu.getNo();
			double score = stu.getScore();
			ClassRoom room = map.get(no);
			if(null==room) {
				room = new ClassRoom(no);
				map.put(no, room);
			}
			room.getStuList().add(stu);
			room.setTotal(room.getTotal()+score);
		}
		return map;
	}
	
	/**
	 * ģ�⿼�� �������ݵ�List��
	 */
	public static List<Student> exam(){
		List<Student> list = new ArrayList<Student>();
		//���ѧ���ɼ�
		list.add(new Student("����","a",100));
		list.add(new Student("����","a",90));
		list.add(new Student("���չ�","b",80));
		list.add(new Student("����","b",85));
		return list;
	}
}
