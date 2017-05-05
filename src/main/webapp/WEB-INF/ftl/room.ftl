<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>room</title>
	<script src="/js/jquery-3.2.0.min.js"></script>
	<script src="/js/sockjs.min.js"></script>
	<script src="/js/stomp.js"></script>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	        crossorigin="anonymous"></script>
	<script src="/js/player/cyberplayer.js"></script>
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

		.item {
			width: 300px;
			display: inline-block;
			background-color: white;
			box-shadow: 0px 0px 6px 3px #4c4948;
			margin: 4px;
			position: relative;
			transition: all 550ms;
		}

		.item_screenshot {
			width: 300px;
			height: 170px;
			display: inline-block;
			background-color: darkslategrey;
		}

		.item_content_mask_layer {
			width: 300px;;
			height: 170px;
			position: absolute;
			z-index: 1000;
			opacity: 0;
			transition: background 0.9s;
		}

		.item_content_mask_layer_img {
			position: absolute;
			top: 50%;
			left: 50%;
			margin-left: -32px;
			margin-top: -32px;
			opacity: 0;
			transition: all 0.5s;
		}

		.item:hover .item_content_mask_layer {
			background: black;
			opacity: 0.6;
		}

		.item:hover .item_content_mask_layer_img {
			opacity: 0.5;
			transform: scale(1.5, 1.5);
		}

		.item:hover .item_content_mask_layer_img {
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-left: -32px;
			margin-top: -32px;
			opacity: 1;
			/*transition: all ease-out 250ms;*/
		}

		.item_info {
			width: 300px;
			height: 50px;
			background-color: #dddedb;
			position: relative;
		}

		.item_info_room_name {
			text-align: center;
			font-size: 15px;;
			margin: 0;
			padding: 3px 5px;
			position: relative;
		}

		.item_info_user_name {
			background: url(http://127.0.0.1/images/anchors.png) 0 3px no-repeat;
			text-align: left;
			font-size: 12px;;
			padding: 1px 3px 1px 14px;
			margin: 0;
			position: absolute;
			left: 5px;
			top: 25px;
		}

		.item_info_room_status {
			position: absolute;
			top: 50px;
			right: 1px;
			background-color: #295680;
			padding: 3px 5px;
			box-shadow: 0px 0px 3px 2px #0e4127;
			color: white;
		}
	</style>
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="room_container">
<#if status == 0 && room?? >
    <#if room.roomName??> <h2 class="text-primary">${room.roomName}</h2></#if>
    <#if room.roomId??> <span class="text-info pull-left"
	                          style="font-size: 20px">房间号：&nbsp;${room.roomId?string('0.##')}&nbsp;&nbsp;&nbsp;</span></#if>
    <#if subscribeStatus?? >
        <#if subscribeStatus == 0>
			<span data-for="${subscribeStatus}" class="subscribe-btn glyphicon glyphicon-eye-open pull-left"
			      style="font-size: 20px"></span>
			<label data-for="${subscribeStatus}" style="font-size: 17px"
			       class="subscribe-btn text-info pull-left">已关注</label>
        <#else>
			<span data-for="${subscribeStatus}" class="subscribe-btn glyphicon glyphicon-eye-close pull-left"
			      style="font-size: 20px"></span>
			<label data-for="${subscribeStatus}" style="font-size: 17px"
			       class="subscribe-btn text-info pull-left">关注</label>
        </#if>
    </#if>
    <#if room.categoryName?? > <a style="font-size: 17px" class="text-info pull-right"
	                              href="/live/category/cid/${room.categoryId}">${room.categoryName}</a></#if>
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
	var webSocketUrl ="${nginx_server}:8080/${application_name}/chat";
	var stomp = Stomp.over(SockJS(webSocketUrl));
	stomp.connect({}, function (frame) {
		stomp.subscribe("/topic/msg/" + "${room.streamKey}", function (message) {
			console.log('Received: ', message);
			setTextArea(message.body);
		});
		setTextArea("connected");
	});

	//	init player
	var live_stream_url = "/stream/" + "${room.streamKey}" + "/index.m3u8";

	var room_status = "${room.roomStatus}";

	if (room_status != 0) {
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
	} else {
		console.log("on reset")
	}

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
	$(".subscribe-btn").on('click', function () {
		var status = $(this).attr('data-for');
		console.log(status);
		var roomId = ${room.roomId?string('0.##')}
		if (status == 2) {
//		    触发登录
			$("#user_login_btn").trigger('click');
		} else if (status == 1) {
//		    请求关注
			var url = "${nginx_server}/${application_name}/room/subscribe/confirm/roomid/" + roomId;
			$.post(url, function (data) {
				var res = JSON.parse(data);
				if (res.status == 0) {
					alert("关注成功");
					location.reload(true);
				}
			})
		} else if (status == 0) {
//		    解除关注
			var url = "${nginx_server}/${application_name}/room/subscribe/cancel/roomid/" + roomId;
			$.post(url, function (data) {
				var res = JSON.parse(data);
				if (res.status == 0) {
					alert("解除关注成功");
					location.reload(true);
				}
			})
		}
	})

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
		stomp.send("/app/msg", {'room_id': "${room.roomId}"}, msg);
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
