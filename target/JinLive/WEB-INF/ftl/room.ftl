<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Demo: play HLS video</title>
</head>
<body>
<div id="playercontainer"></div>
<input id="server_ip" value="${server_ip}" hidden/>
<input id="stream_id" value="${stream_id}" hidden/>


<div>
	<textarea style="width: 200px;height: 600px;"></textarea>
	<div style="width: 200px;height: 50px;"
	<input type="text" id="msg" name="name"/>
	<input type="submit" name="Submit"/>
</div>
</div>


<script type="text/javascript" src="/js/player/cyberplayer.js"></script>
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
	var server_ip = $("#server_ip").val();
	var stream_id = $("#stream_id").val();
	console.log("server_ip: " + server_ip);
	var live_stream_url = "http://" + server_ip + "/live/" + stream_id + "/index.m3u8";
	var player = cyberplayer("playercontainer").setup({
		width: 854,
		height: 480,
		stretching: "uniform",
		file: live_stream_url,
		autostart: true,
		repeat: false,
		volume: 100,
		controls: true,
		ak: '7f266db038bd47eaaea92c43055153ab' // 公有云平台注册即可获得accessKey
	});

	//send bullet screen
	var websocket_url = "ws://" + server_ip + "/bullet";
	var socket = new WebSocket(websocket_url);
	socket.onopen = function () {
		console.log("ws on load");
		saySomething("on load message");
	}
	socket.onclose = function () {
		console.log("ws on close");
	}
	socket.onerror = function () {
		console.log("ws on error");
	}
	function saySomething(str) {
		console.log("ws send: " + str);
		socket.send(str);
	}
</script>
</body>
</html>
