<%@ page language="java" contentType="text/html; charset=UTF-8"
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Controller" method="post">
<input type="text" name="searchGroup"/>
<button type="submit" name="req" value="searchByName">検索</button>
</form>
<br>
<form action="Controller" method="post">
<select name="groupID">
<%
if(session.getAttribute("groupList")!=null){
	String groupList = (String)session.getAttribute("groupList");
		String[] groupName = groupList.split(",");
		for(String name:groupName){
		out.println("<option value=\"" + name + "\">" + name + "</option>");
		}
}
%>
</select>
<br>
<button type="button" onclick="location.href='manageGroup.jsp'">キャンセル</button>
<button type="submit" name="req" value="addAffiliation">加入する</button>
</form>
</body>
</html>
