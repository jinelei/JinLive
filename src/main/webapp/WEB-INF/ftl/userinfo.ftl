<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>search result</title>
	<script src="/js/jquery-3.2.0.min.js"></script>
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

		#userinfo_container {
			margin-left: 330px;
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
<div id="userinfo_container">
	<div class="row">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#" data-for="user_info_disp">个人信息</a>
				</li>
				<li>
					<a href="#" data-for="user_subscribe_disp">我的关注</a>
				</li>
				<li style="display: none;" id="nav_room_setting">
					<a href="#" data-for="room_setting_disp">直播间</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="nav-toggle-panel" id="user_info_disp">
    <#if status ==0 && user?? && user != "anonymousUser">
		<input hidden id="modify_user_id" value="${user.userId}">
		<br/>
		<h3 class="text-info">个人信息</h3>
		<table class="table table-hover">
			<tr>
				<td>昵称：</td>
				<td><span>
                    <#if user.userNickname??> ${user.userNickname}
                    <#else>
						无
                    </#if></span>
					&nbsp;&nbsp;&nbsp;<a id="modify_user_nickname" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_nickname_input" type="text" class="form-control modify-user-input"
						       name="nickname"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_nickname_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_nickname_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><span>
                    <#if user.userSex == 0>保密<#elseif  user.userSex == 1>男<#elseif user.userSex ==2>女</#if></span>
					&nbsp;&nbsp;&nbsp;<a id="modify_user_sex" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_sex_input" type="text" class="form-control modify-user-input"
						       name="sex"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_sex_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_sex_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><span>
                    <#if user.userAge??>${user.userAge}<#else>无</#if></span>
					&nbsp;&nbsp;&nbsp;<a id="modify_user_age" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_age_input" type="text" class="form-control modify-user-input"
						       name="age"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_age_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_age_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>身高：</td>
				<td><span>
                    <#if user.userHeight?? >${user.userHeight}<#else>无</#if></span>
					&nbsp;&nbsp;&nbsp; <a id="modify_user_height" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_height_input" type="text" class="form-control modify-user-input"
						       name="height"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_height_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_height_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>体重：</td>
				<td><span>
                    <#if user.userWeight??>${user.userWeight}<#else>无</#if></span>
					&nbsp;&nbsp;&nbsp; <a id="modify_user_weight" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_weight_input" type="text" class="form-control modify-user-input"
						       name="weight"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_weight_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_weight_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
		</table>

		<br/>
		<h3 class="text-info">联系方式</h3>
		<table class="table table-hover">
			<tr>
				<td>邮箱：</td>
				<td>
                    <#if user.userEmail??>${user.userEmail}<#else>无</#if></span>
					&nbsp;&nbsp;&nbsp; <a id="modify_user_email" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_email_input" type="text" class="form-control modify-user-input"
						       name="email"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_email_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_email_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-remove-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><span>
                    <#if user.userPhone??>${user.userPhone}<#else>无</#if></span>
					&nbsp;&nbsp;&nbsp;<a id="modify_user_phone" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_phone_input" type="text" class="form-control modify-user-input"
						       name="phone"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_phone_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_phone_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
		</table>
		<br/>
		<h3 class="text-info">帐号信息</h3>
		<table class="table table-hover">
			<tr>
				<td>密码：</td>
				<td>
					<span>********</span>
					&nbsp;&nbsp;&nbsp;<a id="modify_user_password" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_user_password_input" type="passwor" class="form-control modify-user-input"
						       name="password"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_user_password_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-user-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_user_password_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-user-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>用户状态：</td>
				<td>
                    <#if user.userStatus??><input hidden id="user_status" value="${user.userStatus}"></#if>
					<span id="user_status_disp"></span>
				</td>
			</tr>
			<tr hidden>
				<td>房间号：</td>
				<td>
					<span id="user_room_key"></span>
				</td>
			</tr>
			<tr>
				<td>财富值：</td>
				<td><span>
                    <#if user.userTreasure??>${user.userTreasure}<#else>无</#if></span>
				</td>
			</tr>
		</table>
    <#else>
		<div style="text-align: center">
			<h4 style="padding-top: 80px">Please
				<a class="text-primary" data-whatever="login" data-toggle="modal"
				   data-target="#user_modal" href="#">Login</a>
			</h4>
		</div>
    </#if>
	</div>
	<div class="nav-toggle-panel" id="user_subscribe_disp" style="display: none;">
    <#if online?? || offline??>
        <#if online??>
			<h4 class="text-primary">直播中</h4>
            <#list online as room>
				<div class="col-lg-3">
					<div class="item" id="${room.streamKey}">
						<div class="item_content_mask_layer">
							<img class="item_content_mask_layer_img" src="/images/play-button.png"/>
						</div>
						<div class="item_screenshot">
                            <#if room.roomScreenshot ?? >
								<h2>asdf</h2>
                            <#else>
								<img src="/images/default-screenshot.png">
                            </#if>
						</div>
						<div class="item_info_room_status">
                            <#if  room.roomStatus == 1 >
								<span>Live</span>
                            <#else>
								<span>Rest</span>
                            </#if>
						</div>
						<div class="item_info">
							<span class="item_info_room_name"> ${room.roomName}</span>
							<span class="item_info_user_name"> ${room.userName}</span>
						</div>
					</div>
				</div>
            </#list>
        </#if>
        <#if offline??>
			<h4 class="text-primary">休息中</h4>
            <#list offline as room>
				<div class="col-lg-3">
					<div class="item" id="${room.streamKey}">
						<div class="item_content_mask_layer">
							<img class="item_content_mask_layer_img" src="/images/play-button.png"/>
						</div>
						<div class="item_screenshot">
                            <#if room.roomScreenshot ?? >
								<h2>asdf</h2>
                            <#else>
								<img src="/images/default-screenshot.png">
                            </#if>
						</div>
						<div class="item_info_room_status">
                            <#if  room.roomStatus == 1 >
								<span>Live</span>
                            <#else>
								<span>Rest</span>
                            </#if>
						</div>
						<div class="item_info">
							<span class="item_info_room_name"> ${room.roomName}</span>
							<span class="item_info_user_name"> ${room.userName}</span>
						</div>
					</div>
				</div>
            </#list>
        </#if>
    <#else>
		<h4 class="text-primary">尚未关注主播，赶紧去关注吧</h4>
    </#if>
		<div hidden>
			<form action="${tomcat_proxy_server_ip}/${application_name}/room" method="post">
				<input type="text" id="stream_key" name="stream_key"/>
				<input type="submit" id="submit"/>
			</form>
		</div>
	</div>

	<div class="nav-toggle-panel" id="room_setting_disp" style="display: none;">
		<h3 class="text-info">直播间</h3>
		<table class="table table-hover">

			<tr>
				<td>名称：</td>
				<td>
					<span id="set_room_name"></span>
					&nbsp;&nbsp;&nbsp;<a id="modify_room_name" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_room_name_input" type="text" class="form-control modify-room-input"
						       name="name"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_room_name_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-room-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_room_name_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-room-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>流密钥：</td>
				<td>
					<span id="set_room_stream_key"></span>
				</td>
			</tr>
			<tr>
				<td>分类：</td>
				<td>
					<span id="set_room_category"></span>
					&nbsp;&nbsp;&nbsp;<a id="modify_room_category" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<select class="form-control" id="modify_room_category_select" name="category">
						</select>
                    <#--<input id="modify_room_category_input" type="text" class="form-control modify-room-input"-->
                    <#--name="category"-->
                    <#--placeholder="Input new Value" aria-describedby="basic-addon1">-->
						<span id="modify_room_category_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-room-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_room_category_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-room-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>简介：</td>
				<td>
					<span id="set_room_introduce"></span>
					&nbsp;&nbsp;&nbsp;<a id="modify_room_introduce" class="modify_a">修改</a>
				</td>
				<td style="display: none;">
					<div class="input-group">
						<input id="modify_room_introduce_input" type="text" class="form-control modify-room-input"
						       name="introduce"
						       placeholder="Input new Value" aria-describedby="basic-addon1">
						<span id="modify_room_introduce_submit"
						      class="glyphicon glyphicon-ok input-group-addon modify-room-submit-btn"
						      aria-hidden="true"></span>
						<span id="modify_room_introduce_cancel"
						      class="glyphicon glyphicon-remove input-group-addon modify-room-cancel-btn"
						      aria-hidden="true"></span>
					</div>
				</td>
			</tr>
		</table>
	</div>

