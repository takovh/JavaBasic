package cn.zhang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����ResultSet������Ļ����÷�
 * @author tako_
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","111111");
			
			String sql = "select * from t_user where id>?";//?ռλ��
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 2);
			rs = ps.executeQuery();
			while(rs.next()) System.out.println(rs.getObject(1)+"."+rs.getObject(2)+""+rs.getObject(3));

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
				if(ps!=null) ps.close();
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
