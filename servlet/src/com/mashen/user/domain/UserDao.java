package com.mashen.user.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mashen.user.domain.MysqlConnectionFactory;
import com.mashen.user.domain.User;

public class UserDao {
	

	private String insertSql = "insert into user(account,nickName,password,age,sex,headImage) values(?,?,?,?,?,?)";

	public void add(User us) {
		Connection conn = null;
		try {

			conn = MysqlConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(insertSql);
			ps.setString(1, us.getAccount());
			ps.setString(2, us.getNickName());
			ps.setString(3, us.getPassword());
			ps.setInt(4, us.getAge());
			ps.setString(5, us.getSex());
			ps.setString(6, us.getHeadImage());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlConnectionFactory.close(conn);
		}
	}

	private String getSqlString = "select account,nickName,password,age,sex,headImage from user where id=?";

	public User get(int id) {
		Connection conn = null;
		User user = null;
		try {
			conn = MysqlConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(getSqlString);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setAccount(rs.getString("account"));
				user.setNickName(rs.getString("nickName"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setHeadImage(rs.getString("headImage"));
				return user;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlConnectionFactory.close(conn);
		}
		return user;
	}
}
