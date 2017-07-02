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
	<div align="right">
		<hr>
		<input placeholder="検索" name="id" size="40" maxlength="10"
			type="search">
	</div>
	<div align="center">
		<select style="width: 250px;" name="group">
			<option value="団体A">団体A</option>
			<option value="団体B">団体B</option>
			<option value="団体C">団体C</option>
		</select>
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
											<form action="manageGroup.jsp" method="post">
												<button type="submit" name="cancel">キャンセル</button>
											</form>
										</td>
										<td>
											<form action="home.jsp" method="post">
												<button type="submit" name="cancel">新しい団体に加入する</button>
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
