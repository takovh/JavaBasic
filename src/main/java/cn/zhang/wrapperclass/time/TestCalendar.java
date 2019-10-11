package cn.zhang.wrapperclass.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ����Calendar���ʹ��
 * Calendar�ǳ�����
 * GregorianCalendar����������
 * @author ����
 *
 */
public class TestCalendar {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.MONTH, Calendar.OCTOBER);
		c.set(2018, Calendar.NOVEMBER, 1);
		c.setTime(new Date(1234567890123L));
		
		Date d = c.getTime();
		System.out.println(d);
		System.out.println("һ��ĵ�"+c.get(Calendar.WEEK_OF_YEAR)+"��");
		
		c.add(Calendar.DAY_OF_YEAR, 78);
		
		d = c.getTime();
		System.out.println(d);
		System.out.println("һ��ĵ�"+c.get(Calendar.WEEK_OF_YEAR)+"��");
		
	}
}
