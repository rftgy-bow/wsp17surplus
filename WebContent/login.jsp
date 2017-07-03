<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>出欠管理システム</h1>
	<hr>
	<div align="center">
		<form action="Controller" method="post">
			<table style="width: 400px; height: 150px;" border="0">
				<tbody>
					<tr>
						<th>アカウントID</th>
						<td><input type="text" name="accountID" maxlength="10"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" name="accountPass" maxlength="64"></td>
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
		<div style="margin-top: 10px">
			<button type="button" onclick="location.href='createAccount.jsp'">アカウント新規作成</button>
		</div>
	</div>
</body>
</html>
