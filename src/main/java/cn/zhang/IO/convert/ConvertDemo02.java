package cn.zhang.IO.convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * ת�������ֽ�ת�ַ�
 * 1.����� OutputStreamWriter ->����
 * 2.������ InputStreamReader ->����
 * @author tako_
 * 
 */
public class ConvertDemo02 {
	public static void main(String[] args) throws IOException {
		//ָ�������ַ���
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("D:/tmp/c.txt")),"utf-8"
						)
				);
				
		String info = null;
		while(null!=(info=br.readLine())) System.out.println(info);
		br.close();
	}
}
