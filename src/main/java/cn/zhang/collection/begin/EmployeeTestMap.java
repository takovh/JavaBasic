package cn.zhang.collection.begin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *һ��Map��Ӧһ�м�¼
 * @author ����
 *
 */
public class EmployeeTestMap {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("id", 0301);
		map.put("name", "����");
		map.put("salary", 3000);
		map.put("department", "��Ŀ��");
		map.put("hireDate", "2010-10");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		
		System.out.println(list.get(0).get("name"));
	}
}
