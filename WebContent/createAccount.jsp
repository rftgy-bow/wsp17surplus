<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント新規作成画面</title>
</head>
<body>
	<h1>アカウント新規作成画面</h1>
	<hr>
	<div align="center">
		<table border="0" cellpadding="0" cellspacing="0" width="494">
			<tbody>
				<tr align="center">
					<td><p style="text-align: right;">アカウント名</p></td>
					<td><input id="accountID" name="accountID" value=""
						maxlength="99" onkeypress="pressKey(event.keyCode);"
						class="inputSecret" type="accountID"></td>
				</tr>
				<tr align="center">
					<td><p style="text-align: right;">パスワード</p></td>
					<td><input id="password" name="password" value=""
						maxlength="99" onkeypress="pressKey(event.keyCode);"
						class="inputSecret" type="password"></td>
				</tr>
				<tr align="center">
					<td><p style="text-align: right;">氏名</p></td>
					<td><input id="username" name="username" value=""
						maxlength="99" onkeypress="pressKey(event.keyCode);"
						class="inputSecret" type="username"></td>
				</tr>
			</tbody>
		</table>
		<p style="text-align: center;">
			<font color="#ff0000">[アカウント名・パスワード・氏名]に不備があります。<br>正しい値に修正してください。
			</font>
		</p>
		<tr align="center">
			<td><br> <br></td>
		</tr>
		<tr align="center">
			<form action="defaultGroup.jsp" method="post">
				<-- createAccount -->
				<input value="新規作成" style="width: 210px; height: 60px;" type="submit">
			</form>
			<form action="login.jsp" method="post">
				<input value="戻る" style="width: 210px; height: 60px;" type="submit">
			</form>
		</tr>
	</div>
</body>
</html>