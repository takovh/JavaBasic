package cn.zhang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * ����ʱ�䴦��java.sql.Date,Time,Timestamp����ȡ��ָ��ʱ��ε�����
 * @author tako_
 *
 */
public class Demo8 {
	public static void main(String[] args) throws InterruptedException, ParseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","111111");
			ps = conn.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime<? order by lastLoginTime");
			
			java.sql.Timestamp start = new java.sql.Timestamp(str2Date("2019-1-8 10:00:00"));
			java.sql.Timestamp end = new java.sql.Timestamp(str2Date("2019-1-8 13:00:00"));
			ps.setObject(1,start);
			ps.setObject(2,end);
			rs = ps.executeQuery();
			while(rs.next()) System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getTimestamp("lastLoginTime"));;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("���ݿ����ʧ��");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
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
	/**
	 * ���ַ������������תΪlong���֣���ʽ��yyyy-MM-dd hh:mm:ss��
	 * @param dateString
	 * @return
	 * @throws ParseException 
	 */
	private static long str2Date(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.parse(dateString).getTime();
	}
}
