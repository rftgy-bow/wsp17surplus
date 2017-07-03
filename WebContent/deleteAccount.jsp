<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deleteAccount</title>
</head>
<body>
 <br>
            <br>
            <div style="text-align: left;">　　　　　　
              　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <b><font color="#e0a000">※　本当にアカウントを削除してよろしいですか？<br>
                  　　　　　　
                  　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp; ※　一度削除したアカウントは二度と使用できなくなります。<br>
                  　　　　　　
                  　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  ※　本当によろしいですか？</font></b><br>
                  <%
            if(session.getAttribute("deleteAccount")!=null && !(Boolean)session.getAttribute("deleteAccount")) {
	        out.println("<p>IDまたはパスワードが違います</p>");
             }
            %>
            <form action="Controller" method="post">
              <br>
              <br>
              <br>
              <br>
              　　　　　　　アカウントID　<input size="70" name="SelectAccout" type="text" required/><br>
              　　　　　　　パスワード　　<input type="password" name="accountPass" size="70" required/><br>
              <br>
              <br>
              <br>
              <br>
              <br>
              　　　　　　　<em>　<button type="submit" name="req" value="deleteAccount">削除する</button></em>
              　　　　　　　<button type="button" onclick="location.href='manageAccount.jsp'">取り消し</button>
</form>           
</body>
</html>