package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ScheduleManager {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public void login(HttpServletRequest request, HttpServletResponse response) {
		//sessionにscheduleListを設定する
		ScheduleDAO dao = new ScheduleDAO();
		HttpSession session = request.getSession();
		ArrayList<Date> dateList = null;
		String dateString = "";
		//dateListの取得
		dateList = dao.getDateList(((Group) session.getAttribute("group")).getGroupID());
		for (int i = 0; i < dateList.size(); i++) {
			if (i != 0) {
				dateString += ",";
			}
			dateString += dateFormat.format(dateList.get(i));
		}
		session.setAttribute("dateList", dateString);
		ArrayList<Schedule> scheduleList = null;
		scheduleList = dao.getScheduleList(((Group) session.getAttribute("group")).getGroupID());
		session.setAttribute("scheduleList", scheduleList);

	}

	public String putSchedule(HttpServletRequest request, HttpServletResponse response) {
		ScheduleDAO dao = new ScheduleDAO();
		AttendanceDAO adao = new AttendanceDAO();
		Schedule schedule = new Schedule();
		HttpSession session = request.getSession();
		String groupID = ((Group) session.getAttribute("group")).getGroupID();
		Date date = null;
		try {
			date = new java.sql.Date((dateFormat.parse(request.getParameter("date"))).getTime());
			schedule.setGroupID(groupID);
			schedule.setName(request.getParameter("scheduleName"));
			schedule.setDate(date);
			schedule.setStartTime(new java.sql.Time(timeFormat.parse(request.getParameter("startTime")).getTime()));
			schedule.setEndTime(new java.sql.Time(timeFormat.parse(request.getParameter("endTime")).getTime()));
			schedule.setLocation(request.getParameter("location"));
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		dao.putSchedule(schedule.getGroupID(), schedule.getName(), schedule.getDate(), schedule.getStartTime(),
				schedule.getEndTime(), schedule.getLocation());
		adao.initAttendance(groupID, dao.getScheduleID(groupID, date));
		this.login(request, response);
		return "/calendar.jsp";
	}

	public void setSchedule(HttpServletRequest request, HttpServletResponse response) {
		ScheduleDAO dao = new ScheduleDAO();
		HttpSession session = request.getSession();
		String groupID = ((Group) session.getAttribute("group")).getGroupID();
		Schedule schedule = null;
		Date date = null;
		try {
			date = new java.sql.Date((dateFormat.parse(request.getParameter("date"))).getTime());
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		schedule = dao.getSchedule(groupID, date);
		request.setAttribute("startTime", timeFormat.format(schedule.getStartTime()));
		request.setAttribute("endTime", timeFormat.format(schedule.getEndTime()));
		request.setAttribute("schedule", schedule);
	}
}
