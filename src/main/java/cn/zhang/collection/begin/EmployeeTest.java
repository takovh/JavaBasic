package cn.zhang.collection.begin;

import java.util.ArrayList;
import java.util.List;

/**
 * javabean
 * һ���������һ�м�¼
 * @author ����
 *
 */
public class EmployeeTest {
	public static void main(String[] args) {
		Employee e = new Employee(0301, "����", 3000, "��Ŀ��", "2010-10");
		Employee e1 = new Employee(0302, "��ʿ��", 3500, "��ѧ��", "2010-10");
		Employee e2 = new Employee(0302, "����", 3500, "��ѧ��", "2010-10");
		
		/**
		 * List<>��ʾ����
		 */
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e1);
		list.add(e2);
		for(Employee element : list) System.out.println(element.getName());
	}

}
