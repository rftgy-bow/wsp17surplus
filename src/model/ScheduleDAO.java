package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Properties;

public class ScheduleDAO {
	private static String filename = "db.properties";
	private static String user; // アクセスできるユーザ
	private static String password; // wspuserのパスワード
	private static String driverClassName;
	private static String url;

	public ScheduleDAO() {
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

	public void putSchedule(String groupID, String name, Date date, Time startTime, Time endTime, String location) {
		Connection connection = null;
		String sql = "insert into schedule values(nextval('schedule_scheduleID_seq'),?,?,?,?,?,?)";
		//GroupIDとNameの重複をチェックする
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, groupID);
			pstmt.setString(2, name);
			pstmt.setDate(3, date);
			pstmt.setTime(4, startTime);
			pstmt.setTime(5, endTime);
			pstmt.setString(6, location);
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

	public ArrayList<Date> getDateList(String groupID) {
		//groupIDから取得したscheduleをdateで並び替えて返す
		ArrayList<Date> dateList = new ArrayList<Date>();
		Connection connection = null;
		String sql = "select * from schedule where groupid=? order by date ASC";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, groupID);
			pstmt.executeQuery();
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				dateList.add(resultSet.getDate("date"));
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
		return dateList;
	}
}
