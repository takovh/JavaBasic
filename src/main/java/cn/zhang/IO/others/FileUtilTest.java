package cn.zhang.IO.others;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtilTest {
	public static void main(String[] args) throws IOException {
		byte[] data = getByteFromFile("D:/tmp/a.txt");//1.�ļ�1 --����--> �ֽ�����
		System.out.println(data);
	}
	/**
	 * 1.�ļ� --����--> �ֽ�����
	 * @return
	 * @throws IOException 
	 */
	public static byte[] getByteFromFile(String srcPath) throws IOException {
		//1.�����ļ�Դ
		File src = new File(srcPath);
		//�����ֽ�����Ŀ�ĵ�
		byte[] dest = null;
		
		//2.ѡ�������ļ������� + �ֽ����������
		//�ļ�������
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		//�ֽ��������������ʹ�ö�̬
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		//3.���� ���϶�ȡ�ļ� д�����ֽ���������
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			//д�����ֽ���������
			baos.write(flush, 0, len);
		}
		baos.flush();
		
		//4.��ȡ����
		dest = baos.toByteArray();
		FileUtil.close(baos,is);
		return dest;
	}
}
