package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AffiliationDAO {
	final private static String dbname = "surplus"; // データベース名
	final private static String user = "surpuser"; // アクセスできるユーザ
	final private static String password = "hogehoge"; // wspuserのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;

	public boolean check(String accountID, String groupID) {//重複チェックメソッド
		boolean result = false;
		Connection connection = null;
		String sql = "select * from affiliation where accountid=? and groupid=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			pstmt.setString(2, groupID);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
			resultSet.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//クローズ処理
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int getLength() {
		int length = 0;
		Connection connection = null;
		String sql = "select * from affiliation";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				length++;
			}
			resultSet.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//クローズ処理
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return length;
	}

	public void addAffiliation(String accountID, String groupID) {
		Connection connection = null;
		String sql = "insert into affiliation values(?,?,?,0,false)";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, this.getLength() + 1);
			pstmt.setString(2, accountID);
			pstmt.setString(3, groupID);

			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//クローズ処理
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
