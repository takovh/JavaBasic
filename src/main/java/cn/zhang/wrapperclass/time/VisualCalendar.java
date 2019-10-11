package cn.zhang.wrapperclass.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ���ӻ���������
 * @author ����
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("���������ڣ���yyyy-MM-dd)");
		Scanner s = new Scanner(System.in);//��������ΪSC����������ɨ���ǣ�Scanner�����Ӷ�����������ڴ�
		String test = s.nextLine();
		s.close();//ʹ��Scanner�󣬽������������ͷ��ڴ�	
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
		try {
			Date d = df.parse(test);//��StringתΪDate
			Calendar c = new GregorianCalendar();
			c.setTime(d);//��Date��ʽ��Ϊ����
			int day = c.get(Calendar.DATE);
			
			c.set(Calendar.DATE, 1);
			int day_of_week = c.get(Calendar.DAY_OF_WEEK);//Calendar.SUNDAY;������1
			int max_days_in_month = c.getActualMaximum(Calendar.DATE);
			
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
			for(int i = 1;i<day_of_week;i++) System.out.print("\t");
			for(int i = 1;i<=max_days_in_month;i++) {
				if(i == day) System.out.print("*");
				System.out.print(i+"\t");
				int w = c.get(Calendar.DAY_OF_WEEK);
				if(w == Calendar.SATURDAY) System.out.print('\n');
				c.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
