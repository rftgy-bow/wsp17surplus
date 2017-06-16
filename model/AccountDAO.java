package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
	final private static String dbname = "surplus"; // データベース名
	final private static String user = "surpuser"; // アクセスできるユーザ
	final private static String password = "hogehoge"; // wspuserのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;

	public boolean login(String accountID, String accountPass) {
		// accountがDBにあるかどうかを調べる
		boolean result = false;
		Connection connection = null;
		String sql = "select * from account where accountID=? and pass=?";

		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, accountID);
			pstmt.setString(2, accountPass);

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

	public boolean findByAccountID(String accountID) {
		boolean result = false;
		Connection connection = null;
		String sql = "select * from account where accountID=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, accountID);

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

	public void createAccount(String accountID, String accountPass, String userName) {
		Connection connection = null;
		String sql = "insert into account values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, accountID);
			pstmt.setString(2, accountPass);
			pstmt.setString(3, userName);

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

	public void deleteAccount(String accountID, String accountPass) {
		Connection connection = null;
		String sql = "delete from account where accountID=? and pass=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, accountID);
			pstmt.setString(2, accountPass);

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

	public void changePass(String accountID, String accountPass, String newPass) {
		Connection connection = null;
		String sql = "update account set pass=? where accountid=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, newPass);
			pstmt.setString(2, accountID);

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
