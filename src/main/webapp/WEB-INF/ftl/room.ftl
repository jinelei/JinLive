<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>room</title>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
	<script src="${nginx_server_ip}/js/sockjs.min.js"></script>
	<script src="${nginx_server_ip}/js/stomp.js"></script>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	        crossorigin="anonymous"></script>
	<script src="${nginx_server_ip}/js/player/cyberplayer.js"></script>
	<style>
		* {
			padding: 0;
			margin: 0;
		}

		#room_container {
			margin-left: 330px;
			margin-right: 400px;
			/*background-color: #52aabb;*/
		}

		#chat_box {
			position: fixed;
			top: 0;
			right: 0;
			bottom: 0;
			z-index: 0;
			/*background-color: blueviolet;*/
			width: 360px;
		}

		#collapsing_chat_btn {
			width: 14px;
			height: 120px;
			position: fixed;
			top: 40%;
			right: 360px;
			background: url(http://192.168.31.169/images/collapsing.png) no-repeat;
			transform: rotate(180deg);
			background-position: -30px 0;
		}

		#chat_input_box {
			height: 100px;
			padding: 30px 2px;
		}
	</style>
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="room_container">
<#if status == 0 && room?? >
    <#if room.roomName??> <h2 class="text-primary">${room.roomName}</h2></#if>
    <#if room.categoryName?? > <a style="font-size: 17px" class="text-info pull-right"
	                              href="/category/cid/${room.categoryId}">${room.categoryName}</a></#if>
	<hr/>
	<div id="player_box" class="player-box player-box-chat-open player-box-side-open">
		<div id="player"></div>
	</div>
	<hr/>
    <h3 class="text-info">主播介绍</h3>
	<table class="table table-hover">
		<tr>
			<td>主播昵称：</td>
			<td>
                <#if room.userNickname??>
					<span>${room.userNickname}</span>
                <#else>
					保密
                </#if>
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><#if room.userSex == 0>保密<#elseif  room.userSex == 1>男<#elseif room.userSex ==2>女</#if></td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td><#if room.userAge??>${room.userAge}<#else>保密</#if></td>
		</tr>
		<tr>
			<td>身高：</td>
			<td><#if room.userHeight??>${room.userHeight}<#else>保密</#if></td>
		</tr>
		<tr>
			<td>体重：</td>
			<td><#if room.userWeight??>${room.userWeight}<#else>保密</#if></td>
		</tr>
	</table>
	<hr/>
    <#if room.roomIntroduce??> <h3 class="text-info">${room.roomIntroduce}</h3></#if>
</#if>
</div>
<div id="chat_box" class="chat-box-open">
	<a id="collapsing_chat_btn" class="collapsing-chat-btn-open"></a>
	<div id="chat_content_box">
		<textarea id="chat_content_area" readonly></textarea>
	</div>
	<div id="chat_input_box">
    <@security.authorize access="hasAnyRole('USER')">
        <@security.authentication property="principal" var="user"/>
		<div class="input-group">
			<input id="msg" type="text" class="form-control" name="name"
			       placeholder="Join us" aria-describedby="basic-addon1"
			       onkeypress=" if (event.keyCode == 13 && this.value.length != 0)  submitInput() ">
			<span id="msg_submit" class="glyphicon glyphicon-send input-group-addon"
			      onclick="if (document.getElementById('msg').value.length) submitInput()" aria-hidden="true"></span>
		</div>
    </@security.authorize>
    <@security.authorize access="!hasAnyRole('USER')">
		<div style="text-align: center">
			<h4>please
				<a class="text-primary" data-whatever="login" data-toggle="modal"
				   data-target="#user_modal" href="#">Login</a>
			</h4>
		</div>
    </@security.authorize>
	</div>
</div>

<script>

	//    init websocket
	var webSocketUrl = "${tomcat_server_ip}" + "/" + "${application_name}" + "/msgservice";
	var stomp = Stomp.over(SockJS(webSocketUrl));
	stomp.connect({}, function (frame) {
		stomp.subscribe("/topic/msg/" + "${stream_key}", function (message) {
			console.log('Received: ', message);
			setTextArea(message.body);
		});
		setTextArea("connected");
	});

	//	init player
	var live_stream_url = "${nginx_server_ip}" + "/stream/" + "${stream_key}" + "/index.m3u8";

	//		初始化播放器andwebsocket
	var player = cyberplayer("player").setup({
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

	//	resize
	playerBoxResize();
	initChatContainer();

	//	bind event
	$("#collapsing_chat_btn").on("mouseenter mouseout", ChatMouseOverAction);
	$("#collapsing_chat_btn").on('click', ChatCollapsingBtnToggle);
	$("#menu_container").on('boxzoomin boxzoomout', function (event) {
		if (event.type == 'boxzoomin') {
			$('#room_container').animate({'margin-left': '100px'}, 200, playerBoxResize);
		} else if (event.type == 'boxzoomout') {
			$('#room_container').animate({'margin-left': '330px'}, 200, playerBoxResize);
		}
	})
	$("#chat_box").on('boxzoomin boxzoomout', function (event) {
		console.log(event.type);
		if (event.type == 'boxzoomin') {
			console.log("zoomin")
			$('#room_container').animate({'margin-right': '20px'}, 100, playerBoxResize);
		} else if (event.type == 'boxzoomout') {
			console.log("zoomout")
			$('#room_container').animate({'margin-right': '400px'}, 100, playerBoxResize);
		}
	});

	//	functions
	function ChatMouseOverAction(event) {
//		console.log("mouse over action");
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
//		console.log("toggle btn click");
		$("#collapsing_chat_btn").toggleClass("collapsing-chat-btn-open");
		$("#collapsing_chat_btn").toggleClass("collapsing-chat-btn-close");
		$("#collapsing_chat_btn").trigger("mouseover");
//		切换动画
		if ($("#chat_box").hasClass("chat-box-open")) {
			$("#collapsing_chat_btn").animate({right: '0'}, 200);
			$("#chat_box").animate({width: 0}, 200, function () {
				$("#chat_box").trigger("boxzoomin");
			});
		} else {
			$("#collapsing_chat_btn").animate({right: '360px'}, 200);
			$("#chat_box").animate({width: '360px'}, 200, function () {
				$("#chat_box").trigger("boxzoomout");
			});
		}
//		切换class
		$("#chat_box").toggleClass("chat-box-open");
		$("#chat_box").toggleClass("chat-box-close");
	}
	function setTextArea(data) {
		var msg = $("#chat_content_area").val() + "\n" + data;
		$("#chat_content_area").val(msg);
	}
	function saySomething(msg) {
		stomp.send("/app/msg", {'room_id': "${stream_key}"}, msg);
	}
	function submitInput() {
		var msg = $("#msg").val();
		saySomething(msg);
		$("#msg").val("");
	}
	function playerBoxResize() {
		var wid = document.getElementById("room_container").clientWidth;
		var hei = wid * 8 / 16;
		player.resize(wid, hei);
	}
	function initChatContainer() {
		$("#chat_content_area").width($("#chat_box").width());
		$("#chat_content_area").height($("#chat_box").height() - 100);
		$("#chat_input_box").width($("#chat_box").width());
		$("#chat_input_box").height(100);
	}

</script>

</body>
</html>
