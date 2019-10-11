package cn.zhang.thread.create;

/**
 * ��̬�������ģʽ
 * 1.��ʵ��ɫ
 * 2.�����ɫ
 * 3.����ʵ����ͬ�Ľӿ�
 * @author tako_
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//������ʵ��ɫ
		You you = new You();
		//���������ɫ + ��ʵ��ɫ������
		WeddingCompany wc = new WeddingCompany(you);
		//ִ������
		wc.marry();
	}
	
}

//��ͬ�Ľӿ�
interface Marry{
	public abstract void marry();
}

//��ʵ��ɫ
class You implements Marry{
	@Override
	public void marry() {
		System.out.println("���Ϻ��ܼһ۽���ˣ�");
	}
}

//�����ɫ
class WeddingCompany implements Marry{
	private Marry you;
	public WeddingCompany() {}
	public WeddingCompany(Marry you) {
		this.you = you;
	}
	private void before() {
		System.out.println("�����·�...");
	}
	private void after() {
		System.out.println("�ֶ���...");
	}
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}



