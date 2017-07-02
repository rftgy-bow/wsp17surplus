<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ホーム画面</title>
</head>
<body>
	<h1>ホーム画面</h1>
	<hr>
	<div align="right">
		<tr align="right">
			<p>【 ${sessionScope.group.groupName} グループの ${sessionScope.account.role} として ${sessionScope.account.name} がログイン中です】</p>
		</tr>
		<tr align="right">
			<form action="login.jsp" method="post">
				<input value="ログアウト" style="width: 140px; height: 40px;"
					type="submit">
			</form>
		</tr>
	</div>
	<div align="center">
		<tr align="center">
			<div style="display: inline-flex">
				<form action="calender.jsp" method="post">
					<input value="予定カレンダー" style="width: 210px; height: 60px;"
						type="submit">
				</form>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<form action="manageAccount.jsp" method="post">
					<input value="アカウント管理" style="width: 210px; height: 60px;"
						type="submit">
				</form>
			</div>
		</tr>
		<tr align="center">
			<td><br> <br></td>
		</tr>
		<tr align="center">
			<div style="display: inline-flex">
				<form action="manageGroup.jsp" method="post">
					<input value="団体管理" style="width: 210px; height: 60px;"
						type="submit">
				</form>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<form action="memberList.jsp" method="post">
					<input value="メンバー一覧" style="width: 210px; height: 60px;"
						type="submit">
				</form>
			</div>
		</tr>
		<tr align="center">
			<td><br> <br></td>
		</tr>
		<tr align="center">
			<input value="ニュース一覧" style="width: 600px; height: 400px;"
				type="text">
		</tr>
	</div>
	<div align="right">
		<tr align="right">
			<form action="putNews.jsp" method="post">
				<input value="ニュース追加" style="width: 140px; height: 40px;"
					type="submit">
			</form>
		</tr>
	</div>
</body>
</html>