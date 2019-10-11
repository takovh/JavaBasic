package cn.zhang.pattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
	Star realStar;
	
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		System.out.println("�����ķ���ִ��ǰ��");
		System.out.println("��̸��ǩ��ͬ����Ʊ");
		if(method.getName().equals("sing")) {
			obj = method.invoke(realStar, args);
		}
		System.out.println("�����ķ���ִ�к�");
		System.out.println("��Ǯ");
		return obj;
	}

}
