package cn.zhang.IO.file;

import java.io.File;

/**
 * ����������
 * 1.·���ָ���
 * 2.���Ʒָ���
 * 
 * ���·�������·������File����
 * @author tako_
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//·����ʾ��ʽ
		String path = "D:\\tmp\\1.jpg";//ת���ַ�����
		path = "D:" + File.separator + "tmp" + File.separator + "1.jpg";//��ƽ̨
		path = "D:/tmp/1.jpg";//�Ƽ���ʽ���滻Ϊ/
		System.out.println(path);
		
		String parentPath = "D:/tmp";
		String name = "1.jpg";
		//���·��
		File src = new File(parentPath,name);
		src = new File(new File(parentPath),name);
		//���
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//����·��
		src = new File("D:/tmp/1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//û���̷�����user.dir����
		src = new File("1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}
}
