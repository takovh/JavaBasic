package cn.zhang.wrapperclass.Integer;
/**
 * ���԰�װ��Ļ����÷�
 * @author ����
 *
 */
public class TestInt {
	public static void main(String[] args) {
		Integer [] i = new Integer[4];
		i[0] = new Integer(100);//��ʱ��,���ǲ�Ӱ��ʹ��
		i[1] = 101;
		i[2] = Integer.parseInt("102");
		i[3] = new Integer("103");//��ʱ��,���ǲ�Ӱ��ʹ��
		for(Integer m : i) {
			System.out.println(m);
			System.out.println(m.intValue());
		}
	}
}
