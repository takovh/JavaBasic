package cn.zhang.IO.others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ����� �ڵ���
 * ����ĳ�������, ����������ܴ�
 * 
 * �ļ����ݲ�Ҫ̫��
 * 1.�ļ� --����--> �ֽ�����
 * 2.�ֽ����� --����--> �ļ�
 * @author tako_
 *
 */
public class ByteArrayDemo01 {
	public static void main(String[] args) throws IOException {
		read(write());
	}
	
	/**
	 * ������ �������ļ�������һ��
	 * ��ȡ�ֽ�����
	 * @throws IOException 
	 */
	public static void read() throws IOException {
		String msg = "�������ļ�������һ��";
		byte[] src = msg.getBytes();
		
		//ѡ����
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) System.out.println(new String(flush, 0, len));
		//�ͷ���Դ
		is.close();
	}
	public static void read(byte[] src) throws IOException {
		//ѡ����
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) System.out.println(new String(flush, 0, len));
		//�ͷ���Դ
		is.close();
	}
	
	/**
	 * ����� �������ļ��������Щ��ͬ������������������ʹ�ö�̬
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException {
		//Ŀ�ĵ�
		byte[] dest;
		//ѡ���� ��ͬ��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//���� д��
		String msg = "�������ļ�������һ��";
		byte[] info = msg.getBytes();
		baos.write(info, 0, info.length);
		//��ȡ����
		dest = baos.toByteArray();
		//�ͷ���Դ
		baos.close();
		return dest;
	}
}
