package cn.zhang.array.testarray;

public class Test02 {
	public static void main(String[] args) {
		//����
		int[] a;
		int b[];
		
		//�����������
		a = new int[2];
		b = new int[3];
		
		//������Ԫ�صĳ�ʼ��
		//Ĭ�ϳ�ʼ��������Ԫ���൱�ڶ���ĳ�Ա������Ĭ��ֵ����Ա�����Ĺ���һ����
		//���֣�0       ������false  char��\u0000    ���ã�null
		//��̬��ʼ��:
		a[0] = 23;
		a[1] = 45;
		for(int i = 0;i<a.length;i++) {
			a[i] = i*2;
		}
		for(int i = 0;i<b.length;i++) {
			b[i] = i*2;
		}
		//��̬��ʼ����
		int c[] = {1,2,3};
		Car cars[] = {new Car("BMW"),new Car("VW"),new Car("BYD")};
		for(int i = 0;i<c.length;i++) {
			System.out.println(c[i]);
		}
		for(int i = 0;i<cars.length;i++) {
			System.out.println(cars[i].name);
		}
	}
}
