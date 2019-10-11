package cn.zhang.sort.referenceType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������Ŀ��ʵ����
 * @author tako_
 *
 */
public class NewsItem implements java.lang.Comparable<NewsItem> {
	//����
	private String title;
	//�����
	private int hits;
	//ʱ��
	private Date publicTime;
	public String getTitle() {
		return title;
	}
	
		
	public NewsItem() {
		
	}
	
	public NewsItem(String title, int hits, Date publicTime) {
		super();
		this.title = title;
		this.hits = hits;
		this.publicTime = publicTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}

	//ʱ�併��+���������+���⽵��
	@Override
	public int compareTo(NewsItem o) {
		// TODO Auto-generated method stub
		int result = 0;
		//�Ƚ�ʱ��
		result = -this.publicTime.compareTo(o.publicTime);//����
		if(0==result) {//ʱ����ͬ
			//�Ƚϵ����
			result = this.hits - o.hits;//����
			if(0==result) {//�������ͬ
				//�Ƚϱ���
				result = -this.title.compareTo(o.title);//����
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("���⣺").append(this.title).append(", ");
		sb.append("ʱ�䣺").append(new SimpleDateFormat("MM-dd HH:mm:ss").format(this.publicTime)).append(", ");
		sb.append("�������").append(this.hits).append("\n");
		return sb.toString();
	}
	
}
