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
if(session.getAttribute("createAccount")!=null && !(Boolean)session.getAttribute("createAccount")) {
	out.println("<p>既に使われているアカウントIDです。</p>");
}
%>
<!-- 文字数制限や入力文字タイプの指定は未実装 -->>
<form action="Controller" method="post">
アカウントID<input type="text" name="accountID" size="12" required/><br>
パスワード<input type="password" name="accountPass"size="12" required/><br>
氏名<input type="text" name="userName"size="12" required/><br>
<button type="submit" name="req" value="createAccount">新規作成</button>
</form>
<button type="button" onclick="location.href='login.jsp'">戻る</button>
</body>
</html>