</div>

<script>

	//	bind click event
	$(".item").on("click", function () {
		var id = $(this).attr("id");
		$("#stream_key").val(id);
		$("#submit").click();
	})
	$(".modify_a").on('click', function () {
		console.log(this);
		$(this).parent('td').parent('tr').children('td:last').show();
		$(this).parent('td').hide();
	})
	$(".modify-user-input,.modify-room-input").on('blur', function () {
		if ($(this).val().length != 0) {
			var res = confirm("是否提交");
			if (res) {
				$(this).next('span').trigger('click');
			} else {
				$(this).next('span').next('span').trigger('click');
			}
		} else {
//		    触发取消按钮
			$(this).next('span').next('span').trigger('click');
		}
	})
	$(".modify-user-submit-btn").on('click', function () {
		var newVal = $(this).prev('input').val();
		var oldVal = $(this).parent('div').parent('td').prev('td').children('span').text().trim();
		console.log(oldVal);
		if (newVal == oldVal) {
			alert("与原数据一致");
			$(this).parent('div').addClass('has-error');
		} else if (newVal.length == 0) {
			alert("输入为空");
			$(this).parent('div').addClass('has-error');
		} else {
			modifyUserInfoSubmit(this);
			openOrCloseInput(this, 'close');
		}
	})
	$(".modify-room-submit-btn").on('click', function () {
		var newVal = $(this).prev('input').val() || $(this).prev('select').attr('name');
		var oldVal = $(this).parent('div').parent('td').prev('td').children('span').text().trim();
		console.log(oldVal);
		if (newVal == oldVal) {
			alert("与原数据一致");
			$(this).parent('div').addClass('has-error');
		} else if (newVal.length == 0) {
			alert("输入为空");
			$(this).parent('div').addClass('has-error');
		} else {
			modifyRoomInfoSubmit(this);
			openOrCloseInput(this, 'close');
		}
	})
	$(".modify-user-cancel-btn,.modify-room-cancel-btn").on('click', function () {
		openOrCloseInput(this, 'close');
	})
	$(".nav-tabs>li>a").on('click', function () {
		console.log('nav click');
		$(".nav-tabs>li.active").removeClass("active");
		$(this).parent('li').addClass('active');
		var type = $(".nav-tabs>li.active").children('a').attr("data-for");
		var ele = document.getElementById(type);
		$(".nav-toggle-panel").fadeOut(100);
		$(ele).fadeIn(100);
	})

	$("#menu_container").on("boxzoomin boxzoomout", function (event) {
		if (event.type == "boxzoomin") {
			$("#userinfo_container").css("margin-left", "100px");
		} else if (event.type == "boxzoomout") {
			$("#userinfo_container").css("margin-left", "330px");
		}
	})

	setUserStatus();


	function setUserStatus() {
		var status = parseInt($("#user_status").val());
		console.log(status);
		if ((status & 1) > 0) {
			console.log("inactive")
			$("<a href='/live/user/request/active'>&nbsp;申请激活&nbsp;</a>").appendTo($("#user_status_disp"));
		}
		if ((status & 256) > 0) {
			console.log("locked")
			$("<a href='/live/user/request/lock'>&nbsp;申请解锁&nbsp;</a>").appendTo($("#user_status_disp"));
		}
		if ((status & 32 ) == 0) {
			console.log("anchor")
			$("<a href='/live/user/request/anchor'>&nbsp;申请成为主播&nbsp;</a>").appendTo($("#user_status_disp"));
		} else {
			$("#user_room_key").parent('td').parent('tr').show();
			$.get("/live/room/info", function (data) {
				var res = JSON.parse(data);
				console.log(res);
				if (res.status == 0) {
					$("#nav_room_setting").show();
					var room = JSON.parse(res.room);
					console.log(room)
					$("#set_room_name").text(room.roomName);
					$("#set_room_stream_key").text(room.streamKey);
					$("#set_room_category").text(room.categoryName);
					$("#set_room_introduce").text(room.roomIntroduce);
				} else {
					$("#nav_room_setting").hide();
					console.log("该用户不是主播");
				}
			})
			$.get("/live/category/list/json",function (data) {
				var res = JSON.parse(data);
				for(var index in res.list){
				    console.log(res.list[index]);
				    var tmp = res.list[index];
				    $("<option data-for='"+tmp.categoryId+"'>"+tmp.categoryName+"</option>").appendTo($("#modify_room_category_select"));
				}
			})
		}
	}
	function modifyRoomInfoSubmit(ele) {
		var type = $(ele).prev('input').attr('name') || $(ele).prev('select').attr('name');
		var userid = $("#modify_user_id").val().trim();
		var value = $(ele).prev('input').val() || $(ele).prev('select').children('option:selected').attr('data-for');
		console.log(type);
		console.log(userid);
		console.log(value);

		$.post("/live/room/update", {
			userid: userid,
			type: type,
			value: value,
		}, function (data) {
			var res = JSON.parse(data);
			if (res.status == 0) {
				alert("更新成功");
				location.reload(false);
			} else {
				alert("更新失败,请重试");
			}
		});
	}
	function modifyUserInfoSubmit(ele) {
		var type = $(ele).prev('input').attr('name').trim();
		var userid = $("#modify_user_id").val().trim();
		var value = $(ele).prev('input').val().trim();
		console.log(type);
		console.log(userid);
		console.log(value);

		$.post("/live/user/update", {
			userid: userid,
			type: type,
			value: value,
		}, function (data) {
			var res = JSON.parse(data);
			if (res.status == 0) {
//				alert("更新成功");
				location.reload(false);
			} else {
				alert("更新失败,请重试");
			}
		});
	}
	function openOrCloseInput(ele, type) {
		if (type == 'open' || type == 0) {
			$(ele).parent('div').parent('td').show();
			$(ele).parent('div').parent('td').prev('td').hide();
		} else {
			$(ele).parent('div').parent('td').hide();
			$(ele).parent('div').parent('td').prev('td').show();
		}
	}

</script>

</body>
</html>
