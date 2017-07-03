package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Properties;

public class AttendanceDAO {
	private static String filename = "db.properties";
	private static String user; // アクセスできるユーザ
	private static String password; // wspuserのパスワード
	private static String driverClassName;
	private static String url;

	public AttendanceDAO() {
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

	public boolean check(String accountID, int scheduleID) {
		Connection connection = null;
		String sql = "select * from attendance where accountid=? and scheduleid=?";
		boolean result = false;
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			pstmt.setInt(2, scheduleID);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				result = true;
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
		return result;
	}

	public Attendance getAttendance(String accountID, int scheduleID) {
		Attendance attendance = new Attendance();
		Connection connection = null;
		String sql = "select * from attendance where accountid=? and scheduleid=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			pstmt.setInt(2, scheduleID);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				attendance.setAttendanceID(resultSet.getInt(1));
				attendance.setAccountID(resultSet.getString(2));
				attendance.setGroupID(resultSet.getString(3));
				attendance.setScheduleID(resultSet.getInt(4));
				attendance.setAbsenceType(resultSet.getString(5));
				attendance.setReason(resultSet.getString(6));
				attendance.setAttendTime(resultSet.getTime(7));
				attendance.setLeaveTime(resultSet.getTime(8));
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
		return attendance;
	}

	public void putAttendance(String accountID, String groupID, int scheduleID, String absenceType,
			String reason, Time attendTime, Time leaveTime) {
		Connection connection = null;
		String sql = "insert into attendance values(nextval('attendance_attendanceID_seq'),?,?,?,?,?,?,?)";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accountID);
			pstmt.setString(2, groupID);
			pstmt.setInt(3, scheduleID);
			pstmt.setString(4, absenceType);
			pstmt.setString(5, reason);
			pstmt.setTime(6, attendTime);
			pstmt.setTime(7, leaveTime);
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

	public void updateAttendance(String accountID, int scheduleID, String absenceType, String reason, Time attendTime,
			Time leaveTime) {
		Connection connection = null;
		String sql = "update attendance set absencetype=?, reason=?, attendtime=?, leavetime=? where accountid=? and scheduleid=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, absenceType);
			pstmt.setString(2, reason);
			pstmt.setTime(3, attendTime);
			pstmt.setTime(4, leaveTime);
			pstmt.setString(5, accountID);
			pstmt.setInt(6, scheduleID);
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

	public ArrayList<Attendance> getAttendanceList(int scheduleID) {
		ArrayList<Attendance> alist = new ArrayList<Attendance>();
		Connection connection = null;
		String sql = "select * from attendance where scheduleid=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, scheduleID);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Attendance cache = new Attendance();
				cache.setAttendanceID(resultSet.getInt("attendanceid"));
				cache.setAccountID(resultSet.getString("accountid"));
				cache.setGroupID(resultSet.getString("groupid"));
				cache.setScheduleID(scheduleID);
				cache.setAbsenceType(resultSet.getString("absencetype"));
				cache.setReason(resultSet.getString("reason"));
				cache.setAttendTime(resultSet.getTime("attendtime"));
				cache.setLeaveTime(resultSet.getTime("leavetime"));
				alist.add(cache);
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
		return alist;
	}

	public void initAttendance(String groupID, int scheduleID) {
		//scheduleIDのスケジュールにグループ全員の未登録を登録
		Connection connection = null;
		String sql1 = "select * from affiliation where groupid=?";
		String sql2 = "insert into attendance values(nextval('attendance_attendanceID_seq'),?,?,?,'未登録','','00:00','00:00')";
		ArrayList<String> accountIDList = new ArrayList<String>();
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql1);
			pstmt.setString(1, groupID);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				accountIDList.add(resultSet.getString("accountid"));
			}
			resultSet.close();
			pstmt.close();
			pstmt = connection.prepareStatement(sql2);
			for (int i = 0; i < accountIDList.size(); i++) {
				pstmt.setString(1, accountIDList.get(i));
				pstmt.setString(2, groupID);
				pstmt.setInt(3, scheduleID);
				pstmt.executeUpdate();
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
	}
}
