package cn.zhang.collection.others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties������ļ�
 * Ҳ������Դ�����ļ���
 * 1. .properties
 * store(out, comments)
 * 
 * 2. .xml 
 * storeToXML(os, comment)
 * 
 * @author tako_
 *
 */
public class PropertiesDomo02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//��������
		Properties pro = new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user","Scott");
		pro.setProperty("pwd","123");
		
		//ʹ�þ���·��,�����d:/tmp
		//pro.store(new FileOutputStream(new File("d:/tmp/db.properties")), "db����");
		//pro.storeToXML(new FileOutputStream(new File("d:/tmp/db.properties")), "db����");
		
		//ʹ�����·��,�������ǰ����
		pro.store(new FileOutputStream(new File("src/cn/zhang/collection/others/db.properties")), "db����");
		pro.storeToXML(new FileOutputStream(new File("src/cn/zhang/collection/others/db.xml")), "db����");
	}
}
