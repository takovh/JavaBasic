package cn.zhang.IO.convert;

import java.io.UnsupportedEncodingException;

/**
 * ����������ַ�����ͳһ���ֽ������������������
 * @author tako_
 *
 */
public class ConvertDemo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "һ����abc123";//GBK
		//����1��char-(GBK)->byte
		byte[] data1 = str.getBytes();
		//����1��byte-(GBK)->char
		System.out.println(new String(data1));//����������ַ���ͳһ
		
		//����2��char-(utf-8)->byte
		byte[] data2 = str.getBytes("utf-8");//�趨�����ַ���
		//����2��byte-(GBK)->char
		System.out.println(new String(data2));//����������ַ�����ͳһ
		
		//����3��char-(utf-8)->byte
		byte[] data3 = str.getBytes("utf-8");//�趨�����ַ���
		//����3��byte-->char
		System.out.println(new String(data3, "utf-8"));//��ָ����Ĭ��GBK
		
	}
}
