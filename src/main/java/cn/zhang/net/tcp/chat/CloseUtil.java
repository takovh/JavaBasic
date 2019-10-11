package cn.zhang.net.tcp.chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * ������ر���
 * �ɱ������ ... ֻ�ܷ����βε����һ��λ��,����ʽ������һ��
 * @author tako_
 *
 */
public class CloseUtil {
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
