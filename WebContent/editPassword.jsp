<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("editPassword")!=null && !(Boolean)session.getAttribute("editPassword")){
	out.println("<p>同じパスワードを入力してください。</p>");
}
%>
<form action="Controller" method="post">
新しいパスワード<input type="password" name="newPass1" size="12" required/><br>
新しいパスワードを確認<input type="password" name="newPass2" size="12" required/><br>
<button type="submit" name="req" value="editPassword">パスワードを変更</button>
</form>
</body>
</html>