package cn.zhang.IO.others;

import java.io.Closeable;
import java.io.IOException;

/**
 * ������ر���
 * �ɱ������ ... ֻ�ܷ����βε����һ��λ��,����ʽ������һ��
 * @author tako_
 *
 */
public class FileUtil {
	public static void close(Closeable ... io) {
		for(Closeable temp:io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
