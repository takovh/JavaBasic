package cn.takovh.javaBasic.c_02_OOP.polymorphism.test03;

public class Student extends Person{
	public String name;//父类拥有的字段
	public Person headTeacher;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(Person headTeacher, String name) {
//		this.headTeacher.name = headTeacher.name; //构造失败
		this.headTeacher = headTeacher;//由于共有字段问题，构造失败this.headTeacher=null
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student{" +
				"stu.name='" + name + '\'' +
				", headTeacher.name='" + headTeacher.name + '\'' +
				'}';
	}
   
}
