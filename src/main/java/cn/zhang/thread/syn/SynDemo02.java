package cn.zhang.thread.syn;

/**
 * �������ģʽ��ȷ��һ����ֻ��һ������
 * 
 * @author tako_
 *
 */
public class SynDemo02 {
	public static void main(String[] args) {
		
	}
}

/**
 * �������ģʽ
 * ȷ��һ����ֻ��һ������
 * ����ʽ
 * 1.������˽�л��������ⲿֱ�Ӵ�������
 * 2.����һ��˽�еľ�̬����
 * 3.����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
 * @author tako_
 *
 */
class Jvm{
	//����һ��˽�еľ�̬����
	private static  Jvm instance = null;
	//������˽�л��������ⲿֱ�Ӵ�������
	private Jvm() {	}
	public static Jvm getInstance() {
		if(null==instance) {
			instance = new Jvm();
		}
		return instance;
	}
}