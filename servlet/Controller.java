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

	public Controller() {
		super();
		accountManager = new AccountManager();
		groupManager = new GroupManager();
		affiliationManager = new AffiliationManager();
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
		}
		getServletContext().getRequestDispatcher(result).forward(request, response);

	}

}
