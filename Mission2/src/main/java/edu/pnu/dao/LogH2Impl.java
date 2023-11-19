package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LogH2Impl implements LogInterface {

	private Connection con;

	public LogH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/Mission2", "sa", "abcd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addLog(String method, String sqlstring, boolean success) {
		PreparedStatement pst = null;
		String sql = "insert into dblog (method, sqlstring, success) values (?, ?, ?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, method);
			pst.setString(2, sqlstring);
			pst.setBoolean(3, success);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
