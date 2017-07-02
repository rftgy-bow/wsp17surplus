<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>ログイン画面</title>
</head>
<body>
	<h1>出欠管理システム</h1>
	<div align="center">
		<form action="Controller" method="post">
			<hr>
			<table style="width: 400px; height: 150px;" border="0">
				<tbody>
					<tr>
						<th>ID</th>
						<td><input name="accountID" size="40" maxlength="10"
							type="text"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input name="accountPass" size="40" maxlength="64"
							type="password"></td>
					</tr>
				</tbody>
				<%
					if (session.getAttribute("login") != null && !(Boolean) session.getAttribute("login")) {
						out.println("<p>ユーザ名またはパスワードが違います</p>");
					}
				%>
			</table>
			<button type="submit" name="req" value="login">ログイン</button>
		</form>
		<form action="createAccount.jsp" method="post">
			<button type="submit" name="newaccount">アカウント新規作成</button>
		</form>
	</div>
</body>
</html>
