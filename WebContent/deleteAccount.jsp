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
if(session.getAttribute("deleteAccount")!=null && !(Boolean)session.getAttribute("deleteAccount")){
	out.println("<p>IDまたはパスワードが間違っています。</p>");
}
%>
<form action="Controller" method="post">
アカウントID<input type="text" name="accountID" size="12" required/><br>
パスワード<input type="password" name="accountPass" size="12" required/><br>
<button type="submit" name="req" value="deleteAccount">削除する</button>
<button type="button" onclick="location.href='manageAccount.jsp'">取り消し</button>
</form>
</body>
</html>