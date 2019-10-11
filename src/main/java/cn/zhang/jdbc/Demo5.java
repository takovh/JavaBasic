package cn.zhang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����������Ļ����÷�
 * @author tako_
 *
 */
public class Demo5 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","111111");
			conn.setAutoCommit(false);//�������ùر��Զ��ύ
			stmt = conn.createStatement();
			long start = System.currentTimeMillis();
			for(int i=0;i<20000;i++) {
				stmt.addBatch("insert into t_user(username,pwd,regTime) values('zhang"+i+"',666666,now())");
			}
			stmt.executeBatch();
			conn.commit();//�ύ����
			long end = System.currentTimeMillis();
			System.out.println("����20000�����ݺ�ʱ��" + (end-start) + "ms");
		} catch (ClassNotFoundException e) {
			System.err.println("���ݿ����ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر�˳����ѭ��resultSet-->statement-->connection��������һ��Ҫ�ֿ�д
			try {
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
