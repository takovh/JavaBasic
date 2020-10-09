package cn.zhang.designPattern.adapter;

/**
 * 相当于例子中的笔记本，只有USB接口
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
