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

		body{
			background-color: #d4d4d4;
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
			/*background-color: #7E5005;*/
			width: 245px;
		}

		.side-menu {
			position: fixed;
			top: 0;
			bottom: 0;
			background-color: #3d403a;
			width: 230px;
		}

		.player-box {
			overflow: hidden;
			z-index: 0;
			/*background-color: #C5820D;*/
			position: relative;
			right: 10px;
			margin-right: 370px;
			margin-left: 260px;
		}

		#chat_box {
			position: fixed;
			top: 0;
			right: 0;
			bottom: 0;
			z-index: 0;
			/*background-color: blueviolet;*/
			width: 355px;
		}

		#collapsing_menu_btn {
			width: 14px;
			height: 120px;
			position: fixed;
			top: 40%;
			left: 228px;
			background: url(http://192.168.31.169/images/collapsing.png) no-repeat;
			background-position: -30px 0;
		}

		#collapsing_chat_btn {
			width: 14px;
			height: 120px;
			position: fixed;
			top: 40%;
			right: 355px;
			background: url(http://192.168.31.169/images/collapsing.png) no-repeat;
			transform: rotate(180deg);
			background-position: -30px 0;
		}

	</style>
</head>
<body>
<div id="main_container" class="main-contariner">

	<div id="side_box" class="side-box">
		<div id="side_menu" class="side-menu side-menu-open"></div>
		<a id="collapsing_menu_btn" class="collapsing-menu-btn-open"></a>
	</div>
	<div id="player_box" class="player-box player-box-chat-open player-box-side-open">
		<div id="player"></div>
	</div>
	<div id="chat_box" class="chat-box-open">
		<a id="collapsing_chat_btn" class="collapsing-chat-btn-open"></a>
		<div id="chat_content_box">
			<textarea id="chat_content_area" readonly></textarea>
		</div>
		<div id="chat_input_box">
			<input type="text" onkeypress="getKey()" id="msg" name="name"/>
			<input type="submit" id="msg_submit" name="Submit"/>
		</div>
	</div>

</div>


<script type="text/javascript">
	var nginx_server_ip = "${nginx_server_ip}";
	var stream_key = "${stream_key}";
	var app_name = "${application_name}";
	var tomcat_proxy_server_ip = "${tomcat_proxy_server_ip}";
	var tomcat_server_ip = "${tomcat_server_ip}";
	var live_stream_url = nginx_server_ip + "/live/" + stream_key + "/index.m3u8";
	var webSocketUrl = tomcat_server_ip + "/" + app_name + "/msgservice";

	var player_box = $("#player_box");
	var chat_box = $("#chat_box");
	var chat_textarea = $("#chat_content_area");
	var chat_input_box = $("#chat_input_box");

	var sock = SockJS(webSocketUrl);
	var stomp = Stomp.over(sock);
	//	初始化播放器andwebsocket
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
	stomp.connect({}, function (frame) {
		stomp.subscribe("/topic/msg/" + stream_key, function (message) {
			console.log('Received: ', message);
			setTextArea(message.body);
		});
		setTextArea("connected");
	});

	//	resize
	player.resize(player_box.width(), player_box.width() / 16 * 9);
	chat_textarea.width(chat_box.width());
	chat_textarea.height(chat_box.height() - 100);
	chat_input_box.width(chat_box.width());
	chat_input_box.height(100);

	//	bind enter event
	$("#msg_submit").on("click", submitInput);
	$("#collapsing_menu_btn").on("mouseenter mouseout", MenuMouseOverAction);
	$("#collapsing_menu_btn").on('click', MenuCollapsingBtnToggle);
	$("#collapsing_chat_btn").on("mouseenter mouseout", ChatMouseOverAction);
	$("#collapsing_chat_btn").on('click', ChatCollapsingBtnToggle);

	function ChatMouseOverAction(event) {
		console.log("mouse over action");
		if (event.type == 'mouseenter') {
			if ($(this).hasClass('collapsing-chat-btn-open'))
				$(this).css('background-position-x', '-45px');
			else
				$(this).css('background-position-x', '-15px');
		} else if (event.type == 'mouseout') {
			if ($(this).hasClass('collapsing-chat-btn-open'))
				$(this).css('background-position-x', '-30px');
			else
				$(this).css('background-position-x', '0px');
		}
	}
	function ChatCollapsingBtnToggle() {
		console.log("toggle btn click");
		$("#collapsing_chat_btn").toggleClass("collapsing-chat-btn-open");
		$("#collapsing_chat_btn").toggleClass("collapsing-chat-btn-close");
		$("#collapsing_chat_btn").trigger("mouseover");
//		切换动画
		if ($("#chat_box").hasClass("chat-box-open")) {
			$('#player_box').animate({'margin-right': '20px'}, 200);
			$("#chat_box").animate({width: 0}, 200);
			$("#collapsing_chat_btn").animate({right: '0'}, 200, function () {
				player.resize(player_box.width(), player_box.width() / 16 * 9);
			});
		} else {
			$('#player_box').animate({'margin-right': '370px'}, 200);
			$("#chat_box").animate({width: '355px'}, 200);
		$("#collapsing_chat_btn").animate({right: '355px'}, 200, function () {
				player.resize(player_box.width(), player_box.width() / 16 * 9);
			});
		}
//		切换class
		$("#chat_box").toggleClass("chat-box-open");
		$("#chat_box").toggleClass("chat-box-close");
	}
	function MenuMouseOverAction(event) {
		console.log("mouse over action");
		if (event.type == 'mouseenter') {
			if ($(this).hasClass('collapsing-menu-btn-open'))
				$(this).css('background-position-x', '-45px');
			else
				$(this).css('background-position-x', '-15px');
		} else if (event.type == 'mouseout') {
			if ($(this).hasClass('collapsing-menu-btn-open'))
				$(this).css('background-position-x', '-30px');
			else
				$(this).css('background-position-x', '0px');
		}
	}
	function MenuCollapsingBtnToggle() {
		console.log("toggle btn click");
		$("#collapsing_menu_btn").toggleClass("collapsing-menu-btn-open");
		$("#collapsing_menu_btn").toggleClass("collapsing-menu-btn-close");
		$("#collapsing_menu_btn").trigger("mouseover");
//		切换动画
		if ($("#side_menu").hasClass("side-menu-open")) {
			$('#player_box').animate({'margin-left': '100px'}, 200);
			$("#side_menu").animate({width: "70px"}, 200);
			$("#collapsing_menu_btn").animate({left: '69px'}, 200, function () {
				player.resize(player_box.width(), player_box.width() / 16 * 9);
			});
		} else {
			$('#player_box').animate({'margin-left': '260px'}, 200);
			$("#side_menu").animate({width: "230px"}, 200);
			$("#collapsing_menu_btn").animate({left: '229px'}, 200, function () {
				player.resize(player_box.width(), player_box.width() / 16 * 9);
			});
		}
//		切换class
		$("#side_menu").toggleClass("side-menu-close");
		$("#side_menu").toggleClass("side-menu-open");
	}
	function setTextArea(data) {
		var msg = $("#chat_content_area").val() + "\n" + data;
		$("#chat_content_area").val(msg);
	}
	function saySomething(msg) {
		stomp.send("/app/msg", {'room_id': stream_key}, msg);
	}
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
