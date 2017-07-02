package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AccountDAO {
	private static String filename = "db.properties";
	private static String user; // アクセスできるユーザ
	private static String password; // wspuserのパスワード
	private static String driverClassName;
	private static String url;

	public AccountDAO() {
		Properties props = new Properties();
		try {
			props.load(getClass().getClassLoader().getResourceAsStream(filename));
			user = props.getProperty("user");
			password = props.getProperty("password");
			driverClassName = props.getProperty("driverClassName");
			url = props.getProperty("url");
		} catch (IOException e) {
			System.out.println("Warning: " + filename + " is not found.");
		}
	}

	public boolean check(String accountID, String accountPass) {
		// accountがDBにあるかどうかを調べる
		boolean result = false;
		Connection connection = null;
		String sql = "select * from account where accountid=? and pass=?";

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

	public Account login(String accountID, String accountPass) {
		//DBからアカウント情報を取得しそれを返す
		Account account = null;
		Connection connection = null;
		String sql = "select *from account where accountID=? and pass=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			pstmt.setString(2, accountPass);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				account = new Account();
				account.setAccountID(accountID);
				account.setPass(accountPass);
				account.setUserName(resultSet.getString("userName"));
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
		return account;
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
