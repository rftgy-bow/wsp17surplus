<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>authorization</title>
</head>
<body>
<p>特定のアカウント名 に権限を付与することができます</p>
    <p><br>
    </p>
    <select style="width: 200px" name="SelectAccount">
      <option value="selectAccount">アカウント名を選択</option>
      <option value="absent">団体B</option>
      <option value="leave early">団体C</option>
    </select>
    に
    <select style="width: 200px" name="SelectPosition">
      <option value="selectPosition">権限を選択</option>
      <option value="absent">団体B</option>
      <option value="leave early">団体C</option>
    </select>
    を付与する<br>
    <br>
    <br>
    <br>
    <form method="post" action="authorization.jsp">
    <button type="button" name="changeRole" value="aaa" style="WIDTH:150px"> <font size="4"> 
    決定する </font></button>
    </form>
    <form method="post" action="memberList.jsp">
    <button type="button" name="backMemb" value="aaa"style="WIDTH:300px"> <font size="4"> 
    メンバー一覧画面に戻る </font></button>
    </form>
</body>
</html>