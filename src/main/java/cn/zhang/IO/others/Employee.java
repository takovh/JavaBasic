package cn.zhang.IO.others;

/**
 * java.io.Serializable �սӿڣ�ֻ��Ϊ��ʶ
 * @author tako_
 *
 */
public class Employee implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����Ҫ���л�
	private transient String name;
	private double salary;
	public Employee() {}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
