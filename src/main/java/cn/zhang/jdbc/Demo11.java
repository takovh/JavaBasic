package cn.zhang.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ����ʹ��JDBCUtil����JDBC����
 * @author tako_
 *
 */
public class Demo11 {
	public static void main(String[] args) throws InterruptedException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getMysqlConn();
			ps = conn.prepareStatement("insert into t_user(username,pwd,regTime) values(?,?,?)");
			ps.setObject(1, "Mike");//����������1��ʼ
			ps.setObject(2, "369");
			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
	}
}
