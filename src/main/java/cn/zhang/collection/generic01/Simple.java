package cn.zhang.collection.generic01;

import java.util.ArrayList;
import java.util.List;

/**
 * ���͵�����
 * 1.���ͣ���ǩ����������
 * 2.���ã�ʡ�ġ���ȫ����ȫ��飩
 * @author ����
 *
 */
public class Simple {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//��ȫ
		//list.add(1);//���ͼ��
		list.add("so easy!");
		//ʡ��
		String ele = list.get(0);
		System.out.println(ele);
	}
}
