package cn.zhang.IO.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * �������еĶ��󶼿������л�
 * �������е����Զ���Ҫ���л�
 * @author tako_
 *
 */
public class ObjectDemo01 {
	public static void main(String[] args) {
		try {
			seri("D:/tmp/d.txt");
			reseri("D:/tmp/d.txt");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���л�
	public static void seri(String destPath) throws IOException {
		Employee emp = new Employee("zhangyu",10000);
		// ����Դ
		File dest = new File(destPath);
		//ObjectOutputStream
		ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
		// ����
		dos.writeObject(emp);
		dos.close();
	}
	
	//�����л�
	public static void reseri(String destPath) throws IOException, ClassNotFoundException {
		//����Դ
		File src = new File(destPath);
		//ѡ����
		ObjectInputStream dis = new ObjectInputStream(
					new BufferedInputStream(
								new FileInputStream(src)
							)
				);
		//��������ȡ��˳�������д��һ�� ������ڲ��ܶ�ȡ
		Object obj = dis.readObject();
		if(obj instanceof Employee) {
			Employee emp = (Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}
		
		dis.close();
	}
}
