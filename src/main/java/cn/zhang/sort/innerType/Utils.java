package cn.zhang.sort.innerType;

import java.util.Comparator;
import java.util.List;


/**
 * 1��������
 * 
 * @author tako_
 *
 */
public class Utils {
	/**
	 * ��������-����
	 * @param arr
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Object[] arr) {
		boolean sorted = true;
		int len = arr.length;
		for (int j = 0; j < len - 1; j++) {
			sorted = true;
			for (int i = 0; i < len - 1 - j; i++) {
				if (((Comparable) arr[i]).compareTo(arr[i + 1]) < 0) {
					Object temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false;
				}
			}
			if(sorted) break;
		}
	}
	
	/**
	 * ��������-����(ʹ�÷���)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable<T>> void sort(T[] arr) {
		boolean sorted = true;
		int len = arr.length;
		for (int j = 0; j < len - 1; j++) {
			sorted = true;
			for (int i = 0; i < len - 1 - j; i++) {
				if (((Comparable) arr[i]).compareTo(arr[i + 1]) < 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false;
				}
			}
			if(sorted) break;
		}
	}
	
	/**
	 * ��������
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(List<T> list) {
		//��һ����ת������
		Object[] arr = list.toArray();
		sort(arr);
		//�ڶ������ı������ж�Ӧ��ֵ
		for(int i=0;i<arr.length;i++) list.set(i, (T)(arr[i]));
	}
	
	/**
	 * ��������򣨽���+Comparator�ӿ�
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Object[] arr, Comparator com) {
		boolean sorted = true;
		int len = arr.length;
		for (int j = 0; j < len - 1; j++) {
			sorted = true;
			for (int i = 0; i < len - 1 - j; i++) {
				if (com.compare(arr[i], arr[i+1]) < 0) {
					Object temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false;
				}
			}
			if(sorted) break;
		}
	}
}
