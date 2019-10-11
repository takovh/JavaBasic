package cn.zhang.pattern.adapter;

/**
 * ��������������������ʽ��
 * �൱�������е�����������USB��PS/2ת������
 * @author tako_
 *
 */
public class Adapter2 implements Target {
	private Adaptee adaptee;
	@Override
	public void handleReq() {
		adaptee.request();
	}
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}
	
}
