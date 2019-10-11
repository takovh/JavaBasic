package cn.zhang.sort.referenceType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * ʹ��Collections
 * @author tako_
 *
 */
public class NewsItemApp {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("���չ��ѵ��ˣ�����",100,new Date()));
		news.add(new NewsItem("�����ѵ��ˣ�����",200,new Date(System.currentTimeMillis()-1000*60*60)));
		news.add(new NewsItem("���չ�ǻ�ˣ�����",90,new Date(System.currentTimeMillis()-1000*60*60)));
		System.out.println("����ǰ��\n"+news);
		
		Collections.sort(news);
		System.out.println("�����\n"+news);
	}
}
