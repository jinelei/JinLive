<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>search result</title>
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
	<style>
		* {
			padding: 0;
			margin: 0;
		}

		#template_container {
			margin-left: 330px;
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

		#chat_input_box {
			height: 100px;
			padding: 30px 2px;
		}
	</style>
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="template_container">

</div>
<div id="chat_box" class="chat-box-open">
	<a id="collapsing_chat_btn" class="collapsing-chat-btn-open"></a>
	<div id="chat_content_box">
		<textarea id="chat_content_area" readonly></textarea>
	</div>
	<div id="chat_input_box">
    <#--<input type="text" onkeypress="getKey()" id="msg" name="name"/>-->
    <#--<input type="submit" id="msg_submit" name="Submit"/>-->

    <@security.authorize access="hasAnyRole('USER')">
        <@security.authentication property="principal" var="user"/>
		<div class="input-group">
			<input id="msg" type="text" class="form-control" name="name"
			       placeholder="Join us" aria-describedby="basic-addon1">
			<span id="msg_submit" class="glyphicon glyphicon-send input-group-addon" aria-hidden="true"></span>
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

	var player_box = $("#player_box");
	var chat_box = $("#chat_box");
	var chat_textarea = $("#chat_content_area");
	var chat_input_box = $("#chat_input_box");
	var webSocketUrl = "${tomcat_server_ip}" + "/" + "${application_name}" + "/msgservice";
    <#--var webSocketUrl = "${tomcat_server_ip}" +"/live/msgservice";-->
	var sock = SockJS(webSocketUrl);
	var stomp = Stomp.over(sock);
	stomp.connect({}, function (frame) {
		stomp.subscribe("/topic/msg/" + "${stream_key}", function (message) {
			console.log('Received: ', message);
			setTextArea(message.body);
		});
		setTextArea("connected");
	});

	chat_textarea.width(chat_box.width());
	chat_textarea.height(chat_box.height() - 100);
	chat_input_box.width(chat_box.width());
	chat_input_box.height(100);

	//	bind enter event
	$("#collapsing_chat_btn").on("mouseenter mouseout", ChatMouseOverAction);
	$("#collapsing_chat_btn").on('click', ChatCollapsingBtnToggle);
	$("#msg_submit").on("click", submitInput);

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
			$("#collapsing_chat_btn").animate({right: '355px'}, 200);
			$("#chat_box").animate({width: '355px'}, 200, function () {
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
