<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>room</title>
<#--<script src="/js/room.js"></script>-->
	<script src="/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/css/base.css">
	<script src="/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
	<script src="/js/sockjs.min.js"></script>
	<script src="/js/stomp.js"></script>
	<script src="/js/player/cyberplayer.js"></script>

</head>
<body>

<#include  'menu-navigation.ftl'>
<#--<script src="/js/user.js"></script>-->

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
	                              href="/${application_name}/category/cid/${room.categoryId}">${room.categoryName}</a></#if>
	<hr/>
	<div id="player_box" class="player-box player-box-chat-open player-box-side-open">
		<div id="player">
		</div>
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
	var sock = new WebSocket("ws://localhost/${application_name}/chat");
	var stomp = Stomp.over(sock);
	stomp.connect({}, function (frame) {
		stomp.subscribe("/topic/msg/" + "${room.roomId}", function (message) {
			console.log('Received: ', message);
			setTextArea(message.body);
		});
		setTextArea("connected");
	});

	//	init player
	var live_stream_url = "/stream/" + "${room.streamKey}" + "/index.m3u8";
	var live_stream_image = "/screenshot/" + "${room.streamKey}.jpg";

	var room_status = "${room.roomStatus}";

	if (room_status != 0) {
		//		初始化播放器andwebsocket
		var player = cyberplayer("player").setup({
			width: 854,
			height: 480,
			stretching: "uniform",
			file: live_stream_url,
			autostart: true,
			volume: 100,
			controls: true,
			stretching: 4,
			controlbar: {
				barLogo: false
			},
			ak: '7f266db038bd47eaaea92c43055153ab' // 公有云平台注册即可获得accessKey
		});
	} else {
		console.log("on reset")
		var player = cyberplayer("player").setup({
			width: 854,
			height: 480,
			stretching: "uniform",
			file: live_stream_url,
			autostart: false,
			image: live_stream_image,
			volume: 100,
			controls: false,
			controlbar: {
				barLogo: false
			},
			ak: '7f266db038bd47eaaea92c43055153ab' // 公有云平台注册即可获得accessKey
		});
		$("<div id='rest_disp' class='rest-div'><h3><@spring.message 'web.room.rest.tips'/></h3><img src='/images/rest.png'/><h4><@spring.message 'web.return'/><a href='/jinlive/index'><@spring.message 'web.home'/></a></h4></div>").appendTo($("#player_box"));

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
		var username = $("#user_info_btn").text();
		stomp.send("/app/msg", {'room_id': "${room.roomId}", "user_name": username.trim()}, msg);
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
