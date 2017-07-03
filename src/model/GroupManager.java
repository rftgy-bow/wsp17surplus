package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GroupManager {

	public void login(HttpServletRequest request, HttpServletResponse response) {
		GroupDAO dao = new GroupDAO();
		HttpSession session = request.getSession();
		Affiliation affiliation = (Affiliation) session.getAttribute("affiliation");
		if (affiliation != null) {
			Group group = dao.getByID(affiliation.getGroupID());
			session.setAttribute("group", group);
		}
	}

	public void changeGroup(HttpServletRequest request, HttpServletResponse response) {
		Group group = null;
		GroupDAO dao = new GroupDAO();
		group = dao.getByName(request.getParameter("groupName"));
		HttpSession session = request.getSession();
		session.setAttribute("group", group);
	}

	public String createGroup(HttpServletRequest request, HttpServletResponse response) {
		//TODO 作成後にグループリストの更新をする
		Group group = new Group();
		GroupDAO dao = new GroupDAO();
		//リクエスト情報のセット
		group.setGroupID(request.getParameter("groupID"));
		group.setGroupName(request.getParameter("groupName"));
		//IDと名前の重複を確認
		HttpSession session = request.getSession();
		if (dao.findByID(group.getGroupID())) {
			session.setAttribute("createGroup", "id");//エラー情報付与
			return "/createGroup.jsp";
		}
		if (dao.findByName(group.getGroupName())) {
			session.setAttribute("createGroup", "name");//エラー情報付与
			return "/createGroup.jsp";
		}
		//グループ作成
		dao.createGroup(group.getGroupID(), group.getGroupName());
		if (session.getAttribute("createGroup") != null) {
			session.removeAttribute("createGroup");//エラー情報の削除
		}
		//所属情報の追加
		AffiliationDAO adao = new AffiliationDAO();
		Account account = (Account) session.getAttribute("account");
		adao.addAffiliation(account.getAccountID(), group.getGroupID(), "代表", true);
		//ログイン情報に追加(グループ未登録時
		if ((Affiliation) session.getAttribute("affiliation") == null) {
			Affiliation affiliation = adao.login(account.getAccountID());
			session.setAttribute("affiliation", affiliation);
			session.setAttribute("group", group);
		}
		return "/manageGroup.jsp";
	}

	public String deleteGroup(HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	public String searchByName(HttpServletRequest request, HttpServletResponse response) {//","で区切る
		ArrayList<Group> list;
		GroupDAO dao = new GroupDAO();
		HttpSession session = request.getSession();
		String groupName = request.getParameter("searchGroup");
		list = dao.searchByName(groupName);
		String chooseList = "";
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				chooseList += ",";
			}
			chooseList += list.get(i).getGroupName();
		}
		session.setAttribute("chooseList", chooseList);
		return "/chooseGroup.jsp";
	}
}
