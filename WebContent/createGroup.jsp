<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 文字数制限や入力文字タイプの指定は未実装 -->
<form action="Controller" method="post">
団体名<input type="text" name="groupID" size="12" required/><br>
団体ID<input type="text" name="groupName"size="12" required/><br>
タグ<input type="text" name="groupTag"size="12" /><br>
<button type="submit" name="req" value="createGroup">作成</button>
<button type="button" onclick="location.href'manageGroup.jsp'">キャンセル</button>
</form>
</body>
</html>