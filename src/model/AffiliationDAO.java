package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class AffiliationDAO {
	private static String filename = "db.properties";
	private static String user; // アクセスできるユーザ
	private static String password; // wspuserのパスワード
	private static String driverClassName;
	private static String url;

	public AffiliationDAO() {
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

	public Affiliation login(String accountID) {//メインに指定している団体を取得
		Affiliation affiliation = null;
		Connection connection = null;
		String sql = "select * from affiliation where accountid=? and ismain=true";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				affiliation = new Affiliation();
				affiliation.setAffiliationID(resultSet.getInt("affiliationid"));
				affiliation.setAccountID(accountID);
				affiliation.setGroupID(resultSet.getString("groupid"));
				affiliation.setRole(resultSet.getString("role"));
				affiliation.setIsMain(true);
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
		return affiliation;
	}

	public Affiliation getAffiliation(String accountID, String groupID) {
		Affiliation affiliation = null;
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
				affiliation = new Affiliation();
				affiliation.setAffiliationID(resultSet.getInt("affiliationid"));
				affiliation.setAccountID(accountID);
				affiliation.setGroupID(groupID);
				affiliation.setRole(resultSet.getString("role"));
				affiliation.setIsMain(true);
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
		return affiliation;

	}

	public void addAffiliation(String accountID, String groupID, String role, boolean ismain) {
		Connection connection = null;
		String sql = "insert into affiliation values(nextval('affiliation_affiliationID_seq'),?,?,?,?)";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			pstmt.setString(2, groupID);
			pstmt.setString(3, role);
			pstmt.setBoolean(4, ismain);

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

	public void deleteAffiliation(String accountID, String groupID) {
		Connection connection = null;
		String sql = "delete from affiliation where accountid =? and groupID =?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			pstmt.setString(2, groupID);

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

	public ArrayList<Affiliation> getAffiliationList(String accountid) {
		ArrayList<Affiliation> list = new ArrayList<Affiliation>();
		Connection connection = null;
		String sql = "select * from affiliation where accountid =?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountid);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Affiliation cache = new Affiliation();
				cache.setAffiliationID(resultSet.getInt("affiliationid"));
				cache.setAccountID(resultSet.getString("accountid"));
				cache.setGroupID(resultSet.getString("groupid"));
				cache.setRole(resultSet.getString("role"));
				cache.setIsMain(resultSet.getBoolean("ismain"));
				list.add(cache);
			}
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
		return list;
	}

	public ArrayList<Affiliation> getMemberList(String groupid) {
		ArrayList<Affiliation> list = new ArrayList<Affiliation>();
		Connection connection = null;
		String sql = "select * from affiliation where groupid =? ORDER BY affiliationid ASC";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, groupid);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Affiliation cache = new Affiliation();
				cache.setAffiliationID(resultSet.getInt("affiliationid"));
				cache.setAccountID(resultSet.getString("accountid"));
				cache.setGroupID(resultSet.getString("groupid"));
				cache.setRole(resultSet.getString("role"));
				cache.setIsMain(resultSet.getBoolean("ismain"));
				list.add(cache);
			}
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
		return list;
	}

	public void changeMainGroup(String accountID, String groupID) {
		Connection connection = null;
		String sql1 = "update affiliation set ismain = false where accountid=? and ismain = true";
		String sql2 = "update affiliation set ismain = true where accountid=? and groupid=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql1);
			pstmt.setString(1, accountID);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = connection.prepareStatement(sql2);
			pstmt.setString(1, accountID);
			pstmt.setString(2, groupID);
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
