package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AffiliationManager {
	public void login(HttpServletRequest request, HttpServletResponse response) {
		//TODO 申請中のグループは除外する
		AffiliationDAO dao = new AffiliationDAO();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		if (account != null) {
			Affiliation affiliation = dao.login(account.getAccountID());
			session.setAttribute("affiliation", affiliation);
			ArrayList<Affiliation> alist = dao.getAffiliationList(account.getAccountID());
			GroupDAO gdao = new GroupDAO();
			String groupList = "";
			for (int i = 0; i < alist.size(); i++) {
				if (i != 0) {
					groupList += ",";
				}
				groupList += gdao.getByID(alist.get(i).getGroupID()).getGroupName();
			}
			session.setAttribute("groupList", groupList);

		}
	}

	public void changeAffiliation(HttpServletRequest request, HttpServletResponse response) {
		AffiliationDAO dao = new AffiliationDAO();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Group group = (Group) session.getAttribute("group");
		Affiliation affiliation = null;
		affiliation = dao.getAffiliation(account.getAccountID(), group.getGroupID());
		session.setAttribute("affiliation", affiliation);
	}

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
		dao.addAffiliation(accountID, groupID, "申請中", false);
		return "/manageGroup.jsp";
	}

	public String deleteAffiliation(HttpServletRequest request, HttpServletResponse response) {
		AffiliationDAO dao = new AffiliationDAO();
		HttpSession session = request.getSession();
		Affiliation affiliation = (Affiliation) session.getAttribute("affiliation");
		dao.deleteAffiliation(affiliation.getAccountID(), affiliation.getGroupID());
		ArrayList<Affiliation> list = dao.getAffiliationList(affiliation.getAccountID());
		if (list.size() == 0) {
			session.setAttribute("affiliation", null);
			session.setAttribute("group", null);
		} else {
			GroupDAO gdao = new GroupDAO();
			session.setAttribute("affiliation", list.get(0));
			session.setAttribute("group", gdao.getByID(list.get(0).getGroupID()));
		}
		return "/manageGroup.jsp";
	}

	public String getGroupList(HttpServletRequest request, HttpServletResponse response) {
		AffiliationDAO dao = new AffiliationDAO();
		HttpSession session = request.getSession();
		Affiliation affiliation = (Affiliation) session.getAttribute("affiliation");
		ArrayList<Affiliation> alist = null;
		alist = dao.getAffiliationList(affiliation.getAccountID());
		String groupList = "";
		GroupDAO gdao = new GroupDAO();
		for (int i = 0; i < alist.size(); i++) {
			if (i != 0) {
				groupList += ",";
			}
			groupList += gdao.getByID(alist.get(i).getGroupID());
		}
		return groupList;

	}

	public String changeMainGroup(HttpServletRequest request, HttpServletResponse response) {
		AffiliationDAO dao = new AffiliationDAO();
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Group group = (Group) session.getAttribute("group");
		dao.changeMainGroup(account.getAccountID(), group.getGroupID());
		return "/home.jsp";
	}
}
