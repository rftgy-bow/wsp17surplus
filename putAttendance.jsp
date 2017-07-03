<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>putAttendance</title>
</head>
<body>
<p></p>
            <center><font size="5">出欠</font>
              <select style="width: 70px" name="attendance">
                <option value="attend">出席</option>
                <option value="absent">欠席</option>
                <option value="leave early">早退</option>
                <option value="late">遅刻</option>
              </select>
            </center>
            
            <% %>
            
            <center><font size="5">理由</font> <input size="80" type="text"><br>
              <br>
              <br>
              <font size="5"> </font></center>
            <center>
            <% %>
            	<select name="hour">
                    <%
                    for (int i = 0; i <= 23; i++) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>時<select name="minute">
                    <%
                    for (int i = 0; i <= 55; i+=5) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>分～
                    <select name="hour">
                    <%
                    for (int i = 0; i <= 23; i++) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>時<select name="minute">
                    <%
                    for (int i = 0; i <= 55; i+=5) {
                    out.print("<option value=\"" + i + "\">" + i + "</option>");
                    }
                    %>
                    </select>分
                    <%
            if(session.getAttribute("putAttendance")!=null && !(Boolean)session.getAttribute("PutAttendance")) {
	        out.println("<p>時刻を間違えています。正しく入力してください。</p>");
             }
            %>
                <br>
                <br>
                <br>
              </font>
               　<form method="post" action="calender.jsp">
              <center><input value="登録" type="button">　<input value="戻る" type="button"></center></form>
</body>
</html>