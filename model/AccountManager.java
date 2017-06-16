package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountManager {

	public String login(HttpServletRequest request, HttpServletResponse response) {
		Account account = new Account();
		AccountDAO dao = new AccountDAO();
		//リクエスト情報をセット
		account.setAccountID(request.getParameter("accountID"));
		account.setPass(request.getParameter("accountPass"));
		//アカウントをDBでcheck
		boolean result = false;
		result = dao.login(account.getAccountID(), account.getPass());
		HttpSession session = request.getSession();
		session.setAttribute("login", result);
		if (result) {
			//ログインに成功
			//セッションにアカウントを追加
			session.setAttribute("account", account);
			return "/home.jsp";
		} else {
			return "/login.jsp";
		}
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/login.jsp";
	}

	public String createAccount(HttpServletRequest request, HttpServletResponse response) {
		Account account = new Account();
		AccountDAO dao = new AccountDAO();
		//リクエストからの情報をセット
		String accountID = request.getParameter("accountID");
		String accountPass = request.getParameter("accountPass");
		String userName = request.getParameter("userName");
		//idが重複しないか調べる
		HttpSession session = request.getSession();
		if (dao.findByAccountID(accountID)) {
			session.setAttribute("createAccount", false);
			return "/createAccount.jsp";
		} else {
			//アカウントを作成
			dao.createAccount(accountID, accountPass, userName);
			//アカウント情報をセット
			account.setAccountID(accountID);
			account.setPass(accountPass);
			account.setName(userName);
			if (session.getAttribute("createAccount") != null) {
				session.removeAttribute("createAccount");//失敗情報の削除
			}
			session.setAttribute("account", account);
			session.setAttribute("login", true);
			return "/defaultGroup.jsp";
		}
	}

	public String deleteAccount(HttpServletRequest request, HttpServletResponse response) {
		AccountDAO dao = new AccountDAO();
		String accountID = request.getParameter("accountID");
		String accountPass = request.getParameter("accountPass");
		//アカウントIDとPassの確認
		HttpSession session = request.getSession();
		if (dao.login(accountID, accountPass)) {//idとpassが合っている
			dao.deleteAccount(accountID, accountPass);//削除
			if (session.getAttribute("deleteAccount") != null) {//失敗情報の削除
				session.removeAttribute("deleteAccount");
			}
			//ログイン情報の削除
			session.removeAttribute("account");
			session.removeAttribute("login");
			return "/login.jsp";
		} else {
			session.setAttribute("deleteAccount", false);//失敗情報の付与
			return "/deleteAccount.jsp";
		}
	}

	public String editPassword(HttpServletRequest request, HttpServletResponse response) {
		Account account = new Account();
		AccountDAO dao = new AccountDAO();
		HttpSession session = request.getSession();
		//account情報の取得
		account = (Account) session.getAttribute("account");
		String accountID = account.getAccountID();
		String accountPass = account.getPass();
		//リクエストからの情報をセット
		String newPass1 = request.getParameter("newPass1");
		String newPass2 = request.getParameter("newPass2");
		if (!newPass1.equals(newPass2)) {//パスワードが違うとき
			session.setAttribute("editPassowrd", false);
			return "/editPassword.jsp";
		} else {
			dao.changePass(accountID, accountPass, newPass1);
			if (session.getAttribute("editPassword") != null) {
				session.removeAttribute("editPassword");//失敗情報の削除
			}
			account.setPass(newPass1);
			return "/manageAccount.jsp";
		}
	}
}