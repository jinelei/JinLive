<!DOCTYPE html>
<html>
<head>
	<#--<meta http-equiv="Access-Control-Allow-Origin" content="*.127.0.0.1"/>-->
	<title>Demo: play HLS video</title>
	<script src="${base}/js/sockjs.min.js"></script>
	<script src="${base}/js/stomp.js"></script>
	<script src="${base}/js/jquery-3.2.0.min.js"></script>
</head>
<body>
<div id="main_container">
	<div id="playercontainer"></div>

	<h5>${base}</h5>

	<div>
		<textarea style="width: 200px;height: 600px;" id="message-area"></textarea>
		<div style="width: 200px;height: 50px;">
			<input type="text" onkeypress="getKey()" id="msg" name="name"/>
			<input type="submit" id="msg_submit" name="Submit"/>
		</div>
	</div>

	<input id="server_ip" value="${server_ip}" hidden/>
	<input id="stream_id" value="${stream_id}" hidden/>
	<input id="base_path" value="${base}" hidden/>
	<input id="server_ip" value="${server}" hidden/>
</div>


<script type="text/javascript" src="${base}/js/player/cyberplayer.js"></script>
<script type="text/javascript" src="${base}/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
	var server_ip = $("#server_ip").val();
	var stream_id = $("#stream_id").val();
	var base_path = $("#base_path").val();
	var server_ip= $("#server_ip").val();
	//	console.log("server_ip: " + server_ip);
//	var live_stream_url = base_path + "/" + stream_id + "/index.m3u8";
	var live_stream_url = server_ip+ "/live/" + stream_id + "/index.m3u8";
//	    var live_stream_url = "rtmp://" + server_ip + ":1935/live/" + stream_id;
	console.log(live_stream_url);
	var player = cyberplayer("playercontainer").setup({
		width: 854,
		height: 480,
		stretching: "uniform",
		file: live_stream_url,
//		autostart: false,
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

	var url = base_path + "/msgservice";
	//	var url = "http://" + window.location.host + "/tomcat/live/msgservice";
	var sock = SockJS(url);
	var stomp = Stomp.over(sock);
	stomp.connect({}, function (frame) {
		stomp.subscribe("/topic/msg/" + stream_id, function (message) {
			console.log('Received: ', message);
			setTextArea(message.body);
		});
		setTextArea("connected");
	});

	function setTextArea(data) {
		var msg = $("#message-area").val() + "\n" + data;
		$("#message-area").val(msg);
	}

	function saySomething(msg) {
		stomp.send("/app/msg", {'room_id': stream_id}, msg);
	}

	$("#msg_submit").on("click", submitInput);

	function submitInput() {
		var msg = $("#msg").val();
//		setTextArea(msg);
		saySomething(msg);
		$("#msg").val("");
	}

	function getKey() {
		if (event.keyCode == 13) {
			submitInput();
		}
	}

</script>
</body>
</html>