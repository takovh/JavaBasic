package cn.zhang.collection.others;

import java.util.Properties;

/**
 * Properties��Դ�����ļ��Ķ�д
 * 1.key��valueֻ��Ϊ�ַ���
 * 2.�洢���ȡ
 * 	setProperty(key, value)
 * 	getProperty(key)
 * @author tako_
 *
 */
public class PropertiesDemo01 {
	public static void main(String[] args) {
		//��������
		Properties pro = new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user","Scott");
		pro.setProperty("pwd","123");
		
		//��ȡ
		String url = pro.getProperty("url","default");
		System.out.println(url);
		
	}
}
