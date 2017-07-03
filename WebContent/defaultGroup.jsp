<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初期団体選択画面</title>
</head>
<body>
	<h1>初期団体選択画面</h1>
	<hr>
	<div align="center">
		<tr align="center">
			<form action="chooseGroup.jsp" method="post">
				<input value="既存団体に加入" style="width: 210px; height: 60px;"
					type="submit">
			</form>
		</tr>
		<tr align="center">
			<td><br> <br></td>
		</tr>
		<tr align="center">
			<form action="createGroup.jsp" method="post">
				<input value="新しく団体を作成" style="width: 210px; height: 60px;"
					type="submit">
			</form>
		</tr>
	</div>
</body>
</html>