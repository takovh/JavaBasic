package cn.zhang.IO.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ����+���� ������ļ�
 * �������ͣ�����+String��������
 * 1.������DataInputStream ReadXxx()
 * 2.�����DataOutputStream WriteXxx()
 * ������������ʹ�ö�̬
 * 
 * java.IO.EOFException :û�ж�ȡ����ص�����
 * @author tako_
 *
 */
public class DataDemo01 {
	public static void main(String[] args) throws IOException {
		//write("D:/tmp/d.txt");
		read("D:/tmp/d.txt");
	}
	/**
	 * ����+���� ������ļ�
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		//����Դ
		File dest = new File(destPath);
		///DataOutputStream
		DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(
								new FileOutputStream(dest)
							)
				);
		//����
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dos.close();
	}
	
	/**
	 * ���ļ��ж�ȡ����+����
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException {
		//����Դ
		File src = new File(destPath);
		//ѡ����
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(
								new FileInputStream(src)
							)
				);
		//��������ȡ��˳�������д��һ�� ������ڲ��ܶ�ȡ
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		System.out.println(num1 + num2 + str);
		dis.close();
	}
}
