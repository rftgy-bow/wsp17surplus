package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;
import model.AffiliationManager;
import model.GroupManager;
import model.ScheduleManager;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	AccountManager accountManager;
	GroupManager groupManager;
	AffiliationManager affiliationManager;
	ScheduleManager scheduleManager;

	public Controller() {
		super();
		accountManager = new AccountManager();
		groupManager = new GroupManager();
		affiliationManager = new AffiliationManager();
		scheduleManager = new ScheduleManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String requestValue = "";
		requestValue = request.getParameter("req");
		String result = "";

		switch (requestValue) {
		default:
			result = "/login.jsp";
			break;
		case "login":
			result = accountManager.login(request, response);
			if (result == "/home.jsp") {
				affiliationManager.login(request, response);
				groupManager.login(request, response);
				scheduleManager.login(request, response);
			}
			break;
		case "logout":
			result = accountManager.logout(request, response);
			break;
		case "createAccount":
			result = accountManager.createAccount(request, response);
			break;
		case "editPassword":
			result = accountManager.editPassword(request, response);
			break;
		case "deleteAccount":
			result = accountManager.deleteAccount(request, response);
			break;
		case "createGroup":
			result = groupManager.createGroup(request, response);
			break;
		case "searchByName":
			result = groupManager.searchByName(request, response);
			break;
		case "addAffiliation":
			result = affiliationManager.addAffiliation(request, response);
			break;
		case "changeGroup":
			groupManager.changeGroup(request, response);
			affiliationManager.changeAffiliation(request, response);
			scheduleManager.login(request, response);
			result = "/home.jsp";
			break;
		case "changeMainGroup":
			result = affiliationManager.changeMainGroup(request, response);
			break;
		case "deleteAffiliation":
			result = affiliationManager.deleteAffiliation(request, response);
			break;
		case "putSchedule":
			result = scheduleManager.putSchedule(request, response);
			break;
		}
		getServletContext().getRequestDispatcher(result).forward(request, response);
	}

}
