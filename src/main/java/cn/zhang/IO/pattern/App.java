package cn.zhang.IO.pattern;

/**
 * ������
 * ������֮��Ĺ�ϵ
 * 1.�������β�|�ֲ�����
 * 2.����������
 * 		�ۺϣ������벿�� ��һ�µ��������ڣ���������
 * 		��ϣ������벿�� һ�µ��������ڣ����������
 * 3.�̳У��������ϵ
 * 4.ʵ�֣��ӿ���ʵ�����ϵ
 * @author tako_
 *
 */
public class App {
	public static void main(String[] args) {
		Voice v = new Voice();
		v.say();
		Amplifier am = new Amplifier(v);
		am.say();
	}
}
