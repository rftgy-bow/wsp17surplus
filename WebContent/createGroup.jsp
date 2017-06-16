<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>団体新規作成画面</title>
</head>
<body>
	<h1>団体新規作成画面</h1>
	<div align="center">
		<hr>
		<table style="width: 400px; height: 150px;" border="0">
			<tbody>
				<tr>
					<th>名前</th>
					<td><input name="id" size="40" maxlength="11" type="text"></td>
				</tr>
				<tr>
					<th>団体ID</th>
					<td><input name="psw" size="40" maxlength="11" type="password"></td>
				</tr>
			</tbody>
		</table>
		<div style="display: inline-flex">
			<table>
				<tbody>
					<tr align="center">
						<td>
							<table>
								<tbody>
									<tr>
										<td>
											<form action="manageGroup.jsp" method="post">
												<button type="submit" name="no">キャンセル</button>
											</form>
										</td>
										<td>
											<form action="home.jsp" method="post">
												<button type="submit" name="create">作成</button>
											</form>
										</td>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</div>
</body>
</html>