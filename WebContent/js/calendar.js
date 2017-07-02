/**
 *
 */
// メモ
// whileでリストループしてフォーマットと同じものがあるか調べる→true
function printCalendar(dateList) {
	var dateFormat = new DateFormat("yyyy-MM-dd");
	var clday = new Date();
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	var date = today.getDate();
	var day = today.getDay();
	var lastDateData = new Date(year, month - 1, 0); // 前月の最終日
	var lastDate = lastDateData.getDate();
	var lastDay = lastDateData.getDay();
	var endDateData = new Date(year, month, 0); // 今月の最終日
	var endDate = endDateData.getDate()
	var endDay = endDateData.getDay();
	var textCount = 0;
	var textDay = 1;
	var textSkip = true;
	var dateListString = dateList + "";
	var dateListArray = dateListString.split(",");
	var scheduleIsExist = false;
	console.log(dateList);
	console.log(dateListString);
	// 曜日リスト
	var dates = new Array("日", "月", "火", "水", "木", "金", "土");
	// カレンダーの作成
	var clout = "<table class=\"callender\">";
	// 年月
	clout += "<tr><td colspan=\"7\">" + year + "年" + month + "月" + "</tb></tr>";
	// 曜日
	clout += "<tr class=\"day\">";
	for (var i = 0; i < 7; i++) {
		clout += "<th class=\"day\">";
		clout += dates[i] + "</th>";
	}
	clout += "</tr>";
	// 日
	for (var i = 0; i < 6; i++) {
		if (textSkip == true && lastDay != 6 || textCount - lastDay > endDate) {
			clout += "<tr>";
		} else {
			clout += "<tr class=\"date\">";
		}
		for (var j = 0; j < 7; j++, textCount++) {
			if (textSkip == true && (textCount <= lastDay || lastDay == 6)) { // 前月の最終曜日まで
				clout += "<td class=\"other\">";
				clout += (lastDate - lastDay + textCount);
			} else {
				textSkip = false;
				if (textCount - lastDay <= endDate) {// 今月
					clday.setDate(textCount - lastDay)// カウントの日をDateで所持
					for (var k = 0; k < dateListArray.length; k++) {
						if (dateListArray[k] == dateFormat.format(clday)) {
							scheduleIsExist = true;
							break;
						} else {
							scheduleIsExist = false;
						}
					}
					if (textCount - lastDay == date) {
						if (scheduleIsExist) {
							clout += "<td class=\"todaySchedule\">";
						} else {
							clout += "<td class=\"today\">";// 当日
						}
					} else {
						if (scheduleIsExist) {
							clout += "<td class=\"schedule\">";
						} else {
							clout += "<td>";
						}
					}
					clout += textCount - lastDay;
					if (scheduleIsExist == false) {
						clout += putSchedule(dateFormat.format(clday));
					}else{
						clout += putAttendance(dateFormat.format(clday));
					}
				} else {
					clout += "<td class=\"other\">";
					clout += textCount - lastDay - endDate;// 次月
				}
			}
			clout += "</td>";
		}
		clout += "</tr>";
	}
	clout += "</table>";
	document.write(clout);
}
function putSchedule(cldate) {
	var sout = "<form action=\"putSchedule.jsp\" method=\"get\">"
			+ "<input type= \"hidden\" name=\"date\" value =\"" + cldate
			+ "\"/>" + "<button type=\"submit\">予定作成</button>" + "</form>";
	return sout;
}

function putAttendance(cldate) {
	var aout = "<form action=\"putAttendance.jsp\" method=\"get\">"
			+ "<input type= \"hidden\" name=\"date\" value =\""
			+ cldate
			+ "\"/>"
			+ "<button type=\"submit\" name=\"req\" value=\"putAttendance\">出欠入力</button>"
			+ "</form>";
	return aout;

}