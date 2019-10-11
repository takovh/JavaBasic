package cn.zhang.IO.file;

import java.io.File;

/**
 * ������ＶĿ¼|�ļ�������(����·��)
 * 1.listFiles
 * 2.�ݹ�
 * @author tako_
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path = "D:/tmp";
		File parent = new File(path);
		printName(parent);
	}
	
	//���·��
	public static void printName(File src) {
		if(null==src||!src.exists()) return;
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()) for(File sub:src.listFiles()) printName(sub);
	}
}
