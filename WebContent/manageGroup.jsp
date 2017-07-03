<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manageGroup</title>
<!-- css -->
<link rel ="stylesheet" href="${pageContext.request.contextPath}/css/surplus.css">
</head>
<body>
<left>
      <form method="post" action="manageGroup.jsp">
      <select style="width: 229px; height: 70px;" name="attendance">
        <option value="attend">団体A</option>
        <option value="absent">団体B</option>
        <option value="leave early">団体C</option>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </select>
      </form>
      <br>
      <br>
       </left>
 <Div Align="center"><button class="button" type="button" onclick="location.href='home.jsp'">ホーム団体に設定</button></Div><br>
<Div Align="center"><button class="button" type="button" onclick="location.href='withdraw.jsp'">脱退</button></Div><br>
<Div Align="center"><button class="button" type="button" onclick="location.href='chooseGroup.jsp'">新しく団体に加入</button></Div><br>
<Div Align="center"><button class="button" type="button" onclick="location.href='createGroup.jsp'">新しい団体を作成</button></Div><br>
<Div Align="center"><button class="button" type="button" onclick="location.href='home.jsp'">戻る</button></Div><br>
</body>
</html>