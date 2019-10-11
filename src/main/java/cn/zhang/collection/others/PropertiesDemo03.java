package cn.zhang.collection.others;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties��ȡ�����ļ�
 * ��Դ�����ļ���
 * load(inStream)
 * @author tako_
 *
 */
public class PropertiesDemo03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//��ȡ���·��
		pro.load(new FileReader("src/cn/zhang/collection/others/db.properties"));
		System.out.println(pro.getProperty("user","default"));
	}
}
