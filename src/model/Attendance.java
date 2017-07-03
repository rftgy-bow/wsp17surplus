package model;

import java.io.Serializable;

public class Attendance implements Serializable {
	private int attendanceID;
	private String scheduleID;
	private String accountID;
	private int attendTime;
	private int leaveTime;
	private int absenceType;
	private String reason;

	public int getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(int attendanceID) {
		this.attendanceID = attendanceID;
	}

	public String getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public int getAttendTime() {
		return attendTime;
	}

	public void setAttendTime(int attendTime) {
		this.attendTime = attendTime;
	}

	public int getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(int leaveTime) {
		this.leaveTime = leaveTime;
	}

	public int getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(int absenceType) {
		this.absenceType = absenceType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
