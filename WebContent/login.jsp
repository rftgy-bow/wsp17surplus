<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>さばぷろ</title>
</head>
<body>
<%
if(session.getAttribute("login")!=null && !(Boolean)session.getAttribute("login")) {
	out.println("<p>ユーザ名またはパスワードが違います</p>");
}
%>
<form action="Controller" method="post">
<dl>
<dt>アカウントID</dt>
<dd><input type="text" name="accountID" /></dd>
<dt>パスワード</dt>
<dd><input type="password" name="accountPass" /></dd>
</dl>
<button type="submit" name="req" value="login">ログイン</button>
</form>
<button type="button" onclick="location.href='createAccount.jsp'">アカウント新規作成</button>
</body>
</html>
