package cn.zhang.collection.map;

/**
 * javabean �洢����po bo vo ����setter��getter����������
 * @author tako_
 *
 */
public class Letter {
	private String name;//����
	private int count;//
	
	public Letter() {
		// TODO Auto-generated constructor stub
	}

	//������
	//alt+shift+s -->o
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public Letter(String name) {
		super();
		this.name = name;
		this.count = 0;
	}
	//setter��getter
	//alt+shift+s -->r -->Tab -->enter -->Shift+Tab -->enter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
