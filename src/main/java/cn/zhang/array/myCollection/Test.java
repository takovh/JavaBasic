package cn.zhang.array.myCollection;
/**
 * ģ��ʵ��JDK���ṩ��ArrayList��
 * @author ����
 *
 */
public class Test {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add("a");
		list.add(new Human("zhangyu"));
		Human h = (Human)list.get(1);
		
		System.out.println(list.get(0));
		System.out.println(h.getName());
		System.out.println(list.size());
	}
}
