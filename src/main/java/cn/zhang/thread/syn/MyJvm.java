package cn.zhang.thread.syn;

/**
 * ���������ķ�ʽ
 * 1.����ʽ
 * 1).������˽�л��������ⲿֱ�Ӵ�������
 * 2).����һ��˽�еľ�̬����
 * 3).����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
 * @author tako_
 *
 */
public class MyJvm {
	private static MyJvm instance = null;
	private MyJvm() {}
	public static MyJvm getInstance() {
		if(null==instance) {//��һ�μ�飺���Ч��
			synchronized(MyJvm.class) {
				if(null==instance) {//�ڶ��μ�飺��ȫ
					instance = new MyJvm();
				}
			}
		}
		return instance	;
	}
}

/**
 * ����ʽ
 * 1).������˽�л�
 * 2).����һ��˽�еľ�̬���ԣ�ͬʱ�����ö���
 * 3).�����ṩ�������Եľ�̬����
 * @author tako_
 *
 */
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();
	private MyJvm2() {}
	public static MyJvm2 getInstance() {
		return instance	;
	}
}

/**
 * ����ʹ�õ�ʱ����أ��ӻ��˼���ʱ��
 * ��Ϊ����һ��ʼ�ͻ��ʼ���������ڼ���ʱ��ʼ��
 * @author tako_
 *
 */
class MyJvm3 {
	private static class JVMholder{
		private static MyJvm3 instance = new MyJvm3();
	}
	private MyJvm3() {}
	public static MyJvm3 getInstance() {
		return JVMholder.instance;
	}
}
