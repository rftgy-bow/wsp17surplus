/**
 *
 */
// TODO フォントサイズ指定を変数から指定する
// TODO データ幅からグラフのWidthHeightを変更する
// TODO グラフの長さからサイズを拡大縮小する
// contextの取得
var timeline = document.getElementById('timeline');
var ctx = timeline.getContext('2d');

// グラフに関する座標データ
var width = timeline.width;
var height = timeline.height;
var dateSize = 22;// 左上の日付フォントサイズ
var timeSize = 12;// 上の時間座標フォントサイズ(timeSize<dateSize)
var nameSize = 12;// usernameのフォントサイズ
var nameWidth = 80;// usernameの幅
var hourWidth = 60;// 1時間における幅
var minWidth = hourWidth / 60;// 1分における幅
var lineSize = 30;// タイムラインバーの幅
var lineMargin = 10;// タイムラインバーのmargin
// 時間に関するデータ
// SessionからstartTimeとendTimeのStringを取得している
// HH:mm形式からint(整数)型の数字に変換する
var dateFormat = new DateFormat("HH:mm:ss");

var startTime = "09:00:00";
var endTime = "21:00:00";
var start = dateFormat.parse(startTime);
var end = dateFormat.parse(endTime);
var s ;
var e ;
console.log(s);
console.log(e);

// タイムラインに関するデータ
// 個々の配列を作る
// 名前
/*var username = [];
username.push("小宮");
username.push("田中");
*/
// 時間
/*
 * var ah = []; var am = []; var lh = []; var lm = []; var attendTime = "09:00";
 * var leaveTime = "18:30"; var attend = dateFormat.parse(attendTime); var leave =
 * dateFormat.parse(leaveTime); ah.push(attend.getHours());
 * am.push(attend.getMinutes()); lh.push(leave.getHours());
 * lm.push(leave.getMinutes());
 */

// 描画 jsp側で書くことにした
// drawOutline();
// drawText();
// drawTimeline();
// function群

function initTime(startTime,endTime){
	var startt = dateFormat.parse(startTime);
	var endd = dateFormat.parse(endTime);
	s = startt.getHours();
	e = endd.getHours();
	console.log(s);
	console.log(e);
}

function drawOutline() {
	// アウトライン
	ctx.beginPath();
	ctx.moveTo(0, dateSize);
	ctx.lineTo(width, dateSize)
	ctx.moveTo(nameWidth, dateSize);
	ctx.lineTo(nameWidth, height);
	ctx.stroke();
	ctx.moveTo(nameWidth + 5, dateSize);
	ctx.lineTo(nameWidth + 5, height);
	ctx.stroke();
	// 時間の点線
	for (var i = 0; i < 13; i++) {
		var x = nameWidth + 20 + i * hourWidth;
		strokeDottedLine(x, dateSize, x, height);
	}
}

function drawText() {
	// 上の日付
	ctx.fillStyle = "black";
	ctx.font = "22px 'Calibri'";
	ctx.textAlign = "left";
	ctx.textBaseline = "top";
	ctx.fillText("6/29(木)", 5, 0);
	// 上の時間
	ctx.fillStyle = "black";
	ctx.font = "12px 'Calibri'";
	ctx.textAlign = "center";
	ctx.textBaseline = "top";
	for (var i = 0; s + i <= e+1; i++) {
		ctx.fillText(s + i + ":00", nameWidth + 20 + i * hourWidth, dateSize
				- timeSize);
	}

}

function drawTimeline(username, attendTime, leaveTime, index) {
	// タイムライン
	// TODO 遅刻早退で色を変える
	// 時間をフォーマット
	var times = formatTime(attendTime, leaveTime);
	// 名前
	ctx.fillStyle = "black";
	ctx.font = "18px 'Calibri'";
	ctx.textAlign = "center";
	ctx.textBaseline = "middle";
	ctx.fillText(username, nameWidth / 2, dateSize + lineSize * index
			+ lineMargin * (index + 1) + lineSize / 2, nameWidth);
	// バー
	console.log("attendTime" + times.ah + ":" + times.am);
	console.log("leaveTime" + times.lh + ":" + times.lm);
	ctx.beginPath();
	ctx.fillStyle = "#0000ff";
	var x = nameWidth + 20 + (times.ah - s) * hourWidth + times.am * minWidth;
	var y = dateSize + lineSize * index + lineMargin * (index + 1);
	var w = (times.lh - times.ah) * hourWidth + (times.lm - times.am) * minWidth;
	ctx.fillRect(x, y, w, lineSize);

}

function formatTime(attendTime, leaveTime) {
	var attend = dateFormat.parse(attendTime);
	var leave = dateFormat.parse(leaveTime);
	var ah = attend.getHours()
	var am = attend.getMinutes();
	var lh = leave.getHours();
	var lm = leave.getMinutes();
	return {
		ah : ah,
		am : am,
		lh : lh,
		lm : lm
	};
}

// 点線を引くためのfunction
// http://www.jstarted.com/article/000287.shtml
function strokeDottedLine(p1x, p1y, p2x, p2y) {
	var d = Math.sqrt(Math.pow(p2x - p1x, 2) + Math.pow(p2y - p1y, 2));
	var rad = Math.atan2(p2y - p1y, p2x - p1x);
	var space = 10;
	var dotted = Math.round(d / space / 2);

	for (var i = 0; i < dotted; i++) {
		var p3x = Math.cos(rad) * space * (i * 2) + p1x;
		var p3y = Math.sin(rad) * space * (i * 2) + p1y;
		var p4x = Math.cos(rad) * space * (i * 2 + 1) + p1x;
		var p4y = Math.sin(rad) * space * (i * 2 + 1) + p1y;

		ctx.beginPath();
		ctx.moveTo(p3x, p3y);
		ctx.lineTo(p4x, p4y);
		ctx.stroke();
		ctx.closePath();
	}
};