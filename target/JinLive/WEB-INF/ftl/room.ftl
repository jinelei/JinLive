<!DOCTYPE html>
<html>
<head>
<#--<meta http-equiv="Access-Control-Allow-Origin" content="*.127.0.0.1"/>-->
	<title>Demo: play HLS video</title>
	<script src="${nginx_server_ip}/js/sockjs.min.js"></script>
	<script src="${nginx_server_ip}/js/stomp.js"></script>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
	<script src="${nginx_server_ip}/js/player/cyberplayer.js"></script>
	<style>
		* {
			margin: 0;
			padding: 0;
		}

		.main-contariner {
			position: relative;
			width: 100%;
			height: 100%;
		}

		.side-box {
			position: fixed;
			top: 0;
			bottom: 0;
			left: 0;
			background-color: #7E5005;
			z-index: 0;
		}

		.side-box-open {
			width: 230px;
		}

		.side-box-close {
			width: 40px;
		}

		.player-box {
			overflow: hidden;
			z-index: 0;
			background-color: #C5820D;
			position: relative;
			height:400px;
			right:10px;
		}
		.player-box-chat-open{
			margin-right: 370px;
		}
		.player-box-chat-close{
			margin-right: 30px;
		}
		.player-box-side-open{
			margin-left:250px;
		}
		.player-box-side-close{
			margin-left: 50px;
		}

		.chat-box {
			position: fixed;
			top: 0;
			right: 0;
			bottom: 0;
			z-index: 0;
			background-color: blueviolet;
		}

		.chat-box-open {
			width: 370px;
		}

		.chat-box-close {
			width: 30px;
		}
	</style>
</head>
<body>
<div id="main_container" class="main-contariner">

	<div id="side_box" class="side-box side-box-open"></div>
	<div id="player_box" class="player-box player-box-chat-open player-box-side-open">
        <div id="player"></div>
	</div>
	<div id="chat_box" class="chat-box-open chat-box">
		<div id="chat_content_box">
			<textarea id="chat_content_area"></textarea>
		</div>
		<div id="chat_input_box">
			<input type="text" onkeypress="getKey()" id="msg" name="name"/>
			<input type="submit" id="msg_submit" name="Submit"/>
		</div>
	</div>

</div>


<script type="text/javascript">
	var nginx_server_ip = "${nginx_server_ip}";
	var stream_id = "${stream_id}";
	var app_name = "${application_name}";
	var tomcat_proxy_server_ip = "${tomcat_proxy_server_ip}";
	var tomcat_server_ip = "${tomcat_server_ip}";
	var live_stream_url = nginx_server_ip + "/live/" + stream_id + "/index.m3u8";
	console.log(live_stream_url);
	var player = cyberplayer("player").setup({
		width: 854,
		height: 480,
		stretching: "uniform",
		file: live_stream_url,
		autostart: true,
//		repeat: false,
		rtmp: {
			reconnecttime: 5, // rtmp直播的重连次数
			bufferlength: 1 // 缓冲多少秒之后开始播放 默认1秒
		},
		volume: 100,
		controls: true,
		ak: '7f266db038bd47eaaea92c43055153ab' // 公有云平台注册即可获得accessKey
	});

	var webSocketUrl = tomcat_server_ip + "/" + app_name + "/msgservice";
	console.log(webSocketUrl);
	var sock = SockJS(webSocketUrl);
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
