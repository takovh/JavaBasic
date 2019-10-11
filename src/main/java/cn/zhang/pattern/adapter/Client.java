package cn.zhang.pattern.adapter;

/**
 * �൱�������еıʼǱ���ֻ��USB�ӿ�
 * @author tako_
 *
 */
public class Client {
	
	public void test1(Target t) {
		t.handleReq();
	}
	public static void main(String[] args) {
		Client c = new Client();
		Adaptee a = new Adaptee();
		Target t = new Adapter();
		Target t2 = new Adapter2(a);
		
		c.test1(t);
		c.test1(t2);
	}
}
