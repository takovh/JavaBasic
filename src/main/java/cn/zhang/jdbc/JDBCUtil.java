package cn.zhang.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static Properties pros = null;//���԰�����ȡ�ʹ�����Դ�ļ��е���Ϣ
	static {//����JDBCUtil���ʱ��ʹ��
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getMysqlConn() {
		//����������
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			//��������
			return DriverManager.getConnection(pros.getProperty("mysqlURL"),pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	//�ر�˳����ѭ��resultSet-->statement-->connection��������һ��Ҫ�ֿ�д
	public static void close(ResultSet rs, Statement ps, Connection conn) {
		try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public static void close(Statement ps, Connection conn) {
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
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
