<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予定作成画面</title>
</head>
<body>
	<h1>予定作成画面</h1>
	<div align="center">
		<form action="Controller" method="post">
			<hr>
			<table style="width: 400px; height: 150px;" border="0">
				<tbody>
					<tr>
						<th>名前</th>
						<td><input type="text" name="name" maxlength="10"></td>
					</tr>
					<tr>
						<th>場所</th>
						<td><input type="text" name="place" maxlength="10"></td>
					</tr>
					<tr>
						<th>時間</th>
						<td><select name="hour">
								<%
									for (int i = 0; i <= 23; i++) {
										out.print("<option value=\"" + i + "\">" + i + "</option>");
									}
								%>
						</select>時<select name="minute">
								<%
									for (int i = 0; i <= 55; i += 5) {
										out.print("<option value=\"" + i + "\">" + i + "</option>");
									}
								%>
						</select>分～ <select name="hour">
								<%
									for (int i = 0; i <= 23; i++) {
										out.print("<option value=\"" + i + "\">" + i + "</option>");
									}
								%>
						</select>時<select name="minute">
								<%
									for (int i = 0; i <= 55; i += 5) {
										out.print("<option value=\"" + i + "\">" + i + "</option>");
									}
								%>
						</select>分</td>
					</tr>
				</tbody>
			</table>
			<button type="button" onclick="location.href='putSchedule.jsp'">予定作成</button>
		</form>
		<div style="margin-top: 10px">
			<button type="button" onclick="location.href='calender.jsp'">キャンセル</button>
		</div>
	</div>
</body>
</html>