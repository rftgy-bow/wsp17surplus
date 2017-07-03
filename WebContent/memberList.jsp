<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メンバー一覧画面</title>
</head>
<body>
	<h1>メンバー一覧画面</h1>
	<hr>
	<div align="right">
		<table>
			<tbody>
				<tr align="center">
					<form action="home.jsp" method="post">
						<input value="ホーム" style="width: 210px; height: 60px;"
							type="submit">
					</form>
				</tr>
			</tbody>
		</table>
	</div>
	<div align="center">
		<table>
			<tbody>
				<tr align="center">
					<form>
						<option value="nametag">メンバー一覧</option>
						<select size="20" name="nameList"
							style="width: 400px; height: 300px;">
							<option value="name1">石川 光晶</option>
							<option value="name2">吉井 康貴</option>
							<option value="name3">小宮 寛季</option>
							<option value="name4">田中 隆文</option>
							<option value="name5">沼崎 一輝</option>
							<option value="name6">鈴木 太郎</option>
							<option value="name7">山田 次郎</option>
						</select>
					</form>
					<td><br> <br></td>
				</tr>
				<tr align="center">
					<td>
						<table>
							<tbody>
								<tr>
									<td>
										<form action="joinRequest.jsp" method="post">
											<input value="出欠一覧" style="width: 210px; height: 60px;"
												type="submit">
										</form>
									</td>
									<td>
										<form action="authorization.jsp" method="post">
											<input value="申請一覧" style="width: 210px; height: 60px;"
												type="submit">
										</form>
									</td>
									<td>
										<form action="attendanceList.jsp" method="post">
											<input value="権限付与" style="width: 210px; height: 60px;"
												type="submit">
										</form>
									</td>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>