<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editPassword</title>
</head>
<body>
<%
if(session.getAttribute("editPassword")!=null && !(Boolean)session.getAttribute("editPassword")) {
	        out.println("<p>同じパスワードを入力してください。</p>");
} 
%>
<Div Align="right"><button type="submit" name="req" size="40" onclick="location.href='manageAccount.jsp'">戻る</button></Div><br>   
<form action="Controller" method="post">   
                                      
<Div Align="center">新しいパスワード　　　　　　<input type="password" name="NewPasswordtext" size="70" required/></Div><br>
                <p><Div Align="center">※パスワードは○文字以上にして下さい。</Div></p><br>
<Div Align="center">新しいパスワードを確認　　<input type="password" name="CheckNewPasswordtext" size="70" required/></Div><br><br>
<Div Align="center"><button type="submit" name="req" size="160" value="editPassword">パスワードを変更</button></Div>
</form>
</body>
</html>