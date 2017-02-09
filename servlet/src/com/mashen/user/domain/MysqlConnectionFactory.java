package com.mashen.user.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionFactory {
	private String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=UTF-8";
	private String user = "root";
	private String password = "123456";

	private static MysqlConnectionFactory instance = new MysqlConnectionFactory();

	public static MysqlConnectionFactory getInstance() {
		return instance;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private MysqlConnectionFactory() {
		try {
//			 DriverManager.setLogWriter(new PrintWriter(System.out));
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(MysqlConnectionFactory.getInstance().getConnection());
	}

}
