package cn.zhang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����PreparedStatement�Ļ����÷�
 * ps.setObject(parameterIndex, x);
 * @author tako_
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","111111");
			
			String sql = "insert into t_user(username,pwd,regTime) values(?,?,?)";//?ռλ��
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, "Mary");//����������1��ʼ
//			ps.setString(2, "258");
//			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			
			ps.setObject(1, "Mike");//����������1��ʼ
			ps.setObject(2, "369");
			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			//����һ�м�¼
			//ps.execute();
			int count = ps.executeUpdate();
			System.out.println("count=" + count);
		} catch (ClassNotFoundException e) {
			System.err.println("���ݿ����ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
