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
	<hr>
	<div align="center">
		<form action="Controller" method="post">
			<table style="width: 400px; height: 150px;" border="0">
				<tbody>
					<tr>
						<th>団体名</th>
						<td><input type="text" name="groupID" maxlength="11"></td>
					</tr>
					<tr>
						<th>団体ID</th>
						<td><input type="text" name="groupName" maxlength="11"></td>
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
												<button type="button" onclick="location.href='manageGroup.jsp'">キャンセル</button>
											</td>
											<td>
												<button type="button" name="req" value="createGroup">作成</button>
											</td>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
	</div>
</body>
</html>