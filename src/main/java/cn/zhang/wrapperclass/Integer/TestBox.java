package cn.zhang.wrapperclass.Integer;
/**
 * �����Զ������װ��
 * @author ����
 *
 */
public class TestBox {
	public static void main(String[] args) {
		Integer [] i = new Integer[2];
		i[0] = new Integer(100);//��ʱ��,���ǲ�Ӱ��ʹ��
		i[1] = 100;//jdk5.0֮�󣬱����������ж� ���� �Զ�װ�䣺�������������޸Ĵ���Ϊi[1] = new Integer(100);
		for(Integer e : i) System.out.println(e);
		
		int m = i[0].intValue();
		int n = i[0];//jdk5.0֮�󣬱����������ж� ���� �Զ����䣺�������������޸Ĵ���Ϊint n = i[0].intValue();
		System.out.println(m);
		System.out.println(n);
		
		System.out.println(i[0] == i[1]);//�ٴ���ʶ���ã��ڴ����
		System.out.println(i[0].equals(i[1]));
		
		Integer d1 = 128;//[-128,127]֮���������Ȼ����������������������
		Integer d2 = 128;
		Integer d3 = new Integer(100);//new�����ĵ�ַһ������
		Integer d4 = new Integer(100);
		System.out.println(d1 == d2);
		System.out.println(d3 == d4);
	}
}
