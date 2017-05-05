<style>

	#chat_box {
		position: fixed;
		top: 0;
		right: 0;
		bottom: 0;
		z-index: 0;
		/*background-color: blueviolet;*/
		width: 355px;
	}

	#chat_content_area {
		resize: none;
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
		border: 1px red dashed;
		padding: 30px 0;
	}

</style>
<#assign security=JspTaglibs["/WEB-INF/tlds/security.tld"]/>
<div id="chat_box" class="chat-box-open">
	<a id="collapsing_chat_btn" class="collapsing-chat-btn-open"></a>
	<div id="chat_content_box">
		<textarea id="chat_content_area" readonly></textarea>
	</div>
	<div id="chat_input_box">
    <#--<@security.authorize access="hasAnyRole('USER')">-->
    <#--<@security.authentication property="principal" var="user"/>-->
    <#--<div class="input-group">-->
    <#--<input hidden id="username_hidden" value="${user.userName}">-->
    <#--<input id="msg" type="text" class="form-control" name="name" onkeypress="getKey()"-->
    <#--placeholder="Join with us" aria-describedby="basic-addon1">-->
    <#--<span id="msg_submit" class="glyphicon glyphicon-send input-group-addon" aria-hidden="true"></span>-->
    <#--</div>-->
    <#--</@security.authorize>-->
    <#--<@security.authorize access="!hasAnyRole('USER')">-->
    <#--<div>-->
    <#--click me-->
    <#--<span class="user-action-item side-open" data-whatever="login" data-toggle="modal" data-target="#user_modal"-->
    <#--role="button">login-->
    <#--</span>-->
    <#--</div>-->
    <#--</@security.authorize>-->
		<input type="text" onkeypress="getKey()" id="msg" name="name"/>
		<input type="submit" id="msg_submit" name="Submit"/>
	</div>
</div>


<script type="text/javascript">

	var player_box = $("#player_box");
	var chat_box = $("#chat_box");
	var chat_textarea = $("#chat_content_area");
	var chat_input_box = $("#chat_input_box");
	var webSocketUrl = "${nginx_server}/${application_name}/chat";
//    var webSocketUrl = "http://localhost/msgservice";
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
