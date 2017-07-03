package model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AttendanceManager {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public void checkAttendance(HttpServletRequest request, HttpServletResponse response) {
		AttendanceDAO dao = new AttendanceDAO();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Schedule schedule = (Schedule) request.getAttribute("schedule");
		if (dao.check(account.getAccountID(), schedule.getScheduleID())) {
			Attendance attendance = dao.getAttendance(account.getAccountID(), schedule.getScheduleID());
			request.setAttribute("attendTime", timeFormat.format(attendance.getAttendTime()));
			request.setAttribute("leaveTime", timeFormat.format(attendance.getLeaveTime()));
			request.setAttribute("attendance", attendance);
		}
	}

	public void initAttendance(HttpServletRequest request, HttpServletResponse response) {
		AttendanceDAO dao = new AttendanceDAO();
		HttpSession session = request.getSession();
		Group group = (Group) session.getAttribute("group");
		Schedule schedule = (Schedule) request.getAttribute("schedule");
		dao.initAttendance(group.getGroupID(), schedule.getScheduleID());
	}

	public String putAttendance(HttpServletRequest request, HttpServletResponse response) {
		AttendanceDAO dao = new AttendanceDAO();
		ScheduleDAO sdao = new ScheduleDAO();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Group group = (Group) session.getAttribute("group");
		String date = request.getParameter("date");
		String absenceType = request.getParameter("absenceType");
		session.setAttribute("absenceType", absenceType);
		String reason = request.getParameter("reason");
		Time attendTime = null;
		Time leaveTime = null;
		int scheduleID = 0;
		try {
			scheduleID = sdao.getScheduleID(group.getGroupID(), new java.sql.Date((dateFormat.parse(date)).getTime()));
			attendTime = new java.sql.Time((timeFormat.parse(request.getParameter("attendTime")).getTime()));
			leaveTime = new java.sql.Time((timeFormat.parse(request.getParameter("leaveTime")).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.putAttendance(account.getAccountID(), group.getGroupID(), scheduleID, absenceType, reason, attendTime,
				leaveTime);
		return "/calendar.jsp";
	}

	public String updateAttendance(HttpServletRequest request, HttpServletResponse response) {
		AttendanceDAO dao = new AttendanceDAO();
		ScheduleDAO sdao = new ScheduleDAO();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Group group = (Group) session.getAttribute("group");
		String date = request.getParameter("date");
		String absenceType = request.getParameter("absenceType");
		session.setAttribute("absenceType", absenceType);
		String reason = request.getParameter("reason");
		Time attendTime = null;
		Time leaveTime = null;
		int scheduleID = 0;
		try {
			scheduleID = sdao.getScheduleID(group.getGroupID(), new java.sql.Date((dateFormat.parse(date)).getTime()));
			attendTime = new java.sql.Time((timeFormat.parse(request.getParameter("attendTime")).getTime()));
			leaveTime = new java.sql.Time((timeFormat.parse(request.getParameter("leaveTime")).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.updateAttendance(account.getAccountID(), scheduleID, absenceType, reason, attendTime, leaveTime);
		return "/calendar.jsp";
	}

	public String jumpTimeline(HttpServletRequest request, HttpServletResponse response) {
		//dateとgroupIDからSchedule探してきてScheduleIDからattendaceリストをsessionに登録
		AttendanceDAO dao = new AttendanceDAO();
		ScheduleDAO sdao = new ScheduleDAO();
		HttpSession session = request.getSession();
		Group group = (Group) session.getAttribute("group");
		String date = request.getParameter("date");
		int scheduleID = 0;
		try {
			scheduleID = sdao.getScheduleID(group.getGroupID(),
					new java.sql.Date((dateFormat.parse(date)).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<Attendance> alist = dao.getAttendanceList(scheduleID);
		request.setAttribute("attendanceList", alist);
		return "/timeline.jsp";
	}

	public void setAllAttendanceList(HttpServletRequest request, HttpServletResponse response) {
		AttendanceDAO dao = new AttendanceDAO();
		HttpSession session = request.getSession();
		ArrayList<ArrayList<Attendance>> aalist = new ArrayList<ArrayList<Attendance>>();
		ArrayList<Schedule> slist = null;
		slist = (ArrayList<Schedule>) session.getAttribute("scheduleList");
		for (Schedule s : slist) {
			aalist.add(dao.getAttendanceList(s.getScheduleID()));
		}
		session.setAttribute("allAttendanceList", aalist);
	}
}
