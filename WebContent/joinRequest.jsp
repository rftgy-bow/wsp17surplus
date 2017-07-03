<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申請一覧画面</title>
</head>
<body>
	<h1>申請一覧画面</h1>
	<hr>
	<div align="center">
		<table>
			<tbody>
				<tr align="center">
					<td><option value="name1">石川 光晶</option></td>
					<td>
						<form action="joinRequest.jsp" method="post">
							<input value="許可" style="width: 210px; height: 60px;"
								type="submit">
						</form>
					</td>
					<td>
						<form action="joinRequest.jsp" method="post">
							<input value="却下" style="width: 210px; height: 60px;"
								type="submit">
						</form>
					</td>
				</tr>
				<tr align="center">
					<td><option value="name2">吉井 康貴</option></td>
					<td>
						<form action="joinRequest.jsp" method="post">
							<input value="許可" style="width: 210px; height: 60px;"
								type="submit">
						</form>
					</td>
					<td>
						<form action="joinRequest.jsp" method="post">
							<input value="却下" style="width: 210px; height: 60px;"
								type="submit">
						</form>
					</td>
				</tr>
				<tr align="center">
					<td><option value="name3">小宮 寛季</option></td>
					<td>
						<form action="joinRequest.jsp" method="post">
							<input value="許可" style="width: 210px; height: 60px;"
								type="submit">
						</form>
					</td>
					<td>
						<form action="joinRequest.jsp" method="post">
							<input value="却下" style="width: 210px; height: 60px;"
								type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div align="right">
		<tr align="center">
			<form action="memberList.jsp" method="post">
				<input value="戻る" style="width: 210px; height: 60px;" type="submit">
			</form>
		</tr>
	</div>
</body>
</html>