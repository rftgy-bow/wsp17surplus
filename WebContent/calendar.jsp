<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/calendar.css" type="text/css">
</head>
<body>
<!-- TODO sessionにスケジュールリストがなかったらControllerにgetScheduleしてから戻る -->
<%
String dateList = (String)session.getAttribute("dateList");
//out.println(dateList + "<br>");
%>
<script type="text/javascript" src="js/dateformat.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript">
printCalendar("<%= dateList %>");
console.log("<%= dateList %>");
</script>
</body>
</html>