package cn.zhang.wrapperclass.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * �����಻��ʵ������������new��ʵ����������
 * ������ֻ�������̳�
 * ���󷽷����뱻����ʵ��
 * DateFormat�ǳ�����,��Ҫ������SimpleDateFormat��ʵ��
 * ʱ�䣺yyyy-MM-dd hh:mm:ss
 * @author ����
 */
public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df0 = new SimpleDateFormat("yyyy��MM��dd��");
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date(System.currentTimeMillis());
		String [] str = {
				df0.format(d),//��Date����ʽת��Ϊ�ַ�����format�������ظö������ƶ���ʽ���ַ���
				df1.format(d) //��Date����ʽת��Ϊ�ַ�����format�������ظö������ƶ���ʽ���ַ���
		};
		for(String e : str) System.out.println(e);
		
		try {
			Date d0 = df0.parse(str[0]);//���ַ�������ʽת��ΪDate��һ��Ҫ��Ӧƥ��
			Date d1 = df1.parse(str[1]);//���ַ�������ʽת��ΪDate��һ��Ҫ��Ӧƥ��
			System.out.println(d0);
			System.out.println(d1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
