package cn.zhang.IO.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * ���÷���
 * 1.�ļ���
 * 2.�ж���Ϣ
 * 3.�����ֽ��������ܶ�ȡ�ļ��еĳ��ȣ�
 * 4.������ɾ���ļ�
 * 5.����Ŀ¼
 * @author tako_
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//test01();
		//test02();
		/*try {
			test03();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//test04();
		test05();
	}
	
	//�ļ���
	public static void test01() {
		File src = new File("D:/tmp/1.jpg");
		System.out.println(src.getName());//��������
		System.out.println(src.getPath());//����Ǿ���·������������·�������򷵻����·��
		System.out.println(src.getAbsolutePath());//���ؾ���·��
		System.out.println(src.getParent());//������һ��Ŀ¼���������ԣ�����null
	}
	
	//�ж���Ϣ
	public static void test02() {
		String parentPath = "D:/tmp";
		String name = "1.jpg";
		System.out.println("********���ļ�********");
		File src = new File(parentPath,name);
		System.out.println("�ļ��Ƿ���ڣ�" + src.exists());
		System.out.println("���ļ��У�" + src.isDirectory());
		System.out.println("���ļ���" + src.isFile());
		System.out.println("����Ϊ��" + src.length());
		
		System.out.println("********���ļ���********");
		src = new File(parentPath);
		System.out.println("�ļ��Ƿ���ڣ�" + src.exists());
		System.out.println("�ļ��Ƿ��д��" + src.canWrite());
		System.out.println("���ļ��У�" + src.isDirectory());
		System.out.println("���ļ���" + src.isFile());
		System.out.println("����Ϊ��" + src.length());
	}
	
	//������ɾ���ļ�
	public static void test03() throws IOException, InterruptedException {
		String path = "D:/tmp/1.jpg";
		File src = new File(path);
		
		//�����ļ�
		if(!src.exists()) {
			boolean flag = src.createNewFile();
			System.out.println(flag?"�����ɹ���":"����ʧ�ܣ�");
		}
		
		//ɾ���ļ�
		boolean flag = src.delete();
		System.out.println(flag?"ɾ���ɹ���":"ɾ��ʧ�ܣ�");
		
		//������ʱ�ļ�
		//static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp)Ĭ����ʱ�ռ�
		//static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp��Ŀ¼��
		File temp = File.createTempFile("tes", ".temp" ,new File("D:/tmp"));
		Thread.sleep(10000);
		temp.deleteOnExit();
	}
	
	//�ļ��в���
	public static void test04() {
		String path1 = "D:/tmp/test";
		File src = new File(path1);
		src.mkdir();//��Ŀ¼�����ڻᴴ��ʧ��
		src.mkdirs();//��Ŀ¼��������Ҳ��һͬ����
	}
	
	//�ļ��б� [�ļ�|�ļ���]
	public static void test05() {
		String path = "D:/tmp";
		File src = new File(path);
		if(src.isDirectory()) {
			String[] subNames = src.list();
			for(String temp:subNames) System.out.println(temp);
		}
		
		System.out.println("======��Ŀ¼|�ļ�File����======");
		File[] subFiles = src.listFiles();
		for(File temp:subFiles) System.out.println(temp.getAbsolutePath());
				
		System.out.println("======���ļ�.mp3����======");
		//�������ģʽ
		subFiles = src.listFiles(new FilenameFilter() {
			@Override
			//dir����src
			public boolean accept(File dir, String name) {
				return new File(dir,name).isFile()&&name.endsWith(".mp3");
			}
		});
		for(File temp:subFiles) System.out.println(temp.getAbsolutePath());
	}
}
