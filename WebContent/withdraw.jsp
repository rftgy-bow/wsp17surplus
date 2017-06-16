<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>団体脱退画面</title>
</head>
<body>
	<h1>団体脱退画面</h1>
	<hr>
	<div align="center">
		本当に団体を脱退しますか？
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
											<button type="submit" name="no">キャンセル</button>
										</form>
										</td>
										<td>
											<form action="login.jsp" method="post">
												<button type="submit" name="yes">はい</button>
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