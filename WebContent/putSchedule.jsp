<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>予定作成画面</title>
</head>
<body>
	<h1>予定作成画面</h1>
	<div align="center">
	<form action="putSchedule" method="post">
	<hr>
		<table style="width: 350px; height: 150px;" border="0">
			<tbody>
				<tr>
					<th>名前</th>
					<td><input name="name" size="40" maxlength="11" type="text">
					</td>
				</tr>
				<tr>
					<th>場所</th>
					<td><input name="place" size="40" maxlength="11" type="text">
					</td>
				</tr>
				<tr>
					<th>時間</th>
					<td>
					<select name="hour">
                    <%
                    for (int i = 0; i <= 23; i++) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>時<select name="minute">
                    <%
                    for (int i = 0; i <= 55; i+=5) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>分～
                    <select name="hour">
                    <%
                    for (int i = 0; i <= 23; i++) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>時<select name="minute">
                    <%
                    for (int i = 0; i <= 55; i+=5) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>分</td>
				</tr>
			</tbody>
		</table>

		</form>
		<form action = "putSchedule.jsp" method = "post">
		<button type="submit" name="putSchedulet">予定作成</button>
		</form>
		<form action = "calender.jsp" method = "post">
		<button type="submit" name="cancel">キャンセル</button>
		</form>
	</div>
</body>
</html>