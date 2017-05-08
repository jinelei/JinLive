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
	<link rel="stylesheet" href="/css/base.css">

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
	                              href="/${application_name}/category/cid/${room.categoryId}">${room.categoryName}</a></#if>
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

<script src="/js/room.js"></script>

</body>
</html>
