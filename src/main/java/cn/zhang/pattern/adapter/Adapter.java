package cn.zhang.pattern.adapter;

/**
 * ������������������ʽ��
 * �൱�������е�����������USB��PS/2ת������
 * @author tako_
 *
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void handleReq() {
		super.request();
	}
	
}
