<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Demo: play HLS video</title>
</head>
<body>
<div id="main_container">
	<div id="playercontainer"></div>

	<div>
		<textarea style="width: 200px;height: 600px;" id="message-area"></textarea>
		<div style="width: 200px;height: 50px;">
			<input type="text" id="msg" name="name"/>
			<input type="submit" id="msg_submit" name="Submit"/>
		</div>
	</div>

	<input id="server_ip" value="${server_ip}" hidden/>
	<input id="stream_id" value="${stream_id}" hidden/>
</div>


<script type="text/javascript" src="js/player/cyberplayer.js"></script>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
	var server_ip = $("#server_ip").val();
	var stream_id = $("#stream_id").val();
	//	console.log("server_ip: " + server_ip);
	var live_stream_url = "http://" + server_ip + "/live/" + stream_id + "/index.m3u8";
//		var live_stream_url = "rtmp://" + server_ip + ":1935/live/" + stream_id;
		console.log(live_stream_url);
	var player = cyberplayer("playercontainer").setup({
		width: 854,
		height: 480,
		stretching: "uniform",
		file: live_stream_url,
		autostart: true,
//		repeat: false,
//		rtmp: {
//			reconnecttime: 5, // rtmp直播的重连次数
//			bufferlength: 1 // 缓冲多少秒之后开始播放 默认1秒
//		},
		volume: 100,
		controls: true,
		ak: '7f266db038bd47eaaea92c43055153ab' // 公有云平台注册即可获得accessKey
	});

	//send bullet screen
	var websocket_url = "ws://localhost:8080/live/websck";
	var socket = new WebSocket(websocket_url);
	socket.onopen = function () {
		console.log("ws on load");
	}
	socket.onclose = function () {
		console.log("ws on close");
	}
	socket.onerror = function (err) {
		console.log("ws on error");
		console.log(err);
	}
	socket.onmessage = function (event) {
		console.log(event.data);
		setTextArea(event.data);
	}
	function saySomething(str) {
		socket.send(str);
		setTextArea(str);
	}
	function setTextArea(data) {
		var msg = $("#message-area").val() + "\n" + data;
		$("#message-area").val(msg);
	}
	$("#msg_submit").on("click", function () {
		var msg = $("#msg").val();
		saySomething(msg);
	})

</script>
</body>
</html>
