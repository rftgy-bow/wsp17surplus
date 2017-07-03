<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全員の出欠一覧画面</title>
</head>
<body>
	<h1>全員の出欠一覧画面</h1>
	<hr>
	<div align="center">
		<table border="1" bordercolor="#333333">
			<tbody>
				<tr align="center">
					<th><option value="tag1">日付</option></th>
					<th><option value="tag2">時間</option></th>

					<th><option value="name1">石川 光晶</option></th>
					<th><option value="name2">吉井 康貴</option></th>
					<th><option value="name3">小宮 寛季</option></th>
					<th><option value="name4">田中 隆文</option></th>
					<th><option value="name5">沼崎 一輝</option></th>
					<th><option value="name6">鈴木 太郎</option></th>
					<th><option value="name7">山田 次郎</option></th>
				</tr>
				<tr align="center">
					<td><option value="tag1_1">6月12日 (月)</option></td>
					<td><option value="tag2_1">16:30 ～ 19:00</option></td>

					<td><option value="name1_1">欠席</option></td>
					<td><option value="name2_1">○</option></td>
					<td><option value="name3_1">○</option></td>
					<td><option value="name4_1">○</option></td>
					<td><option value="name5_1">○</option></td>
					<td><option value="name6_1">早退</option></td>
					<td><option value="name7_1">遅刻</option></td>
				</tr>
				<tr align="center">
					<td><option value="tag1_2">6月13日 (火)</option></td>
					<td><option value="tag2_2">16:30 ～ 19:00</option></td>

					<td><option value="name1_1_2">○</option></td>
					<td><option value="name2_1_2">○</option></td>
					<td><option value="name3_1_2">遅刻</option></td>
					<td><option value="name4_1_2">○</option></td>
					<td><option value="name5_1_2">○</option></td>
					<td><option value="name6_1_2">○</option></td>
					<td><option value="name7_1_2">欠席</option></td>
				</tr>
				<tr align="center">
					<td><option value="tag1_3">6月14日 (水)</option></td>
					<td><option value="tag2_3">16:30 ～ 19:00</option></td>

					<td><option value="name1_1_3">遅刻</option></td>
					<td><option value="name2_1_3">○</option></td>
					<td><option value="name3_1_3">遅刻</option></td>
					<td><option value="name4_1_3">○</option></td>
					<td><option value="name5_1_3">○</option></td>
					<td><option value="name6_1_3">○</option></td>
					<td><option value="name7_1_3">欠席</option></td>
				</tr>
				<tr align="center">
					<td><option value="tag1_4">6月15日 (木)</option></td>
					<td><option value="tag2_4">16:30 ～ 19:00</option></td>

					<td><option value="name1_1_4">○</option></td>
					<td><option value="name2_1_4">○</option></td>
					<td><option value="name3_1_4">遅刻</option></td>
					<td><option value="name4_1_4">○</option></td>
					<td><option value="name5_1_4">○</option></td>
					<td><option value="name6_1_4">○</option></td>
					<td><option value="name7_1_4">○</option></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div align="right">
		<table>
			<tbody>
				<tr align="center">
					<td><br> <br></td>
				</tr>
				<tr align="center">
					<td>
						<table>
							<tbody>
								<tr>
									<td><form action="timeline.jsp" method="post">
											<input value="出欠タイムラインに戻る"
												style="width: 210px; height: 60px;" type="submit">
										</form></td>
									<td><form action="memberList.jsp" method="post">
											<input value="メンバー一覧画面に戻る"
												style="width: 210px; height: 60px;" type="submit">
										</form></td>
									<td><form action="home.jsp" method="post">
											<input value="ホーム画面に戻る" style="width: 210px; height: 60px;"
												type="submit">
										</form>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>