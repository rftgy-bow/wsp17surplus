package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AffiliationManager {
	public String addAffiliation(HttpServletRequest request, HttpServletResponse response) {
		AffiliationDAO dao = new AffiliationDAO();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		String accountID = account.getAccountID();
		String groupID = request.getParameter("groupID");

		if (dao.check(accountID, groupID)) {
			request.setAttribute("chooseGroup", false);
			return "/chooseGroup.jsp";
		}
		dao.addAffiliation(accountID, groupID);
		return "/manageGroup.jsp";
	}
}
