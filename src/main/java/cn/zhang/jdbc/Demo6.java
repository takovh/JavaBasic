package cn.zhang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��������Ļ���������÷�
 * @author tako_
 *
 */
public class Demo6 {
	public static void main(String[] args) throws InterruptedException {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","111111");
			conn.setAutoCommit(false);//JDBCĬ��true,���Զ��ύ����
			
			ps1 = conn.prepareStatement("insert into t_user(username,pwd) values(?,?)");
			ps1.setObject(1, "����");
			ps1.setObject(2, 123456);
			ps1.execute();
			System.out.println("����һ����¼������");
			
			Thread.sleep(3000);
			ps2 = conn.prepareStatement("insert into t_user(username,pwd) values(?,?,?)");
			ps2.setObject(1, "����");
			ps2.setObject(2, 123456);
			ps2.execute();
			System.out.println("����һ����¼������");
			
			conn.commit();//�ύ����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("���ݿ����ʧ��");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.err.println("����ع��С�����");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(ps1!=null) ps1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ps2!=null) ps2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
