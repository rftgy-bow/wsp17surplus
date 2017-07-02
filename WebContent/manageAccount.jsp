<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント管理画面</title>
</head>
<body>
	<h1>アカウント管理画面</h1>
	<hr>
	<div align="right">
		<tr align="center">
			<form action="home.jsp" method="post">
				<input value="ホーム" style="width: 210px; height: 60px;" type="submit">
			</form>
		</tr>
	</div>
	<div align="center">
		<tr align="center">
			<form action="editPassword.jsp" method="post">
				<input value="パスワード変更" style="width: 210px; height: 60px;"
					type="submit">
			</form>
		</tr>
		<tr align="center">
			<td><br> <br></td>
		</tr>
		<tr align="center">
			<form action="deleteAccount.jsp" method="post">
				<input value="アカウント削除" style="width: 210px; height: 60px;"
					type="submit">
			</form>
		</tr>
	</div>
</body>
</html>