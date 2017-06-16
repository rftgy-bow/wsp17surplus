package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GroupManager {
	//Affiliationに代表者として登録が未実装！！！
	public String createGroup(HttpServletRequest request, HttpServletResponse response) {
		Group group = new Group();
		GroupDAO dao = new GroupDAO();
		//リクエスト情報のセット
		group.setGroupID(request.getParameter("groupID"));
		group.setGroupName(request.getParameter("groupName"));
		group.setGroupTag(request.getParameter("groupTag"));
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
		dao.createGroup(group.getGroupID(), group.getGroupName(), group.getGroupTag());
		if (session.getAttribute("createGroup") != null) {
			session.removeAttribute("createGroup");//エラー情報の削除
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
		String groupList = "";
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				groupList += ",";
			}
			groupList += list.get(i).getGroupName();
		}
		session.setAttribute("groupList", groupList);
		return "/chooseGroup.jsp";
	}

}
