package cn.zhang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����ִ��sql��䣬�Լ�sqlע������
 * @author tako_
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","111111");
			Statement stmt = conn.createStatement();
			String sql = "insert into t_user(username,pwd,regTime) values('����',147,now())";
			//����sqlע��
			//String id = "5 or 1=1"
			//String sql = "delete from t_test where id="+id;
			stmt.execute(sql);
		} catch (ClassNotFoundException e) {
			System.err.println("���ݿ����ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
