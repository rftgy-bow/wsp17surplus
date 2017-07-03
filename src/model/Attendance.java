package model;

import java.io.Serializable;
import java.sql.Time;

public class Attendance implements Serializable {
	private int attendanceID;
	private String accountID;
	private String groupID;
	private int scheduleID;
	private String absenceType;
	private String reason;
	private Time attendTime;
	private Time leaveTime;

	public int getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(int attendanceID) {
		this.attendanceID = attendanceID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(String absenceType) {
		this.absenceType = absenceType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Time getAttendTime() {
		return attendTime;
	}

	public void setAttendTime(Time attendTime) {
		this.attendTime = attendTime;
	}

	public Time getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Time leaveTime) {
		this.leaveTime = leaveTime;
	}
}
