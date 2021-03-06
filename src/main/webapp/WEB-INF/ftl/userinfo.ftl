<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title><@spring.message "web.userinfo"/></title>
	<script src="/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
	<script src="/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/css/base.css">
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="userinfo_container">
	<div class="row">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#" data-for="user_info_disp"><@spring.message "web.userinfo"/></a>
				</li>
				<li>
					<a href="#" data-for="user_subscribe_disp"><@spring.message "web.userinfo.focus"/></a>
				</li>
				<li style="display: none;" id="nav_room_setting">
					<a href="#" data-for="room_setting_disp"><@spring.message "web.liveroom"/></a>
				</li>
			</ul>

			<div class="nav-toggle-panel" id="user_info_disp">
            <#if status ==0 && user?? && user != "anonymousUser">
				<input hidden id="modify_user_id" value="${user.userId}">
				<br/>
				<h3 class="text-info"><@spring.message "web.userinfo"/></h3>
				<table class="table table-hover">
					<tr>
						<td><@spring.message "web.userinfo.nickname"/>：</td>
						<td><span>
                            <#if user.userNickname??> ${user.userNickname}
                    <#else>
                                <@spring.message "web.none"/>
                            </#if></span>
							&nbsp;&nbsp;&nbsp;<a id="modify_user_nickname"
							                     class="modify_a"><@spring.message "web.modify"/></a>
						</td>
						<td style="display: none;">
							<div class="input-group">
								<input id="modify_user_nickname_input" type="text"
								       class="form-control modify-user-input"
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
						<td><@spring.message "web.userinfo.sex"/>：</td>
						<td><span>
                            <#if user.userSex == 0><@spring.message "web.screct"/><#elseif  user.userSex == 1><@spring.message "web.userinfo.sex.man"/><#elseif user.userSex ==2><@spring.message "web.userinfo.sex.woman"/></#if></span>
							&nbsp;&nbsp;&nbsp;<a id="modify_user_sex"
							                     class="modify_a"><@spring.message "web.modify"/></a>
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
						<td><@spring.message "web.userinfo.age"/>：</td>
						<td><span>
                            <#if user.userAge??>${user.userAge}<#else><@spring.message "web.none"/></#if></span>
							&nbsp;&nbsp;&nbsp;<a id="modify_user_age"
							                     class="modify_a"><@spring.message "web.modify"/></a>
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
						<td><@spring.message "web.userinfo.height"/>：</td>
						<td><span>
                            <#if user.userHeight?? >${user.userHeight}<#else><@spring.message "web.none"/></#if></span>
							&nbsp;&nbsp;&nbsp; <a id="modify_user_height"
							                      class="modify_a"><@spring.message "web.modify"/></a>
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
						<td><@spring.message "web.userinfo.weight"/>：</td>
						<td><span>
                            <#if user.userWeight??>${user.userWeight}<#else><@spring.message "web.none"/></#if></span>
							&nbsp;&nbsp;&nbsp; <a id="modify_user_weight"
							                      class="modify_a"><@spring.message "web.modify"/></a>
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
				<h3 class="text-info"><@spring.message "web.userinfo.contact"/></h3>
				<table class="table table-hover">
					<tr>
						<td><@spring.message "web.userinfo.email"/>：</td>
						<td>
                                <#if user.userEmail??>${user.userEmail}<#else><@spring.message "web.none"/></#if></span>
							&nbsp;&nbsp;&nbsp; <a id="modify_user_email"
							                      class="modify_a"><@spring.message "web.modify"/></a>
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
						<td><@spring.message "web.userinfo.phone"/>：</td>
						<td><span>
                            <#if user.userPhone??>${user.userPhone}<#else><@spring.message "web.none"/></#if></span>
							&nbsp;&nbsp;&nbsp;<a id="modify_user_phone"
							                     class="modify_a"><@spring.message "web.modify"/></a>
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
				<h3 class="text-info"><@spring.message "web.userinfo.account"/></h3>
				<table class="table table-hover">
					<tr>
						<td><@spring.message "web.userinfo.password"/>：</td>
						<td>
							<span>********</span>
							&nbsp;&nbsp;&nbsp;<a id="modify_user_password"
							                     class="modify_a"><@spring.message "web.modify"/></a>
						</td>
						<td style="display: none;">
							<div class="input-group">
								<input id="modify_user_password_input" type="password"
								       class="form-control modify-user-input"
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
						<td><@spring.message "web.userinfo.status"/>：</td>
						<td>
                            <#if user.userStatus??><input hidden id="user_status" value="${user.userStatus}"></#if>
							<span id="user_status_disp"></span>
						</td>
					</tr>
					<tr>
						<td><@spring.message "web.userinfo.treasure"/>：</td>
						<td><span>
                            <#if user.userTreasure??>${user.userTreasure}<#else><@spring.message "web.none"/></#if></span>
						</td>
					</tr>
				</table>
            <#else>
				<div style="text-align: center">
					<h4 style="padding-top: 80px">Please
						<a class="text-primary" data-whatever="login" data-toggle="modal"
						   data-target="#user_modal" href="#"><@spring.message "web.login"/></a>
					</h4>
				</div>
            </#if>
			</div>

			<div class="nav-toggle-panel" id="user_subscribe_disp" style="display: none;">
				<br/>
            <#include 'room-list-component.ftl'>
			</div>

			<div class="nav-toggle-panel" id="room_setting_disp" style="display: none;">
				<br/>
				<h3 class="text-info"><@spring.message "web.liveroom"/></h3>
				<table class="table table-hover">

					<tr>
						<td><@spring.message "web.room.name"/>：</td>
						<td>
							<span id="set_room_name"></span>
							&nbsp;&nbsp;&nbsp;<a id="modify_room_name"
							                     class="modify_a"><@spring.message "web.modify"/></a>
						</td>
						<td style="display: none;">
							<div class="input-group">
								<input id="modify_room_name_input" type="text"
								       class="form-control modify-room-input"
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
						<td><@spring.message "web.room.stream"/>：</td>
						<td>
							<span id="set_room_stream_key"></span>
						</td>
					</tr>
					<tr>
						<td><@spring.message "web.category"/>：</td>
						<td>
							<span id="set_room_category"></span>
							&nbsp;&nbsp;&nbsp;<a id="modify_room_category"
							                     class="modify_a"><@spring.message "web.modify"/></a>
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
						<td><@spring.message "web.room.introduce"/>：</td>
						<td>
							<span id="set_room_introduce"></span>
							&nbsp;&nbsp;&nbsp;<a id="modify_room_introduce"
							                     class="modify_a"><@spring.message "web.modify"/></a>
						</td>
						<td style="display: none;">
							<div class="input-group">
								<input id="modify_room_introduce_input" type="text"
								       class="form-control modify-room-input"
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
			alert("与同原数据一致");
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
			$("<a href='${nginx_server}/${application_name}/user/request/active'>&nbsp;申请激活&nbsp;</a>").appendTo($("#user_status_disp"));
		}
		if ((status & 256) > 0) {
			console.log("locked")
			$("<a href='${nginx_server}/${application_name}/user/request/lock'>&nbsp;申请解锁&nbsp;</a>").appendTo($("#user_status_disp"));
		}
		if ((status & 32 ) == 0) {
			console.log("anchor")
			$("<a href='${nginx_server}/${application_name}/user/request/anchor'>&nbsp;申请成为主播&nbsp;</a>").appendTo($("#user_status_disp"));
		} else {
			$("#user_room_key").parent('td').parent('tr').show();
			$.get("${nginx_server}/${application_name}/room/info", function (data) {
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
			$.get("${nginx_server}/${application_name}/category/list/json", function (data) {
				var res = JSON.parse(data);
				for (var index in res.list) {
					console.log(res.list[index]);
					var tmp = res.list[index];
					$("<option data-for='" + tmp.categoryId + "'>" + tmp.categoryName + "</option>").appendTo($("#modify_room_category_select"));
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

		$.post("${nginx_server}/${application_name}/room/update", {
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

		$.post("${nginx_server}/${application_name}/user/update", {
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
