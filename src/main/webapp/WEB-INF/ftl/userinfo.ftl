<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>search result</title>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
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

	</style>
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="userinfo_container">
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

<script>

	$(".modify_a").on('click', function () {
		console.log(this);
		$(this).parent('td').parent('tr').children('td:last').show();
		$(this).parent('td').hide();
	})
	$(".modify-user-input").on('blur', function () {
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
	$(".modify-user-cancel-btn").on('click', function () {
		openOrCloseInput(this, 'close');
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
		var status = parseInt($("#user_status").val().trim());
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
			$.get("/live/room/stream_key", function (data) {
				var res = JSON.parse(data);
				if (res.status == 0) {
					console.log(res.stream_key);
					$("<span class='text-primary'>"+ res.stream_key + "</span>").appendTo($("#user_room_key"));
				} else {
					console.log("该用户不是主播");
				}
			})
		}
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
