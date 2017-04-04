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
		#room_matrix{
			width:100%;
			height:100%;
			background-color: aliceblue;
			position: relative;
		}
		#side-box{
			position: fixed;
			width:30px;
			height:100%;
			background-color: burlywood;
		}
		#main_container{
			position: relative;
			top:0;
			left:0;
			right:0;
		}
		#player_box{
			position: relative;
			margin-right: 400px;
			top:0;
			left:0;
			right:0;
            background-color: darkolivegreen;
		}
		#chat_room_box{
			position: fixed;
			top:0;
			left:0;
			right:0;
            background-color: darkcyan;
		}
		#chat_content_box{
			position: relative;
			width:100%;
			height:90%;
		}
        #chat_input_box{
	        position: relative;
	        width:100%;
	        height:10%;
	        bottom:0;
        }

	</style>
</head>
<body>
<div id="room_matrix">
	<div id="side-box"></div>
	<div id="main_container">
		<div id="player_box"></div>
		<div id="chat_room_box">
            <div id="chat_content_box">
                <textarea id="chat_content_area"></textarea>
            </div>
			<div id="chat_input_box">
				<input type="text" onkeypress="getKey()" id="msg" name="name"/>
				<input type="submit" id="msg_submit" name="Submit"/>
			</div>
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
	var player = cyberplayer("player_box").setup({
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
