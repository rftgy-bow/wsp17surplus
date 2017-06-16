package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	final private static String dbname = "tutorial";   // データベース名
	final private static String user = "wspuser";      // tutorialにアクセスできるユーザ
	final private static String password = "hogehoge"; // wspuserのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;

	public boolean check(Member member) throws SQLException {
		// memberがDBにあるかどうかを調べる
		boolean result = false;
		Connection connection;
		String sql = "select * from member where name=? and pass=?";

		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPass());

			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) result = true;

			resultSet.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}