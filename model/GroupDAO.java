package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupDAO {
	final private static String dbname = "surplus"; // データベース名
	final private static String user = "surpuser"; // アクセスできるユーザ
	final private static String password = "hogehoge"; // wspuserのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;

	public void createGroup(String groupID, String groupName, String groupTag) {
		Connection connection = null;
		String sql = "insert into groups values(?,?,?)";
		//GroupIDとNameの重複をチェックする
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, groupID);
			pstmt.setString(2, groupName);
			pstmt.setString(3, groupTag);
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

	public boolean findByID(String groupID) {
		boolean result = false;
		Connection connection = null;
		String sql = "select * from groups where groupID=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, groupID);
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

	public boolean findByName(String groupName) {
		boolean result = false;
		Connection connection = null;
		String sql = "select * from groups where groupName=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, groupName);
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

	public ArrayList<Group> searchByName(String groupName) {
		ArrayList<Group> groupList = new ArrayList<Group>();
		Connection connection = null;
		String sql = "select * from groups where groupname like ?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + groupName + "%");
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Group cache = new Group();
				cache.setGroupID(resultSet.getString("groupid"));
				cache.setGroupName(resultSet.getString("groupname"));
				cache.setGroupTag(resultSet.getString("grouptag"));
				groupList.add(cache);
			}
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
		return groupList;
	}
}
