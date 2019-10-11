package cn.zhang.pattern.flyWeight;

/**
 * ��Ԫ��
 * @author tako_
 *
 */
public interface ChessFlyWeight {
	void setColor(String color);
	String getColor();
	void display(Coordinate c);
}


class ConcreteChess implements ChessFlyWeight {
	
	private String color;
	
	public ConcreteChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("������ɫ��" + color);
		System.out.println("����λ�ã�" + "(" + c.getX() + "," + c.getY() + ")");
	}
	
}