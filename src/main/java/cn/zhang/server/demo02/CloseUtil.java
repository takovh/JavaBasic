package cn.zhang.server.demo02;

import java.io.Closeable;
import java.io.IOException;

/**
 * ������ر���
 * �ɱ������ ... ֻ�ܷ����βε����һ��λ��,����ʽ������һ��
 * @author tako_
 *
 */
public class CloseUtil {
	public static void closeIO(Closeable ... io) {
		for(Closeable temp:io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void closeSocket(Closeable ... Socket) {
		for(Closeable temp:Socket) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void closeall(Closeable ... io) {
		for(Closeable temp:io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
