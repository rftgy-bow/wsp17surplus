<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>加入団体選択画面</title>
</head>
<body>
	<h1>加入団体選択画面</h1>
	<hr>
	<div align="right">
		<form action="Controller" method="post">
			<input type="text" name="searchGroup" maxlength="10">
			<button type="submit" name="req" value="searchByName">検索</button>
		</form>
	</div>
	<form action="Controller" method="post">
		<div align="center">
			<div style="margin-top: 10px">
				<select name="groupID" style="width: 250px;" name="groupID">
					<%
						if (session.getAttribute("groupList") != null) {
							String groupList = (String) session.getAttribute("groupList");
							String[] groupName = groupList.split(",");
							for (String name : groupName) {
								out.println("<option value=\"" + name + "\">" + name + "</option>");
							}
						}
					%>
				</select>
			</div>
			<p>
			<div style="display: inline-flex">
				<table>
					<tbody>
						<tr align="center">
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<button type="button"
													onclick="location.href='manageGroup.jsp'">キャンセル</button>
											</td>
											<td>
												<button type="submit" name="req" value="addAffiliation"
													onclick="location.href='home.jsp'">新しい団体に加入する</button>
											</td>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
