package cn.zhang.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ��װip��DNS
 * 1.getHostAddress()
 * 2.getHostName()
 * @author tako_
 *
 */
public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//����192.168.227.1
		System.out.println(addr.getHostName());//������������DESKTOP-59NVJL1
		
		//���������õ�InetAddress����
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//����163��������ip:113.142.80.177
		System.out.println(addr.getHostName());//�������
		
		//����ip�õ�InetAddress����
		addr = InetAddress.getByName("113.142.80.177");
		System.out.println(addr.getHostAddress());//����163��������ip:113.142.80.177
		System.out.println(addr.getHostName());//���ip
	}
}
